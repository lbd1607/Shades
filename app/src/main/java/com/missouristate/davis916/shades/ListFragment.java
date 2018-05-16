package com.missouristate.davis916.shades;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 *  This class is responsible for inflating the list fragment
 * and assisting with the transition between this fragment and
 * the information fragment.
 */

public class ListFragment extends Fragment{

    private OnItemSelectedListener listener;
    private String information;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.list_fragment,
                container,
                false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(ShadeChangeListener);

        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(ShadeChangeListener);

        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(ShadeChangeListener);

        return view;
    }//end onCreateView()

    private OnClickListener ShadeChangeListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String description = (String) view.getContentDescription();
            information = description;
            updateDetail();
        }//end onClick()

    };//end View.OnClickListener

    public interface OnItemSelectedListener{
        void onShadeItemSelected(String link);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener) activity;
        }else {
            throw new ClassCastException(activity.toString() +
                    "must implement MyListFragment.OnItemSelectedListener");
        }
    }//end onAttach()

    public void updateDetail(){
        listener.onShadeItemSelected(information);
    }

}//end ListFragment class
