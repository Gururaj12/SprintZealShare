package com.sprintzeal.sprint.sprintzeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sprintzeal.sprint.sprintzeal.Login.SplashActivity;
import com.sprintzeal.sprint.sprintzeal.home.HomePage;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivityDemo extends AppCompatActivity {
    private static final String  RegisterUrl="http://lms.sprintzeal.com/lms_new/api/v1/CustomerRegistration";
    String first_name,device_id,os,guest,dtoken;
    public static final String MyPREFERENCES = "MyData" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        guest = sp.getString("guest_id", null);
        dtoken = sp.getString("device_toke", null);
        loginuser();


    }

    public void loginuser() {




        final StringRequest request = new StringRequest(Request.Method.POST, RegisterUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegisterActivityDemo.this, response.toString(), Toast.LENGTH_LONG).show();
                try {

                    JSONObject json= (JSONObject) new JSONTokener(response).nextValue();
                    JSONObject json2 = json.getJSONObject("response_data");

                    SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
              //  params.put("first_name","gururaj");
                params.put("email","rajguru@gmail.com");
                params.put("guest_id",guest );
                params.put("password","12345678");
                params.put("login_by","manual");
                params.put("phone","9591865276");
                params.put("device_type",os);
                params.put("device_token",dtoken);
                params.put("social_unique_id","");
                params.put("device_id",device_id);

                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
    }
}
