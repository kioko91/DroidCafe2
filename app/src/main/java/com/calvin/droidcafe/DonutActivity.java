package com.calvin.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DonutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);

        TextView donutTitle=findViewById(R.id.donut_title);
        TextView donutDescription=findViewById(R.id.donut_prep);
        ImageView donutImage=findViewById(R.id.donut_image);

        donutTitle.setText(getIntent().getStringExtra("dTitle"));
        donutDescription.setText(getIntent().getStringExtra("dDescription"));
        Glide.with(this).load(getIntent().getIntExtra("dImage",0)).into(donutImage);
    }
}