package com.easyway.review.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easyway.review.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList;

    public RecycleViewAdapter(List<String> list) {
        this.mList = list;
    }



    /**
     * @param position 根据 集合的position判断是那种布局,这里返回的是布局的id, 可以随意指定int值的.
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return R.layout.item_recycle_simple;
    }

    /**
     * item总共条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 在这里判断是哪个布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        if (viewType == R.layout.item_recycle_simple) {
//            return new ViewHolder(inflater.inflate(R.layout.item_recycle_simple, parent, false));
//        }
        return new ViewHolder(inflater.inflate(R.layout.item_recycle_simple, parent, false));
    }

    /**
     * 在这里赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final String content = mList.get(position);
        ViewHolder holderBig = (ViewHolder) holder;
        holderBig.tv.setText(content);

    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_recycle_tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }
}


