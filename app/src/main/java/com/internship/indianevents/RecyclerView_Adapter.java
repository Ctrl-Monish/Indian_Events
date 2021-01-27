package com.internship.indianevents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RecyclerView_Adapter extends FirebaseRecyclerAdapter<EventsModel, RecyclerView_Adapter.myViewHolder> {


    public RecyclerView_Adapter(@NonNull FirebaseRecyclerOptions<EventsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull EventsModel model) {
        holder.yearView.setText(model.getDate());
        holder.textView.setText(model.getText());
        Glide.with(holder.imageView.getContext()).load(model.getPurl()).into(holder.imageView);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new myViewHolder(view);
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView yearView;
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            yearView = itemView.findViewById(R.id.item_year);
            textView = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }


}


