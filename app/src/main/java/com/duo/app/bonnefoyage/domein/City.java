package com.duo.app.bonnefoyage.domein;

import android.location.Location;
import android.media.Image;

import com.duo.app.bonnefoyage.Enum.AttractionType;

import java.util.ArrayList;
import java.util.List;

/**
 * the city class, this class has methods for checking "recomendability".
 * Created by yannic on 13/04/2017.
 */

public class City {
    private String name;
    private Image bannerImage;
    private List<LandMark> landMarks;
    private Location centreLocation;


    public City(String name, Location centreLocation) {
        this.name = name;
        this.centreLocation = centreLocation;
        landMarks = new ArrayList<>();
    }

    public void addLandMark(LandMark toAdd){
        landMarks.add(toAdd);
    }

    public void setBannerImage(Image bannerImage){
        this.bannerImage = bannerImage;
    }

    public boolean checkRecommendable(AttractionType interest){
        return false;
    }

    public boolean checkRecommendable(List<AttractionType> interests){
        return false;
    }
}
