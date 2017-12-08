package com.example.zwanzigdrei.localfoodie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by zwanzigdrei on 30/11/17.
 */

public class LocListAdapter extends RecyclerView.Adapter<LocListAdapter.LocListViewHolder>  {

    private LinkedList<String> curdata;
    private MainActivity.LocJsonData[] data;
    private LayoutInflater mInflater;
    Context parentContext;

    public LocListAdapter(Context c, MainActivity.LocJsonData[] data, LinkedList<String> curdata){
        this.curdata = curdata;
        this.data = data;
        this.mInflater = LayoutInflater.from(c);
        this.parentContext = c;
    }

    @Override
    public LocListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycle_loc_layout, parent, false);
        return new LocListViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(LocListViewHolder holder, int position) {
        // Retrieve the data for that position
        String current = curdata.get(position);

        for (MainActivity.LocJsonData i : data){
            if (current.matches(i.location)){
                String packageName = parentContext.getPackageName();
                String typeOfResource = "drawable";
                int resID = parentContext.getResources().getIdentifier(i.file,typeOfResource,packageName);
                // Add the data to the view
                holder.location.setText(current);
//                holder.cost.setText(i.cost);
                holder.picture.setImageResource(resID);
                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return curdata.size(); //#of entries that is passed to it
    }

    class LocListViewHolder extends RecyclerView.ViewHolder {
        TextView location;
//        TextView cost;
        ImageView picture;
        LocListAdapter mAdapter;
        public LocListViewHolder(View itemView, LocListAdapter adapter) {
            super(itemView);
            location = itemView.findViewById(R.id.item_text);
//            cost = itemView.findViewById(R.id.item_cost);
            picture = itemView.findViewById(R.id.item_image);
            this.mAdapter = adapter;
        }
    }


}
