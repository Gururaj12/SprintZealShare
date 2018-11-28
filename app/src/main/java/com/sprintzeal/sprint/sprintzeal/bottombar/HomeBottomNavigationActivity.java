package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.sprintzeal.sprint.sprintzeal.Login.MyObjectMessage;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.Trunks;

public class HomeBottomNavigationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    TextView bounce;
    Animation animation;

    public static Activity mainActivity;

    //SharedPreference
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;
    public static String currentCourse = "";
    //--




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_bottom_navigation);
       /* Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("key_1");
        boolean b = bundle.getBoolean("key_2");*/




       // toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        toolbar=findViewById(R.id.toolbar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
      navigation.setSelectedItemId(R.id.navigation_shop);
       loadFragment(new CourseFragment());
      //  toolbar.setTitle("Shop");
        toolbar.setLogo(R.drawable.newlogo);
        bounce=findViewById(R.id.bounce);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);




        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
     /*   MyObjectMessage myObjectMessage=new MyObjectMessage();
        Toast.makeText(mainActivity, myObjectMessage.getName(), Toast.LENGTH_SHORT).show();*/
        //SharedPreference
        pref = getApplicationContext().getSharedPreferences(Trunks.SHP_NAME,MODE_PRIVATE);
        editor = pref.edit();
        //--
        editor.putString(Trunks.SHP_EMAIL,"gururajbijjaragi@gmail.com");
        editor.commit();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup_filters, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_group:
                Toast.makeText(this, "Welcome to Group Training", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(HomeBottomNavigationActivity.this,PrivacySetting.class);
                startActivity(intent);
                break;

            /*case R.id.menu_corporate:
                Toast.makeText(this, "Welcome to Group Corporate Training", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(HomeBottomNavigationActivity.this,CorporateTraining.class);
                startActivity(intent1);
                break;*/


        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    fragment=new MyCourseFragment();
                    loadFragment(fragment);

                /*    fragment = new CourseFragment();
                    loadFragment(fragment);*/
                    // toolbar.setTitle("Shop");
/*
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    CourseList courseList = new CourseList();
                    fragmentTransaction.replace(R.id.frame_container,courseList).addToBackStack("one").commit();
                    Toast.makeText(HomeBottomNavigationActivity.this, "store", Toast.LENGTH_SHORT).show();*/
                    return true;

               /* case R.id.navigation_demo:
                    // toolbar.setTitle("Shop");


                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    MyCources myCources = new MyCources();
                    fragmentTransaction1.replace(R.id.frame_container,myCources).commit();
                    return true;*/

                case R.id.navigation_gifts:
                  //  toolbar.setTitle("My Gifts");
                    fragment = new SearchFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_cart:
                  //  toolbar.setTitle("Cart");
                  /*  fragment = new CartFragment();
                    loadFragment(fragment);*/
                   /* PopupMenu popup = new PopupMenu(this, findViewById(R.id.navigation_cart));
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.mymenu, popup.getMenu());
                    popup.show();
                    showFilterPopup(this,getApplication() );*/
                    bounce.setVisibility(View.VISIBLE);
                    bounce.startAnimation(animation);
                    fragment = new CartFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_profile:
                  //  toolbar.setTitle("Profile");

                    fragment = new OffersFragment();
                    loadFragment(fragment);



                    return true;
                case R.id.navigation_more:
                    //  toolbar.setTitle("Profile");
                    fragment = new MoreFragment();
                    loadFragment(fragment);

                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showFilterPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        // Inflate the menu from xml
        popup.inflate(R.menu.popup_filters);
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_group:
                        Toast.makeText(HomeBottomNavigationActivity.this, "Keyword!", Toast.LENGTH_SHORT).show();

                        return true;
                    /*case R.id.menu_corporate:
                        Toast.makeText(HomeBottomNavigationActivity.this, "Popularity!", Toast.LENGTH_SHORT).show();
                        return true;*/
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }

}
