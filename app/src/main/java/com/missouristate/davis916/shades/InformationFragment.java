package com.missouristate.davis916.shades;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 *  This class is responsible for inflating the information
 * fragment and setting the shade info in the TextView.
 */

public class InformationFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.information_fragment,
                container, false);
        return view;
    }//end onCreateView

    public void setText(String shadeInfo){
        TextView view = (TextView) getView().findViewById(R.id.textView1);
        view.setText(shadeInfo);
    }//end setText

}//end InformationFragment
