package com.duo.app.bonnefoyage.domein;

import android.location.Geocoder;
import android.location.Location;

import com.duo.app.bonnefoyage.Enum.AttractionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Attraction class, contains the location and attractions of a Landmark in a city.
 * Created by yannic on 13/04/2017.
 */

public class LandMark {
    private String name;
    private Location Location;
    private AttractionType mainAttraction;
    private List<AttractionType> allSubAttractions;

    public LandMark(String name, android.location.Location location, AttractionType mainAttraction) {
        this.name = name;
        Location = location;
        this.mainAttraction = mainAttraction;
        allSubAttractions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public android.location.Location getLocation() {
        return Location;
    }

    public AttractionType getMainAttraction() {
        return mainAttraction;
    }

    public void setMainAttraction(AttractionType mainAttraction) {
        this.mainAttraction = mainAttraction;
    }

    public void addSubAttraction(AttractionType attraction){
        allSubAttractions.add(attraction);
    }

    public void removeSubAttraction(AttractionType attraction){
        allSubAttractions.remove(attraction);
    }

    public String getAddress(){
        return "temporary test address";
        //TODO change location to an address.
    }

}

