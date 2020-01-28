package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Book> lstBook2;
    List<Prod> Book22;
    List<r3> mTrends;

    ViewFlipper mFlipper;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Data for view 1
        lstBook2 = new ArrayList<>();
        lstBook2.add(new Book("Toddler suit", "Kids", "Description", R.drawable.baby));
        lstBook2.add(new Book("Black shoes", "Shoes", "Description", R.drawable.shoes));
        lstBook2.add(new Book("Dress", "Women", "Description", R.drawable.female));
        lstBook2.add(new Book("Designer Jacket", " Men", "Description", R.drawable.jacket));
        lstBook2.add(new Book("Toddler suit", "Kids", "Description", R.drawable.baby));
        lstBook2.add(new Book("Black shoes", "Shoes", "Description", R.drawable.shoes));
        lstBook2.add(new Book("Dress", "Women", "Description", R.drawable.female));
        lstBook2.add(new Book("Designer Jacket", "Men", "Description", R.drawable.jacket));
        lstBook2.add(new Book("Toddler suit", "Kids", "Description", R.drawable.baby));
        lstBook2.add(new Book("Black shoes", "Shoes", "Description", R.drawable.shoes));
        lstBook2.add(new Book("Dress", "Women", "Description", R.drawable.female));
        lstBook2.add(new Book("Designer Jacket", "Men", "Description", R.drawable.jacket));

        //Data for view 2
        Book22 = new ArrayList<>();
        Book22.add(new Prod("Toddler suit", "Kids", "Description", R.drawable.baby));
        Book22.add(new Prod("Black shoes", "Shoes", "Description", R.drawable.shoes));
        Book22.add(new Prod("Dress", "Women", "Description", R.drawable.female));
        Book22.add(new Prod("Designer Jacket", " Men", "Description", R.drawable.jacket));
        Book22.add(new Prod("Toddler suit", "Kids", "Description", R.drawable.baby));
        Book22.add(new Prod("Black shoes", "Shoes", "Description", R.drawable.shoes));
        Book22.add(new Prod("Dress", "Women", "Description", R.drawable.female));
        Book22.add(new Prod("Designer Jacket", "Men", "Description", R.drawable.jacket));
        Book22.add(new Prod("Toddler suit", "Kids", "Description", R.drawable.baby));
        Book22.add(new Prod("Black shoes", "Shoes", "Description", R.drawable.shoes));
        Book22.add(new Prod("Dress", "Women", "Description", R.drawable.female));
        Book22.add(new Prod("Designer Jacket", "Men", "Description", R.drawable.jacket));

        //Data for view 3

        mTrends = new ArrayList<>();
        mTrends.add(new r3("Toddler suit", "Kids", "Description", R.drawable.baby));
        mTrends.add(new r3("Black shoes", "Shoes", "Description", R.drawable.shoes));
        mTrends.add(new r3("Dress", "Women", "Description", R.drawable.female));
        mTrends.add(new r3("Designer Jacket", " Men", "Description", R.drawable.jacket));
        mTrends.add(new r3("Toddler suit", "Kids", "Description", R.drawable.baby));
        mTrends.add(new r3("Black shoes", "Shoes", "Description", R.drawable.shoes));
        mTrends.add(new r3("Dress", "Women", "Description", R.drawable.female));
        mTrends.add(new r3("Designer Jacket", "Men", "Description", R.drawable.jacket));
        mTrends.add(new r3("Toddler suit", "Kids", "Description", R.drawable.baby));
        mTrends.add(new r3("Black shoes", "Shoes", "Description", R.drawable.shoes));
        mTrends.add(new r3("Dress", "Women", "Description", R.drawable.female));
        mTrends.add(new r3("Designer Jacket", "Men", "Description", R.drawable.jacket));


//Recycler View 1

        View view = inflater.inflate(R.layout.homefragment, container, false);
        View v2 = inflater.inflate(R.layout.cardveiw_item_prod, null);

        ImageView prod = (ImageView) v2.findViewById(R.id.book_img_id);

        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(), lstBook2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);

//Recycler View 2

        RecyclerView myrv2 = (RecyclerView) view.findViewById(R.id.recyclerview2);
        RecyclerViewProdAdapter myAdapter1 = new RecyclerViewProdAdapter(getActivity(), Book22);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv2.setLayoutManager(layoutManager1);
        myrv2.setAdapter(myAdapter1);

//Recycler View 3

        RecyclerView myrv3 = (RecyclerView) view.findViewById(R.id.recyclerview3);
        RecyclerView3 myAdapter2 = new RecyclerView3(getActivity(), mTrends);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv3.setLayoutManager(layoutManager2);
        myrv3.setAdapter(myAdapter2);


        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productdetail = new Intent(getActivity(), Prod_Activity.class);
                startActivity(productdetail);
            }
        });

//Flipper

        int images[] = {R.drawable.ac_banner,R.drawable.cloth_banner,R.drawable.sale1,R.drawable.mobile_banner};
        mFlipper = view.findViewById(R.id.flipper);


        for(int image: images)
        {
            flipperImages(image);
        }
        return view;
    }

    public void flipperImages(int image)
    {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        mFlipper.addView(imageView);
        mFlipper.setFlipInterval(4000);
        mFlipper.setAutoStart(true);

        mFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        mFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }
}
