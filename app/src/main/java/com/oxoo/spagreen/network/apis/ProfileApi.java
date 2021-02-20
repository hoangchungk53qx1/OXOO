package com.oxoo.spagreen.network.apis;

import android.net.Uri;

import com.oxoo.spagreen.network.model.ResponseStatus;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ProfileApi {
    @FormUrlEncoded
    @POST("update_profile")
    Call<ResponseStatus> updateProfile(@Header("API-KEY") String apiKey,
                                       @Field("id") String id,
                                       @Field("name") String name,
                                       @Field("email") String email,
                                       @Field("phone") String phone,
                                       @Field("password") String password,
                                       @Field("photo") Uri imageUri,
                                       @Field("gender") String gender);

}
