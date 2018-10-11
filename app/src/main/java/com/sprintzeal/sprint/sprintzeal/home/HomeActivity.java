package com.sprintzeal.sprint.sprintzeal.home;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class HomeActivity extends AppCompatActivity {
    TextView step1,step1signup,step1moresteps,step1account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Typeface raleBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        Typeface raleLight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        step1=findViewById(R.id.step1);
        step1signup=findViewById(R.id.step1signup);
        step1moresteps=findViewById(R.id.step1moresteps);
        step1account=findViewById(R.id.step1account);
        step1.setTypeface(raleBold);
        step1account.setTypeface(raleBold);
        step1signup.setTypeface(raleLight);
        step1moresteps.setTypeface(raleLight);
        toolbar.setLogo(R.drawable.tool);
    }
    public void buttoncontinue(View view) {
        Intent intent=new Intent(HomeActivity.this,HomePlanActivity.class);
        startActivity(intent);
    }
}
