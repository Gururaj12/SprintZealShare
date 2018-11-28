package com.sprintzeal.sprint.sprintzeal.home;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class ContactUs extends AppCompatActivity {
    Toolbar contactbar;
    TextView contactmessage,contactaddress,contactemail,contactname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        contactbar=findViewById(R.id.contactbar);
       contactbar.setSubtitle("ContactUs");

        contactbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        contactmessage=findViewById(R.id.contactmessage);
        contactaddress=findViewById(R.id.contactaddress);
        contactemail=findViewById(R.id.contactemail);
        contactname=findViewById(R.id.contactname);
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");

        contactmessage.setTypeface(ralelight);
        contactaddress.setTypeface(ralelight);
        contactemail.setTypeface(ralelight);
        contactname.setTypeface(ralelight);

    }
}
