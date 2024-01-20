package com.materialuiux.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.materialuiux.store.adapter.Ad_Arrivals;
import com.materialuiux.store.model.Clothes;

import java.util.ArrayList;

public class ArrivalsActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    GridLayoutManager gridLayoutManager;
    Ad_Arrivals ad_arricals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrivals);

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

        recyclerview = findViewById(R.id.recyclerview);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        ad_arricals = new Ad_Arrivals(this, getData());

        recyclerview.setAdapter(ad_arricals);

    }

    private ArrayList<Clothes> getData() {
        ArrayList<Clothes> arrayList = new ArrayList<>();
        arrayList.add(new Clothes(R.drawable.nike_t, "Nike Dri-FIT Academy Men's T-Shirt", "Nike", 35));
        arrayList.add(new Clothes(R.drawable.jacket, "jacket", "Nike", 70));
        arrayList.add(new Clothes(R.drawable.niket, "Nike T-Shirts", "Nike", 35));
        arrayList.add(new Clothes(R.drawable.nikeblazerhigh, "Nike Blazer High Shoes", "Nike", 75));
        arrayList.add(new Clothes(R.drawable.guccihandbags, "Gucci Handbags ", "Gucci", 150));
        arrayList.add(new Clothes(R.drawable.hat, "Hat", "Nike", 40));
        arrayList.add(new Clothes(R.drawable.shirt, "Shirts", "Nike", 80));
        arrayList.add(new Clothes(R.drawable.russell, "RUSSELL KIDS LONG SLEEVE ", "RUSSELL", 25));
        return arrayList;
    }

}
