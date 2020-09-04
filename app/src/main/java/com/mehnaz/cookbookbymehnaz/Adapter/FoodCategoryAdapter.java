package com.mehnaz.cookbookbymehnaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mehnaz.cookbookbymehnaz.Models.FruitModel;
import com.mehnaz.cookbookbymehnaz.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FruitModel> imageModelArrayList;

    public FoodCategoryAdapter(Context ctx, ArrayList<FruitModel> imageModelArrayList1){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList1;
    }

    @Override
    public FoodCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_single_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FoodCategoryAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        CircleImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv);
            iv = (CircleImageView) itemView.findViewById(R.id.iv);
        }

    }
}