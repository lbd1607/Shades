package com.missouristate.davis916.shades;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 * This class is responsible for the information activity setup.
 */

public class InformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Verify that orientation has been switched to landscape mode
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        //Get the layout for this activity
        setContentView(R.layout.information_fragment);

        //Display the up icon for the action bar
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

        //Return the intent that started this activity
        Intent intent = getIntent();
        String shadeInformation = intent.getStringExtra("Information");

        //Set text for TextView
        TextView information = (TextView) findViewById(R.id.textView1);
        information.setText(shadeInformation);
    }//end onCreate

}//end InformationActivity class
