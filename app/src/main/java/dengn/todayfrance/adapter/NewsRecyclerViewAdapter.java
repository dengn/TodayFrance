package dengn.todayfrance.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dengn.todayfrance.R;
import dengn.todayfrance.bean.NewsEntity;
import dengn.todayfrance.data.Constants;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static enum ITEM_TYPE {
        ITEM_TYPE_TEXT,
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_MULTI_IMAGE
    }

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    ArrayList<NewsEntity> newsEntity;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsEntity> newsEntities) {

        mContext = context;
        newsEntity = newsEntities;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void refresh(ArrayList<NewsEntity> newsEntities){
        newsEntity = newsEntities;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_TEXT.ordinal()) {

            return new NewsTextViewHolder(mLayoutInflater.inflate(R.layout.news_row_text, parent, false));
        } else if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {

            return new NewsImageViewHolder(mLayoutInflater.inflate(R.layout.news_row_image, parent, false));
        } else {

            return new NewsMultiImageViewHolder(mLayoutInflater.inflate(R.layout.news_row_multi_image, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsTextViewHolder) {
            ((NewsTextViewHolder) holder).newsHead.setText(newsEntity.get(position).getTitle());
            ((NewsTextViewHolder) holder).newsTime.setText(newsEntity.get(position).getNewsAbstract());
            ((NewsTextViewHolder) holder).newsBody.setText(newsEntity.get(position).getSource());
        } else if (holder instanceof NewsImageViewHolder) {
            ((NewsImageViewHolder) holder).newsHead.setText(newsEntity.get(position).getTitle());
            ((NewsImageViewHolder) holder).newsTime.setText(newsEntity.get(position).getNewsAbstract());
            ((NewsImageViewHolder) holder).newsBody.setText(newsEntity.get(position).getSource());

            //Set image by fresco
            ((NewsImageViewHolder) holder).newsImage.setImageURI(Uri.parse(newsEntity.get(position).getPicOne()));

        } else {
            ((NewsMultiImageViewHolder) holder).newsHead.setText(newsEntity.get(position).getTitle());
            ((NewsMultiImageViewHolder) holder).newsTime.setText(newsEntity.get(position).getNewsAbstract());

            //Set image
            ((NewsMultiImageViewHolder) holder).newsImageLeft.setImageURI(Uri.parse(newsEntity.get(position).getPicOne()));
            ((NewsMultiImageViewHolder) holder).newsImageCenter.setImageURI(Uri.parse(newsEntity.get(position).getPicTwo()));
            ((NewsMultiImageViewHolder) holder).newsImageRight.setImageURI(Uri.parse(newsEntity.get(position).getPicThr()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(newsEntity.get(position).getPicOne()==null){
            if(Constants.DEBUG)
                Log.d(Constants.TAG, "text type");
            return ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
        }
        else if(newsEntity.get(position).getPicTwo()==null&&newsEntity.get(position).getPicThr()==null){
            if(Constants.DEBUG)
                Log.d(Constants.TAG, "image type");
            return ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal();
        }
        else{
            if(Constants.DEBUG)
                Log.d(Constants.TAG, "multi type");
            return ITEM_TYPE.ITEM_TYPE_MULTI_IMAGE.ordinal();
        }

    }

    @Override
    public int getItemCount() {
        return newsEntity == null ? 0 : newsEntity.size();
    }

    public static class NewsTextViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.news_text_head)
        TextView newsHead;

        @InjectView(R.id.news_text_time)
        TextView newsTime;

        @InjectView(R.id.news_text_body)
        TextView newsBody;

        NewsTextViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

    public static class NewsImageViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.news_image_head)
        TextView newsHead;

        @InjectView(R.id.news_image_image)
        SimpleDraweeView newsImage;

        @InjectView(R.id.news_image_time)
        TextView newsTime;

        @InjectView(R.id.news_image_body)
        TextView newsBody;

        NewsImageViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);

            //newsImage.setAspectRatio(1.33f);
        }
    }

    public static class NewsMultiImageViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.news_multi_head)
        TextView newsHead;

        @InjectView(R.id.news_multi_time)
        TextView newsTime;

        @InjectView(R.id.news_image_left)
        SimpleDraweeView newsImageLeft;

        @InjectView(R.id.news_image_center)
        SimpleDraweeView newsImageCenter;

        @InjectView(R.id.news_image_right)
        SimpleDraweeView newsImageRight;

        NewsMultiImageViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);

            //newsImageLeft.setAspectRatio(1.33f);
            //newsImageCenter.setAspectRatio(1.33f);
            //newsImageRight.setAspectRatio(1.33f);
        }
    }

}
