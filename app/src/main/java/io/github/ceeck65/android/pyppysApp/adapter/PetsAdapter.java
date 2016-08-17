
package io.github.ceeck65.android.pyppysApp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import io.github.ceeck65.android.pyppysApp.Pets.Pets;
import io.github.ceeck65.android.pyppysApp.Picasso.PicassoClient;
import io.github.ceeck65.android.pyppysApp.R;

/**
 * Created by mariofernandez on 8/8/16.
 */

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.petsViewHolder> {

    private ArrayList<Pets> listPest;
    Context context;
    int Like;


    public PetsAdapter(ArrayList<Pets> listPest, Context context) {
        this.listPest = listPest;
        this.context = context;
    }


    @Override
    public petsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows, viewGroup, false);
        petsViewHolder pets = new petsViewHolder(view);
        return pets;
    }

    @Override
    public void onBindViewHolder(final petsViewHolder petViewHolder, int position) {
        final Pets pets = listPest.get(position);
        petViewHolder.namePet.setText(pets.getNamePet());
        petViewHolder.pointPet.setText(String.valueOf(pets.getPointPet()));
        PicassoClient.loadPicasso(context, pets.getImgPetUrl(), petViewHolder.imagePet);
        pets.setFavorite(false);
        petViewHolder.imgFavorite.setImageResource(R.drawable.notfavorite);

        if(pets.getFavorite() == false)
        {
            petViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Like++;
                    pets.setPointPet(pets.getPointPet() + 1);
                    petViewHolder.pointPet.setText(String.valueOf(pets.getPointPet()));
                    Toast.makeText(context, "le distes like a " + pets.getNamePet(), Toast.LENGTH_SHORT).show();
                    petViewHolder.imgFavorite.setImageResource(R.drawable.isfavorite);
                    pets.setFavorite(true);
                }
            });
        }
        if (pets.getPointPet() > 0)
        {
            petViewHolder.imgFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    petViewHolder.imgFavorite.setImageResource(R.drawable.notfavorite);
                    pets.setPointPet(pets.getPointPet() - 1);
                    petViewHolder.pointPet.setText(String.valueOf(pets.getPointPet()));
                    pets.setFavorite(false);
                    Toast.makeText(context, "le has quitado like a " + pets.getNamePet(), Toast.LENGTH_SHORT).show();

                    if (pets.getPointPet() < 0)
                    {
                        petViewHolder.pointPet.setText(String.valueOf(0));
                    } else {
                        pets.setPointPet(pets.getPointPet());
                        petViewHolder.pointPet.setText(String.valueOf(pets.getPointPet()));
                    }

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listPest.size();
    }


    public class petsViewHolder  extends RecyclerView.ViewHolder {

        TextView namePet, pointPet;
        ImageView imagePet;
        ImageView imgFavorite;
        Button btnLike;


        public petsViewHolder(View itemView) {
            super(itemView);

            namePet  = (TextView) itemView.findViewById(R.id.tvPet);
            pointPet = (TextView) itemView.findViewById(R.id.tvRating);
            imagePet = (ImageView) itemView.findViewById(R.id.imgPets);
            imgFavorite = (ImageView) itemView.findViewById(R.id.active);
            btnLike = (Button) itemView.findViewById(R.id.btnLike);
        }
    }


}