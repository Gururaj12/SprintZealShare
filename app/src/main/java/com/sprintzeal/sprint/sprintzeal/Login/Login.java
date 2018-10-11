package com.sprintzeal.sprint.sprintzeal.Login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;
import com.sprintzeal.sprint.sprintzeal.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.SharedPrefManager;
import com.sprintzeal.sprint.sprintzeal.URLs;
import com.sprintzeal.sprint.sprintzeal.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button linkregister,btnlogin;
    TextView textmemberLogin,copyright,sprint,terms,policy,loginname,loginpassword;
    EditText edemail,edpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Typeface proximaRegular= Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");
        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        copyright=findViewById(R.id.copyright);
        textmemberLogin=findViewById(R.id.textmemberLogin);
        sprint=findViewById(R.id.sprint);
        terms=findViewById(R.id.terms);
        loginname=findViewById(R.id.loginname);
        loginpassword=findViewById(R.id.loginpassword);
        policy=findViewById(R.id.policy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textmemberLogin.setTypeface(proximaRegular);
        copyright.setTypeface(proximaRegular);
        sprint.setTypeface(proximaRegular);
        terms.setTypeface(proximaRegular);
        policy.setTypeface(proximaRegular);
        loginname.setTypeface(ralelight);
        loginpassword.setTypeface(ralelight);
        edemail=findViewById(R.id.useremail);
        edpassword=findViewById(R.id.userpassword);
        toolbar.setLogo(R.drawable.tool);

     linkregister=findViewById(R.id.btnLinkToRegisterScreen);
        btnlogin=findViewById(R.id.btnLogin);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeBottomNavigationActivity.class));
        }

        btnlogin.setTypeface(raleRegular);
        linkregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,HomeBottomNavigationActivity.class);
                startActivity(intent);

            }
        });
    }
    public void loginuser(){

        String useremail=edemail.getText().toString();
        String password=edpassword.getText().toString();

        if (TextUtils.isEmpty(useremail)){
            edemail.setError("please enter valid email");
            edemail.setFocusable(true);
        }
        if (TextUtils.isEmpty(password)){
            edpassword.setError("please enter valid password");
            edpassword.setFocusable(true);
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
            edemail.setError("Enter a valid email");
            edemail.requestFocus();
            return;
        }

        final StringRequest request=new StringRequest(Request.Method.POST, URLs.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (!jsonObject.getBoolean("error")){
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject userJson = jsonObject.getJSONObject("user");
                        UserModel user=new UserModel(userJson.getInt(""),
                                userJson.getString(""),
                                userJson.getString(""),
                                userJson.getString(""));

                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), HomeBottomNavigationActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", "");
                params.put("email", "");
               /* params.put("password", "");
                params.put("gender", "");*/
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);

    }
}
