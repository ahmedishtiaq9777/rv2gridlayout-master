package com.demotxt.myapp.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.demotxt.myapp.recyclerview.R;
import com.demotxt.myapp.recyclerview.r3;
import com.demotxt.myapp.recyclerview.r3_Activity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView3 extends RecyclerView.Adapter<RecyclerView3.MyViewHolder> implements Filterable {

    private Context mContext ;
    private List<r3> Data2 ;
    //
    private List<r3> r3Full;


    public RecyclerView3(Context mContext, List<r3> data) {
        this.mContext = mContext;
        this.Data2 = data;
        //
        r3Full = new ArrayList<>(data);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_r3,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_r3_title.setText(Data2.get(position).getTitle());
        holder.tv_r3_price.setText(Data2.get(position).getPrice());
        holder.img_r3_thumbnail.setImageResource(Data2.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, r3_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",Data2.get(position).getTitle());
                intent.putExtra("Description",Data2.get(position).getDescription());
                intent.putExtra("Thumbnail",Data2.get(position).getThumbnail());
                intent.putExtra("Price",Data2.get(position).getPrice());
                // start the activity
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return Data2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_r3_title,tv_r3_price;
        ImageView img_r3_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_r3_title = itemView.findViewById(R.id.r3_title_id) ;
            tv_r3_price = itemView.findViewById(R.id.r3_price_id);
            img_r3_thumbnail = itemView.findViewById(R.id.r3_img_id);
            cardView = itemView.findViewById(R.id.cardview3);


        }
    }
//Filter
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<r3> filteredlist = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredlist.addAll(r3Full);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (r3 item : r3Full){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredlist.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredlist;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Data2.clear();
            Data2.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };
}
