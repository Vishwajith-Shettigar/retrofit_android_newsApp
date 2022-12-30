package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.Newsheadlines;
import com.squareup.picasso.Picasso;

public class Diplaynews extends AppCompatActivity {
Newsheadlines newsheadlines;
TextView title,author,content,time,detail;
ImageView imagenews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplaynews);

title=findViewById(R.id.title);
author=findViewById(R.id.author);


        content=findViewById(R.id.content);
        time=findViewById(R.id.time);
        detail=findViewById(R.id.detail);
        imagenews=findViewById(R.id.imagenews);

        newsheadlines=(Newsheadlines) getIntent().getSerializableExtra("data");
title.setText(newsheadlines.getTitle());
author.setText(newsheadlines.getAuthor());
time.setText(newsheadlines.getPublishedAt());
content.setText(newsheadlines.getContent());
detail.setText(newsheadlines.getDescription());
        Picasso.get().load(newsheadlines.getUrltoImage()).into(imagenews);




    }
}