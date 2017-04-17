package com.duo.app.bonnefoyage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.User;

import java.io.Serializable;

/**
 * this is a fragment for the tabViewActivity it will show a list of recommended cities.
 * for each city it will show an image, the distance and the most popular LandMark./
 * Created by yannic on 13/04/2017.
 */

public class CityFragment extends Fragment {

    private User user;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        user = (User) args.getSerializable("user");
        //todo: get recommended cities for user, and show in list (RecyclerView)
        //todo: calculate recommended cities based on user.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cities, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
        textView.setText("Recommended cities");
        return rootView;
    }
}
