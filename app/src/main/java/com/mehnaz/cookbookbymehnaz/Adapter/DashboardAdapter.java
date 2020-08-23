package com.mehnaz.cookbookbymehnaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mehnaz.cookbookbymehnaz.R;

public class  DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    private String[] mData = new String[0];
    private String [] values = new String[0];
//  private int [] images= new int[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public DashboardAdapter(Context context, String[] data, String[] value) {
        this.mInflater = LayoutInflater.from(context);
//       this.images =images;
        this.mData = data;
        this.values =value;

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
        String title = mData[position];
        String  subtext = values[position];
//         int image =images[position];
        holder.myTextView.setText(title);
        holder.textView.setText(subtext);
//     holder.imageView.setImageResource(image);

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView textView;
       CardView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.tvTitle);
            textView = (TextView) itemView.findViewById(R.id.tvSubject);
            imageView = (CardView) itemView.findViewById(R.id.imgMarks);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData[id];
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