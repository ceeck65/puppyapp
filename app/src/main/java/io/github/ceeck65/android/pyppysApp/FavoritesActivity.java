package io.github.ceeck65.android.pyppysApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.ceeck65.android.pyppysApp.Pets.Pets;
import io.github.ceeck65.android.pyppysApp.adapter.PetsAdapter;
import io.github.ceeck65.android.pyppysApp.fragments.RecyclerViewFragments;

public class FavoritesActivity extends AppCompatActivity implements RecyclerViewFragments.OnFragmentInteractionListener {

    private RecyclerView recyclerViewPets;
    private RecyclerView.LayoutManager layoutManagerPets;
    private RecyclerView.Adapter adapterPets;
    Toolbar toolbar;
    private ImageView  logoBar;
    private TextView titleBarFavorite;

    ArrayList<Pets> listPest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorites);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logoBar = (ImageView) findViewById(R.id.logoBar);
        titleBarFavorite = (TextView) findViewById(R.id.titleBar);

        logoBar.setImageResource(R.drawable.fetdog);
        titleBarFavorite.setText(getResources().getString(R.string.titleBarFavorites));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle(getResources().getString(R.string.titleBarFavorites));

        Bundle bundleObject = getIntent().getExtras();

        recyclerViewPets = (RecyclerView) findViewById(R.id.rvPetsFavorite);
        layoutManagerPets = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPets.setLayoutManager(layoutManagerPets);

         inicializePetsList(getIntent());
      //   adapterPets();

    }

    public  void inicializePetsList(Intent intent) {

        listPest  = new ArrayList<Pets>();
            ArrayList<Pets> arrayList = (ArrayList<Pets>) intent.getSerializableExtra("listPest");

            System.out.println(arrayList);

        /*    for (Pets pets: arrayList) {
                if (pets.getFavorite() != null && pets.getFavorite() == true){
                    dataPets.add(pets);
                }
            }
        */
     }

    public  void adapterPets() {
        adapterPets = new PetsAdapter(listPest, this);
        recyclerViewPets.setAdapter(adapterPets);
    }


    @Override
    public void onFragmentSetPets(ArrayList<Pets> pets) {
        listPest = pets;
    }
}
