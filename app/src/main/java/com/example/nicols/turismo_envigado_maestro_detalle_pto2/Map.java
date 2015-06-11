package com.example.nicols.turismo_envigado_maestro_detalle_pto2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Map extends Fragment implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap map;
    private CameraUpdate cameraUpdate;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private LatLng currentLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_map, container, false);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();
        map.addMarker(new MarkerOptions()
                        .position(new LatLng(6.170132f, -75.587311f))
                        .title("Envigado")

        );
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(6.170132f, -75.587311f), 14);
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.animateCamera(cameraUpdate);
        buildGoogleApiClient();
        createLocationRequest();
        return view;
    }

    @Override
    public void onDestroyView() {
        Fragment fragment = (getFragmentManager()
                .findFragmentById(R.id.mapa));
        if (fragment.isResumed()) {
            getFragmentManager().beginTransaction().remove(fragment)
                    .commit();
        }
        super.onDestroyView();
        /*super.onDestroyView();
        try {

            FragmentManager fragmentman = getFragmentManager();
            fragmentman.beginTransaction().remove(fragmentman.findFragmentById(R.id.mapa)).commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null){
            setNewLocation(mLastLocation);
        }
    }

    private void setNewLocation(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        currentLocation = new LatLng(latitude,longitude);
        map.addMarker(new MarkerOptions().position(currentLocation).title("Find me here!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }
    protected void createLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onPause(){
        super.onPause();
        if (mGoogleApiClient.isConnected()){
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public  void onResume(){
        super.onResume();
        if (!mGoogleApiClient.isConnected()){
            mGoogleApiClient.connect();
        }
    }
/*
    public void ShowLocation(View view){

        map.clear();
        map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();

        map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();
        map.addMarker(new MarkerOptions().position(new LatLng(6.170132f, -75.587311f)).title("ENVIGADO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.animateCamera(cameraUpdate);
        if(null != map){
            map.addMarker(new MarkerOptions()
                            .position(new LatLng(6.170132f, -75.587311f))
                            .title("Envigado")
                            .draggable(true)
            );

            cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(6.170132f, -75.587311f), 16);
        }

    }
*/

}
