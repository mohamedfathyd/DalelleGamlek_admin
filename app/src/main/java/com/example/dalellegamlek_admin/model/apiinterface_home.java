package com.example.dalellegamlek_admin.model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {
    @FormUrlEncoded
    @POST("Gmalek_add_category.php") Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name, @Field("image") String image);
    @FormUrlEncoded
    @POST("Gmalek_add_annonce.php") Call<ResponseBody> getcontacts_add_annonce(@Field("image") String image);

    @FormUrlEncoded
    @POST("Gmalek_delete_category.php")
    Call<ResponseBody> delete_first(@Field("id") int id);

    @GET("Gmalek_annonce.php")
    Call<List<contact_annonce>> getcontacts_annonce();
    @FormUrlEncoded
    @POST("Gmalek_delete_annonce.php")
    Call<ResponseBody> delete_annonce(@Field("id") int id);

}

