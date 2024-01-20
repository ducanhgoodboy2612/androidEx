package com.materialuiux.store;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.materialuiux.store.adapter.PickerColorAdapter;
import com.materialuiux.store.utility.ExpandOrCollapse;

public class ProductCard extends AppCompatActivity {


    LinearLayout collapsablelayout, collapsablelayout2;
    private boolean isVisible = false;
    private boolean isVisible2 = false;
    private TextView descriptionText, descriptionText2;
    private RelativeLayout checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_card);


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

        PickerColorAdapter adapter = new PickerColorAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.id_recycler_view_color_picker);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        checkout = findViewById(R.id.id_checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCard.this, CartActivity.class);
                startActivity(intent);
            }
        });

        final ImageView imageView = findViewById(R.id.id_expand_bt);
        collapsablelayout = findViewById(R.id.collapsable);

        final ImageView imageView2 = findViewById(R.id.id_expand_bt2);
        collapsablelayout2 = findViewById(R.id.collapsable2);

        descriptionText2 = findViewById(R.id.id_description2);
        descriptionText = findViewById(R.id.id_description);
        collapsablelayout.setVisibility(View.GONE);
        imageView.setBackground(getDrawable(R.drawable.ic_add));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible) {
                    ExpandOrCollapse.collapse(collapsablelayout, 3000, -200);
                    isVisible = false;
                    descriptionText.setVisibility(View.GONE);
                    imageView.setBackground(getDrawable(R.drawable.ic_add));
                } else if (!isVisible) {
                    ExpandOrCollapse.expand(collapsablelayout, 3000, -200);
                    isVisible = true;
                    descriptionText.setVisibility(View.VISIBLE);
                    imageView.setBackground(getDrawable(R.drawable.ic_minus));
                }
            }
        });

        collapsablelayout2.setVisibility(View.GONE);
        imageView2.setBackground(getDrawable(R.drawable.ic_add));
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible2) {
                    ExpandOrCollapse.collapse(collapsablelayout2, 1000, -200);
                    isVisible2 = false;
                    descriptionText2.setVisibility(View.GONE);
                    imageView2.setBackground(getDrawable(R.drawable.ic_add));
                } else if (!isVisible2) {
                    ExpandOrCollapse.expand(collapsablelayout2, 1000, 200);
                    isVisible2 = true;
                    descriptionText2.setVisibility(View.VISIBLE);
                    imageView2.setBackground(getDrawable(R.drawable.ic_minus));
                }
            }
        });
    }

}
