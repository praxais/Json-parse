package com.xais.prajwal.json_parse.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xais.prajwal.json_parse.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
        backgroundWorker.execute();
    }
}
