package com.sprintzeal.sprint.sprintzeal.Login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.sprintzeal.sprint.sprintzeal.Trunks;
import com.sprintzeal.sprint.sprintzeal.bottombar.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.SharedPrefManager;
import com.sprintzeal.sprint.sprintzeal.home.HomePage;
import com.squareup.picasso.Picasso;


import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.sprintzeal.sprint.sprintzeal.home.PaymentActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sprintzeal.sprint.sprintzeal.bottombar.HomeBottomNavigationActivity.editor;

public class RegisterActivity extends AppCompatActivity implements    View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    TextView step1, step1account, step1signup, step1moresteps, step2, step2signup, videos, steptextaccess, steptexlap, steptextmonth,
            registername, registerpassword, registerfullname, registernumber, steptextcancel;
    Button con,forgotpassword;
    EditText useremail, userpassword, usernumber, userfullname;
    CheckBox check;
    private static final String EMAIL = "email";
    LoginButton loginButton;
    CallbackManager callbackManager;
    ImageView imageView;
    TextView txtUsername, txtEmail;
    private AccessToken mAccessToken;
    private ProgressDialog mProgressDialog;
    String MobilePattern = "[0-9]{10}";

    private static final int RC_SIGN_IN = 007;

    private GoogleApiClient mGoogleApiClient;
    String RegisterUrl="http://lms.sprintzeal.com/lms_new/api/v1/CustomerRegistration";

    ProgressBar progressBar;
    String first_name,device_id,os,guest,dtoken;
  //  public static final String MyPREFERENCES = "MyData" ;
    //  String Reg_url="https://lms.sprintzeal.com/lms_new/api/v1/CustomerRegistration";
/*

    //SharedPreference
    SharedPreferences pref;
    //    SharedPreferences.Editor editor;
    //    //--
*/

    //SharedPreference
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    //--
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        step1 = findViewById(R.id.step1);
        step1account = findViewById(R.id.step1account);
        con = findViewById(R.id.btnLogin);
        step2 = findViewById(R.id.step2);
        step1signup = findViewById(R.id.step1signup);
        videos = findViewById(R.id.videos);
        steptextaccess = findViewById(R.id.steptextaccess);
        steptexlap = findViewById(R.id.steptexlap);
        steptextmonth = findViewById(R.id.steptextmonth);
        step2signup = findViewById(R.id.step2signup);
        registername = findViewById(R.id.registername);
        registernumber = findViewById(R.id.registernumber);
        registerfullname = findViewById(R.id.registerfullname);
        registerpassword = findViewById(R.id.registerpassword);
        check = findViewById(R.id.check);
        steptextcancel = findViewById(R.id.steptextcancel);

        step1signup = findViewById(R.id.step1signup);
        step1moresteps = findViewById(R.id.step1moresteps);

        useremail = findViewById(R.id.useremail);
        userpassword = findViewById(R.id.userpassword);
        usernumber = findViewById(R.id.usernumber);
        userfullname = findViewById(R.id.userfullname);
        forgotpassword=findViewById(R.id.forgotpassword);

        //SharedPreference
        pref = getApplicationContext().getSharedPreferences(Trunks.SHP_NAME,MODE_PRIVATE);
        editor = pref.edit();
        //--
        //SharedPreference
     /*   pref = getApplicationContext().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        editor = pref.edit();*/
        //--

        SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
         guest = sp.getString("guest_id", null);
         dtoken = sp.getString("device_toke", null);
       // Toast.makeText(this, guest, Toast.LENGTH_SHORT).show();


        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.tool);


/*
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeBottomNavigationActivity.class));
            return;
        }*/
        callbackManager = CallbackManager.Factory.create();


        loginButton = findViewById(R.id.login_button);
        //  loginButton.setsize(SignInButton.SIZE_STANDARD);
        imageView = findViewById(R.id.imageView);
      /*  txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);*/
        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

        if (!loggedOut) {
            Picasso.with(this).load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
            Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());

            //Using Graph API
         //   getUserProfile(AccessToken.getCurrentAccessToken());
        }

        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        callbackManager = CallbackManager.Factory.create();

        Typeface railwayrethin1 = Typeface.createFromAsset(getAssets(), "fonts/proximanova-bold.otf");
        Typeface railwayrethi2 = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");


        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
        step1.setTypeface(railwayrethi2);
        step1account.setTypeface(railwayrethi2);
        step2signup.setTypeface(railwayrethi2);
        step1moresteps.setTypeface(railwayrethi2);
        step2.setTypeface(railwayrethi2);
        step1signup.setTypeface(railwayrethi2);
        videos.setTypeface(railwayrethi2);
        steptextaccess.setTypeface(railwayrethi2);
        steptexlap.setTypeface(railwayrethi2);
        steptextmonth.setTypeface(railwayrethi2);
        con.setTypeface(raleRegular);
        check.setTypeface(railwayrethi2);
        registername.setTypeface(ralelight);
        registernumber.setTypeface(ralelight);
        registerfullname.setTypeface(ralelight);
        registerpassword.setTypeface(ralelight);
        steptextcancel.setTypeface(railwayrethi2);
     //   init();


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot=new Intent(RegisterActivity.this,Login.class);
                startActivity(forgot);
            }
        });


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mAccessToken = loginResult.getAccessToken();
            //    getUserProfile(mAccessToken);

               /* boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
                Log.d("API123", loggedIn + " ??");*/
                // Toast.makeText(RegisterActivity.this, loginResult.getAccessToken().getUserId(), Toast.LENGTH_SHORT).show();
                // App code


            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }


    public void registerContinue(View view) {
        register();
      //  registeruser();
       /* Intent intent=new Intent(RegisterActivity.this, PaymentActivity.class);
        startActivity(intent);*/
    }

    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String email = object.getString("email");
                            String id = object.getString("id");
                         //   String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";

                            txtUsername.setText("First Name: " + first_name + "\nLast Name: " + last_name);
                            txtEmail.setText(email);
                        //    Picasso.with(RegisterActivity.this).load(image_url).into(imageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    public void validateEmail() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Validating email address");
        dialog.setCancelable(false);
        dialog.show();
        String sEmail = useremail.getText().toString();
        String url = Trunks.checkEmail + "" + sEmail;
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject job = jsonArray.getJSONObject(0);
                    if (job.getString("status").equals("yes")) {
                        alertDialog("Alert", "You are already register");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
            }
        });
        Trunks.retryPolicy(request);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void init() {
        useremail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().contains(".com")) {
                   // validateEmail();
                }
            }
        });
    }

    private void registeruser() {
        final String email = useremail.getText().toString().trim();
        final String password = userpassword.getText().toString().trim();
        final String fullname = userfullname.getText().toString().trim();
        final String phonenumber = usernumber.getText().toString().trim();


        EditText fields[] = {userfullname, useremail, usernumber, userpassword};
        boolean canSave = true;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().toString().isEmpty()) {
                canSave = false;
                fields[i].setError("Please fill");
            }
        }
        if (userpassword.getText().toString().length() < 8) {
            canSave = false;
            userpassword.setError("Password must be minimum 8 digits");
        }
        if (canSave && emailValidator(useremail.getText().toString())) {
            String full_name = userfullname.getText().toString();
            try {
                full_name = URLEncoder.encode(full_name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }







        Log.d("RegisterResponse", RegisterUrl);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Creating account");
        dialog.show();
        dialog.setCancelable(false);
        StringRequest request = new StringRequest(RegisterUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

           //     Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getBoolean("success")==true){
                        //   String jsonObject1=jsonObject.getString("response_data");
                        Toast.makeText(RegisterActivity.this, "what", Toast.LENGTH_SHORT).show();
                        String message=jsonObject.getString("message");

                        Toast.makeText(RegisterActivity.this,message , Toast.LENGTH_LONG).show();
                        JSONObject res = jsonObject.getJSONObject("response_data");
                      //  String mes=res.getString("message");
                        String screen_view=res.getString("screen_view");
                        if (screen_view.equals("ms1")){
                            Intent cs1=new Intent(RegisterActivity.this,Login.class);
                            startActivity(cs1);

                        }

                    }else {
                        String error=  jsonObject.getString("error");
                        Toast.makeText(RegisterActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Log.d("RegisterResponse", error.toString());
                Toast.makeText(RegisterActivity.this, "Connection fail", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("first_name",fullname);
                params.put("email",email);
                params.put("guest_id",guest );
                params.put("password",password);
                params.put("login_by","manual");
                params.put("phone",phonenumber);
                params.put("device_type",os);
                params.put("device_token",dtoken);
                params.put("social_unique_id","");
                params.put("device_id",device_id);



                // params.put("device_token",ip);


               /* params.put("password", "");
                params.put("gender", "");*/
                return params;
            }
        };

     //   Trunks.retryPolicy(request);
        MyApplication.getInstance().addToRequestQueue(request);
       /* RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);*/
    }


    // MyApplication.getInstance(this).addToRequestQueue(stringRequest);

    public boolean isValidPhone(CharSequence phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(phone).matches();
        }
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            Log.e("", "display name: " + acct.getDisplayName());

            String personName = acct.getDisplayName();
         //   String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

         /*   Log.e("", "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);*/
            Intent intent = new Intent(RegisterActivity.this, PaymentActivity.class);
            startActivity(intent);

            /*txtName.setText(personName);
            txtEmail.setText(email);
            Glide.with(getApplicationContext()).load(personPhotoUrl)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfilePic);*/


        } else {
            // Signed out, show unauthenticated UI.
          //  Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("", "onConnectionFailed:" + connectionResult);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.sign_in_button:
                signIn();


                break;
        }


    }


    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d("", "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("loading");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    public void alertDialog(String title, String message) {
        final AlertDialog.Builder mBuiler = new AlertDialog.Builder(this);
        mBuiler.setMessage(message);
        mBuiler.setTitle(title);
        mBuiler.setCancelable(true);
        mBuiler.setPositiveButton("Forgot Password", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //forgotPassword();
            }
        }).show();

        mBuiler.setNegativeButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(RegisterActivity.this, Login.class);
                startActivity(i);
                finish();
                dialog.dismiss();
                //  overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            }
        }).show();
    }


    public boolean emailValidator(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }


    }



    public void register() {

        EditText fields[] = {userfullname, useremail, usernumber, userpassword};
        boolean canSave = true;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().toString().isEmpty()) {
                canSave = false;
                fields[i].setError("Please fill");
            }
        }
        if (userpassword.getText().toString().length() < 8) {
            canSave = false;
            userpassword.setError("Password must be minimum 8 digits");
        }
        if (canSave && emailValidator(useremail.getText().toString())) {
            String full_name = userfullname.getText().toString();
            try {
                full_name = URLEncoder.encode(full_name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }



        SharedPreferences sp = getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();



        Log.d("RegisterResponse", RegisterUrl);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Creating account");
        dialog.hide();
        dialog.setCancelable(false);

        final String email = useremail.getText().toString().trim();
        final String password = userpassword.getText().toString().trim();
        final String fullname = userfullname.getText().toString().trim();
        final String phonenumber = usernumber.getText().toString().trim();


        final StringRequest request1 = new StringRequest(Request.Method.POST, RegisterUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  Toast.makeText(RegisterActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getBoolean("success")==true){
                        //   String jsonObject1=jsonObject.getString("response_data");
                        Toast.makeText(RegisterActivity.this, "what", Toast.LENGTH_SHORT).show();
                        String message=jsonObject.getString("message");

                        Toast.makeText(RegisterActivity.this,message , Toast.LENGTH_LONG).show();
                        JSONObject res = jsonObject.getJSONObject("response_data");
                        //  String mes=res.getString("message");
                        String screen_view=res.getString("screen_view");
                        String cust_id=res.getString("cust_id");
                        editor.putString(Trunks.SHP_EMAIL,useremail.getText().toString());
                        editor.commit();
                        editor.putString("cust_id",cust_id);
                        editor.apply();

                        if (screen_view.equals("ms1")){
                            Intent cs1=new Intent(RegisterActivity.this,Login.class);
                            startActivity(cs1);

                        }

                    }else {
                        String error=  jsonObject.getString("error");
                        Toast.makeText(RegisterActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

              /*  Intent reg=new Intent(RegisterActivity.this,Login.class);
                startActivity(reg);
*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("first_name",fullname);
                params.put("email",email);
                params.put("guest_id",guest );
                params.put("password",password);
                params.put("login_by","manual");
                params.put("phone",phonenumber);
                params.put("device_type",os);
                params.put("device_token",dtoken);
                params.put("social_unique_id","");
                params.put("device_id",device_id);

                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request1);
    }
}
