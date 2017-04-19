package com.duo.app.bonnefoyage.domein;

import android.location.Location;
import android.media.Image;

import com.duo.app.bonnefoyage.Enum.AttractionType;
import com.duo.app.bonnefoyage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * the city class, this class has methods for checking "recomendability".
 * Created by yannic on 13/04/2017.
 */

public class City {
    private int imageID;
    private String name;
    private Image bannerImage;
    private List<LandMark> landMarks;
    private Location centreLocation;


    public City(String name, Location centreLocation, int imageID) {
        this.imageID = imageID;
        this.name = name;
        this.centreLocation = centreLocation;
        landMarks = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public Image getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(Image bannerImage) {
        this.bannerImage = bannerImage;
    }

    public List<LandMark> getLandMarks() {
        return landMarks;
    }

    public Location getCentreLocation() {
        return centreLocation;
    }

    public void addLandMark(LandMark toAdd) {
        landMarks.add(toAdd);
    }

    public boolean checkRecommendable(AttractionType interest) {
        return false;
    }

    public boolean checkRecommendable(List<AttractionType> interests) {
        return false;
    }

    public int getImageID() {
        return imageID;
    }
}
