package com.demotxt.myapp.recyclerview;

public class Prod {

    private String Title;
    private String Description;
    private int Thumbnail;
    private String Price;

    public Prod(String title, String description, int thumbnail,String price) {
        Title = title;
        Description = description;
        Thumbnail = thumbnail;
        Price = price;
    }

    //GET
    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public String getPrice(){return Price;}

    //SET
    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setPrice(String price){Price = price;}
}
