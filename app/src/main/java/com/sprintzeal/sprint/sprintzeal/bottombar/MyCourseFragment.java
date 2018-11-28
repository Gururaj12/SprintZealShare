package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sprintzeal.sprint.sprintzeal.FullCourseFragment;
import com.sprintzeal.sprint.sprintzeal.Listeners.RecycleListener;
import com.sprintzeal.sprint.sprintzeal.Login.Login;
import com.sprintzeal.sprint.sprintzeal.MyApplication;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.RecyclerTouchListener;
import com.sprintzeal.sprint.sprintzeal.TestFragment;
import com.sprintzeal.sprint.sprintzeal.Trunks;
import com.sprintzeal.sprint.sprintzeal.home.HomePage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;
import static com.facebook.FacebookSdk.getApplicationContext;

public class MyCourseFragment extends Fragment implements RecycleListener {
    //Components
    LinearLayout box;
  private RecyclerView allCourseList;
    //--
  RecyclerView recyclerView, recyclerView1;
    ListView listView;
    //ResultValues
    View view;
    private ProgressBar progress;
    Bundle s;
    String email, device_id, os, guest, dtoken, os_version, operationg_system,
            resolution, screen_details, time_zone, app_verson, model_type, manufacture_mode,
            ip_address, login_token, cust_id,usercourse_id,trainer_id,cd;

    boolean isNew = true;
    private CatTestAdapter testAdapter;
    private TestFragment adapter;
    private MyTestFragment myadapter;
    private TrainerAdapter mAdapter;
    CategoryAdapter feedsAdapter;


    private List<CategoryModel> beanList = new ArrayList<>();
    private List<MyListModel> mybeanList = new ArrayList<>();
    private List<TrainerModel> trainerList = new ArrayList<>();

    //testingexample

    private List<TestCategoryModel> testCategoryModels=new ArrayList<>();
    private List<ExampleCourseList> exampleCourseLists=new ArrayList<>();
    private List<ExampleTrainer> exampleTrainers=new ArrayList<>();


    //--
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mycourse_fragment, container, false);
        allCourseList=view.findViewById(R.id.recyclerdata);

progress=view.findViewById(R.id.progress);
      /*  recyclerView = view.findViewById(R.id.recyclerdata);
        recyclerView1 = view.findViewById(R.id.myrecyclerdata);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView1.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext().getApplicationContext(), 3);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(view.getContext().getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView1.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        //    recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView1.setNestedScrollingEnabled(false);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
                final SharedPreferences.Editor editor = sp.edit();

                CategoryModel categoryModel=beanList.get(position);
                 usercourse_id=categoryModel.getCourseid();
                 trainer_id=categoryModel.getTrainerid();

                 Log.d("usercourse_id",usercourse_id);
                 Log.d("trainer_id",trainer_id);
                 editor.putString(Trunks.course_id,usercourse_id);
                 editor.putString(Trunks.trainer_id,trainer_id);
                 editor.apply();

                FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FullCourseFragment courseList = new FullCourseFragment();
                fragmentTransaction.replace(R.id.frame_container,courseList).addToBackStack("one").commit();
                //getrainer();
              //  alertdialogue();

            *//*    SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
                final SharedPreferences.Editor editor = sp.edit();

                editor.putString(Trunks.course_id,scourse_id);
                Log.d("scourse",scourse_id);
                editor.apply();*//*




                Toast.makeText(getActivity(), categoryModel.getCourseid(), Toast.LENGTH_SHORT).show();
             //   Toast.makeText(getActivity(), categoryModel.getTrainerid(), Toast.LENGTH_SHORT).show();





            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
*/
        box = (LinearLayout) view.findViewById(R.id.box);

        //Init
        retMyCources();
        democourse();
        //--


        return view;


    }
    private void recyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.feedsAdapter = new CategoryAdapter(getContext(), this.testCategoryModels, this);
        recyclerView.setAdapter(this.feedsAdapter);
        this.feedsAdapter.notifyDataSetChanged();
        this.feedsAdapter.setClickListener(this);
        feedsAdapter.setClickListener(this);
    }

    private void recyclerViewMyList(List<ExampleCourseList> list) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.myrecyclerdata);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        RecyclerView.Adapter courseAdapter = new ExampleCourseAdapter(getActivity(), list, 1);
        recyclerView.setAdapter(courseAdapter);
        courseAdapter.notifyDataSetChanged();
      //  courseAdapter.setClickListener(this);
    }
   /* private void recyclerView(RecyclerView recyclerView) {

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        this.testAdapter=new CatTestAdapter(testCategoryModels,getContext(),this);

     //   this.testAdapter = new CatTestAdapter(getContext(), this.categoryCourseBeanList, recyclerView);
        recyclerView.setAdapter(this.testAdapter);
        this.testAdapter.notifyDataSetChanged();
       // this.testAdapter.setClickListener(this);
    }*/
    public void add(TrainerModel mol){
        View view=getLayoutInflater().inflate(R.layout.trainer_selection,null);
        Button button=view.findViewById(R.id.trainername);
Log.d("train",mol.getTrainerNAme());

      //  final LinearLayout innerBox = (LinearLayout)view.findViewById(R.id.box);
//button.setText(model.getTrainerNAme());

//box.addView(view);

    }

    private void retMyCources() {
        SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        // guest = sp.getString("guest_id", null);
        dtoken = sp.getString("device_toke", null);
        os_version = sp.getString("os_version", null);
        operationg_system = sp.getString("operationg_system", null);
        resolution = sp.getString("resolution", null);
        screen_details = sp.getString("screen_details", null);
        time_zone = sp.getString("time_zone", null);
        app_verson = sp.getString("app_verson", null);
        model_type = sp.getString("model_type", null);
        manufacture_mode = sp.getString("manufacture_mode", null);
        ip_address = sp.getString("ip_address", null);
        login_token = sp.getString("login_token", null);
        cust_id = sp.getString("cust_id", null);
       // course_id = sp.getString("course_id", null);
/*
        final ProgressDialog dialog = new ProgressDialog(v.getContext());
        dialog.setTitle("Loading");
        dialog.setMessage("Getting My Courses..");
        dialog.setCancelable(false);
        dialog.show();*/
        final String MyCourseUrl = "http://lms.sprintzeal.com/lms_new/api/v1/CustmrHomeScr";
        final StringRequest request = new StringRequest(Request.Method.POST, MyCourseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.d("responsedata", response);

                try {


                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getBoolean("success") == true) {


                        JSONObject res = jsonObject.getJSONObject("response_data");
                        String device_token = res.getString("device_token");
                        String cust_id = res.getString("cust_id");
                        String login_token = res.getString("login_token");
                        String message = res.getString("message");
                        String screen_view = res.getString("screen_view");
                        String count = res.getString("cust_type");
                        Log.d("datacount", count);

                        JSONArray cat_course = (JSONArray) res.get("category_courses");


                        JSONArray my_cat_course = (JSONArray) res.get("my_category_courses");

                        for (int j = 0; j < my_cat_course.length(); j++) {
                            JSONObject json_message_my_cat = my_cat_course.getJSONObject(j);
                            String mycatname = json_message_my_cat.getString("catName");
                            String mycatid = json_message_my_cat.getString("catId");
                            Log.d("mycat", mycatname);
                            Log.d("mycatid", mycatid);

                            TestCategoryModel testCategoryModel=new TestCategoryModel();
                            testCategoryModel.setCatId(mycatid);
                            testCategoryModel.setCatName(mycatname);

                            JSONArray mycourse = (JSONArray) json_message_my_cat.get("courseList");
                            for (int k = 0; k < mycourse.length(); k++) {
                                JSONObject json_message_my = mycourse.getJSONObject(k);

                               ExampleCourseList exampleCourseList=new ExampleCourseList();

                                String my_CourseId = json_message_my.getString("courseId");
                                String my_CourseName = json_message_my.getString("courseName");
                                String my_CourseImg = json_message_my.getString("courseImgUrl");

                                exampleCourseList.setCourseId(my_CourseId);
                                exampleCourseList.setCourseName(my_CourseName);
                                exampleCourseList.setCourseImgUrl(my_CourseImg);
                               MyCourseFragment.this.exampleCourseLists.add(exampleCourseList);
                               testCategoryModel.setExampleCourseLists(exampleCourseLists);



                                Log.d("my_CourseName", my_CourseName);
                                Log.d("my_CourseId", my_CourseId);

                                JSONArray mytrainer = (JSONArray) json_message_my.get("courseTrainerz");
                                Log.d("trainer", String.valueOf(mytrainer));
                                for (int t= 0; t < mytrainer.length(); t++){
                                    JSONObject json_message_mytrainer = mytrainer.getJSONObject(t);

                                    String trainerid=json_message_mytrainer.getString("trainerId");
                                    String trainername=json_message_mytrainer.getString("trainerName");

                                    ExampleTrainer exampleTrainer=new ExampleTrainer();
                                    exampleTrainer.setTrainerId(trainerid);
                                    exampleTrainer.setTrainerName(trainername);
                                    MyCourseFragment.this. exampleTrainers.add(exampleTrainer);
                                    SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);

                                 /*   MyListModel myListModel = new MyListModel(mycatname, my_CourseName,my_CourseId,trainerid,trainername);
                                    mybeanList.add(myListModel);*/
                                }
                              /*  testCategoryModel.setExampleCourseLists(exampleCourseLists);
                                testCategoryModels.add(testCategoryModel);
                                recyclerView(allCourseList);*/

                             exampleCourseList.setExampleTrainers( MyCourseFragment.this.exampleTrainers);
                               //data12 MyCourseFragment.this. exampleCourseLists.add(exampleCourseList);





                            }


                            testCategoryModel.setExampleCourseLists(exampleCourseLists);


                         //data  testCategoryModels.add(testCategoryModel);
                           /* testAdapter=new CatTestAdapter(testCategoryModels,getContext());

                            recyclerView1.setAdapter(testAdapter);
                            testAdapter.notifyDataSetChanged();*/


                         /*   myadapter = new MyTestFragment(mybeanList, getContext());
                            recyclerView1.setAdapter(myadapter);
                            myadapter.notifyDataSetChanged();*/
                        }


                        recyclerViewMyList( MyCourseFragment.this.exampleCourseLists);


               /*         for (int i = 0; i < cat_course.length(); i++) {

                            JSONObject json_message = cat_course.getJSONObject(i);


                            String catname = json_message.getString("catName");
                            String catId = json_message.getString("catId");

                            TestCategoryModel testCategoryModel=new TestCategoryModel();
                            testCategoryModel.setCatId(catId);
                            testCategoryModel.setCatName(catname);
                            JSONArray d = (JSONArray) json_message.get("courseList");
                            for (int z = 0; z < d.length(); z++) {
                                ExampleCourseList exampleCourseList=new ExampleCourseList();
                                JSONObject json_message1 = d.getJSONObject(z);
                                String CourseId = json_message1.getString("courseId");
                                String CourseName = json_message1.getString("courseName");
                                String CourseImg = json_message1.getString("courseImgUrl");

                                exampleCourseList.setCourseId(CourseId);
                                exampleCourseList.setCourseName(CourseName);
                                exampleCourseList.setCourseImgUrl(CourseImg);
                          //data123      MyCourseFragment.this.  exampleCourseLists.add(exampleCourseList);

                                JSONArray category_trainer = (JSONArray) json_message1.get("courseTrainerz");

                                Log.d("cattrainer", String.valueOf(category_trainer));
                                for (int a= 0; a < category_trainer.length(); a++){
                                    JSONObject json_message_mytrainer = category_trainer.getJSONObject(a);

                                    String cattrainerid=json_message_mytrainer.getString("trainerId");
                                    String cattrainername=json_message_mytrainer.getString("trainerName");
                                    SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);

                                    ExampleTrainer exampleTrainer=new ExampleTrainer();
                                    exampleTrainer.setTrainerId(cattrainerid);
                                    exampleTrainer.setTrainerName(cattrainername);
                                  //  exampleTrainers.add(exampleTrainer);

                                  *//*  CategoryModel categoryModel = new CategoryModel(catname, CourseName,CourseId,cattrainerid,cattrainername);
                                    //  add(categoryModel);
                                    beanList.add(categoryModel);*//*
                                }
                                exampleCourseList.setExampleTrainers(exampleTrainers);
                                exampleCourseLists.add(exampleCourseList);


                            }
                            testCategoryModel.setExampleCourseLists(exampleCourseLists);


                               testCategoryModels.add(testCategoryModel);


                           *//* if (MyCourseFragment.this.testCategoryModels.size() == 0) {
                                MyCourseFragment.this.progress.setVisibility(View.GONE);
                                MyCourseFragment.this.allCourseList.setVisibility(View.VISIBLE);
                                return;
                            }
                            MyCourseFragment.this.progress.setVisibility(View.VISIBLE);
                            MyCourseFragment.this.allCourseList.setVisibility(View.GONE);*//*
                            recyclerView(MyCourseFragment.this.allCourseList);


                           *//* adapter = new TestFragment(beanList, getContext());

                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();*//*
                        }*/


                    } else {
                        String error = jsonObject.getString("error");
                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
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
                params.put("cust_id", cust_id);

                params.put("os_version", String.valueOf(os_version));
                params.put("operating_system", operationg_system);
                params.put("resolution", resolution);
                params.put("screen_detail", screen_details);
                params.put("time_zone", time_zone);
                params.put("app_version", app_verson);
                params.put("model_type", model_type);
                params.put("manufacture_type", manufacture_mode);
                params.put("manufacture_model", model_type);
                params.put("public_ip", ip_address);
                params.put("login_token", login_token);
                return params;

            }

        };
        MyApplication.getInstance().addToRequestQueue(request);
    }


    @Override
    public void itemClicked(String str, String str2, String str3, View view, int i, int i2) {
        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
/*
        if (i2 == 1) {
            str3 = "my";
        } else if (i2 == 0) {
            str3 = "demo";
        }*/
        Intent in= new Intent(getActivity(), HomePage.class);
        startActivity(in);
       /* i.putExtra(Trunks.COURSE_NAME, str4);
        i.putExtra("chapter_name", 1);
        i.putExtra(PayUmoneyConstants.WALLET_HISTORY_PARAM_LIMIT, 1);
        i.putExtra(Trunks.FROM, str3);
        i.putExtra(Trunks.COURSE_ID, str2);
        i.putExtra("des", str5);
        i.putExtra("cha_count", str);*/
       // startActivity(i);
        getActivity().finish();

    }
    /*@Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {

    }*/

    private void democourse() {
        SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        device_id = sp.getString("device_id", null);
        os = sp.getString("operationg_system", null);
        // guest = sp.getString("guest_id", null);
        dtoken = sp.getString("device_toke", null);
        os_version = sp.getString("os_version", null);
        operationg_system = sp.getString("operationg_system", null);
        resolution = sp.getString("resolution", null);
        screen_details = sp.getString("screen_details", null);
        time_zone = sp.getString("time_zone", null);
        app_verson = sp.getString("app_verson", null);
        model_type = sp.getString("model_type", null);
        manufacture_mode = sp.getString("manufacture_mode", null);
        ip_address = sp.getString("ip_address", null);
        login_token = sp.getString("login_token", null);
        cust_id = sp.getString("cust_id", null);
        // course_id = sp.getString("course_id", null);
/*
        final ProgressDialog dialog = new ProgressDialog(v.getContext());
        dialog.setTitle("Loading");
        dialog.setMessage("Getting My Courses..");
        dialog.setCancelable(false);
        dialog.show();*/
        final String MyCourseUrl = "http://lms.sprintzeal.com/lms_new/api/v1/CustmrHomeScr";
        final StringRequest request = new StringRequest(Request.Method.POST, MyCourseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.d("responsedata", response);

                try {


                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getBoolean("success") == true) {


                        JSONObject res = jsonObject.getJSONObject("response_data");
                        String device_token = res.getString("device_token");
                        String cust_id = res.getString("cust_id");
                        String login_token = res.getString("login_token");
                        String message = res.getString("message");
                        String screen_view = res.getString("screen_view");
                        String count = res.getString("cust_type");
                        Log.d("datacount", count);

                        JSONArray cat_course = (JSONArray) res.get("category_courses");


                        JSONArray my_cat_course = (JSONArray) res.get("my_category_courses");

                   /*     for (int j = 0; j < my_cat_course.length(); j++) {
                            JSONObject json_message_my_cat = my_cat_course.getJSONObject(j);
                            String mycatname = json_message_my_cat.getString("catName");
                            String mycatid = json_message_my_cat.getString("catId");
                            Log.d("mycat", mycatname);
                            Log.d("mycatid", mycatid);

                            TestCategoryModel testCategoryModel=new TestCategoryModel();
                            testCategoryModel.setCatId(mycatid);
                            testCategoryModel.setCatName(mycatname);

                            JSONArray mycourse = (JSONArray) json_message_my_cat.get("courseList");
                            for (int k = 0; k < mycourse.length(); k++) {
                                JSONObject json_message_my = mycourse.getJSONObject(k);

                                ExampleCourseList exampleCourseList=new ExampleCourseList();

                                String my_CourseId = json_message_my.getString("courseId");
                                String my_CourseName = json_message_my.getString("courseName");
                                String my_CourseImg = json_message_my.getString("courseImgUrl");

                                exampleCourseList.setCourseId(my_CourseId);
                                exampleCourseList.setCourseName(my_CourseName);
                                exampleCourseList.setCourseImgUrl(my_CourseImg);
                                MyCourseFragment.this.exampleCourseLists.add(exampleCourseList);
                                testCategoryModel.setExampleCourseLists(exampleCourseLists);



                                Log.d("my_CourseName", my_CourseName);
                                Log.d("my_CourseId", my_CourseId);

                                JSONArray mytrainer = (JSONArray) json_message_my.get("courseTrainerz");
                                Log.d("trainer", String.valueOf(mytrainer));
                                for (int t= 0; t < mytrainer.length(); t++){
                                    JSONObject json_message_mytrainer = mytrainer.getJSONObject(t);

                                    String trainerid=json_message_mytrainer.getString("trainerId");
                                    String trainername=json_message_mytrainer.getString("trainerName");

                                    ExampleTrainer exampleTrainer=new ExampleTrainer();
                                    exampleTrainer.setTrainerId(trainerid);
                                    exampleTrainer.setTrainerName(trainername);
                                    MyCourseFragment.this. exampleTrainers.add(exampleTrainer);
                                    SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);

                                 *//*   MyListModel myListModel = new MyListModel(mycatname, my_CourseName,my_CourseId,trainerid,trainername);
                                    mybeanList.add(myListModel);*//*
                                }
                              *//*  testCategoryModel.setExampleCourseLists(exampleCourseLists);
                                testCategoryModels.add(testCategoryModel);
                                recyclerView(allCourseList);*//*

                                exampleCourseList.setExampleTrainers( MyCourseFragment.this.exampleTrainers);
                                //data12 MyCourseFragment.this. exampleCourseLists.add(exampleCourseList);





                            }


                            testCategoryModel.setExampleCourseLists(exampleCourseLists);


                            //data  testCategoryModels.add(testCategoryModel);
                           *//* testAdapter=new CatTestAdapter(testCategoryModels,getContext());

                            recyclerView1.setAdapter(testAdapter);
                            testAdapter.notifyDataSetChanged();*//*


                         *//*   myadapter = new MyTestFragment(mybeanList, getContext());
                            recyclerView1.setAdapter(myadapter);
                            myadapter.notifyDataSetChanged();*//*
                        }


                        recyclerViewMyList( MyCourseFragment.this.exampleCourseLists);
*/

                        for (int i = 0; i < cat_course.length(); i++) {

                            JSONObject json_message = cat_course.getJSONObject(i);


                            String catname = json_message.getString("catName");
                            String catId = json_message.getString("catId");

                            TestCategoryModel testCategoryModel=new TestCategoryModel();
                            testCategoryModel.setCatId(catId);
                            testCategoryModel.setCatName(catname);
                            JSONArray d = (JSONArray) json_message.get("courseList");
                            for (int z = 0; z < d.length(); z++) {
                                ExampleCourseList exampleCourseList=new ExampleCourseList();
                                JSONObject json_message1 = d.getJSONObject(z);
                                String CourseId = json_message1.getString("courseId");
                                String CourseName = json_message1.getString("courseName");
                                String CourseImg = json_message1.getString("courseImgUrl");

                                exampleCourseList.setCourseId(CourseId);
                                exampleCourseList.setCourseName(CourseName);
                                exampleCourseList.setCourseImgUrl(CourseImg);
                          //data123      MyCourseFragment.this.  exampleCourseLists.add(exampleCourseList);

                                JSONArray category_trainer = (JSONArray) json_message1.get("courseTrainerz");

                                Log.d("cattrainer", String.valueOf(category_trainer));
                                for (int a= 0; a < category_trainer.length(); a++){
                                    JSONObject json_message_mytrainer = category_trainer.getJSONObject(a);

                                    String cattrainerid=json_message_mytrainer.getString("trainerId");
                                    String cattrainername=json_message_mytrainer.getString("trainerName");
                                    SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);

                                    ExampleTrainer exampleTrainer=new ExampleTrainer();
                                    exampleTrainer.setTrainerId(cattrainerid);
                                    exampleTrainer.setTrainerName(cattrainername);
                                  //  exampleTrainers.add(exampleTrainer);

                                   /* CategoryModel categoryModel = new CategoryModel(catname, CourseName,CourseId,cattrainerid,cattrainername);
                                    //  add(categoryModel);
                                    beanList.add(categoryModel);*/
                                }
                                exampleCourseList.setExampleTrainers(exampleTrainers);
                                exampleCourseLists.add(exampleCourseList);


                            }
                            testCategoryModel.setExampleCourseLists(exampleCourseLists);


                               testCategoryModels.add(testCategoryModel);


                     /*       if (MyCourseFragment.this.testCategoryModels.size() == 0) {
                                MyCourseFragment.this.progress.setVisibility(View.GONE);
                                MyCourseFragment.this.allCourseList.setVisibility(View.VISIBLE);
                                return;
                            }
                            MyCourseFragment.this.progress.setVisibility(View.VISIBLE);
                            MyCourseFragment.this.allCourseList.setVisibility(View.GONE);*/
                            recyclerView(MyCourseFragment.this.allCourseList);

/*
                            adapter = new TestFragment(beanList, getContext());

                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();*/
                        }


                    } else {
                        String error = jsonObject.getString("error");
                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
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
                params.put("cust_id", cust_id);

                params.put("os_version", String.valueOf(os_version));
                params.put("operating_system", operationg_system);
                params.put("resolution", resolution);
                params.put("screen_detail", screen_details);
                params.put("time_zone", time_zone);
                params.put("app_version", app_verson);
                params.put("model_type", model_type);
                params.put("manufacture_type", manufacture_mode);
                params.put("manufacture_model", model_type);
                params.put("public_ip", ip_address);
                params.put("login_token", login_token);
                return params;

            }

        };
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    public void getrainer() {

        SharedPreferences sp =getActivity(). getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
         cd = sp.getString("course_id", null);
        Log.d("cd",cd);
        final String MyTrainerUrl = "http://lms.sprintzeal.com/lms_new/api/v1/CrseTrainerz";

        final StringRequest request = new StringRequest(Request.Method.POST, MyTrainerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  Log.d("Url",LoginUrl);
                Log.d("dat", response);

                //    Toast.makeText(Login.this, response, Toast.LENGTH_LONG).show();
                try {

                    //  List<CategoryCourses> demoCourseBeans = new ArrayList<>();

                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("success") == true) {
                        //   String jsonObject1=jsonObject.getString("response_data");
                        JSONObject res = jsonObject.getJSONObject("response_data");
                        String login_token=res.getString("login_token");
                        String cust_id=res.getString("cust_id");
                        String cust_type=res.getString("cust_type");
                        String device_token=res.getString("device_token");
                        String login_token1=res.getString("login_token");
                        String message=res.getString("message");
                        String screen_view=res.getString("screen_view");
                        String version=res.getString("version");

                        JSONArray courses_trainerz = (JSONArray) res.get("courses_trainerz");

                        for (int t= 0; t < courses_trainerz.length(); t++) {
                            JSONObject json_messagetrainer= courses_trainerz.getJSONObject(t);
                            String trainerId = json_messagetrainer.getString("trainerId");
                            String trainerName = json_messagetrainer.getString("trainerName");

                            Log.d("trainerId",trainerId);
                            Log.d("trainerName",trainerName);

                           // SharedPreferences sp = getActivity().getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);

                            TrainerModel trainerModel = new TrainerModel(trainerName,trainerId);
                             // add(trainerModel);
                            trainerList.add(trainerModel);

                        }


                                // alertdialogue();

                    } else {
                        String error = jsonObject.getString("error");

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
                params.put("cust_id", cust_id);
                params.put("course_id", cd);
                params.put("login_token", login_token);
                Log.d("testid",usercourse_id);



                return params;
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);


    }

/*    public void alertdialogue(){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getActivity());

        LayoutInflater inflater = getLayoutInflater();

        // create view for add item in dialog

        View convertView = (View) inflater.inflate(R.layout.trainer_selection, null);
        alertDialog.setView(convertView);
        ListView lv = (ListView) convertView.findViewById(R.id.listdata);

        TrainerAdapter clad = new TrainerAdapter(getContext(), trainerList);
     //   lv.setAdapter( new TrainerAdapter(getContext(),trainerList));
       lv.setAdapter(clad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                Log.d("testing","helo");
            }
        });

        final AlertDialog alert = alertDialog.create();
alert.show();

*//*
        final Dialog dialog = new Dialog(getContext());

        View view = getLayoutInflater().inflate(R.layout.trainer_selection, null);

        ListView lv = (ListView) view.findViewById(R.id.listdata);
      //  lv.setOnItemClickListener((AdapterView.OnItemClickListener) getApplicationContext());

        // Change MyActivity.this and myListOfItems to your own values
        TrainerAdapter clad = new TrainerAdapter(getContext(), trainerList);


        lv.setAdapter(clad);
      //  clad.refreshEvents(trainerList);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {

                TrainerModel trainerModel=trainerList.get(position);
                //   Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), trainerModel.getTrainerNAme(), Toast.LENGTH_SHORT).show();
                Log.d("get",trainerModel.getTrainerNAme());
                Log.d("getdata","hello");

                *//**//*switch(position){
                    case 0:

                        Toast.makeText(getActivity(), "clicked 1", Toast.LENGTH_SHORT).show();
                        break;

                }*//**//*
            }
        });

        dialog.setContentView(view);

        dialog.show();*//*

       *//* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // TrainerModel trainerModel=trainerList.get(position);
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();


             //   Toast.makeText(getContext(),trainerModel.getTrainerNAme()+trainerModel.getTrainerId(), Toast.LENGTH_SHORT).show();
            }
        });*//*

//        dialog.setCanceledOnTouchOutside(true);



       *//* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trainerList.get(position); // here you will get the clicked item from
                //your imagelist and you can check by getting a title  by using this

                String title= trainerList.get(position).getTrainerNAme();
                Log.d("title",title);
                Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();

            }
        });*//*
    }*/


}
