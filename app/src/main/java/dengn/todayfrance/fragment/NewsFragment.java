package dengn.todayfrance.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import dengn.todayfrance.utils.NewsHTTPUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class NewsFragment extends Fragment implements SwipyRefreshLayout.OnRefreshListener {

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


    public static NewsFragment newInstance(String title) {
        NewsFragment fragment = new NewsFragment();
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //判断Fragment中的ListView时候存在，判断该Fragment时候已经正在前台显示  通过这两个判断，就可以知道什么时候去加载数据了
        if (isVisibleToUser && isVisible() && newsList.getVisibility() != View.VISIBLE) {
            initData(); //加载数据的方法
        }

    }
    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {

        initData();

    }

    private void initData(){



        NewsHTTPUtils.todayFranceGetNews.getNews(new Callback<ArrayList<NewsEntity>>() {
            @Override
            public void success(ArrayList<NewsEntity> newsEntity, Response response) {

                swipeContainer.setRefreshing(false);

                newsEntities = newsEntity;
                newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(getActivity(), newsEntities);
                newsList.setAdapter(newsRecyclerViewAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

                swipeContainer.setRefreshing(false);


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

    private void showToast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
    }
}
