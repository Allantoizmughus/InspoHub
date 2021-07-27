package com.moringaschool.inspohub.Network;

import com.moringaschool.inspohub.Model.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApi {
    @GET("/api/v3/quotes")
    Call<List<Quote>> getQuotes();

}
