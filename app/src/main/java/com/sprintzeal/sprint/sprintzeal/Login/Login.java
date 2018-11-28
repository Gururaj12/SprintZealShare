package com.sprintzeal.sprint.sprintzeal.Login;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sprintzeal.sprint.sprintzeal.CategoryCourses;
import com.sprintzeal.sprint.sprintzeal.MovieAdapter;
import com.sprintzeal.sprint.sprintzeal.Trunks;
import com.sprintzeal.sprint.sprintzeal.bottombar.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button linkregister,btnlogin;
    TextView textmemberLogin,copyright,sprint,terms,policy,loginname,loginpassword;
    EditText edemail,edpassword;
    String first_name,device_id,os,guest,dtoken;
  //  public static final String MyPREFERENCES = "MyData" ;

    String LoginUrl="http://lms.sprintzeal.com/lms_new/api/v1/LoginCstmr";
   // List<String> items = new ArrayList<>();

   List<CategoryCourses> movieList;

    Bundle s;



   /* public List<CategoryCourses> aList = new ArrayList<>();
    public List<CourseListData> bList = new ArrayList<>();*/



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

        //SharedPreference
        SharedPreferences pref;
        SharedPreferences.Editor editor;
        //--

        //SharedPreference
        pref = getApplicationContext().getSharedPreferences(Trunks.SHP_NAME,MODE_PRIVATE);
        editor = pref.edit();
        //--

        movieList = new ArrayList<>();

        String email = pref.getString(Trunks.SHP_EMAIL,"no");
        if (!email.equalsIgnoreCase("no")){
            Intent i = new Intent(this,HomeBottomNavigationActivity.class);
            startActivity(i);
            finish();
        }

        SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        guest = sp.getString("guest_id", null);
        dtoken = sp.getString("device_toke", null);

        Toast.makeText(this, "os"+os+"guest"+guest+"token"+dtoken, Toast.LENGTH_LONG).show();

     linkregister=findViewById(R.id.btnLinkToRegisterScreen);
        btnlogin=findViewById(R.id.btnLogin);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeBottomNavigationActivity.class));
        }

        btnlogin.setTypeface(raleRegular);
    /*    linkregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             *//*   Intent intent=new Intent(Login.this,ForgotPassword.class);
                startActivity(intent);*//*
            }
        });*/
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                loginuser();

//                Toast.makeText(Login.this, items.get(0), Toast.LENGTH_SHORT).show();
              /*  Intent intent=new Intent(Login.this,HomeBottomNavigationActivity.class);
                startActivity(intent);*/

            }
        });
    }
    public void loginuser(){

        movieList = new ArrayList<>();
        final String useremail=edemail.getText().toString();
        final String password=edpassword.getText().toString();



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

        SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        final StringRequest request=new StringRequest(Request.Method.POST, LoginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  Log.d("Url",LoginUrl);
                Log.d("response",response);

            //    Toast.makeText(Login.this, response, Toast.LENGTH_LONG).show();
                try {

                  //  List<CategoryCourses> demoCourseBeans = new ArrayList<>();

                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getBoolean("success")==true){
                     //   String jsonObject1=jsonObject.getString("response_data");
                        JSONObject res = jsonObject.getJSONObject("response_data");

                        String mes=res.getString("message");
                        String cust_id=res.getString("cust_id");

                        String login_token=res.getString("login_token");

                      //  JSONArray msgs = (JSONArray) res.get("category_courses");

                    /*    for (int i = 0; i < msgs.length(); i++) {
                            JSONObject json_message = msgs.getJSONObject(i);


                            String firstName = json_message.getString("catName");
                            String catId = json_message.getString("catId");



                          *//*  personUtil.setCatName(firstName);
                            personUtil.setCatId(catId);*//*
                           *//* CategoryCourses categoryCourses=new CategoryCourses();
                            categoryCourses.setCatId(catId);
                            categoryCourses.setCatName(firstName);*//*
                            String courseList = json_message.getString("courseList");


                            JSONArray d= (JSONArray) json_message.get("courseList");

                            for (int z = 0; z < d.length(); z++) {
                                System.out.println(d.get(z));
                                JSONObject json_message1 = d.getJSONObject(z);
                                String CourseId= json_message1.getString("courseId");
                                String CourseName= json_message1.getString("courseName");
                               *//* personUtil.setCourseId(CourseId);
                                personUtil.setCourseName(CourseName);
*//*
                                String CourseImg= json_message1.getString("courseImgUrl");
                            //    CategoryCourses bean=new CategoryCourses(catId,firstName,CourseId,CourseName);
                              *//*  CategoryCourses bean=new CategoryCourses();
                                Log.d("firstmname",firstName);
                                Log.d("first",CourseName);
                               bean.setTitle(firstName);
                               bean.setYear(CourseName);
                                movieList.add(bean);*//*
                               // add(bean);
                              //  CategoryCourses bean = new CategoryCourses(firstName,catId,CourseName,CourseId);
                                CategoryCourses ad=new CategoryCourses();
                                ad.setTitle(firstName);
                                ad.setYear(CourseName);
                                movieList.add(ad);




                             Log.d("size", String.valueOf(movieList.size()));
                             Log.d("size2", String.valueOf(movieList.get(0)));


                               *//* CourseListData courseListData=new CourseListData();
                                courseListData.setCourseId(CourseId);
                                courseListData.setCourseName(CourseName);
*//*
                                Log.d("courseId",CourseId);
                                Log.d("courseName",CourseName);
                                Log.d("courseImg",CourseImg);


//
                            }



                           // Log.d("catname",firstName);
                          //  Log.d("catId",catId);
                          //  Log.d("course",courseList);


                        }


                  //      List messages = new ArrayList();

                        //JSONArray msgs = (JSONArray) res.get("listMessages");
                        //    JSONObject object= jsonArray.getJSONObject(i);

                     *//*   for (int i = 0; i < msgs.length(); i++) {
                            JSONObject json_message = msgs.getJSONObject(i);
                            if (json_message != null) {
                                MyObjectMessage objMsg = new MyObjectMessage();

                                objMsg.setName(json_message.getString("catName"));
                                messages.add(objMsg);
                            }
                        }*/



                        Toast.makeText(Login.this, "hi", Toast.LENGTH_SHORT).show();
                        editor.putString(Trunks.SHP_EMAIL,edemail.getText().toString());
                        editor.commit();
                        editor.putString(Trunks.login_token,login_token);
                        editor.putString(Trunks.cust_id,cust_id);
                        editor.apply();
                        String screen_view=res.getString("screen_view");
                        if (screen_view.equals("cs1")){

                           /* for(int k=0;k<movieList.size();k++)
                            {
                                System.out.println(movieList.get(k));
                                Log.d("data", String.valueOf(movieList.get(k)));
                            }*/
                            Intent cs1=new Intent(Login.this,HomeBottomNavigationActivity.class);

                            startActivity(cs1);
                         /*  CategoryCourses categoryCourses;
                           categoryCourses.getCatName();*/
                          /*  Bundle bundle = new Bundle();
                            bundle.putString("key_1", items.get(1));
                            bundle.putBoolean("key_2", true);
                            cs1.putExtras(bundle);
                            startActivity(cs1);
*/
                        }

                        Toast.makeText(Login.this, mes, Toast.LENGTH_SHORT).show();
                    }else {
                      String error=  jsonObject.getString("error");
                        Toast.makeText(Login.this, error, Toast.LENGTH_SHORT).show();
                    }
                 /*   if (!jsonObject.getBoolean("error")){
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject userJson = jsonObject.getJSONObject("user");
                        UserModel user=new UserModel(userJson.getInt(""),
                                userJson.getString(""),
                                userJson.getString(""),
                                userJson.getString(""));

                     //   SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), HomeBottomNavigationActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }*/
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
                params.put("device_token", dtoken);
                params.put("device_id", device_id);
                params.put("device_type", "android");
                params.put("email", useremail);
                params.put("password", password);
                params.put("guest_id", guest);
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);

    }

    public void add(CategoryCourses bean){




        Log.d("bean",bean.getYear());
        Log.d("bean1",bean.getTitle());
        Toast.makeText(this, bean.getTitle(), Toast.LENGTH_SHORT).show();


    }

    public void forgotPassword(View view){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.mail_dialog,null);
        final EditText email = (EditText)v.findViewById(R.id.email);
        Button verify = (Button)v.findViewById(R.id.verifiy);
        mBuilder.setView(v);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    String sEmail = email.getText().toString();
               /* if (sEmail.isEmpty()){
                    Toast.makeText(Login.this, "Please enter your mail Id", Toast.LENGTH_SHORT).show();
                }else{
                    if (emailValidator(sEmail)){
                        dialog.dismiss();
                        generateOTP(email.getText().toString());

                    }else{
                        Toast.makeText(Login.this, "Please enter valid mail Id", Toast.LENGTH_SHORT).show();
                    }
                }*/
}
        });
    }


                }
