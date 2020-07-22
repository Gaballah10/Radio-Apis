package com.route.islamimon.APi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abdulrahman Gaballah on 10/14/2019.
 * jaballah.9999@gmail.com
 */
public class APIManager {

    private static Retrofit retrofit;
    private static Retrofit getInstance(){
        if(retrofit==null)
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.mp3quran.net/radios/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;

    }

    public static WebServices getApis(){
        return  getInstance().create(WebServices.class);
    }
}
