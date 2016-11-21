package com.xais.prajwal.json_parse.json;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xais.prajwal.json_parse.R;

import java.util.ArrayList;

/**
 * Created by Prajwal on 2016-11-20.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Json> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Json> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Json json = arrayList.get(position);
        holder.name.setText(json.getName());
        holder.price.setText(json.getPrice());
        holder.description.setText(json.getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, description;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtName);
            price = (TextView) itemView.findViewById(R.id.txtPrice);
            description = (TextView) itemView.findViewById(R.id.txtDescription);
        }
    }

}
