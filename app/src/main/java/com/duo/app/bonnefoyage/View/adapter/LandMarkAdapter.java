package com.duo.app.bonnefoyage.View.adapter;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.LandMark;
import com.duo.app.bonnefoyage.domein.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by zeb on 19-4-17.
 */

public class LandMarkAdapter extends RecyclerView.Adapter<LandMarkAdapter.LandMarkViewHolder> {

    //todo when the list is zero to add a fake landmark that will tell you to add one, with a button.
    private List<LandMark> landMarks;
    private User user;

    public LandMarkAdapter(User user){
        this.landMarks = user.getCurrentCity().getLandMarks();
        this.user = user;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * sets the layout, ex:
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if(landMarks.size() == 0){
            return R.layout.list_item_no_landmarks;
        }
        if(position == landMarks.size()){
            return R.layout.list_item_add_button;
        }else {
            return R.layout.list_item_landmark;
        }
    }

    @Override
    public LandMarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if(viewType == R.layout.list_item_landmark){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_landmark, parent, false);
        }else if(viewType == R.layout.list_item_no_landmarks){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_no_landmarks, parent, false);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_add_button, parent, false);
        }

        return new LandMarkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final LandMarkViewHolder holder, int position) {
        if(landMarks.size() == 0){
            holder.textViewOnEmptyList.setText("No landmarks for this location");
        } else if(position == landMarks.size()){
            holder.buttonAddNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(holder.itemView.getContext(), "clicked", Toast.LENGTH_LONG).show();
                    //todo make this button go to another activity.
                }
            });
        } else {
            LandMark landMark = landMarks.get(position);
            holder.textViewAddresAndDistance.setText(getAddressFromLocation(landMark.getLocation()) +" "+ calcDistance(landMark));
            holder.textViewName.setText(landMarks.get(position).getName());
        }
    }

    private void lastButtonOnClick(){
        //Toast.makeText(this.getContext, "clicked", Toast.LENGTH_LONG).show();
    }

    private String getAddressFromLocation(Location location) {
        return "temp test addres";
    }

    /**
     * returns the distance between the user and the landmark, in KM.
     * @param landMark the landmark to calculate distance to.
     * @return a string representing the distance
     */
    private String calcDistance(LandMark landMark) {
        if(user.getLocation().getProvider() != "error"){
            return String.valueOf(landMark.getLocation().distanceTo(user.getLocation()) / 1000) + " km";
        }else{
            return "unknown";
        }

    }


    @Override
    public int getItemCount() {
        return landMarks.size();
    }

    //INNER ClASS
    public class LandMarkViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public TextView textViewAddresAndDistance;
        public TextView textViewOnEmptyList;
        public Button buttonAddNew;
        //TODO add attractiontype to the layout.
        public LandMarkViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textView_LandMarkName);
            textViewAddresAndDistance = (TextView) itemView.findViewById(R.id.textView_LandMark_Adress_Distance);
            buttonAddNew = (Button) itemView.findViewById(R.id.button_addNewEntry);
            textViewOnEmptyList = (TextView) itemView.findViewById(R.id.textView_emptyListMessage);
        }
    }
}
