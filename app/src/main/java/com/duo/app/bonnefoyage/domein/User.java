package com.duo.app.bonnefoyage.domein;

import android.location.Location;

import com.duo.app.bonnefoyage.Enum.AttractionType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The user class for this app, containing information about the users preferences,
 * his location and previously liked locations
 * Created by yannic on 13/04/2017.
 */

public class User implements Serializable{
    private String email;
    private String name;
    private List<AttractionType> interests;
    private Location location;
    private List<LandMark> likedLocations;
    private List<City> recommendations;

    public User(String email, String name) {
        this.email = email;
        this.name = name;

        interests = new ArrayList<>();
        likedLocations = new ArrayList<>();
        recommendations = new ArrayList<>();
    }

    public List<AttractionType> getInterests() {
        return interests;
    }

    public List<LandMark> getLikedLocations() {
        return likedLocations;
    }

    public List<City> getRecommendations() {
        return recommendations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addInterest(AttractionType interest){
        interests.add(interest);
    }

    public void addLikedLocation(LandMark likedPlace){
        likedLocations.add(likedPlace);
    }

    public void addRecommendation(City recommendedCity){
        recommendations.add(recommendedCity);
    }

    public void removeInterest(AttractionType interest){
        interests.remove(interest);
    }

    public void removeLikedLocation(LandMark likedPlace){
        likedLocations.remove(likedPlace);
    }

    public void removeRecommendation(City toRemove){
        recommendations.remove(toRemove);
    }
}
