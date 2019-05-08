package com.example.nilufer.obscotest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class RecyclerViewAdapterMembers extends RecyclerView.Adapter<RecyclerViewAdapterMembers.ViewHolder> {
    private static final String TAG = "RecycleViewAdapterM";

    private ArrayList<String> memberIDs;
    private ArrayList<String> memberNames;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button memberName;
        String memberID;

        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memberName = itemView.findViewById(R.id.member_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }

    public RecyclerViewAdapterMembers (Context mContext, ArrayList<String> memberIDs, ArrayList<String> memberNames) {
        this.memberIDs = memberIDs;
        this.memberNames = memberNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem_member, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        System.out.println (position);
        System.out.println (memberNames.get(position));
        System.out.println (memberNames.size());
        viewHolder.memberName.setText(memberNames.get(position));
        viewHolder.memberID = memberIDs.get(position);
    }

    @Override
    public int getItemCount() {
        return memberIDs.size();
    }


}
