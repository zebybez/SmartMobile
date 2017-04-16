package com.duo.app.bonnefoyage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duo.app.bonnefoyage.R;

/**
 * Created by yannic on 13/04/2017.
 */

public class VisitedLocationsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_visited_locations, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
        textView.setText("Previous locations");
        return rootView;
    }
}
