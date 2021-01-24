package com.internship.indianevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class RecyclerView_Adapter extends FirebaseRecyclerAdapter<EventsModel, RecyclerView_Adapter.ViewHolder> {


    public RecyclerView_Adapter(@NonNull FirebaseRecyclerOptions<EventsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull EventsModel model) {
        holder.yearView.setText(model.getDate());
        holder.textView.setText(model.getText());
        Glide.with(holder.imageView.getContext()).load(model.getPurl()).into(holder.imageView);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView yearView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearView = itemView.findViewById(R.id.item_year);
            textView = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }


}


