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
    @POST("montag/dallejamalk/Gmalek_add_category.php") Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name, @Field("image") String image);
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_add_annonce.php") Call<ResponseBody> getcontacts_add_annonce(@Field("image") String image);

    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_delete_category.php")
    Call<ResponseBody> delete_first(@Field("id") int id);

    @GET("montag/dallejamalk/Gmalek_annonce.php")
    Call<List<contact_annonce>> getcontacts_annonce();
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_delete_annonce.php")
    Call<ResponseBody> delete_annonce(@Field("id") int id);
    @GET("montag/dallejamalk/Gmalek_first_category.php")
    Call<List<contact_category>> getcontacts_allfirst();
    @GET("montag/dallejamalk/Gmalek_all_users.php")
    Call<List<contact_users>> getcontacts_users();
    @GET("montag/dallejamalk/Gmalek_all_providers_notaccepted.php")
    Call<List<contact_users>> getcontacts_provider_not();

    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_accept_provider.php")
    Call<ResponseBody> accept_provider(@Field("id") int id);
    @GET("montag/dallejamalk/Gmalek_all_providers_accepted.php")
    Call<List<contact_users>> getcontacts_provider_acc();
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_delete_provider.php")
    Call<ResponseBody> accept_provider_delete(@Field("id") int id);
    //montag/dallejamalk/Gmalek_update_point_provider.php
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_update_point_provider.php")
    Call<ResponseBody> charge_provider(@Field("id") int id,@Field("points")int points);
    @GET("montag/dallejamalk/Gmalek_all_charge_event.php")
    Call<List<content_event>> getcontacts_charge();
    @GET("montag/dallejamalk/Gmalek_all_pull_event.php")
    Call<List<content_event>> getcontacts_pull();
}

