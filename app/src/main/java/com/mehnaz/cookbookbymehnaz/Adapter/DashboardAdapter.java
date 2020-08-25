package com.mehnaz.cookbookbymehnaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mehnaz.cookbookbymehnaz.Models.FruitModel;
import com.mehnaz.cookbookbymehnaz.R;

import java.util.ArrayList;

public class  DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ArrayList<FruitModel> imageModelArrayList;
    // data is passed into the constructor
    public DashboardAdapter(Context context, ArrayList<FruitModel> imageModelArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.imageModelArrayList = imageModelArrayList;


    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.dashboard_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.myTextView.setText(imageModelArrayList.get(position).getName());

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView textView;
       ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.tvTitle);
            textView = (TextView) itemView.findViewById(R.id.tvSubject);
            imageView = (ImageView) itemView.findViewById(R.id.imgMarks1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }



    // allows clicks events to be caught
    public void setClickListener(DashboardAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}