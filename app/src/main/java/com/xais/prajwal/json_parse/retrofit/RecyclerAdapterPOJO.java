package com.xais.prajwal.json_parse.retrofit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xais.prajwal.json_parse.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class RecyclerAdapterPOJO extends RecyclerView.Adapter<RecyclerAdapterPOJO.RecyclerViewHolder> {

    private List<POJO> pojo;

    public RecyclerAdapterPOJO(){
        pojo = new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        POJO mpojo = pojo.get(position);
        holder.name.setText(mpojo.getName());
        holder.price.setText(mpojo.getPrice());
        holder.description.setText(mpojo.getDescription());

    }

    @Override
    public int getItemCount() {
        return pojo.size();
    }

    public void addData(POJO xPOJO) {
        Log.d("Prajwal", xPOJO.getName());
        pojo.add(xPOJO);
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, description;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtName);
            price = (TextView) itemView.findViewById(R.id.txtPrice);
            description = (TextView) itemView.findViewById(R.id.txtDescription);
        }
    }
}
