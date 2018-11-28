package com.sprintzeal.sprint.sprintzeal.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sprintzeal.sprint.sprintzeal.Login.Login;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.bottombar.HomeBottomNavigationActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class Profile extends AppCompatActivity {
    Toolbar profilebar;
  //  TextView profilrname, profilemail, profilenumber, profilepassword, profileaddress;

    EditText name,emailaddress,number,password,address;
    String first_name, device_id, os, cust_id, dtoken,login_token;
    String   pcust_id ,ppimg ,pfirstname ,pemail ,pphone;
    ImageView photo;
    LinearLayout linearopen;
    public static final String MyPREFERENCES = "MyData";
    int PICK_IMAGE_REQUEST = 111;
    Bitmap bitmap;
    ProgressDialog progressDialog;
    String MyprofileUrl = "http://lms.sprintzeal.com/lms_new/api/v1/my_profile";
    String MyprofileUpdateUrl = "http://lms.sprintzeal.com/lms_new/api/v1/update_profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
      /*  profilebar = findViewById(R.id.profilebar);
        profilebar.setSubtitle("Profile");*/
      /*  profilrname = findViewById(R.id.profilrname);
        profilemail = findViewById(R.id.profilemail);
        profilenumber = findViewById(R.id.profilenumber);
        profilepassword = findViewById(R.id.profilepassword);
        profileaddress = findViewById(R.id.profileaddress);*/

        name=findViewById(R.id.fullName);
        emailaddress=findViewById(R.id.email);
        number=findViewById(R.id.contactNo);
        password=findViewById(R.id.password);
        address=findViewById(R.id.address);
        photo=findViewById(R.id.dp);


        SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        cust_id = sp.getString("cust_id", null);
        dtoken = sp.getString("device_toke", null);
        login_token = sp.getString("login_token", null);

//        profilebar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        Typeface proximaRegular = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");
        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface raleRegularitalic = Typeface.createFromAsset(getAssets(), "fonts/Raleway-ThinItalic.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        Typeface ralemedium = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium.ttf");
        Typeface ralethin = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Thin.ttf");

/*
        profilrname.setTypeface(ralelight);
        profilemail.setTypeface(ralelight);
        profilenumber.setTypeface(ralelight);
        profilepassword.setTypeface(ralelight);
        profileaddress.setTypeface(ralelight);*/
        name.setTypeface(ralelight);
        emailaddress.setTypeface(ralelight);
        number.setTypeface(ralelight);
        password.setTypeface(ralelight);
        address.setTypeface(ralelight);
        myprofile();
       /* profilemail.setText(pemail);
        profilrname.setText(pfirstname);
        profilenumber.setText(pphone);*/
       photo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_PICK);
               startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
           }
       });

    }

    public void myprofile() {

String sname=name.getText().toString();
        Toast.makeText(this, sname, Toast.LENGTH_SHORT).show();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Getting profile information");
        dialog.show();
        dialog.setCancelable(false);
        SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();



        final StringRequest request = new StringRequest(Request.Method.POST, MyprofileUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(Profile.this, response, Toast.LENGTH_LONG).show();
                dialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("success") == true) {
                        //   String jsonObject1=jsonObject.getString("response_data");
                        JSONObject res = jsonObject.getJSONObject("response_data");
                         pcust_id = res.getString("cust_id");
                         ppimg = res.getString("profile_image");
                         pfirstname = res.getString("first_name");
                         pemail = res.getString("email");
                         pphone = res.getString("phone");
                         name.setText(res.getString("first_name"));
                        emailaddress.setText(res.getString("email"));
                         number.setText(res.getString("phone"));

                    } else {
                        String error = jsonObject.getString("error");
                        Toast.makeText(Profile.this, error, Toast.LENGTH_SHORT).show();
                    }

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
                params.put("device_token", dtoken);
                params.put("device_id", device_id);
                params.put("device_type", "android");
                params.put("login_token",login_token);
                params.put("cust_id", cust_id);

                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                photo.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(View view) {


        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Getting profile information");
        dialog.show();
        dialog.setCancelable(false);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);


    /* ByteArrayOutputStream byteArrayOutputStreamObject ;

        byteArrayOutputStreamObject = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject);

        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();

        final String ConvertImage = Base64.encodeToString(byteArrayVar, Base64.DEFAULT);*/

        SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        final StringRequest request = new StringRequest(Request.Method.POST, MyprofileUpdateUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

             ///   Toast.makeText(Profile.this, response, Toast.LENGTH_LONG).show();
                dialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("success") == true) {
                        //   String jsonObject1=jsonObject.getString("response_data");
                        JSONObject res = jsonObject.getJSONObject("response_data");
                        String message = res.getString("message");
                    /*    ppimg = res.getString("profile_image");
                        pfirstname = res.getString("first_name");
                        pemail = res.getString("email");
                        pphone = res.getString("phone");
                        name.setText(res.getString("first_name"));
                        emailaddress.setText(res.getString("email"));
                        number.setText(res.getString("phone"));*/
                        Toast.makeText(Profile.this, message, Toast.LENGTH_SHORT).show();

                    } else {
                        String error = jsonObject.getString("error");
                        Toast.makeText(Profile.this, error, Toast.LENGTH_SHORT).show();
                    }

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
                params.put("device_token", dtoken);
                params.put("device_id", device_id);
                params.put("device_type", "android");
                params.put("login_token",login_token);
             params.put("cust_profile ",imageString);

                params.put("cust_id", cust_id);
                   params.put("first_name", name.getText().toString());
                params.put("email", emailaddress.getText().toString());
                params.put("phone", number.getText().toString());
                params.put("password", password.getText().toString());
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
    }
}