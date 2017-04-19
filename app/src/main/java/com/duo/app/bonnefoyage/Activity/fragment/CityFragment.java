package com.duo.app.bonnefoyage.Activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.View.adapter.CityCardAdapter;
import com.duo.app.bonnefoyage.domein.User;

/**
 * this is a fragment for the tabViewActivity it will show a list of recommended cities.
 * for each city it will show an image, the distance and the most popular LandMark./
 * Created by yannic on 13/04/2017.
 */

public class CityFragment extends Fragment {

    private User user;
    private RecyclerView recycleViewCities;


    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        user = (User) args.getSerializable("user");
        //todo: get recommended cities for user, and show in list (RecyclerView)


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cities, container, false);

//        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
//        textView.setText("Recommended cities");
        //get recyclerview
        recycleViewCities = (RecyclerView) rootView.findViewById(R.id.RecyclerView_Cities);
        //setup manager
        recycleViewCities.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //setup adapter
        recycleViewCities.setAdapter(new CityCardAdapter(user.getRecommendations()));
        return rootView;
    }
}
