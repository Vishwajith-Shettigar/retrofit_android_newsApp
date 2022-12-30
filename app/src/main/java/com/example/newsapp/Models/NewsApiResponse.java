package com.example.newsapp.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse  implements Serializable {

    String status;
    int totalResults;

    List<Newsheadlines>articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Newsheadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<Newsheadlines> articles) {
        this.articles = articles;
    }
}
