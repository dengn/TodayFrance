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
        @GET("/getNewsNews.php")
        void getNewsNews(Callback<ArrayList<NewsEntity>> callback);

        @GET("/getFunNews.php")
        void getFunNews(Callback<ArrayList<NewsEntity>> callback);

        @GET("/getLifeNews.php")
        void getLifeNews(Callback<ArrayList<NewsEntity>> callback);

        @GET("/getFinanceNews.php")
        void getFinanceNews(Callback<ArrayList<NewsEntity>> callback);
    }
//    public interface TodayFranceGetFunNews {
//
//    }
//    public interface TodayFranceGetLifeNews {
//
//    }
//    public interface TodayFranceGetFinanceNews {
//
//    }

    static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(ENDPOINT)
                    //是否Debug
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    static public TodayFranceGetNews todayFranceGetNewsNews = restAdapter.create(TodayFranceGetNews.class);
//    static public TodayFranceGetFunNews todayFranceGetFunNews = restAdapter.create(TodayFranceGetFunNews.class);
//    static public TodayFranceGetLifeNews todayFranceGetLifeNews = restAdapter.create(TodayFranceGetLifeNews.class);
//    static public TodayFranceGetFinanceNews todayFranceGetFinanceNews = restAdapter.create(TodayFranceGetFinanceNews.class);
}
