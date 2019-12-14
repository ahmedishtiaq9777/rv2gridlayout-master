package com.demotxt.myapp.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Data for view 1
        lstBook2 = new ArrayList<>();
        lstBook2.add(new Book("Toddler suit","Kids","Description",R.drawable.baby));
        lstBook2.add(new Book("Black shoes","Shoes","Description",R.drawable.shoes));
        lstBook2.add(new Book("Dress","Women","Description",R.drawable.female));
        lstBook2.add(new Book("Designer Jacket"," Men","Description",R.drawable.jacket));
        lstBook2.add(new Book("Toddler suit","Kids","Description",R.drawable.baby));
        lstBook2.add(new Book("Black shoes","Shoes","Description",R.drawable.shoes));
        lstBook2.add(new Book("Dress","Women","Description",R.drawable.female));
        lstBook2.add(new Book("Designer Jacket","Men","Description",R.drawable.jacket));
        lstBook2.add(new Book("Toddler suit","Kids","Description",R.drawable.baby));
        lstBook2.add(new Book("Black shoes","Shoes","Description",R.drawable.shoes));
        lstBook2.add(new Book("Dress","Women","Description",R.drawable.female));
        lstBook2.add(new Book("Designer Jacket","Men","Description",R.drawable.jacket));

        //Data for view 2
        Book22 = new ArrayList<>();
        Book22.add(new Prod("Toddler suit","Kids","Description",R.drawable.baby));
        Book22.add(new Prod("Black shoes","Shoes","Description",R.drawable.shoes));
        Book22.add(new Prod("Dress","Women","Description",R.drawable.female));
        Book22.add(new Prod("Designer Jacket"," Men","Description",R.drawable.jacket));
        Book22.add(new Prod("Toddler suit","Kids","Description",R.drawable.baby));
        Book22.add(new Prod("Black shoes","Shoes","Description",R.drawable.shoes));
        Book22.add(new Prod("Dress","Women","Description",R.drawable.female));
        Book22.add(new Prod("Designer Jacket","Men","Description",R.drawable.jacket));
        Book22.add(new Prod("Toddler suit","Kids","Description",R.drawable.baby));
        Book22.add(new Prod("Black shoes","Shoes","Description",R.drawable.shoes));
        Book22.add(new Prod("Dress","Women","Description",R.drawable.female));
        Book22.add(new Prod("Designer Jacket","Men","Description",R.drawable.jacket));

        //Data for view 3

        mTrends = new ArrayList<>();
        mTrends.add(new r3("Toddler suit","Kids","Description",R.drawable.baby));
        mTrends.add(new r3("Black shoes","Shoes","Description",R.drawable.shoes));
        mTrends.add(new r3("Dress","Women","Description",R.drawable.female));
        mTrends.add(new r3("Designer Jacket"," Men","Description",R.drawable.jacket));
        mTrends.add(new r3("Toddler suit","Kids","Description",R.drawable.baby));
        mTrends.add(new r3("Black shoes","Shoes","Description",R.drawable.shoes));
        mTrends.add(new r3("Dress","Women","Description",R.drawable.female));
        mTrends.add(new r3("Designer Jacket","Men","Description",R.drawable.jacket));
        mTrends.add(new r3("Toddler suit","Kids","Description",R.drawable.baby));
        mTrends.add(new r3("Black shoes","Shoes","Description",R.drawable.shoes));
        mTrends.add(new r3("Dress","Women","Description",R.drawable.female));
        mTrends.add(new r3("Designer Jacket","Men","Description",R.drawable.jacket));


//Recycler View 1
        View view= inflater.inflate(R.layout.homefragment,  null);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstBook2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));

       myrv.setLayoutManager(layoutManager);
       myrv.setAdapter(myAdapter);


//Recycler View 2

      //  View view2= inflater.inflate(R.layout.homefragment,  null);
        RecyclerView myrv2=(RecyclerView) view.findViewById(R.id.recyclerview2);
        RecyclerViewProdAdapter myAdapter1 = new RecyclerViewProdAdapter(getActivity(),Book22);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv2.setLayoutManager(layoutManager1);
        myrv2.setAdapter(myAdapter1);

//Recycler View 3

        //  View view2= inflater.inflate(R.layout.homefragment,  null);
        RecyclerView myrv3=(RecyclerView) view.findViewById(R.id.recyclerview3);
        RecyclerView3 myAdapter2 = new RecyclerView3(getActivity(),mTrends);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myrv3.setLayoutManager(layoutManager2);
        myrv3.setAdapter(myAdapter2);

return  view;





        //return inflater.inflate(R.layout.homefragment,  null);

    }


}
