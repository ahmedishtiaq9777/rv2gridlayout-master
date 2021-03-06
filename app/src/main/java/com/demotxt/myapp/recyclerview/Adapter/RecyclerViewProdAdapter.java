package com.demotxt.myapp.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.demotxt.myapp.recyclerview.Prod;
import com.demotxt.myapp.recyclerview.Prod_Activity;
import com.demotxt.myapp.recyclerview.R;

import java.util.List;

public class RecyclerViewProdAdapter extends RecyclerView.Adapter<RecyclerViewProdAdapter.MyViewHolder> {

    private Context mContext;
    private List<Prod> Data1;
    private List<Prod> ProdFull;


    public RecyclerViewProdAdapter(Context mContext, List<Prod> data1) {
        this.mContext = mContext;
        this.Data1 = data1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_prod, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_prod_title.setText(Data1.get(position).getTitle());
        holder.tv_prod_price.setText(Data1.get(position).getPrice());
        holder.img_prod_thumbnail.setImageResource(Data1.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Prod_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title", Data1.get(position).getTitle());
                intent.putExtra("Description", Data1.get(position).getDescription());
                intent.putExtra("Thumbnail", Data1.get(position).getThumbnail());
                intent.putExtra("Price", Data1.get(position).getPrice());
                // start the activity
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return Data1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_prod_title, tv_prod_price;
        ImageView img_prod_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_prod_title = itemView.findViewById(R.id.prod_title_id);
            tv_prod_price = itemView.findViewById(R.id.prod_price_id);
            img_prod_thumbnail = itemView.findViewById(R.id.prod_img_id);
            cardView = itemView.findViewById(R.id.cardview2);


        }
    }

}
