package com.sprintzeal.sprint.sprintzeal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestDetailsActivity extends AppCompatActivity {
    Button test;
    TextView testnumber,questiondescp,details,detailsinfo,instruct,instructioninfo,systemcheck,screensize,javascript,
            httpdata,httpost,timer,operatingsystem,browsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);
        test=findViewById(R.id.test);
        testnumber=findViewById(R.id.testnumber);
        questiondescp=findViewById(R.id.questiondescp);
        details=findViewById(R.id.details);
        detailsinfo=findViewById(R.id.detailsinfo);
        instruct=findViewById(R.id.instruct);
        instructioninfo=findViewById(R.id.instructioninfo);
        systemcheck=findViewById(R.id.systemcheck);
        screensize=findViewById(R.id.screensize);
        javascript=findViewById(R.id.javascript);
        httpdata=findViewById(R.id.httpdata);
        httpost=findViewById(R.id.httpost);
        timer=findViewById(R.id.timer);
        operatingsystem=findViewById(R.id.operatingsystem);
        browsername=findViewById(R.id.browsername);


        Typeface railwayrethi2 = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");


        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");

        testnumber.setTypeface(raleRegular);
        details.setTypeface(raleRegular);
        instruct.setTypeface(raleRegular);
        systemcheck.setTypeface(raleRegular);

        questiondescp.setTypeface(railwayrethi2);
        instructioninfo.setTypeface(railwayrethi2);
        detailsinfo.setTypeface(railwayrethi2);

        detailsinfo.setTypeface(railwayrethi2);
        detailsinfo.setTypeface(railwayrethi2);
        javascript.setTypeface(railwayrethi2);
        screensize.setTypeface(railwayrethi2);

        httpdata.setTypeface(railwayrethi2);
        httpost.setTypeface(railwayrethi2);
        timer.setTypeface(railwayrethi2);
        operatingsystem.setTypeface(railwayrethi2);
        browsername.setTypeface(railwayrethi2);
        test.setTypeface(raleRegular);


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestDetailsActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
