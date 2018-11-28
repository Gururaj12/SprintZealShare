package com.sprintzeal.sprint.sprintzeal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrivacyPolicy extends AppCompatActivity {

    TextView privacypolicy,privacyinfo,informationcollection,inormation,
            securitydata,privacysectioinfo,pregister,preginfo,porder
            ,porderdata,pcookies,pcookiesdata,psharing,psharinginfo,psite,psiteinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        privacypolicy=findViewById(R.id.privacypolicy);
        privacyinfo=findViewById(R.id.privacyinfo);

        informationcollection=findViewById(R.id.informationcollection);
        inormation=findViewById(R.id.inormation);
        securitydata=findViewById(R.id.securitydata);
        privacysectioinfo=findViewById(R.id.privacysectioinfo);
        pregister=findViewById(R.id.pregister);
        preginfo=findViewById(R.id.privacypolicy);
        porder=findViewById(R.id.porder);
        porderdata=findViewById(R.id.porderdata);
        pcookies=findViewById(R.id.pcookies);
        pcookiesdata=findViewById(R.id.pcookiesdata);
        psharing=findViewById(R.id.psharing);
        psharinginfo=findViewById(R.id.psharinginfo);
        psite=findViewById(R.id.psite);
        psiteinfo=findViewById(R.id.psiteinfo);

        Typeface railwayrethi2 = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");
        Typeface bold = Typeface.createFromAsset(getAssets(), "fonts/proximanova-bold.otf");
        privacypolicy.setTypeface(bold);
        informationcollection.setTypeface(bold);
        securitydata.setTypeface(bold);
        pregister.setTypeface(bold);
        porder.setTypeface(bold);
        pcookies.setTypeface(bold);
        psharing.setTypeface(bold);
        psite.setTypeface(bold);

        privacyinfo.setTypeface(railwayrethi2);
        inormation.setTypeface(railwayrethi2);
        psiteinfo.setTypeface(railwayrethi2);
        psharinginfo.setTypeface(railwayrethi2);
        pcookiesdata.setTypeface(railwayrethi2);
        porderdata.setTypeface(railwayrethi2);
        preginfo.setTypeface(railwayrethi2);
        privacysectioinfo.setTypeface(railwayrethi2);
        privacysectioinfo.setTypeface(railwayrethi2);


    }
}
