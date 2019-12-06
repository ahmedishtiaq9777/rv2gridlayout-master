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

return  view;





        //return inflater.inflate(R.layout.homefragment,  null);

    }


}
