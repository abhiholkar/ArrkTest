package com.arrk.arrktest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arrk.arrktest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name)
    public TextView name;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


}
