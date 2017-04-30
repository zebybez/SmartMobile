package com.duo.app.bonnefoyage.Activity.data;

import android.provider.ContactsContract;

/**
 * Created by zeb on 28-4-17.
 */

public class Database {
    private static IBonneRepo dataInstance = null;

    protected Database(){
        //for security.
    }

    public static IBonneRepo getDataInstance(){
        if(dataInstance == null){
            dataInstance = new TestDataBase();
        }
        return dataInstance;
    }
}
