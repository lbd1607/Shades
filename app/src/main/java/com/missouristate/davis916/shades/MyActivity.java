package com.missouristate.davis916.shades;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 *  This app uses fragments to move back and forth across activities.
 * The app is designed to provide information about specific colors
 * that is displayed in the second activity (information activity) on tap.
 */

public class MyActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        /*
         * Code to get the action bar icon to work
         * Code from FalconHawk @StackOverflow
         * https://stackoverflow.com/questions/26720759/no-app-icon-on-actionbar
         * Instructions from Android Developers
         * https://developer.android.com/studio/write/image-asset-studio.html#create-actionbartab
        */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_action_shades);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }//end onCreate()

    @Override
    public void onShadeItemSelected(String link){
        //Check if the info fragment exists in this layout
        InformationFragment informationFragment = (InformationFragment)
                getFragmentManager().findFragmentById(R.id.fragment2);

        //Check if a two-pane config is being displayed
        if (informationFragment != null && informationFragment.isInLayout()){
            informationFragment.setText(link);
        }

        //A single-pane config exists
        else{
            //If the info fragment does not exist in this layout,
            //activate the info activity

            Intent intent = new Intent(this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity(intent);
        }
    }//end onShadeItemSelected()

}//end MyActivity class
