package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sprintzeal.sprint.sprintzeal.Login.Login;
import com.sprintzeal.sprint.sprintzeal.Login.RegisterActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.PdfDownloadActivity;
import com.sprintzeal.sprint.sprintzeal.Trunks;
import com.sprintzeal.sprint.sprintzeal.home.ContactUs;
import com.sprintzeal.sprint.sprintzeal.home.Help;
import com.sprintzeal.sprint.sprintzeal.home.HomePage;
import com.sprintzeal.sprint.sprintzeal.home.Profile;
import com.sprintzeal.sprint.sprintzeal.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MoreFragment extends Fragment {

    Button moreprofil, contact_us, help, logout, certification;
    String LogoutUrl = "http://lms.sprintzeal.com/lms_new/api/v1/customer_logout";
    String cust_id, device_id, os, guest, dtoken,login_token;
    public static final String MyPREFERENCES = "MyData";
    //SharedPreference
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;
    public static String currentCourse = "";
    //--

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.more_fragment, container, false);
        moreprofil = view.findViewById(R.id.moreprofil);
        certification = view.findViewById(R.id.certification);
        contact_us = view.findViewById(R.id.contact_us);
        help = view.findViewById(R.id.help);
        logout = view.findViewById(R.id.logout);
        //SharedPreference
        pref = getActivity().getSharedPreferences(Trunks.SHP_NAME,MODE_PRIVATE);
        editor = pref.edit();
        //--
        Typeface raleRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        moreprofil.setTypeface(raleRegular);
        contact_us.setTypeface(raleRegular);
        help.setTypeface(raleRegular);
        logout.setTypeface(raleRegular);
        certification.setTypeface(raleRegular);
        SharedPreferences sp = this.getActivity().getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        guest = sp.getString("guest_id", null);
        dtoken = sp.getString("device_toke", null);
        cust_id = sp.getString("cust_id", null);
        login_token = sp.getString("login_token", null);

        certification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pdf = new Intent(getContext(), PdfDownloadActivity.class);
                startActivity(pdf);
            }
        });
        moreprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pro = new Intent(getContext(), Profile.class);
                startActivity(pro);
            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(getContext(), ContactUs.class);
                startActivity(contact);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(getContext(), Help.class);
                startActivity(contact);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove(Trunks.SHP_EMAIL);
                editor.commit();

                logout();
            }
        });

        return view;
    }

    public void logout() {


        final StringRequest request = new StringRequest(Request.Method.POST, LogoutUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getBoolean("success")==false){
                        //   String jsonObject1=jsonObject.getString("response_data");

                        String out=jsonObject.getString("error");

                      //  Toast.makeText(getActivity(),out , Toast.LENGTH_LONG).show();
                     Intent  intent=new Intent(getActivity(), HomePage.class);
                     startActivity(intent);
                    }else
                    {
                        Toast.makeText(getActivity(), "else", Toast.LENGTH_SHORT).show();
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
                params.put("device_type", login_token);
                params.put("login_token", "android");

                params.put("cust_id", cust_id);
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);

    }

}

