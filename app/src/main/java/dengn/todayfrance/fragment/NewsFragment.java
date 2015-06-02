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

import butterknife.ButterKnife;
import butterknife.InjectView;
import dengn.todayfrance.R;
import dengn.todayfrance.adapter.NewsRecyclerViewAdapter;


public class NewsFragment extends Fragment implements SwipyRefreshLayout.OnRefreshListener {

    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @InjectView(R.id.news_list)
    RecyclerView newsList;

    @InjectView(R.id.swipe_container)
    SwipyRefreshLayout swipeContainer;

    private String title;


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

        newsList.setAdapter(new NewsRecyclerViewAdapter(getActivity()));
        newsList.setItemAnimator(new DefaultItemAnimator());
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
