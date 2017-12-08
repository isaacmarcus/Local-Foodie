package com.example.zwanzigdrei.localfoodie;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class OverallMap extends AppCompatActivity implements OnMapReadyCallback {

    //TODO 1.1 - add these instance variables
    private GoogleMap mMap;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overallmap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        action = getIntent().getAction();
        this.setTitle("Map");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Location){
            Fragment1 dFragment = new Fragment1();
            // Show DialogFragment
            dFragment.show(getSupportFragmentManager(), "Dialog Fragment");
        }
        return true;
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

        LatLng BedokBlk85,BedokSimpang,ChangiVillageHawkerCentre,ChinatownFoodstreet,ChompChomp,HongLim,LauPaSat,Maxwell,Newton,Tampines;

        mMap = googleMap;

        BedokBlk85 = new LatLng(1.332071, 103.938534);
        Marker marker1 = mMap.addMarker(new MarkerOptions().position(BedokBlk85).title("Bedok Blk 85"));

        BedokSimpang = new LatLng(1.331346, 103.948360);
        Marker marker2 = mMap.addMarker(new MarkerOptions().position(BedokSimpang).title("Bedok Simpang"));

        ChangiVillageHawkerCentre = new LatLng(1.389661,103.988143);
        Marker marker3 =mMap.addMarker(new MarkerOptions().position(ChangiVillageHawkerCentre).title("Changi Village Hawker Centre"));

        ChinatownFoodstreet = new LatLng(1.282367,103.844665);
        Marker marker4 =mMap.addMarker(new MarkerOptions().position(ChinatownFoodstreet).title("Chinatown Food Street"));

        ChompChomp = new LatLng(1.364614,103.866391);
        Marker marker5 =mMap.addMarker(new MarkerOptions().position(ChompChomp).title("Chomp Chomp Food Centre"));

        HongLim = new LatLng(1.285573,103.845978);
        Marker marker6 =mMap.addMarker(new MarkerOptions().position(HongLim).title("Hong Lim Food Centre"));

        LauPaSat = new LatLng(1.280909,103.850422);
        Marker marker7 =mMap.addMarker(new MarkerOptions().position(LauPaSat).title("Lau Pa Sat"));

        Maxwell = new LatLng(1.280731,103.844854);
        Marker marker8 =mMap.addMarker(new MarkerOptions().position(Maxwell).title("Maxwell Food Centre"));

        Newton = new LatLng(1.312203,103.839553);
        Marker marker9 =mMap.addMarker(new MarkerOptions().position(Newton).title("Newton Food Centre"));

        Tampines = new LatLng(1.345735,103.944630);
        Marker marker10 =mMap.addMarker(new MarkerOptions().position(Tampines).title("Tampines Round Market & Food Centre"));
        switch (action){
            case "Bedok 85":
                marker1.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(BedokBlk85));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Simpang Bedok":
                marker2.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(BedokSimpang));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Changi Village":
                marker3.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ChangiVillageHawkerCentre));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Chinatown Food Street":
                marker4.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ChinatownFoodstreet));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Chomp Chomp":
                marker5.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ChompChomp));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Hong Lim Food Centre":
                marker6.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(HongLim));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Lau Pa Sat":
                marker7.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(LauPaSat));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Maxwell Food Centre":
                marker8.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Maxwell));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Newton Food Centre":
                marker9.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Newton));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;

            case "Tampines Round Market":
                marker10.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Tampines));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                break;
        }

    }
}
