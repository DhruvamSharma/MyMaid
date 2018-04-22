package com.homecaresolutions.mymaid.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.homecaresolutions.mymaid.Adapter.JobListAdapter;
import com.homecaresolutions.mymaid.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView mJobsList;
    private FloatingActionButton mFloatingActionButton;
    private JobListAdapter mAdapter;

    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* RecyclerView finding from XML File */
        mJobsList = findViewById(R.id.home_recycler_view);

        /* Floating Action Button */
        mFloatingActionButton = findViewById(R.id.home_fab);
        mFloatingActionButton.setImageResource(R.drawable.ic_add_white_24dp);

        /* Adapter Listing */
        mArrayList = new ArrayList<>();
        fillData(mArrayList);

        /*Adapter Finding */
        mAdapter = new JobListAdapter(mArrayList);

        /* Layout Manager */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mJobsList.setLayoutManager(layoutManager);
        mJobsList.setAdapter(mAdapter);

        DividerItemDecoration decoration = new DividerItemDecoration(mJobsList.getContext(),layoutManager.getOrientation());
        decoration.setDrawable(mJobsList.getContext().getResources().getDrawable(R.drawable.divider));
        mJobsList.addItemDecoration(decoration);
    }

    public void fillData(ArrayList<String> list) {
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
        list.add("Dummy Data Holder");
    }
}
