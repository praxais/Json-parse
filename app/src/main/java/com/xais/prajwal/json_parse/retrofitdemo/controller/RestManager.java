package com.xais.prajwal.json_parse.retrofitdemo.controller;

import com.xais.prajwal.json_parse.retrofitdemo.callback.APIService;
import com.xais.prajwal.json_parse.retrofitdemo.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class RestManager {

    private APIService apiService;

    public APIService getApiService(){

        if (apiService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(APIService.class);
        }

        return apiService;
    }
}
