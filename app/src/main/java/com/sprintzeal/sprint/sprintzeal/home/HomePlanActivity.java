package com.sprintzeal.sprint.sprintzeal.home;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class HomePlanActivity extends AppCompatActivity {
    TextView step2,step1signup,videos,steptextaccess,steptexlap,steptextmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_plan);

        step2=findViewById(R.id.step2);
        step1signup=findViewById(R.id.step1signup);
        videos=findViewById(R.id.videos);
        steptextaccess=findViewById(R.id.steptextaccess);
        steptexlap=findViewById(R.id.steptexlap);
        steptextmonth=findViewById(R.id.steptextmonth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.tool);


        Typeface caviardreambold=Typeface.createFromAsset(getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        Typeface caviardreams=Typeface.createFromAsset(getAssets(),"fonts/CaviarDreams.ttf");
        Typeface railwayblack=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Black.ttf");
        Typeface railwayregular=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Regular.ttf");
        Typeface railwayrethin=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Thin.ttf");
        Typeface railwaybold=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Bold.ttf");


        step2.setTypeface(caviardreambold);
        step1signup.setTypeface(railwayregular);
        videos.setTypeface(railwayregular);
        steptextaccess.setTypeface(railwayregular);
        steptexlap.setTypeface(railwayregular);
        steptextmonth.setTypeface(railwayregular);
       // Typeface raleBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
       // description.setTypeface(raleBold);
    }

    public void buttonplancontinue(View view) {
        Intent intent=new Intent(HomePlanActivity.this,PaymentActivity.class);
        startActivity(intent);
    }
}
