package com.demotxt.myapp.recyclerview;

public class ExampleItem {
    private String mImageUrl;
    private String mTitle;
    private int mPrice;

    public ExampleItem(String imageUrl,String title,int price)
    {
        mImageUrl = imageUrl;
        mTitle = title;
        mPrice = price;
    }

    public String getImageUrl(){
        return mImageUrl;
    }
    public String getTitle(){
        return mTitle;
    }
    public int getPrice(){
        return mPrice;
    }



}
