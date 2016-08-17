package io.github.ceeck65.android.pyppysApp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import io.github.ceeck65.android.pyppysApp.FavoritesActivity;
import io.github.ceeck65.android.pyppysApp.Pets.Pets;
import io.github.ceeck65.android.pyppysApp.PetsActivity;
import io.github.ceeck65.android.pyppysApp.R;
import io.github.ceeck65.android.pyppysApp.adapter.PetsAdapter;


/**
 * Created by mariofernandez on 11/8/16.
 */

public class RecyclerViewFragments extends Fragment implements View.OnClickListener, Serializable {


    public RecyclerViewFragments() {

    }

    private ImageView  imgFavorite;
    private RecyclerView.LayoutManager layoutManagerPets;
    private RecyclerView.Adapter adapterPets;
    private RecyclerView recyclerViewPets;

    ArrayList<Pets> listPest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragments_recyclerview_pets, container, false);

        recyclerViewPets = (RecyclerView) v.findViewById(R.id.rvPets);
        imgFavorite = (ImageView) v.findViewById(R.id.btnFavoritesNuevo);
        layoutManagerPets = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPets.setLayoutManager(layoutManagerPets);

        final ArrayList<Pets> listPest = new ArrayList<>();

        listPest.add(new Pets("http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", "Azabache"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/e8b99819376e1f6cad519e15afead182.jpg", "Missiu"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/33b8f3619da779a1ae409ac708da1aa6.jpg", "Negrin"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/ef29a541ba49353ffaacfe18bce25c76.jpg", "Nerón"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/930f13cb029d66edb18265cebebd3035.jpg", "Puppy"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/f3eaeb1a408c8e5540b18a93294c56a1.jpg", "Titi"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/17d4242071c488b1e0a481b8f0d1268e.jpg", "Yailon"));
        listPest.add(new Pets("http://www.mascotasderaza.com/arch/b3f7c82d39c02bbcd3952d86fc412949.jpg", "Xiena"));

        adapterPets = new PetsAdapter(listPest, getContext());
        recyclerViewPets.setAdapter(adapterPets);
        imgFavorite.setImageResource(R.drawable.star);
        imgFavorite.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getActivity(), FavoritesActivity.class);
        intent.putExtra("listPest", listPest);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().getApplicationContext().startActivity(intent);

    }


    public interface OnFragmentInteractionListener {
        public void onFragmentSetPets(ArrayList<Pets> pets);
    }


}
