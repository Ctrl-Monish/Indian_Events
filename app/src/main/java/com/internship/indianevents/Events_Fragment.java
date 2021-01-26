package com.internship.indianevents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Events_Fragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView_Adapter recyclerView_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.events_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_viewevents);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<EventsModel> options =
                new FirebaseRecyclerOptions.Builder<EventsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("January").child(MainActivity.dateOfEvent).child("Events"), EventsModel.class)
                        .build();

        recyclerView_adapter = new RecyclerView_Adapter(options);
        recyclerView.setAdapter(recyclerView_adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView_adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerView_adapter.stopListening();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}