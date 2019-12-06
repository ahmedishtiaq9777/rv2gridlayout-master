package com.demotxt.myapp.recyclerview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain2);






        BottomNavigationView navView = findViewById(R.id.nav_view);



        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }

    public  boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentcontainer,fragment)
                    .commit();
            return  true;
        }
        return  false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment=null;
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                fragment=new HomeFragment();
                break;
            case  R.id.nav_favourite:
                fragment=new FavoriteFragment();
                break;
            case  R.id.nav_cart:
                fragment=new CartFragment();
                break;

            case  R.id.nav_acc:
                fragment=new ProfileFragment();
                break;




        }


        return  loadFragment(fragment);
    }
    }
