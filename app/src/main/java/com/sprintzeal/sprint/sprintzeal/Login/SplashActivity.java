package com.sprintzeal.sprint.sprintzeal.Login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.sprintzeal.sprint.sprintzeal.LocationActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.MyFirebaseInstanceIdService;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.Trunks;
import com.sprintzeal.sprint.sprintzeal.URLs;
import com.sprintzeal.sprint.sprintzeal.bottombar.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.home.HomePage;

import android.provider.Settings.Secure;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class SplashActivity extends AppCompatActivity {
    // Splash  timer
    private static int SPLASH_TIME_OUT = 3000;
    private String androidDeviceId;
    String token;
    String ip_address;
    String resolution;
    String model;
    String manufacturer;
    int currentosVer;
    String time;
    String versionName;
    String os;
    String screensize;


    SharedPreferences sharedpreferences;

   //Button button;
    public static final String splashurl ="http://lms.sprintzeal.com/lms_new/api/v1/CustomerSplash?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);






        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
              /*  Toast.makeText(SplashActivity.this, "welcome", Toast.LENGTH_SHORT).show();
                loginuser();*/
             // loginuser();


                getDetails();

                SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString(Trunks.Ip_address,ip_address);
                editor.putString(Trunks.Resolution,resolution);
                editor.putString(Trunks.Token_id,token);
                editor.putString(Trunks.Device_id,androidDeviceId);
                editor.putString(Trunks.Model_type,model);
                editor.putString(Trunks.Manufacture_mode,manufacturer);
                editor.putString(Trunks.Os_version, String.valueOf(currentosVer));
                editor.putString(Trunks.Time_zone,time);
                editor.putString(Trunks.Operationg_system,os);
                editor.putString(Trunks.Screen_details,screensize);
                editor.putString(Trunks.App_verson,versionName);
                editor.putString(Trunks.DeviceType,os);

                editor.apply();
                loginuser();
              /*
                Intent i = new Intent(SplashActivity.this, HomePage.class);
                startActivity(i);
*/
                // close this activity

            }
        }, SPLASH_TIME_OUT);

        //Hiding Status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);





        //--


    }
  //  URLs.URL_LOGIN

    public void loginuser() {




        final StringRequest request = new StringRequest(Request.Method.POST, splashurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                try {

                    JSONObject json= (JSONObject) new JSONTokener(response).nextValue();
                    JSONObject json2 = json.getJSONObject("response_data");

                    SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                 /*   JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonObject2 = new JSONObject("response_data");*/

                 //   String success=jsonObject.getString("success");
                    String guest= (String) json2.get("guest_id");
                    String log_token= (String) json2.get("login_token");
                    String cust_id= (String) json2.get("cust_id");
                    String device_token= (String) json2.get("device_token");
                    String device_id= (String) json2.get("device_id");
                    String screen= (String) json2.get("screen_view");

                    editor.putString(Trunks.guest_id,guest);
                    editor.putString(Trunks.rdevice_id,device_id);
                    editor.putString(Trunks.device_toke,device_token);
                    editor.apply();

                    Toast.makeText(SplashActivity.this, screen, Toast.LENGTH_SHORT).show();
                    if (screen.equals("hs1")){
                        Intent intent=new Intent(SplashActivity.this,HomePage.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SplashActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }


             //       Toast.makeText(getApplicationContext(), jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

                 /*   if (!jsonObject.getBoolean(jsonObject.getString("success"))){
                        Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_SHORT).show();
                      //  Toast.makeText(getApplicationContext(), jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"false", Toast.LENGTH_SHORT).show();
                     //   Toast.makeText(getApplicationContext(), jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                    }*/
               /*     String sucess=jsonObject.getString("success");
                    String error=jsonObject.getString("error");
                    Toast.makeText(SplashActivity.this, sucess, Toast.LENGTH_SHORT).show();
                    Toast.makeText(SplashActivity.this, error, Toast.LENGTH_SHORT).show();*/

                  //  Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                  /*  if (!jsonObject.getBoolean("false")) {
                        Toast.makeText(getApplicationContext(), jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

                       *//* JSONObject userJson = jsonObject.getJSONObject("user");
                        UserModel user=new UserModel(userJson.getInt(""),
                                userJson.getString(""),
                                userJson.getString(""),
                                userJson.getString(""));*//*

                        //   SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                        finish();

                        Intent i = new Intent(SplashActivity.this, HomePage.class);
                        startActivity(i);

                        //startActivity(new Intent(getApplicationContext(), HomeBottomNavigationActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), jsonObject.getString("error_msg"), Toast.LENGTH_SHORT).show();
                    }*/
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
                params.put("device_id", androidDeviceId);
                params.put("device_token",token);
                params.put("os_version", String.valueOf(currentosVer));
                params.put("operating_system","android");
                params.put("resolution",resolution);
                params.put("screen_detail","5.6");
                params.put("time_zone",time);
                params.put("app_version",versionName);
                params.put("model_type",model);
                params.put("manufacture_type","ximio");
                params.put("manufacture_model",manufacturer);
                params.put("public_ip",ip_address);


               // params.put("device_token",ip);


               /* params.put("password", "");
                params.put("gender", "");*/
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
        }
        public void getDetails(){

          // sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            MyFirebaseInstanceIdService myFirebaseInstanceIdService = new MyFirebaseInstanceIdService();
           // SharedPreferences.Editor editor = sharedpreferences.edit();
            DisplayMetrics displayMetrics = new DisplayMetrics();

            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

            @SuppressLint("WifiManagerLeak") WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);


            ip_address = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
            int width = displayMetrics.widthPixels;
            int height = displayMetrics.heightPixels;
            resolution=width+"x"+height;
            double x=Math.pow(width/displayMetrics.xdpi,2);
            double y=Math.pow(height/displayMetrics.xdpi,2);
            double screenInches=Math.sqrt(x+y);
            screenInches=Math.round(screenInches*10)/10;
            token = FirebaseInstanceId.getInstance().getToken();
            androidDeviceId = Secure.getString(getApplicationContext().getContentResolver(),
                    Secure.ANDROID_ID);
            model = android.os.Build.MODEL;
            manufacturer = android.os.Build.MANUFACTURER;
            currentosVer = android.os.Build.VERSION.SDK_INT;
            time=  TimeZone.getDefault().getDisplayName();
            os="android";
            screensize="5.6";





            String serial = android.os.Build.SERIAL;



            try {
                versionName = getApplicationContext().getPackageManager()
                        .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
                Log.d("versionName", versionName);

         /*   Toast.makeText(this, "ip_address"+ip_address+"resolution"+width+"x"+height+"device_id"
                    +androidDeviceId+"model"+model+"serialno"+serial+"manufacture"+manufacturer+"current_osver"+currentosVer+
                    "time"+time+"versionname"+versionName+"token"+token, Toast.LENGTH_LONG).show();
*/
                //    editor.putString(App_verson,versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }


         /*   editor.putString(Ip_address,ip_address);
            editor.putString(Resolution,resolution);
            editor.putString(Token_id,token);
            editor.putString(Device_id,androidDeviceId);
            editor.putString(Model_type,model);
            editor.putString(Manufacture_mode,manufacturer);
            editor.putString(Os_version, String.valueOf(currentosVer));
            editor.putString(Time_zone,time);
            editor.putString(Operationg_system,os);
            editor.putString(Screen_details,screensize);
            editor.putString(App_verson,versionName);
            editor.commit();*/

         }
}

