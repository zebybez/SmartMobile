package com.duo.app.bonnefoyage.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.duo.app.bonnefoyage.R;

/**
 * The activity class for adding a new Landmark.
 * it will be saved to the firebase, and added to visited.
 * Created by zeb on 19-4-17.
 */

public class AddLandMarkActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_landmark);

        //todo get buttons ect.
    }

}
