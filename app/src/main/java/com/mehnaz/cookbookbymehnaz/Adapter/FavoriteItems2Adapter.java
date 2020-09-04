package com.mehnaz.cookbookbymehnaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mehnaz.cookbookbymehnaz.Models.FruitModel;
import com.mehnaz.cookbookbymehnaz.R;

import java.util.ArrayList;


public class FavoriteItems2Adapter extends RecyclerView.Adapter<FavoriteItems2Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FruitModel> imageModelArrayList;

    public FavoriteItems2Adapter(Context ctx, ArrayList<FruitModel> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public FavoriteItems2Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.top_dishesh_items, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FavoriteItems2Adapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.textView2.setText(imageModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tvCategoryName);
            textView2 = (TextView) itemView.findViewById(R.id.tvTitle);
            textView3 = (TextView) itemView.findViewById(R.id.tvPrepTime);
            textView4 = (TextView) itemView.findViewById(R.id.tvDate);
            iv = (ImageView) itemView.findViewById(R.id.imageView2);
        }

    }
}

