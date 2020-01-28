package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.demotxt.myapp.recyclerview.productlist.ShoppyProductListActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test extends AppCompatActivity {


    private ArrayList<String> images;
    private ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

image=(ImageView)findViewById(R.id.imageView1);


        try {

            final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            // String url = "http:// 192.168.10.13:64077/api/login";
            //String url="https://api.myjson.com/bins/kp9wz";
            String url = "http://ahmedishtiaqbutt-001-site1.atempurl.com/Home/getproducts";


            StringRequest rRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                          //  Log.i("Responce: ", response);
                            try {
                                //images=new ArrayList<String>();
                                JSONArray array = new JSONArray(response);
                                String j=new String("img");

                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject product = array.getJSONObject(i);
                                    String img=product.getString("productImage");
                                    j=img;
                                    //images.add(img);
                                    Log.i("path: ", img);
                                }
                                    j="http://ahmedishtiaqbutt-001-site1.atempurl.com"+j;
                                 Toast.makeText(getApplicationContext(),"error: "+j,Toast.LENGTH_SHORT).show();
                               // Picasso.get().load(j).into(image);
                                Picasso.get().load(j).into(image);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            // response
                            //  Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();





                                // getconnection("http://ahmedishtiaqbutt-001-site1.atempurl.com/Home/getproducts/");





                                // finish();
                                //  Intent intent2=new Intent(Login.this,MainActivity2.class);

                                //  startActivity(intent2);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.i("APIERROR", error.getMessage());
                            Toast.makeText(getApplicationContext(), "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", "ahmedishtiaq");
                    params.put("password", "1234567");
                    return params;
                }
                @Override

                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
            };

            requestQueue.add(rRequest);


        }catch (Exception E)
        {
            Toast.makeText(getApplicationContext(),"Error: "+E.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }

    }

