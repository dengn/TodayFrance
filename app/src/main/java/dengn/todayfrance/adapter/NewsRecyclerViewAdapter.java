package dengn.todayfrance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;

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


        try {
            String jsonString = Constants.objectMapper.writeValueAsString(newsEntity);
            if(Constants.DEBUG) {
                Log.d(Constants.TAG, "jackson: " + jsonString);
            }
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
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
            //((NewsImageViewHolder) holder).mTextView.setText(mTitles[position]);
        } else {
            //((NewsMultiImageViewHolder) holder).mTextView.setText(mTitles[position]);
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
        ImageView newsImage;

        @InjectView(R.id.news_image_time)
        TextView newsTime;

        @InjectView(R.id.news_image_body)
        TextView newsBody;

        NewsImageViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

    public static class NewsMultiImageViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.news_multi_head)
        TextView newsHead;

        @InjectView(R.id.news_multi_time)
        TextView newsTime;

        @InjectView(R.id.news_image_left)
        ImageView newsImageLeft;

        @InjectView(R.id.news_image_center)
        ImageView newsImageCenter;

        @InjectView(R.id.news_image_right)
        ImageView newsImageRight;

        NewsMultiImageViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

}
