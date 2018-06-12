package com.arrk.arrktest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arrk.arrktest.R;
import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.view.OnItemClickListener;

import java.util.List;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class StarwarListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<StarWarCharacter> characterList;
    OnItemClickListener clickListener;

    public StarwarListAdapter(List<StarWarCharacter> characterList, OnItemClickListener onItemClickListener) {
        this.characterList = characterList;
        this.clickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final StarWarCharacter starWarCharacter = characterList.get(position);
        holder.name.setText(starWarCharacter.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClicked(starWarCharacter);
            }
        });

    }

    @Override
    public int getItemCount() {
        return characterList.isEmpty() ? 0 : characterList.size();
    }

}
