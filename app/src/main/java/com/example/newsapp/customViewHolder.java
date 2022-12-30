package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class customViewHolder extends RecyclerView.ViewHolder {

    TextView title,data;
    ImageView img;
    CardView cardView;
    public customViewHolder(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title);
        data=itemView.findViewById(R.id.data);
        img=itemView.findViewById(R.id.img_news);
        cardView=itemView.findViewById(R.id.container);
    }


}
