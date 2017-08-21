package com.example.peter.test1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Peter on 2017/8/21.
 */

public interface Picface  {
@GET("/api/f_present/present_home")
Call<Pic11> getpic();
}
