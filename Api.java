package com.example.rahul.retrofituserexanple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by rahul on 14/4/16.
 */
public interface Api {

    //@Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=10000000")
    @FormUrlEncoded
    @POST("api.php?rquest=getAuthorBookList")
    Call<Books> getBooks(@Field("author_id") String Author_id);

}
