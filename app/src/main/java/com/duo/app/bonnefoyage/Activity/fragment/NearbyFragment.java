package com.duo.app.bonnefoyage.Activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.View.adapter.CityCardAdapter;
import com.duo.app.bonnefoyage.View.adapter.LandMarkAdapter;
import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.User;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        user = (User) args.getSerializable("user");
        //todo get current city from user location. and get list of landmarks
        //todo start listening for location using gps
        //todo update list of landmarks on each location update.
        currentCity = user.getRecommendations().get(0);
        //currentCity = getCity(user.getLocation());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city_view, container, false);

//        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
//        textView.setText("Nearby landmarks");

        //populate cardview
//        cardView = (CardView) rootView.findViewById(R.id.cardView_City);
//        cardView.inflate(this.getContext(), R.layout.card_city, container);
//        cityViewHolder = new CityCardAdapter.CityViewHolder(cardView);
//        cityViewHolder.imageButtonViewCity.setImageResource(currentCity.getImageID());
//        cityViewHolder.cityTextView.setText(currentCity.getName());
//        cityViewHolder.toggleLike.setVisibility(View.INVISIBLE);

        //create recyclerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_LandMarks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new LandMarkAdapter(currentCity.getLandMarks()));

        return rootView;
    }
}
