package com.softpo.coordinatorlayoutdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softpo.coordinatorlayoutdemo.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by softpo on 2016/5/2.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList;

    public RvAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RvAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (mList != null) {
            ret = mList.size();
        }

        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = ((TextView) itemView.findViewById(R.id.showMessage));
        }
    }
}
