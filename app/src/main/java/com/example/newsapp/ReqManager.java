package com.example.newsapp;

import android.content.Context;

import com.example.newsapp.Models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ReqManager {

    Context context;

    public ReqManager(Context context) {
        this.context = context;
    }


    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



public  void getNewsHeadlines(OndataFetchListener listener,String category,String query)
{

    CallnewApi callnewApi=retrofit.create(CallnewApi.class);
    Call<NewsApiResponse>call= callnewApi.callHeadlines("us",category,query, context.getString(R.string.apikey));

    try{
        call.enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                if(!response.isSuccessful())
                {

                    return;
                }

                listener.onFetchdata(response.body().getArticles(),response.message() );


            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
listener.oneError("request failed");
            }
        });

    }catch (Exception e){


    }

}

    public  interface  CallnewApi{

        @GET("top-headlines")
        Call<NewsApiResponse> callHeadlines(

@Query("country")String country,
@Query("category") String category,
@Query("q") String query,
@Query("apiKey") String apiKey

        );
    }



}
