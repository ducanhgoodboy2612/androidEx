package com.materialuiux.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.materialuiux.store.adapter.Ad_Blog;
import com.materialuiux.store.adapter.Ad_Main;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {

    RecyclerView recyclerViewBlog;
    Ad_Blog ad_main;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recyclerViewBlog = findViewById(R.id.blog_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewBlog.setHasFixedSize(true);
        recyclerViewBlog.setLayoutManager(layoutManager);
        ad_main = new Ad_Blog(this,getimages());
        recyclerViewBlog.setAdapter(ad_main);

    }
    private ArrayList<Integer> getimages() {
        ArrayList mDataSet = new ArrayList();
        mDataSet.add(R.drawable.blog12);
        mDataSet.add(R.drawable.blog2);
        mDataSet.add(R.drawable.blog3);
        mDataSet.add(R.drawable.blog4);
        mDataSet.add(R.drawable.blog5);
        mDataSet.add(R.drawable.blog6);
        mDataSet.add(R.drawable.blog6);
        mDataSet.add(R.drawable.blog7);
        mDataSet.add(R.drawable.blog8);
        mDataSet.add(R.drawable.blog9);
        mDataSet.add(R.drawable.blog10);
        mDataSet.add(R.drawable.blog11);
        mDataSet.add(R.drawable.blog12);
        return mDataSet;
    }
}
