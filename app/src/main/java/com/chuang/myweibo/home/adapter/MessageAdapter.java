package com.chuang.myweibo.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chuang.myweibo.R;
import com.chuang.myweibo.utils.DensityUtil;

import java.util.ArrayList;

/**
 * Created by Chuang on 4-13.
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //环境
    Context mContext;
    Activity mActiivty;
    //item的类型
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    //item的数据
    ArrayList<Integer> mData;
    ArrayList<String> mText;

    public MessageAdapter(Context mContext, ArrayList<Integer> mData, ArrayList<String> mText) {
        this.mContext = mContext;
        this.mData = mData;
        this.mText = mText;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.headerview_search, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DensityUtil.dp2px(mContext, 40));
            view.setLayoutParams(params);
            SearchViewHolder searchViewHolder = new SearchViewHolder(view);

            return searchViewHolder;

        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_message_item, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);

            return itemViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MessageAdapter.ItemViewHolder) {
            ((ItemViewHolder) holder).imageView.setImageResource(mData.get(position - 1));
            ((ItemViewHolder) holder).textView.setText(mText.get(position - 1));

        }

    }

    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    //------------------不同类型的ViewHolder-------------------------------------------
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.message_icon);
            textView = (TextView) itemView.findViewById(R.id.message_title);
        }
    }


    private class SearchViewHolder extends RecyclerView.ViewHolder {
        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }
    //--------------------------------------------------------------------------------
}