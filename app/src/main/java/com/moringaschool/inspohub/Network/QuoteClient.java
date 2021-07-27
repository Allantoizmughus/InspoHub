package com.moringaschool.inspohub.Network;

import com.moringaschool.inspohub.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteClient {
    private static Retrofit retrofit = null;

    public static QuoteApi getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuoteApi.class);
    }
}
