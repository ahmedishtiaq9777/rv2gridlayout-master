package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class r3_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvPrice;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3);

        tvtitle = (TextView) findViewById(R.id.r3title);
        tvdescription = (TextView) findViewById(R.id.r3Desc);
        tvPrice = (TextView) findViewById(R.id.r3Price);
        img = (ImageView) findViewById(R.id.r3thumbnail);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;
        String Price = intent.getExtras().getString("Price");

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvPrice.setText(Price);
        img.setImageResource(image);


    }
}
