package com.xais.prajwal.json_parse.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xais.prajwal.json_parse.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Prajwal on 2016-11-18.
 */

public class BackgroundWorker extends AsyncTask<Void, Json, Void> {

    Context context;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Json> arrayList = new ArrayList<>();

    ProgressDialog progressDialog;

    public BackgroundWorker(Context context){
        this.context = context;
        activity = (Activity) context;
    }

    String BASE_URL = "http://10.0.2.2/zz/getxais_server_response.php";

    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please Wait!");
        progressDialog.setMessage("List is loading!!");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null){

                stringBuilder.append(line + "\n");
            }

            httpURLConnection.disconnect();

            String BASE_URL = stringBuilder.toString().trim();

            JSONObject jsonObject = new JSONObject(BASE_URL);

            JSONArray jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;

            while (count < jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);
                count++;

                Json json = new Json(JO.getString("name"), JO.getString("price"), JO.getString("description"));
                publishProgress(json);
            }




            Log.d("BASE_URL", BASE_URL);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Json... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
    }

}
