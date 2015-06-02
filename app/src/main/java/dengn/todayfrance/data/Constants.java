package dengn.todayfrance.data;

import java.util.ArrayList;
import java.util.List;

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
        entity = new NewsEntity();
        entity.setTitle("sgrg");
        entity.setSummary("ertretre");
        entity.setSource("wrertretretrg");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("ertret");
        entity.setSummary("wgwertretregr");
        entity.setSource("ertertret");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("ert");
        entity.setSummary("tetertre");
        entity.setSource("wrtq23r43rrg");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("trete");
        entity.setSummary("wgwwetweregr");
        entity.setSource("t34t4w43");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("35yrfgwef");
        entity.setSummary("gheheh");
        entity.setSource("wghrhsrh");
        newsEntities.add(entity);
        entity = new NewsEntity();
        entity.setTitle("ehj4ehge");
        entity.setSummary("hegheg");
        entity.setSource("4sd5g4w5");
        newsEntities.add(entity);
        return newsEntities;
    }

    public static ArrayList<NewsEntity> getNewsList() {
        ArrayList<NewsEntity> newsList = new ArrayList<NewsEntity>();
        for(int i =0 ; i < 10 ; i++){
            NewsEntity news = new NewsEntity();
            news.setId(i);
            news.setNewsId(i);
            news.setCollectStatus(false);
            news.setCommentNum(i + 10);
            news.setInterestedStatus(true);
            news.setLikeStatus(true);
            news.setReadStatus(false);
            news.setNewsCategory("推荐");
            news.setNewsCategoryId(1);
            news.setTitle("可以用谷歌眼镜做的10件酷事：导航、玩游戏");
            List<String> url_list = new ArrayList<String>();
            if(i%2 == 1){
                String url1 = "http://infopic.gtimg.com/qq_news/digi/pics/102/102066/102066094_400_640.jpg";
                String url2 = "http://infopic.gtimg.com/qq_news/digi/pics/102/102066/102066096_400_640.jpg";
                String url3 = "http://infopic.gtimg.com/qq_news/digi/pics/102/102066/102066099_400_640.jpg";
                news.setPicOne(url1);
                news.setPicTwo(url2);
                news.setPicThr(url3);
                url_list.add(url1);
                url_list.add(url2);
                url_list.add(url3);
            }else{
                news.setTitle("AA用车:智能短租租车平台");
                String url = "http://r3.sinaimg.cn/2/2014/0417/a7/6/92478595/580x1000x75x0.jpg";
                news.setPicOne(url);
                url_list.add(url);
            }
            news.setPicList(url_list);
            news.setPublishTime(Long.valueOf(i));
            news.setReadStatus(false);
            news.setSource("手机腾讯网");
            news.setSummary("腾讯数码讯（编译：Gin）谷歌眼镜可能是目前最酷的可穿戴数码设备，你可以戴着它去任何地方（只要法律法规允许或是没有引起众怒），作为手机的第二块“增强现实显示屏”来使用。另外，虽然它仍未正式销售，但谷歌近日在美国市场举行了仅限一天的开放购买活动，价格则为1500美元（约合人民币9330元），虽然仍十分昂贵，但至少可以满足一些尝鲜者的需求，也预示着谷歌眼镜的公开大规模销售离我们越来越近了。");
            news.setMark(i);
            if(i == 4){
                news.setTitle("部落战争强势回归");
                news.setLocal("推广");
                news.setIsLarge(true);
                String url = "http://imgt2.bdstatic.com/it/u=3269155243,2604389213&fm=21&gp=0.jpg";
                news.setPicOne(url);
                url_list.clear();
                url_list.add(url);
            }else{
                news.setIsLarge(false);
            }
            if(i == 2){
                news.setComment("评论部分，说的非常好。");
            }
            newsList.add(news);
        }
        return newsList;
    }
}
