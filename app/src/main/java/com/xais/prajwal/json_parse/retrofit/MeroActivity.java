package com.xais.prajwal.json_parse.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xais.prajwal.json_parse.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeroActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapterPOJO recyclerAdapterPOJO;
    RestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mero);




        configViews();

        manager = new RestManager();


        Call<List<POJO>> listCall = manager.getApiService().getAllXais();

        listCall.enqueue(new Callback<List<POJO>>() {
            @Override
            public void onResponse(Call<List<POJO>> call, Response<List<POJO>> response) {

                if (response.isSuccessful()){



                    List<POJO> mPOJO = response.body();

                    for (int i=0; i < mPOJO.size(); i++){
                        POJO pojo = mPOJO.get(i);
                        recyclerAdapterPOJO.addData(pojo);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<POJO>> call, Throwable t) {

            }
        });



    }

    private void configViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMero);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerAdapterPOJO = new RecyclerAdapterPOJO();
        recyclerView.setAdapter(recyclerAdapterPOJO);

    }


}
