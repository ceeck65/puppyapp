package io.github.ceeck65.android.pyppysApp.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import io.github.ceeck65.android.pyppysApp.Pets.PetsProfile;
import io.github.ceeck65.android.pyppysApp.Picasso.PicassoClient;
import io.github.ceeck65.android.pyppysApp.R;

/**
 * Created by mariofernandez on 16/8/16.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.profileViewHolder>  {

    private ArrayList<PetsProfile> listPest;
    Context context;


    private int[] mDataSetTypes;

    public static final int PETSPROFILES = 0;
    public static final int RECYCLERPROFILE = 1;



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }


    public class profileViewHolder extends ViewHolder {

        ImageView imgProfile;
        TextView ratingProfiles;

        public profileViewHolder(View v) {
            super(v);
            imgProfile = (ImageView) v.findViewById(R.id.imgPetsProfiles);
            ratingProfiles = (TextView) v.findViewById(R.id.tvPetProfiles);
        }
    }

    public class profileCircleViewHolder extends ViewHolder {

        ImageView imgProfileCircle;
        TextView  tvNameCircle;
        public profileCircleViewHolder(View v) {
            super(v);
            imgProfileCircle = (ImageView) v.findViewById(R.id.imgPetsCircle);
            tvNameCircle     = (TextView) v.findViewById(R.id.tvNamePetsProfile);
        }
    }



    public ProfileAdapter(ArrayList<PetsProfile> listPest,  Context context, int[] mDataSetTypes) {
        this.listPest = listPest;
        this.context = context;
        this.mDataSetTypes = mDataSetTypes;
    }

    @Override
    public profileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == PETSPROFILES){
             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile, parent, false);
            return new profileViewHolder(view);
        }

        else  {
             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_profile_pets, parent, false);
            return new profileViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(final profileViewHolder viewHolder, int position) {


            final PetsProfile pestProfiles = listPest.get(position);
            PicassoClient.loadPicasso(context, pestProfiles.getImgPetUrlProfiles(), viewHolder.imgProfile);
            viewHolder.ratingProfiles.setText(String.valueOf(pestProfiles.getRatingProfiles()));

    }

    @Override
    public int getItemCount() {
        return listPest.size();
    }



    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[0];
    }




}
