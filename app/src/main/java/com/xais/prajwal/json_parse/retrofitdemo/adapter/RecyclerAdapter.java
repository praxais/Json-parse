package com.xais.prajwal.json_parse.retrofitdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xais.prajwal.json_parse.R;
import com.xais.prajwal.json_parse.retrofitdemo.pojo.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<Category> mCategory;

    public RecyclerAdapter() {
        mCategory = new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Category category = mCategory.get(position);

        holder.username.setText(category.getUsername());
        holder.slots.setText(Integer.toString(category.getSlots()));
        holder.booked_date.setText(category.getBooked_date());
        holder.booked_time.setText(category.getBooked_time());
        holder.duration.setText(Integer.toString(category.getDuration()));
        holder.cost.setText(Integer.toString(category.getCost()));

    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    public void addData(Category zCategory) {
        mCategory.add(zCategory);
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView username, slots, booked_date, booked_time, duration, cost;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.txtUsername);
            slots = (TextView) itemView.findViewById(R.id.txtSlots);
            booked_date = (TextView) itemView.findViewById(R.id.txtBookedDate);
            booked_time = (TextView) itemView.findViewById(R.id.txtBookedTime);
            duration = (TextView) itemView.findViewById(R.id.txtDuration);
            cost = (TextView) itemView.findViewById(R.id.txtCost);
        }
    }
}
