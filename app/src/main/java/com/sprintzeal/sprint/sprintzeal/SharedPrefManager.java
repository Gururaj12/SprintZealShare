package com.sprintzeal.sprint.sprintzeal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.sprintzeal.sprint.sprintzeal.Login.Login;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME="sprintzeal";
    private static final String KEY_USEREMAIL = "keyemail";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_PHONENUMBER= "keynumber";
    private static final String KEY_ID = "keyid";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(UserModel user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_USEREMAIL, user.getEmail());
        editor.putString(KEY_USERNAME, user.getFullname());
        editor.putString(KEY_PHONENUMBER, user.getNumber());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USEREMAIL, null) != null;
    }

    public UserModel getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserModel(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USEREMAIL, null),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_PHONENUMBER, null)
        );
    }
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Login.class));
    }



}
