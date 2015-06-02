package dengn.todayfrance.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dengn.todayfrance.R;
import dengn.todayfrance.adapter.NewsRecyclerViewAdapter;
import dengn.todayfrance.bean.NewsEntity;


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
        //判断Fragment中的ListView时候存在，判断该Fragment时候已经正在前台显示  通过这两个判断，就可以知道什么时候去加载数据了
        if (isVisibleToUser && isVisible() && newsList.getVisibility() != View.VISIBLE) {
            //initData(); //加载数据的方法
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Hide the refresh after 2sec
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeContainer.setRefreshing(false);
                    }
                });
            }
        }, 2000);
    }
}
