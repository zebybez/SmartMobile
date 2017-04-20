package com.duo.app.bonnefoyage.Activity.data;

import android.location.Location;

import com.duo.app.bonnefoyage.Enum.AttractionType;
import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.LandMark;
import com.duo.app.bonnefoyage.domein.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yannic on 20/04/2017.
 */

public class TestDataBase implements IBonneRepo{

    Map<String, City> cityMap;
    Map<String, User> userMap;

    public TestDataBase() {
        cityMap = new HashMap<>();
        userMap = new HashMap<>();

        //fill with test data
        //location
        Location testLocation = new Location("test");
        testLocation.setLatitude(51.4);
        testLocation.setLongitude(5.5);
        //city
        City city = new City("Eindhoven", testLocation, R.drawable.empire_state_building);
        city.addLandMark(new LandMark("Vue bioscoop", testLocation, AttractionType.Cinema));

        //put cities
        cityMap.put(city.getName(), city);

    }

    public Collection<City> getCityList(){
        return cityMap.values();
    }

    public Collection<User> getUserList(){
        return userMap.values();
    }

    public User getUser(String userEmail){
        return userMap.get(userEmail);
    }

    public City getCity(String cityName){
        return cityMap.get(cityName);
    }
}
