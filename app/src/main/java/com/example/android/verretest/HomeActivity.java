package com.example.android.verretest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_36px);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle("VERRE");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "action clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        View tab1 = View.inflate(this, R.layout.tabs_view, null);
        ((ImageView) tab1.findViewById(R.id.tabs_icon)).setImageResource(R.drawable.ic_directions_car_grey_900_36dp);
        ((TextView) tab1.findViewById(R.id.tabs_title)).setText("STANDARD");

        View tab2 = View.inflate(this, R.layout.tabs_view, null);
        ((ImageView) tab2.findViewById(R.id.tabs_icon)).setImageResource(R.drawable.ic_directions_car_grey_900_36dp);
        ((TextView) tab2.findViewById(R.id.tabs_title)).setText("SEDAN");

        View tab3 = View.inflate(this, R.layout.tabs_view, null);
        ((ImageView) tab3.findViewById(R.id.tabs_icon)).setImageResource(R.drawable.ic_directions_car_grey_900_36dp);
        ((TextView) tab3.findViewById(R.id.tabs_title)).setText("SUV");

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));
        tabs.addTab(tabs.newTab().setCustomView(tab1));
        tabs.addTab(tabs.newTab().setCustomView(tab2));
        tabs.addTab(tabs.newTab().setCustomView(tab3));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
