package dengn.todayfrance.utils;

import java.util.ArrayList;

import dengn.todayfrance.bean.NewsEntity;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by OLEDCOMM on 03/06/2015.
 */
public class NewsHTTPUtils {

    //eg : http://localhost/todayfrance/getAllNews.php

    static final String  ENDPOINT = "http://192.168.23.1/todayfrance";
    public interface TodayFranceGetNews {
        @GET("/getAllNews.php")
        void getNews(Callback<ArrayList<NewsEntity>> callback);
    }

    static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(ENDPOINT)
                    //是否Debug
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    static public TodayFranceGetNews todayFranceGetNews = restAdapter.create(TodayFranceGetNews.class);
}
