package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvPrice;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.booktitle);
        tvdescription = (TextView) findViewById(R.id.bookDesc);
        tvPrice = (TextView) findViewById(R.id.bookPrice);
        img = (ImageView) findViewById(R.id.bookthumbnail);

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
