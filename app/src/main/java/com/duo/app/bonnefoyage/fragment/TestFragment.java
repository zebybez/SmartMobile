package com.duo.app.bonnefoyage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duo.app.bonnefoyage.R;

/**
 * a test fragment for testing and such.
 * Created by yannic on 13/04/2017.
 */

public class TestFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cities, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.title_textView);
        textView.setText("Recommended cities");
        return rootView;
    }
}
