package io.github.ceeck65.android.pyppysApp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.ceeck65.android.pyppysApp.Pets.PetsProfile;
import io.github.ceeck65.android.pyppysApp.Picasso.PicassoClient;
import io.github.ceeck65.android.pyppysApp.R;
import io.github.ceeck65.android.pyppysApp.adapter.ProfileAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePetsFragment extends Fragment {


    private RecyclerView.LayoutManager layoutManagerPets;
    private RecyclerView.Adapter adapterPetsProfiles;
    private RecyclerView recyclerViewPetsProfiles;
    private ImageView imgProfileCircle;
    private TextView tvNamePets;

    private RecyclerView mRecyclerView;
    private ProfileAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final int PETSPROFILES = 0;
    public static final int RECYCLERPROFILE = 1;

    private int mDatasetTypes[] = {PETSPROFILES, RECYCLERPROFILE};


    public ProfilePetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_pets, container, false);

        recyclerViewPetsProfiles = (RecyclerView) view.findViewById(R.id.rvProfilePets);
        layoutManagerPets = new GridLayoutManager(getContext(), 3);
        recyclerViewPetsProfiles.setLayoutManager(layoutManagerPets);


        imgProfileCircle = (ImageView) view.findViewById(R.id.imgPetsCircle);
        tvNamePets = (TextView) view.findViewById(R.id.tvNamePetsProfile);
        PicassoClient.loadPicasso(getContext(), "http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", imgProfileCircle);
        tvNamePets.setText("Azabache");

        final ArrayList<PetsProfile> listPest = new ArrayList<>();

        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", "Azabache", 1));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/e8b99819376e1f6cad519e15afead182.jpg", "Missiu", 0));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/33b8f3619da779a1ae409ac708da1aa6.jpg", "Negrin", 2));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/ef29a541ba49353ffaacfe18bce25c76.jpg", "Nerón", 0));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/930f13cb029d66edb18265cebebd3035.jpg", "Puppy", 4));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/f3eaeb1a408c8e5540b18a93294c56a1.jpg", "Titi", 1));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/17d4242071c488b1e0a481b8f0d1268e.jpg", "Yailon", 2));
        listPest.add(new PetsProfile("http://www.mascotasderaza.com/arch/b3f7c82d39c02bbcd3952d86fc412949.jpg", "Xiena", 2));

        adapterPetsProfiles = new ProfileAdapter(listPest, getContext(), mDatasetTypes);
        recyclerViewPetsProfiles.setAdapter(adapterPetsProfiles);

        return view;
    }

}
