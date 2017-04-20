package com.duo.app.bonnefoyage.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.LandMark;
import com.duo.app.bonnefoyage.domein.User;

import java.util.List;

/**
 * Created by zeb on 19-4-17.
 */

public class LandMarkAdapter extends RecyclerView.Adapter<LandMarkAdapter.LandMarkViewHolder> {

    private List<LandMark> landMarks;
    private User user;

    public LandMarkAdapter(List<LandMark> landMarks, User user){
        this.landMarks = landMarks;
        this.user = user;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public LandMarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_landmark, parent, false);
        return new LandMarkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LandMarkViewHolder holder, int position) {
        LandMark landMark = landMarks.get(position);
        holder.textViewAddresAndDistance.setText(landMark.getAddress() /*+" "+ calcDistance(landMark)*/);
        holder.textViewName.setText(landMarks.get(position).getName());
    }

    /**
     * returns the distance between the user and the landmark, in KM.
     * @param landMark the landmark to calculate distance to.
     * @return a string representing the distance
     */
    private String calcDistance(LandMark landMark) {
        if(user.getLocation() != null){
            return String.valueOf(landMark.getLocation().distanceTo(user.getLocation()) / 1000) + "KM";
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

        public LandMarkViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textView_LandMarkName);
            textViewAddresAndDistance = (TextView) itemView.findViewById(R.id.textView_LandMark_Adress_Distance);
        }
    }
}
