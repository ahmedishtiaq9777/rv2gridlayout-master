package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

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
                    .replace(R.id.fragmentcontainer,fragment).addToBackStack(null)
                    .commit();
            return  true;
        }
        return  false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int op=0;

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
            case  R.id.nav_nearby:
                try {
                    Intent i=new Intent(MainActivity2.this,MapFragment.class);
                    op=1;
                    startActivity(i);
                    //fragment=new MapFragment();
                    break;

                }catch (Exception E){

                    Toast.makeText(getApplicationContext(),"error"+E.getMessage(),Toast.LENGTH_SHORT).show();
                }




        }

      if(op!=1)
        return  loadFragment(fragment);
      return false;
    }
    }

