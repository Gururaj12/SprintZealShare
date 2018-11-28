package com.sprintzeal.sprint.sprintzeal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.sprintzeal.sprint.sprintzeal.Login.Login;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME="sprintzeal";
    private static final String SHARED_PREF_NAME1="sprintzealll";
    private static final String KEY_USEREMAIL = "keyemail";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_PHONENUMBER= "keynumber";
    private static final String KEY_ID = "keyid";



    public static final String Device_id = "device_id";
      public static final String Token_id = "token_id";
    public static final String Os_version = "os_version";
    public static final String Operationg_system = "operationg_system";
    public static final String Resolution = "resolution";
    public static final String Screen_details = "screen_details";
    public static final String Time_zone = "time_zone";
    public static final String App_verson = "app_verson";
    public static final String Model_type = "model_type";
    public static final String Manufacture_mode = "manufacture_mode";
    public static final String Ip_address = "ip_address";
    public static final String mycourse_id = "mycourse_id";


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

    public void getflashData(FlashModel flashModel){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Device_id,flashModel.getDevice_id());
        editor.putString(Token_id,flashModel.getToken_id());
        editor.putString(Os_version,flashModel.getOs_version());
        editor.putString(Operationg_system,flashModel.getOperating_system());
        editor.putString(Resolution,flashModel.getResolution());
        editor.putString(Screen_details,flashModel.getScreen_details());
        editor.putString(Time_zone,flashModel.getTime_zone());
        editor.putString(App_verson,flashModel.getApp_version());
        editor.putString(Model_type,flashModel.getModel_type());
        editor.putString(Manufacture_mode,flashModel.getManufacture_model());
        editor.putString(Ip_address,flashModel.getIp_address());

    }

    public void getresponsesplash(FlashResponeSpModel flashResponeSpModel){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();

    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USEREMAIL, null) != null;
    }

  /*  public UserModel getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserModel(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USEREMAIL, null),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_PHONENUMBER, null)
        );
    }*/
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Login.class));
    }



}
