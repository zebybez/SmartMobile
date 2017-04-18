package com.duo.app.bonnefoyage.Activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.User;

/**
 * This is the fragment for the tabViewActivity, it will show a list of nearby LandMarks
 * the main attraction of each landmark and the distance to the landmark.
 * Created by yannic on 13/04/2017.
 */

public class NearbyFragment extends Fragment {

    private User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        user = (User) args.getSerializable("user");
        //todo get list landMarks near user location.
        //todo start listening for location using gps
        //todo update list on each location update.

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nearby_main, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
        textView.setText("Nearby landmarks");
        return rootView;
    }
}
