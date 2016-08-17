package io.github.ceeck65.android.pyppysApp;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import io.github.ceeck65.android.pyppysApp.Pets.Pets;
import io.github.ceeck65.android.pyppysApp.about.AboutActivity;
import io.github.ceeck65.android.pyppysApp.adapter.PageAdapter;
import io.github.ceeck65.android.pyppysApp.contacts.ContactsActivity;
import io.github.ceeck65.android.pyppysApp.fragments.ProfilePetsFragment;
import io.github.ceeck65.android.pyppysApp.fragments.RecyclerViewFragments;

public class PetsActivity extends AppCompatActivity {


    private ImageView imgview, logoBar;
    private TextView titleBar;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        imgview = (ImageView) findViewById(R.id.imgPets);
        logoBar = (ImageView) findViewById(R.id.logoBar);
        titleBar = (TextView) findViewById(R.id.titleBar);

      //  logoBar.setImageResource(R.drawable.fetdog);
      //  imgFavorite.setImageResource(R.drawable.star);
      //  titleBar.setText(getResources().getString(R.string.titleBar));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager();


    }


    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment>  fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragments());
        fragments.add(new ProfilePetsFragment());
        return  fragments;
    }


    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_profile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuContact :
                Intent intentContact = new Intent(this, ContactsActivity.class);
                startActivity(intentContact);
                break;
            case R.id.menuAbout :
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivity(intentAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
