package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class LvcDetails extends Fragment {
    TextView heading,description,detailinfo,description1,description2,description3,instructorinfo,instructor;
    Button enroll;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=LayoutInflater.from(getContext()).inflate(R.layout.lvc_details,container,false);
        heading=view.findViewById(R.id.heading);
        description=view.findViewById(R.id.description);
        description1=view.findViewById(R.id.description1);
        detailinfo=view.findViewById(R.id.detailinfo);
        description2=view.findViewById(R.id.description2);
        instructorinfo=view.findViewById(R.id.instructorinfo);
        description3=view.findViewById(R.id.description3);
        instructor=view.findViewById(R.id.instructor);
        enroll=view.findViewById(R.id.enroll);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/proxima_nova_reg.ttf");
        description.setTypeface(typeface);
        description1.setTypeface(typeface);
        detailinfo.setTypeface(typeface);
        description2.setTypeface(typeface);
        instructorinfo.setTypeface(typeface);
        description3.setTypeface(typeface);
        enroll.setTypeface(typeface);


        return view;
    }
}
