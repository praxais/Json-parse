package com.xais.prajwal.json_parse.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Prajwal on 2016-11-21.
 */

public interface APIService {

    @GET("zz/getxais.php")
    Call<List<POJO>> getAllXais();
}
