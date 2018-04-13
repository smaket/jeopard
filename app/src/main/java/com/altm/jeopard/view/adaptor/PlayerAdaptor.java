package com.altm.jeopard.view.adaptor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.altm.jeopard.model.Player;

import java.util.ArrayList;

public class PlayerAdaptor extends RecyclerView.Adapter<PlayerAdaptor.PlayerViewHolder>  {
    private Context mCxt;
    private ArrayList<Player> mAdapterItemList;
    public PlayerAdaptor(Activity mContext, ArrayList<Player> aAdapterItemList) {
        super();
        this.mCxt = mContext;
        this.mAdapterItemList = aAdapterItemList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder{
        public PlayerViewHolder(View itemView) {
            super(itemView);
        }
    }


}
