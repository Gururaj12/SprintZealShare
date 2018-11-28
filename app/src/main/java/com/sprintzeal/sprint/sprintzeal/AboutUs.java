package com.sprintzeal.sprint.sprintzeal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    TextView aboutusinfo,aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        aboutus=findViewById(R.id.aboutus);
        aboutusinfo=findViewById(R.id.aboutusinfo);

        Typeface railwayrethi2 = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");
        Typeface bold = Typeface.createFromAsset(getAssets(), "fonts/proximanova-bold.otf");
        aboutus.setTypeface(bold);
        aboutusinfo.setTypeface(railwayrethi2);

    }
}
