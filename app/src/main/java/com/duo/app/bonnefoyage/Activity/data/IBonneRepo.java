package com.duo.app.bonnefoyage.Activity.data;

import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.User;

import java.util.Collection;

/**
 * Created by yannic on 20/04/2017.
 */

public interface IBonneRepo {

    Collection<City> getCityList();

    Collection<User> getUserList();

    User getUser(String userEmail);

    City getCity(String cityName);


}
