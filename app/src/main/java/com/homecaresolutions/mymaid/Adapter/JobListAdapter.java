package com.homecaresolutions.mymaid.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.homecaresolutions.mymaid.R;

import java.util.ArrayList;

/**
 * Created by dell on 21-04-2018.
 */

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.DataHolder> {

    private ArrayList<String> list;

    public JobListAdapter(ArrayList<String> list) {
        this.list = list;
    }


    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_list_view,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        holder.mTimeData.setText(list.get(position));
        holder.mVenueData.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView mVenueData;
        TextView mTimeData;
        ImageView mCallData;

        public DataHolder(View itemView) {
            super(itemView);

            mVenueData = itemView.findViewById(R.id.venue_text_view);
            mTimeData = itemView.findViewById(R.id.time_text_view);
            mCallData = itemView.findViewById(R.id.call_image_view);
        }
    }
}
