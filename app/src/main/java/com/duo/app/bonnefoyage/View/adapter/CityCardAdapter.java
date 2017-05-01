package com.duo.app.bonnefoyage.View.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.duo.app.bonnefoyage.Activity.CityViewActivity;
import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.City;

import java.util.List;

/**
 * the adapter for the recyclerview in CityFragment.
 * it does the stuff to add cities to a recyclerview.
 * Created by yannic on 18-4-17.
 */

public class CityCardAdapter extends RecyclerView.Adapter<CityCardAdapter.CityViewHolder> {

    private static List<City> cities;

    public CityCardAdapter(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_city, parent, false);

        return new CityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.cityTextView.setText(cities.get(position).getName());
        holder.imageButtonViewCity.setImageResource(cities.get(position).getImageID());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    //INNER CLASS
    public static class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView cityTextView;
        public ToggleButton toggleLike;
        public ImageButton imageButtonViewCity;

        public CityViewHolder(View itemView) {
            super(itemView);
            cityTextView = (TextView) itemView.findViewById(R.id.textView_CityName);
            toggleLike = (ToggleButton) itemView.findViewById(R.id.toggleButton_LikeCity);
            imageButtonViewCity = (ImageButton) itemView.findViewById(R.id.imageButton_city);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), CityViewActivity.class);
            Bundle cityBundle = new Bundle();
            cityBundle.putSerializable("city", cities.get(getAdapterPosition()));
            intent.putExtras(cityBundle);
            v.getContext().startActivity(intent);
        }
    }
}
