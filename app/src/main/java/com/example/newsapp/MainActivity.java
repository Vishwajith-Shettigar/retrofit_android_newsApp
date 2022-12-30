package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newsapp.Models.NewsApiResponse;
import com.example.newsapp.Models.Newsheadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
RecyclerView recyclerView;
customAdapter customAdapter;
ProgressDialog progressDialog;
Button b1,b2,b3,b4,b5,b6,b7;
    ReqManager reqManager;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


searchView=findViewById(R.id.search);

searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {

        progressDialog.setTitle("fetching...");
        progressDialog.show();
        reqManager.getNewsHeadlines(listener,"general",query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }
});
        b1=findViewById(R.id.btnone);
b1.setOnClickListener(this);

        b2=findViewById(R.id.btntwo);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.btnthree);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.btnfour);
        b4.setOnClickListener(this);
        b5=findViewById(R.id.btnfive);
        b5.setOnClickListener(this);
        b6=findViewById(R.id.btnsix);
        b6.setOnClickListener(this);
        b7=findViewById(R.id.btnseven);
        b7.setOnClickListener(this);
progressDialog=new ProgressDialog(this);
progressDialog.setTitle("fetching ...");
progressDialog.show();
         reqManager= new ReqManager(this);
        reqManager.getNewsHeadlines(listener,"general",null);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reqManager.getNewsHeadlines(listener,"",null);
            }
        });


    }

    public  final  OndataFetchListener<NewsApiResponse> listener= new OndataFetchListener<NewsApiResponse>() {
        @Override
        public void onFetchdata(List<Newsheadlines> list, String message) {

            if(list.isEmpty())
            {
                Toast.makeText(getApplicationContext()," Sorry no feed",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                return;
            }

            recyclerView=findViewById(R.id.recycler_main);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
            customAdapter= new customAdapter(MainActivity.this,list,selectListener);
            recyclerView.setAdapter(customAdapter);
            progressDialog.dismiss();


        }

        @Override
        public void oneError(String message) {

            Toast.makeText(getApplicationContext(),"something happened",Toast.LENGTH_SHORT).show();

        }
    };
    SelectListener selectListener=new SelectListener()
    {

        @Override
        public void OnNewsClicked(Newsheadlines data) {
            startActivity(new Intent(MainActivity.this, Diplaynews.class)
                    .putExtra("data",data)

            );


        }
    };

    @Override
    public void onClick(View v) {

        Button button=(Button) v;
        String cat=button.getText().toString();
        progressDialog.setTitle("fetching...");
        progressDialog.show();
        reqManager.getNewsHeadlines(listener,cat,null);

    }
}