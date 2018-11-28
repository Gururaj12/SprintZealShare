package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sprintzeal.sprint.sprintzeal.AboutUs;
import com.sprintzeal.sprint.sprintzeal.ManageAccount;
import com.sprintzeal.sprint.sprintzeal.PrivacyPolicy;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.TermsOfUse;
import com.sprintzeal.sprint.sprintzeal.home.Help;

import org.w3c.dom.Text;

public class PrivacySetting extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    TextView manageaccount,aboutus,termsofuse,privacy,helpcenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_setting);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.newlogo);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        manageaccount=findViewById(R.id.manageaccount);
        aboutus=findViewById(R.id.aboutus);

        termsofuse=findViewById(R.id.termsofuse);
        privacy=findViewById(R.id.privacy);
        helpcenter=findViewById(R.id.helpcenter);

        manageaccount.setOnClickListener(this);
        aboutus.setOnClickListener(this);

        termsofuse.setOnClickListener(this);
        privacy.setOnClickListener(this);
        helpcenter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.manageaccount:
              Intent manageintent=new Intent(PrivacySetting.this, ManageAccount.class);
              startActivity(manageintent);
              break;
          case R.id.aboutus:
              Intent intent=new Intent(PrivacySetting.this, AboutUs.class);
              startActivity(intent);
             break;

          case R.id.termsofuse:
              Intent termsintent=new Intent(PrivacySetting.this, TermsOfUse.class);
              startActivity(termsintent);
              break;
          case R.id.privacy:
              Intent privscyintent=new Intent(PrivacySetting.this, PrivacyPolicy.class);
              startActivity(privscyintent);
              break;
          case R.id.helpcenter:
              Intent helpintent=new Intent(PrivacySetting.this, Help.class);
              startActivity(helpintent);
              break;


      }
    }
}
