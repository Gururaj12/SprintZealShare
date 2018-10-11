package com.sprintzeal.sprint.sprintzeal;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MoreFragment extends Fragment {

    Button moreprofil,contact_us,help,logout,certification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.more_fragment, container, false);
        moreprofil=view.findViewById(R.id.moreprofil);
        certification=view.findViewById(R.id.certification);
        contact_us=view.findViewById(R.id.contact_us);
        help=view.findViewById(R.id.help);
        logout=view.findViewById(R.id.logout);

        Typeface raleRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        moreprofil.setTypeface(raleRegular);
        contact_us.setTypeface(raleRegular);
        help.setTypeface(raleRegular);
        logout.setTypeface(raleRegular);
        certification.setTypeface(raleRegular);
        moreprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pro=new Intent(getContext(),Profile.class);
                startActivity(pro);
            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact=new Intent(getContext(),ContactUs.class);
                startActivity(contact);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact=new Intent(getContext(),Help.class);
                startActivity(contact);
            }
        });
        return view;
    }

}
