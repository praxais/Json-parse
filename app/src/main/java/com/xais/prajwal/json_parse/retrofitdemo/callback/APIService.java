package com.xais.prajwal.json_parse.retrofitdemo.callback;

import com.xais.prajwal.json_parse.retrofitdemo.pojo.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Prajwal on 2016-11-21.
 */

public interface APIService {

    @GET("parkdb/getpark_json.php")
    Call<List<Category>> getAllCategory();

}
