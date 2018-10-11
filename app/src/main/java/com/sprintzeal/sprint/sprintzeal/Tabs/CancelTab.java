package com.sprintzeal.sprint.sprintzeal.Tabs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class CancelTab extends Fragment {
    TextView textdescp1,textdescp2,textdescp3,textdescp4,textdescp5;
    Button joinfree,joinfree2,joinfree3,joinfree4;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you class
        view= inflater.inflate(R.layout.cancel_tab, container, false);
        textdescp1=view.findViewById(R.id.textdescp1);
        textdescp2=view.findViewById(R.id.textdescp2);
        textdescp3=view.findViewById(R.id.textdescp3);
        textdescp4=view.findViewById(R.id.textdescp4);
        textdescp5=view.findViewById(R.id.textdescp5);
        joinfree=view.findViewById(R.id.joinfree);
        joinfree2=view.findViewById(R.id.joinfree2);
        joinfree3=view.findViewById(R.id.joinfree3);
        joinfree4=view.findViewById(R.id.joinfree4);

        Typeface raleBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Proxima-Nova-Xbold.otf");
        Typeface railwayrethin=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Proxima-Nova-Sbold.otf");
        Typeface railwayrethin1=Typeface.createFromAsset(getActivity().getAssets(),"fonts/proximanova-bold.otf");
        Typeface railwayrethi2=Typeface.createFromAsset(getActivity().getAssets(),"fonts/proxima_nova_reg.ttf");
        Typeface raleRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        textdescp1.setTypeface(railwayrethi2);
        textdescp2.setTypeface(railwayrethi2);
        textdescp3.setTypeface(railwayrethi2);
        textdescp4.setTypeface(railwayrethi2);
        textdescp5.setTypeface(railwayrethi2);
        joinfree.setTypeface(raleRegular);
        joinfree2.setTypeface(raleRegular);
        joinfree3.setTypeface(raleRegular);
        joinfree4.setTypeface(raleRegular);
        //ksdm


        return view;

    }
}
