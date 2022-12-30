package com.example.newsapp;

import com.example.newsapp.Models.Newsheadlines;

import java.util.List;

public interface OndataFetchListener<NewsApiResponse> {

    void onFetchdata(List<Newsheadlines> list,String message);

    void oneError(String message);

}
