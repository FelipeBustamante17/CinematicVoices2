package com.santotomas.cinematicvoices;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.santotomas.cinematicvoices.databinding.ActivityMapaCinesBinding;

public class MapaCines extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapaCinesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaCinesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng actual = new LatLng(-33.44915868551862, -70.66221183758722);
        mMap.addMarker(new MarkerOptions().position(actual).title("IP Santo tomás").snippet("Ubicación Actual").icon(BitmapDescriptorFactory.fromResource(R.drawable.posicion)));


        LatLng cine1 = new LatLng(-33.45180496940038, -70.67813590541488);
        mMap.addMarker(new MarkerOptions().position(cine1).title("Cinépolis").snippet("Estación Central").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));


        LatLng cine2 = new LatLng(-33.45209142019119, -70.68221286299554);
        mMap.addMarker(new MarkerOptions().position(cine2).title("CinePlanet").snippet("Alameda").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));

        LatLng cine3 = new LatLng(-33.4430677657843, -70.6698532448085);
        mMap.addMarker(new MarkerOptions().position(cine3).title("Zorzal Films").snippet("Erasmo Escala").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));


        LatLng cine4 = new LatLng(-33.44331837130916, -70.65394710604298);
        mMap.addMarker(new MarkerOptions().position(cine4).title("Cineteca").snippet("Nacional de Chile").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));


        LatLng cine5 = new LatLng(-33.44442558470412, -70.65037463976789);
        mMap.addMarker(new MarkerOptions().position(cine5).title("Centro Arte Alameda").snippet("Sala Ceina").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));


        LatLng cine6 = new LatLng(-33.44738518183485, -70.65204604356872);
        mMap.addMarker(new MarkerOptions().position(cine6).title("Cine Normandie").snippet("Tarapacá").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));


        LatLng cine7 = new LatLng(-33.439038622671134, -70.64857109125272);
        mMap.addMarker(new MarkerOptions().position(cine7).title("Cinépolis").snippet("Vivo Imperio").icon(BitmapDescriptorFactory.fromResource(R.drawable.cabritas2)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(actual, 14));
    }
}