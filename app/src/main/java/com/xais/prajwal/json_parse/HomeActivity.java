package com.xais.prajwal.json_parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xais.prajwal.json_parse.json.MainActivity;
import com.xais.prajwal.json_parse.retrofit.MeroActivity;
import com.xais.prajwal.json_parse.retrofitdemo.ui.MyActivity;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
    }

    public void onJson(View view) {
        Intent json_intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(json_intent);
    }

    public void onRetrofit2(View view) {
        Intent retrofit_intent = new Intent(HomeActivity.this, MeroActivity.class);
        startActivity(retrofit_intent);
    }

    public void onRetrofit2n(View view) {
        Intent retrofitn_intent = new Intent(HomeActivity.this, MyActivity.class);
        startActivity(retrofitn_intent);
    }
}
