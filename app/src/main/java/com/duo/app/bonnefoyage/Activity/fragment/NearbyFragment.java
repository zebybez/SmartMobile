package com.duo.app.bonnefoyage.Activity.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.duo.app.bonnefoyage.Activity.data.IBonneRepo;
import com.duo.app.bonnefoyage.Activity.data.TestDataBase;
import com.duo.app.bonnefoyage.Manifest;
import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.View.adapter.CityCardAdapter;
import com.duo.app.bonnefoyage.View.adapter.LandMarkAdapter;
import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.User;

import java.io.IOException;
import java.security.Permissions;

/**
 * This is the fragment for the tabViewActivity, it will show a list of nearby LandMarks
 * the main attraction of each landmark and the distance to the landmark.
 * Created by yannic on 13/04/2017.
 */

public class NearbyFragment extends Fragment {

    private User user;
    private RecyclerView recyclerView;
    private CardView cardView;

    private City currentCity;
    private CityCardAdapter.CityViewHolder cityViewHolder;

    private LocationManager locationManager;
    private Geocoder geo;

    private Context context;
    private IBonneRepo dataRepo;

    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        user = (User) args.getSerializable("user");
        context = getActivity();
        dataRepo = new TestDataBase();
        //todo get current city from user location. and get list of landmarks
        //todo start listening for location using gps
        //todo update list of landmarks on each location update.

        //currentCity = getCity(user.getLocation());
        geo = new Geocoder(context);

        if(ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, getTargetRequestCode() );
        }
        listenForLocationUpdates();

        Location tempLocation =locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        handleLocation(tempLocation);
        currentCity = user.getRecommendations().get(0);
        //currentCity = user.getCurrentCity;
    }

    private void listenForLocationUpdates() {
        // Acquire a reference to the system Location Manager
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                handleLocation(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(context, provider+" changed", Toast.LENGTH_SHORT).show();
                buildAlertMessageNoGps();
            }

            public void onProviderEnabled(String provider) {
                Toast.makeText(context, provider+" enabled", Toast.LENGTH_SHORT).show();
            }

            public void onProviderDisabled(String provider) {
                Toast.makeText(context, provider+" is disabled", Toast.LENGTH_SHORT).show();

            }
        };

// Register the listener with the Location Manager to receive location updates
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, getTargetRequestCode() );
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, locationListener);
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setMessage("This app requires your location")
                .setCancelable(false)
                .setPositiveButton("oke", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void handleLocation(Location location){
        if(location != null){
            user.setLocation(location);
            user.setCurrentCity(getCityFromLocation(location));
            recyclerView.swapAdapter(new LandMarkAdapter(currentCity.getLandMarks(), user), false);
        }
    }

    private City getCityFromLocation(Location location){
        String reportedCity = "";
        try {
            Address address = geo.getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0);
            reportedCity = address.getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!reportedCity.isEmpty()){
            City returnCity = dataRepo.getCity(reportedCity);
            return returnCity;
        }else {
            return null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city_view, container, false);

        textView = (TextView) rootView.findViewById(R.id.textView_currentLocation);
        City city = user.getCurrentCity();
        if(city !=null){
            textView.setText(user.getCurrentCity().getName());
        }else {
            textView.setText("unknown");
        }

        //populate imageButton
        ImageButton cityButton = (ImageButton) rootView.findViewById(R.id.imageButton_city);
        cityButton.setImageResource(R.drawable.empire_state_building);

        //create recyclerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_LandMarks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new LandMarkAdapter(currentCity.getLandMarks(), user));

        return rootView;
    }
}
