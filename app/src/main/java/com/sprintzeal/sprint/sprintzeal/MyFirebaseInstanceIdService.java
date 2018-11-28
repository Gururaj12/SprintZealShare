package com.sprintzeal.sprint.sprintzeal;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
   // public static final String Token_id = "token_id";

    SharedPreferences sharedpreferences;
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        sharedpreferences = getSharedPreferences(Trunks.SHP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();


        //now we will have the token
        String token = FirebaseInstanceId.getInstance().getToken();
        editor.putString(Trunks.Token_id,token);
        editor.commit();
        //for now we are displaying the token in the log
        //copy it as this method is called only when the new token is generated
        //and usually new token is only generated when the app is reinstalled or the data is cleared
        Log.d("MyRefreshedToken", token);
    }
}
