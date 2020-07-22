package com.route.islamimon.APi;

import com.route.islamimon.model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abdulrahman Gaballah on 10/14/2019.
 * jaballah.9999@gmail.com
 */
public interface WebServices {


    @GET("radio_arabic.json")
    Call<RadiosResponse> getRadioChannels();
}
