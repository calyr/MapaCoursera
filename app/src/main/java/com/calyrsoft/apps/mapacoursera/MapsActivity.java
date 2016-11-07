package com.calyrsoft.apps.mapacoursera;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ArrayList<Punto> coordenadas = new ArrayList<>();

    private int Seleccion = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        coordenadas.add(new Punto(-17.3851655, -66.1342379, "Cristo de la concordia", "Cochabamba Bolivia", BitmapDescriptorFactory.HUE_BLUE ));
        coordenadas.add(new Punto(-17.4033718,-66.153644, "La Cancha", "Cochabamba Bolivia", BitmapDescriptorFactory.HUE_GREEN ));
        coordenadas.add(new Punto(-17.3748328,-66.1531461, "Centro Cultural Simon I. Patiño", "Cochabamba Bolivia", BitmapDescriptorFactory.HUE_RED ));
        coordenadas.add(new Punto(-17.3946525,-66.1612237, "Museo Casona Santivañez", "Cochabamba Bolivia"  ,BitmapDescriptorFactory.HUE_YELLOW));

        Bundle bundle = getIntent().getExtras();

        Seleccion = bundle.getInt("seleccion");
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

        mMap.setMyLocationEnabled(true); //Location
        mMap.getUiSettings().setCompassEnabled(true); //Compass
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true); //Indoor
        mMap.getUiSettings().setMapToolbarEnabled(true); //Map toolsbar
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Cristo de la Concordia and move the camera
        LatLng cristodelaconcordia = new LatLng( coordenadas.get(Seleccion).getLatitud(),coordenadas.get(Seleccion).getLongitud()  );
        //mMap.addMarker(new MarkerOptions().getSnippet(coordenadas.get(Seleccion).getDescripcion()).title());


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(cristodelaconcordia).zoom(14).build();
        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        MarkerOptions markerend = new MarkerOptions().position(
                cristodelaconcordia).title(coordenadas.get(Seleccion).getTitulo()).snippet(coordenadas.get(Seleccion).getDescripcion());
        markerend.icon(BitmapDescriptorFactory
                .defaultMarker( coordenadas.get(Seleccion).getHue()));
        // adding marker
        mMap.addMarker(markerend);


    }
}
