package com.internship.indianevents;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Births_Fragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView_Adapter recyclerView_adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.births_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_viewbirths);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<EventsModel> options =
                new FirebaseRecyclerOptions.Builder<EventsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("January").child(MainActivity.dateOfEvent).child("Births"), EventsModel.class)
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