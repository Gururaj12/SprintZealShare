package com.sprintzeal.sprint.sprintzeal.Login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

public class ForgotPassword extends AppCompatActivity {
    Button btnforgotpassword;
    TextView textforgot,resetcopyright,resetlog,resetsprint,resetprivacy,reseterms,forgotemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        btnforgotpassword=findViewById(R.id.btnforgotpassword);
        resetcopyright=findViewById(R.id.resetcopyright);
        resetlog=findViewById(R.id.resetlog);
        resetsprint=findViewById(R.id.resetsprint);
        reseterms=findViewById(R.id.reseterms);
       textforgot=findViewById(R.id.textforgot);
        resetprivacy=findViewById(R.id.resetprivacy);
        forgotemail=findViewById(R.id.forgotemail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.tool);

        Typeface proximaRegular= Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");

        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        textforgot.setTypeface(proximaRegular);
        resetcopyright.setTypeface(proximaRegular);
        resetlog.setTypeface(proximaRegular);
        resetsprint.setTypeface(proximaRegular);
        reseterms.setTypeface(proximaRegular);
        resetprivacy.setTypeface(proximaRegular);
        forgotemail.setTypeface(ralelight);


        btnforgotpassword.setTypeface(raleRegular);
        btnforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotPassword.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
