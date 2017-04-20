package com.duo.app.bonnefoyage.Activity.data;

import com.duo.app.bonnefoyage.domein.City;
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
