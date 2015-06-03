package dengn.todayfrance.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dengn.todayfrance.R;
import dengn.todayfrance.adapter.NewsRecyclerViewAdapter;
import dengn.todayfrance.bean.NewsEntity;
import dengn.todayfrance.data.Constants;
import dengn.todayfrance.utils.NewsHTTPUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class NewsListFragment extends BaseFragment implements SwipyRefreshLayout.OnRefreshListener {

    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @InjectView(R.id.news_list)
    RecyclerView newsList;

    @InjectView(R.id.swipe_container)
    SwipyRefreshLayout swipeContainer;

    NewsRecyclerViewAdapter newsRecyclerViewAdapter;

    private String title;

    private ArrayList<NewsEntity> newsEntities = new ArrayList<NewsEntity>();


    public static NewsListFragment newInstance(String title) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            title = getArguments().getString("title");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, null);
        ButterKnife.inject(this, view);

        swipeContainer.setDirection(SwipyRefreshLayoutDirection.BOTH);
        swipeContainer.setOnRefreshListener(this);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于list view

        newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(getActivity(), newsEntities);
        newsList.setAdapter(newsRecyclerViewAdapter);
        newsList.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    protected void lazyLoad() {

        if (Constants.DEBUG)
            Log.d(Constants.TAG, "lazy loading called");
        initData();
    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {


    }

    private void initData() {

        if (title.equals("推荐")) {

            NewsHTTPUtils.todayFranceGetNewsNews.getNewsNews(new Callback<ArrayList<NewsEntity>>() {
                @Override
                public void success(ArrayList<NewsEntity> newsEntity, Response response) {


                    newsEntities = newsEntity;
                    newsRecyclerViewAdapter.refresh(newsEntities);

                }

                @Override
                public void failure(RetrofitError error) {


                    switch (error.getKind()) {
                        case NETWORK:
                            showToast("网络错误");
                            break;
                        case CONVERSION:
                            showToast("重新输入");
                            break;
                        case HTTP:
                            //这里可以用Mockito模拟
                            showToast("错误代码:"
                                    + String.valueOf(error.getResponse().getStatus())
                                    + "错误原因:" + error.getResponse().getReason());
                            break;
                        case UNEXPECTED:
                            showToast("未知错误");
                            //TODO:写入日志
                            break;
                    }
                    showToast("failure:" + error.getKind());
                }


            });
        } else if (title.equals("热点")) {
            NewsHTTPUtils.todayFranceGetNewsNews.getFunNews(new Callback<ArrayList<NewsEntity>>() {
                @Override
                public void success(ArrayList<NewsEntity> newsEntity, Response response) {


                    newsEntities = newsEntity;
                    newsRecyclerViewAdapter.refresh(newsEntities);

                }

                @Override
                public void failure(RetrofitError error) {


                    switch (error.getKind()) {
                        case NETWORK:
                            showToast("网络错误");
                            break;
                        case CONVERSION:
                            showToast("重新输入");
                            break;
                        case HTTP:
                            //这里可以用Mockito模拟
                            showToast("错误代码:"
                                    + String.valueOf(error.getResponse().getStatus())
                                    + "错误原因:" + error.getResponse().getReason());
                            break;
                        case UNEXPECTED:
                            showToast("未知错误");
                            //TODO:写入日志
                            break;
                    }
                    showToast("failure:" + error.getKind());
                }


            });
        }


    }

    private void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
    }
}
