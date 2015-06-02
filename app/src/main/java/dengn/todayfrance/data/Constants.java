package dengn.todayfrance.data;

import java.util.ArrayList;

import dengn.todayfrance.bean.NewsClassify;
import dengn.todayfrance.bean.NewsEntity;

/**
 * Created by OLEDCOMM on 27/05/2015.
 */
public class Constants {

    public static ArrayList<NewsClassify> getData() {
        ArrayList<NewsClassify> newsClassify = new ArrayList<NewsClassify>();
        NewsClassify classify = new NewsClassify();
        classify.setId(0);
        classify.setTitle("推荐");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(1);
        classify.setTitle("热点");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(2);
        classify.setTitle("数码");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(3);
        classify.setTitle("杭州");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(4);
        classify.setTitle("社会");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(5);
        classify.setTitle("娱乐");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(6);
        classify.setTitle("科技");
        newsClassify.add(classify);
        classify = new NewsClassify();
        classify.setId(7);
        classify.setTitle("汽车");
        newsClassify.add(classify);
        return newsClassify;
    }

    public static ArrayList<NewsEntity> getNews(){
        ArrayList<NewsEntity> newsEntities = new ArrayList<NewsEntity>();
        NewsEntity entity = new NewsEntity();
        entity.setTitle("hahahah");
        entity.setSummary("123455");
        entity.setSource("xinhuashe");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("124er");
        entity.setSummary("tewetwer");
        entity.setSource("sgwt243");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("23rwr");
        entity.setSummary("gwr");
        entity.setSource("sghrg");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("etr42");
        entity.setSummary("wghtrhw");
        entity.setSource("hrgegre");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("fwrtgwrg");
        entity.setSummary("sgrehreghe");
        entity.setSource("sdhregregr");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("wgwrgre");
        entity.setSummary("wgwregr");
        entity.setSource("wrrg");
        newsEntities.add(entity);
        return newsEntities;
    }
}
