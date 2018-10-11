package com.sprintzeal.sprint.sprintzeal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Profile extends AppCompatActivity {
    Toolbar profilebar;
    TextView profilrname,profilemail,profilenumber,profilepassword,profileaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilebar=findViewById(R.id.profilebar);
        profilebar.setSubtitle("Profile");
        profilrname=findViewById(R.id.profilrname);
        profilemail=findViewById(R.id.profilemail);
        profilenumber=findViewById(R.id.profilenumber);
        profilepassword=findViewById(R.id.profilepassword);
        profileaddress=findViewById(R.id.profileaddress);

        profilebar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        Typeface proximaRegular= Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");
        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface raleRegularitalic = Typeface.createFromAsset(getAssets(), "fonts/Raleway-ThinItalic.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        Typeface ralemedium = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium.ttf");
        Typeface ralethin = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Thin.ttf");



        profilrname.setTypeface(ralelight);
        profilemail.setTypeface(ralelight);
        profilenumber.setTypeface(ralelight);
        profilepassword.setTypeface(ralelight);
        profileaddress.setTypeface(ralelight);

    }
}
