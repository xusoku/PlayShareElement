package com.test.transitiondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xushengfu on 2019/6/4.
 */

public class AutoPollAdapter extends RecyclerView.Adapter<AutoPollAdapter.BaseViewHolder> {
    private final Context mContext;
    private final List<String> mData;

    public AutoPollAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mData = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        BaseViewHolder holder = new BaseViewHolder(view);
        holder.textView=view.findViewById(R.id.item_text);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        String data = mData.get(position % mData.size());
        holder.textView.setText(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public BaseViewHolder(View view) {
            super(view);
        }
    }

}


