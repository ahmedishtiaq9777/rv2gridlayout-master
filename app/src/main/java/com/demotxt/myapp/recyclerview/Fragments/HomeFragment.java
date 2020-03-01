package com.demotxt.myapp.recyclerview.Fragments;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.demotxt.myapp.recyclerview.Adapter.ExampleAdapter;
import com.demotxt.myapp.recyclerview.Adapter.RecyclerView3;
import com.demotxt.myapp.recyclerview.Adapter.RecyclerViewAdapter;
import com.demotxt.myapp.recyclerview.Adapter.RecyclerViewProdAdapter;
import com.demotxt.myapp.recyclerview.Book;
import com.demotxt.myapp.recyclerview.Book_Activity;
import com.demotxt.myapp.recyclerview.ExampleItem;
import com.demotxt.myapp.recyclerview.Prod;
import com.demotxt.myapp.recyclerview.Prod_Activity;
import com.demotxt.myapp.recyclerview.R;
import com.demotxt.myapp.recyclerview.r3;
import com.demotxt.myapp.recyclerview.r3_Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Book> lstBook2;
    List<Prod> Book22;
    List<r3> mTrends;
    ViewFlipper mFlipper;

    private RecyclerView3 myAdapter2;
    //R-4
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Data for view 1
        lstBook2 = new ArrayList<>();
        lstBook2.add(new Book("Toddler suit", "Kids suit", R.drawable.baby,"20$"));
        lstBook2.add(new Book("Two", "Shoes", R.drawable.shoes,"20$"));
        lstBook2.add(new Book("Dress", "Women Dress",  R.drawable.female,"13$"));
        lstBook2.add(new Book("Designer Jacket", "Nice Men's Jacket",  R.drawable.jacket,"7$"));
        lstBook2.add(new Book("Toddler suit", " New Kids Suit", R.drawable.baby,"18$"));
        lstBook2.add(new Book("Black shoes", "Shoes",  R.drawable.shoes,"11$"));
        lstBook2.add(new Book("Dress", "Women",  R.drawable.female,"25$"));
        lstBook2.add(new Book("Designer Jacket", "Men",  R.drawable.jacket,"23$"));
        lstBook2.add(new Book("Toddler suit", "Kids",  R.drawable.baby,"29$"));
        lstBook2.add(new Book("Black shoes", "Shoes",R.drawable.shoes,"6$"));
        lstBook2.add(new Book("Dress", "Women", R.drawable.female,"15$"));
        lstBook2.add(new Book("Designer Jacket", "Men",  R.drawable.jacket,"16$"));

        //Data for view 2
        Book22 = new ArrayList<>();
        Book22.add(new Prod("Toddler suit", "Kids suit", R.drawable.baby,"20$"));
        Book22.add(new Prod("Black shoes", "Good Shoes", R.drawable.shoes,"22$"));
        Book22.add(new Prod("Dress", "Women Dress",  R.drawable.female,"13$"));
        Book22.add(new Prod("Designer Jacket", "Nice Men's Jacket",  R.drawable.jacket,"7$"));
        Book22.add(new Prod("Toddler suit", " New Kids Suit", R.drawable.baby,"18$"));
        Book22.add(new Prod("Black shoes", "Shoes",  R.drawable.shoes,"11$"));
        Book22.add(new Prod("Dress", "Women",  R.drawable.female,"25$"));
        Book22.add(new Prod("Designer Jacket", "Men",  R.drawable.jacket,"23$"));
        Book22.add(new Prod("Toddler suit", "Kids",  R.drawable.baby,"29$"));
        Book22.add(new Prod("Black shoes", "Shoes",R.drawable.shoes,"6$"));
        Book22.add(new Prod("Dress", "Women", R.drawable.female,"15$"));
        Book22.add(new Prod("Designer Jacket", "Men",  R.drawable.jacket,"16$"));

        //Data for view 3

        mTrends = new ArrayList<>();
        mTrends.add(new r3("Toddler suit", "Kids suit", R.drawable.baby,"20$"));
        mTrends.add(new r3("Black shoes", "Good Shoes", R.drawable.shoes,"22$"));
        mTrends.add(new r3("Dress", "Women Dress",  R.drawable.female,"13$"));
        mTrends.add(new r3("Designer Jacket", "Nice Men's Jacket",  R.drawable.jacket,"7$"));
        mTrends.add(new r3("Toddler suit", " New Kids Suit", R.drawable.baby,"18$"));
        mTrends.add(new r3("Black shoes", "Shoes",  R.drawable.shoes,"11$"));
        mTrends.add(new r3("Dress", "Women",  R.drawable.female,"25$"));
        mTrends.add(new r3("Designer Jacket", "Men",  R.drawable.jacket,"23$"));
        mTrends.add(new r3("Toddler suit", "Kids",  R.drawable.baby,"29$"));
        mTrends.add(new r3("Black shoes", "Shoes",R.drawable.shoes,"6$"));
        mTrends.add(new r3("Dress", "Women", R.drawable.female,"15$"));
        mTrends.add(new r3("Designer Jacket", "Men",  R.drawable.jacket,"16$"));
        View view = inflater.inflate(R.layout.homefragment, container, false);
        //R-4

        mRecyclerView = view.findViewById(R.id.recycler_view4);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mExampleList = new ArrayList<>();

     /*   mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();*/

//Inflating Cards
        View v1 = inflater.inflate(R.layout.cardveiw_item_book,null);
        View v2 = inflater.inflate(R.layout.cardveiw_item_prod, null);
        View v3 = inflater.inflate(R.layout.cardview_item_r3,null);

        ImageView book = (ImageView) v1.findViewById(R.id.book_img_id);
        ImageView prod = (ImageView) v2.findViewById(R.id.prod_img_id);
        ImageView rr3  = (ImageView) v3.findViewById(R.id.r3_img_id);

//Recycler View 1
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(), lstBook2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv.setLayoutManager(layoutManager);
        myrv.setHasFixedSize(true);
        myrv.setAdapter(myAdapter);

//Recycler View 2

        RecyclerView myrv2 = (RecyclerView) view.findViewById(R.id.recyclerview2);
        RecyclerViewProdAdapter myAdapter1 = new RecyclerViewProdAdapter(getActivity(), Book22);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv2.setLayoutManager(layoutManager1);
        myrv2.setHasFixedSize(true);
        myrv2.setAdapter(myAdapter1);

//Recycler View 3

        RecyclerView myrv3 = (RecyclerView) view.findViewById(R.id.recyclerview3);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myAdapter2 = new RecyclerView3(getActivity(), mTrends);
        myrv3.setLayoutManager(layoutManager2);
        myrv3.setHasFixedSize(true);
        myrv3.setAdapter(myAdapter2);

//ON CLick listener on cards

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookdetail = new Intent(getActivity(), Book_Activity.class);
                startActivity(bookdetail);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proddetail = new Intent(getActivity(), Prod_Activity.class);
                startActivity(proddetail);
            }
        });

        rr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r3detail = new Intent(getActivity(), r3_Activity.class);
                startActivity(r3detail);
            }
        });

//Flipper
        int images[] = {R.drawable.ac_banner, R.drawable.cloth_banner, R.drawable.sale1, R.drawable.mobile_banner};
        mFlipper = view.findViewById(R.id.flipper);


        for (int image : images) {
            flipperImages(image);
        }
        return view;
    }

   /* private void parseJSON() {

        String url = "http://ahmedishtiaqbutt-001-site1.atempurl.com/Home/getrecommendedpro";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("0");

                            for (int i = 0; i < jsonObject.length(); i++) {
                                JSONObject productList = jsonObject.getJSONObject("0");

                                String Title = productList.getString("title");
                                String imageUrl = productList.getString("productImage");
                                int priceCount = productList.getInt("price");

                                mExampleList.add(new ExampleItem(imageUrl, Title, priceCount));
                            }

                            mExampleAdapter = new ExampleAdapter(getActivity(), mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }*/

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        mFlipper.addView(imageView);
        mFlipper.setFlipInterval(4000);
        mFlipper.setAutoStart(true);

        mFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        mFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.example_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter2.getFilter().filter(newText);
                return false;
            }
        });
    }
}

