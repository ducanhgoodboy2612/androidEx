package com.materialuiux.store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.materialuiux.store.adapter.Ad_Cart_Order;

public class CartActivity extends AppCompatActivity {

    Ad_Cart_Order ad_card_order;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Button  continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


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

        recyclerView = findViewById(R.id.id_recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ad_card_order = new Ad_Cart_Order();
        recyclerView.setAdapter(ad_card_order);

        continueButton = findViewById(R.id.id_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,AddressActivity.class);
                startActivity(intent);
            }
        });
    }
}
