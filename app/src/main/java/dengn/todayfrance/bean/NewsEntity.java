package dengn.todayfrance.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by OLEDCOMM on 28/05/2015.
 */
public class NewsEntity implements Parcelable {

    /** 新闻类别 ID */
    private Integer newsCategoryId;
    /** 新闻类型 */
    private String newsCategory;
    /** 标记状态，如推荐之类的 */
    private Integer mark;;
    /** 评论数量 */
    private Integer commentNum;
    /** ID */
    private Integer id;
    /** 新闻ID */
    private Integer newsId;
    /** 标题 */
    private String title;
    /** 新闻源 */
    private String source;
    /** 发布时间 */
    private Long publishTime;
    /** 总结 */
    private String summary;
    /** 摘要 */
    private String newsAbstract;
    /** 评论 */
    private String comment;
    /** 特殊标签，如广告推广之类的 ，可以为空 */
    private String local;
    /** 图片列表字符串 */
    private String picListString;
    /** 图片1 URL */
    private String picOne;
    /** 图片2 URL */
    private String picTwo;
    /** 图片3 URL */
    private String picThr;
    /** 图片 列表 */
    private List<String> picList;
    /** 图片类型是否为大图 */
    private Boolean isLarge;
    /** 阅读状态 ，读过的话显示灰色背景 */
    private Boolean readStatus;
    /** 收藏状态 */
    private Boolean collectStatus;
    /** 喜欢 状态 */
    private Boolean likeStatus;
    /** 感兴趣状态 */
    private Boolean interestedStatus;

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPicListString() {
        return picListString;
    }

    public void setPicListString(String picListString) {
        this.picListString = picListString;
    }

    public String getPicOne() {
        return picOne;
    }

    public void setPicOne(String picOne) {
        this.picOne = picOne;
    }

    public String getPicTwo() {
        return picTwo;
    }

    public void setPicTwo(String picTwo) {
        this.picTwo = picTwo;
    }

    public String getPicThr() {
        return picThr;
    }

    public void setPicThr(String picThr) {
        this.picThr = picThr;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    public Boolean getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(Boolean collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Boolean getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(Boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Boolean getInterestedStatus() {
        return interestedStatus;
    }

    public void setInterestedStatus(Boolean interestedStatus) {
        this.interestedStatus = interestedStatus;
    }

    public String getNewsAbstract() {
        return newsAbstract;
    }

    public void setNewsAbstract(String newsAbstract) {
        this.newsAbstract = newsAbstract;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsLarge() {
        return isLarge;
    }

    public void setIsLarge(Boolean isLarge) {
        this.isLarge = isLarge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.newsCategoryId);
        dest.writeString(this.newsCategory);
        dest.writeValue(this.mark);
        dest.writeValue(this.commentNum);
        dest.writeValue(this.id);
        dest.writeValue(this.newsId);
        dest.writeString(this.title);
        dest.writeString(this.source);
        dest.writeValue(this.publishTime);
        dest.writeString(this.summary);
        dest.writeString(this.newsAbstract);
        dest.writeString(this.comment);
        dest.writeString(this.local);
        dest.writeString(this.picListString);
        dest.writeString(this.picOne);
        dest.writeString(this.picTwo);
        dest.writeString(this.picThr);
        dest.writeList(this.picList);
        dest.writeValue(this.isLarge);
        dest.writeValue(this.readStatus);
        dest.writeValue(this.collectStatus);
        dest.writeValue(this.likeStatus);
        dest.writeValue(this.interestedStatus);
    }

    public NewsEntity() {
    }

    private NewsEntity(Parcel in) {
        this.newsCategoryId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.newsCategory = in.readString();
        this.mark = (Integer) in.readValue(Integer.class.getClassLoader());
        this.commentNum = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.newsId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.source = in.readString();
        this.publishTime = (Long) in.readValue(Long.class.getClassLoader());
        this.summary = in.readString();
        this.newsAbstract = in.readString();
        this.comment = in.readString();
        this.local = in.readString();
        this.picListString = in.readString();
        this.picOne = in.readString();
        this.picTwo = in.readString();
        this.picThr = in.readString();
        this.picList = in.readArrayList(null);
        this.isLarge = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.readStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.collectStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.likeStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.interestedStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsEntity> CREATOR = new Parcelable.Creator<NewsEntity>() {
        public NewsEntity createFromParcel(Parcel source) {
            return new NewsEntity(source);
        }

        public NewsEntity[] newArray(int size) {
            return new NewsEntity[size];
        }
    };
}
