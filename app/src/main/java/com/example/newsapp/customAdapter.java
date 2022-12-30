package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.Newsheadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customViewHolder> {

    private Context context;
    private List<Newsheadlines>newsheadlines;
    SelectListener selectListener;

    public customAdapter(Context context, List<Newsheadlines> newsheadlines,SelectListener selectListener) {
        this.context = context;
        this.newsheadlines = newsheadlines;
        this.selectListener=selectListener;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new customViewHolder(LayoutInflater.from(context).inflate(R.layout.items_recyclerview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position) {

holder.title.setText(newsheadlines.get(position).getTitle());
holder.data.setText(newsheadlines.get(position).getSource().getName());

if(newsheadlines.get(position).getUrltoImage()!=null)
{
    Picasso.get().load(newsheadlines.get(position).getUrltoImage())
            .into(holder.img);

}

holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
   selectListener.OnNewsClicked(newsheadlines.get(position));
    }
});


    }

    @Override
    public int getItemCount() {
        return newsheadlines.size();
    }
}
