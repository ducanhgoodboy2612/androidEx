package com.materialuiux.store;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.materialuiux.store.adapter.Ad_Main;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerViewShop;
    Ad_Main ad_main;
    LinearLayoutManager layoutManager;
    TextView profileText ,blogText ,walletText,aboutUs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        recyclerViewShop = findViewById(R.id.main_shop);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewShop.setHasFixedSize(true);
        recyclerViewShop.setLayoutManager(layoutManager);
        ad_main = new Ad_Main(this,getimages());
        recyclerViewShop.setAdapter(ad_main);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        profileText = findViewById(R.id.id_profile);
        blogText = findViewById(R.id.id_blog);
        walletText = findViewById(R.id.id_wallet);
        aboutUs = findViewById(R.id.id_about_us);

        profileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });

        blogText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,BlogActivity.class);
                startActivity(i);
            }
        });

        walletText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,WalletActivity.class);
                startActivity(i);
            }
        });


        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AboutUs.class);
                startActivity(i);
            }
        });
    }

    private ArrayList<Integer> getimages() {
        ArrayList mDataSet = new ArrayList();
        mDataSet.add(R.drawable.image1);
        mDataSet.add(R.drawable.sute);
        mDataSet.add(R.drawable.women);
        mDataSet.add(R.drawable.glasses);
        mDataSet.add(R.drawable.glasses2);
        mDataSet.add(R.drawable.glasses3);
        mDataSet.add(R.drawable.watchesman);
        mDataSet.add(R.drawable.watcheswomen);
        mDataSet.add(R.drawable.watchesman);
        mDataSet.add(R.drawable.watcheswomen);
        mDataSet.add(R.drawable.watchesman);
        mDataSet.add(R.drawable.watchesman);
        mDataSet.add(R.drawable.watchesman);
        return mDataSet;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
