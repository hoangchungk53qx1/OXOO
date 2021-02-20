package com.oxoo.spagreen.network.apis;

import com.oxoo.spagreen.network.model.RadioModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FeaturedRadioApi {

    @GET("featured_radio")
    Call<List<RadioModel>> getFeaturedRadio(@Header("API-KEY") String apiKey);
}
