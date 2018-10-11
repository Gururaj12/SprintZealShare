package com.sprintzeal.sprint.sprintzeal.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
import com.sprintzeal.sprint.sprintzeal.HomeBottomNavigationActivity;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.SharedPrefManager;
import com.sprintzeal.sprint.sprintzeal.URLs;
import com.sprintzeal.sprint.sprintzeal.UserModel;
import com.squareup.picasso.Picasso;


import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.sprintzeal.sprint.sprintzeal.home.PaymentActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements    View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    TextView step1,step1account,step1signup,step1moresteps,step2,step2signup,videos,steptextaccess,steptexlap,steptextmonth,
            registername,registerpassword,registerfullname,registernumber,steptextcancel;
    Button con;
    EditText useremail,userpassword,usernumber,userfullname;
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


    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        step1=findViewById(R.id.step1);
        step1account=findViewById(R.id.step1account);
        con=findViewById(R.id.btnLogin);
        step2=findViewById(R.id.step2);
        step1signup=findViewById(R.id.step1signup);
        videos=findViewById(R.id.videos);
        steptextaccess=findViewById(R.id.steptextaccess);
        steptexlap=findViewById(R.id.steptexlap);
        steptextmonth=findViewById(R.id.steptextmonth);
        step2signup=findViewById(R.id.step2signup);
        registername=findViewById(R.id.registername);
        registernumber=findViewById(R.id.registernumber);
        registerfullname=findViewById(R.id.registerfullname);
        registerpassword=findViewById(R.id.registerpassword);
        check=findViewById(R.id.check);
        steptextcancel=findViewById(R.id.steptextcancel);

        step1signup=findViewById(R.id.step1signup);
        step1moresteps=findViewById(R.id.step1moresteps);

        useremail=findViewById(R.id.useremail);
        userpassword=findViewById(R.id.userpassword);
        usernumber=findViewById(R.id.usernumber);
        userfullname=findViewById(R.id.userfullname);

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



        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeBottomNavigationActivity.class));
            return;
        }
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
            getUserProfile(AccessToken.getCurrentAccessToken());
        }

        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        callbackManager = CallbackManager.Factory.create();

        Typeface railwayrethin1=Typeface.createFromAsset(getAssets(),"fonts/proximanova-bold.otf");
        Typeface railwayrethi2=Typeface.createFromAsset(getAssets(),"fonts/proxima_nova_reg.ttf");



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


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mAccessToken = loginResult.getAccessToken();
                getUserProfile(mAccessToken);

               /* boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
                Log.d("API123", loggedIn + " ??");*/
               // Toast.makeText(RegisterActivity.this, loginResult.getAccessToken().getUserId(), Toast.LENGTH_SHORT).show();
                // App code

                Intent intent=new Intent(RegisterActivity.this,PaymentActivity.class);
                startActivity(intent);
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
        Intent intent=new Intent(RegisterActivity.this, PaymentActivity.class);
        startActivity(intent);
    }
    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String email = object.getString("email");
                            String id = object.getString("id");
                            String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";

                            txtUsername.setText("First Name: " + first_name + "\nLast Name: " + last_name);
                            txtEmail.setText(email);
                            Picasso.with(RegisterActivity.this).load(image_url).into(imageView);

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
        callbackManager.onActivityResult(requestCode, resultCode,  data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void registeruser(){
        final String email=useremail.getText().toString().trim();
        final String password=userpassword.getText().toString().trim();
        final String fullname=userfullname.getText().toString().trim();
        final String phonenumber=usernumber.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            useremail.setError("Please enter your email");
            useremail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fullname)) {
            userfullname.setError("Please enter username");
            userfullname.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            useremail.setError("Enter a valid email");
            useremail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            userpassword.setError("Enter a password");
            userpassword.requestFocus();
            return;
        }

        /*if (android.util.Patterns.PHONE.matcher(phonenumber).matches()) {
            return true;
        }
        Toast.makeText(this,"Phone No is not valid", Toast.LENGTH_LONG).show();*/
        if(isValidPhone(phonenumber)){

            Toast.makeText(getApplicationContext(),"Phone number is valid",Toast.LENGTH_SHORT).show();
        }else {
            usernumber.setError("Enter a valid number");
            usernumber.requestFocus();

        //    Toast.makeText(getApplicationContext(),"Phone number is not valid",Toast.LENGTH_SHORT).show();

        }


        StringRequest request=new StringRequest(com.android.volley.Request.Method.POST, URLs.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("user");

                        //creating a new user object
                        UserModel user = new UserModel(
                                userJson.getInt(""),
                                userJson.getString(""),
                                userJson.getString(""),
                                userJson.getString("")
                        );

                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), HomeBottomNavigationActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
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
                params.put("username", email);
                params.put("email", password);
                params.put("password", fullname);
                params.put("gender", phonenumber);
                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
       // MyApplication.getInstance(this).addToRequestQueue(stringRequest);
    }
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
            String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

            Log.e("", "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);
            Intent intent=new Intent(RegisterActivity.this,PaymentActivity.class);
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


}
