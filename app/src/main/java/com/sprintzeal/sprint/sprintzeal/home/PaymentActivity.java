package com.sprintzeal.sprint.sprintzeal.home;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.sprintzeal.sprint.sprintzeal.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.Login.Login;
import com.sprintzeal.sprint.sprintzeal.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,GoogleApiClient.OnConnectionFailedListener {
    Spinner expirymonth,expiryyear;
    TextView step3,step3signup,plan,limitedplan,paymentcardnumber,paymentsecuritycode;
    Button btnContinue,logout;
    CheckBox paymentcheck;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        expirymonth=findViewById(R.id.expirymonth);
        expiryyear=findViewById(R.id.expiryyear);
        step3=findViewById(R.id.step3);
        step3signup=findViewById(R.id.step3signup);
        plan=findViewById(R.id.plan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.tool);
        btnContinue=findViewById(R.id.btnContinue);
        limitedplan=findViewById(R.id.limitedplan);
        paymentcheck=findViewById(R.id.paymentcheck);
        paymentcardnumber=findViewById(R.id.paymentcardnumber);
        paymentsecuritycode=findViewById(R.id.paymentsecuritycode);
        logout=findViewById(R.id.logout);



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Typeface railwayrethi2=Typeface.createFromAsset(getAssets(),"fonts/proxima_nova_reg.ttf");
        Typeface raleRegular=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Regular.ttf");

        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");

        step3.setTypeface(railwayrethi2);
        step3signup.setTypeface(railwayrethi2);
        plan.setTypeface(railwayrethi2);
        btnContinue.setTypeface(raleRegular);
        limitedplan.setTypeface(railwayrethi2);
        paymentcheck.setTypeface(railwayrethi2);
        paymentcardnumber.setTypeface(ralelight);
        paymentsecuritycode.setTypeface(ralelight);
logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Intent intent=new Intent(PaymentActivity.this, Login.class);
                        startActivity(intent);
                    }
                });
    }
});


        //setting the title


        // Spinner Drop down elements
        List month = new ArrayList();
        month.add("01");
        month.add("02");
        month.add("03");
        month.add("04");
        month.add("05");
        month.add("06");
        month.add("07");
        month.add("08");
        month.add("09");
        month.add("10");
        month.add("11");
        month.add("12");

        List year = new ArrayList();
        year.add("2018");
        year.add("2019");
        year.add("2020");
        year.add("2021");
        year.add("2022");
        year.add("2023");
        year.add("2024");
        year.add("2025");
        year.add("2026");
        year.add("2027");
        year.add("2028");
        year.add("2029");
        year.add("2030");
        year.add("2031");


        // Creating array adapter for spinner
        ArrayAdapter e_month = new ArrayAdapter(this, android.R.layout.simple_spinner_item, month);
        ArrayAdapter e_year = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);


        // Drop down style will be listview with radio button
        e_month.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        e_year.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        // attaching data adapter to spinner
        expirymonth.setAdapter(e_month);
        expiryyear.setAdapter(e_year);
    }


    public void buttonmember(View view) {

        Intent intent=new Intent(PaymentActivity.this,HomeBottomNavigationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected Country: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
