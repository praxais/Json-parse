package com.xais.prajwal.json_parse.retrofitdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xais.prajwal.json_parse.R;
import com.xais.prajwal.json_parse.retrofitdemo.adapter.RecyclerAdapter;
import com.xais.prajwal.json_parse.retrofitdemo.controller.RestManager;
import com.xais.prajwal.json_parse.retrofitdemo.pojo.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RestManager restManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        configViews();

        restManager = new RestManager();

        final Call<List<Category>> listCall = restManager.getApiService().getAllCategory();

        listCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                if (response.isSuccessful()){

                    List<Category> category = response.body();
                    for (int i=0; i < category.size(); i++){
                        Category zCategory = category.get(i);
                        recyclerAdapter.addData(zCategory);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

    }

    private void configViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMy);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
    }
}
