package com.sprintzeal.sprint.sprintzeal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CorporateTraining extends AppCompatActivity {
    TextView trainingname,trainingAddress,trainingnumber,trainingmembers,trainingType,trainingcompany,trainingdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporate_training);
        trainingname=findViewById(R.id.trainingname);
        trainingAddress=findViewById(R.id.trainingAddress);
        trainingnumber=findViewById(R.id.trainingnumber);
        trainingmembers=findViewById(R.id.trainingmembers);
        trainingType=findViewById(R.id.trainingType);
        trainingcompany=findViewById(R.id.trainingcompany);
        trainingdate=findViewById(R.id.trainingdate);

        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        trainingname.setTypeface(ralelight);
        trainingAddress.setTypeface(ralelight);
        trainingnumber.setTypeface(ralelight);
        trainingmembers.setTypeface(ralelight);
        trainingType.setTypeface(ralelight);
        trainingcompany.setTypeface(ralelight);
        trainingdate.setTypeface(ralelight);


    }
}
