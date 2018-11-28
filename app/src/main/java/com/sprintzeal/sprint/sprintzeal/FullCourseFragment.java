package com.sprintzeal.sprint.sprintzeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class FullCourseFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    View view;
    Bundle s;

    private List<ChapterModel> chapter = new ArrayList<>();
    private List<VideoModel> chaptervideo = new ArrayList<>();
    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> listvideo = new ArrayList<String>();
    //Components
    LinearLayout box;
    Spinner spinner;


    Button button;


    String device_token,device_id,device_type,cust_id,course_id,trainer_id;
    //--
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.full_course_list,container,false);

        box = (LinearLayout) view.findViewById(R.id.box);
        spinner=view.findViewById(R.id.chapter);
        button=view.findViewById(R.id.guide);
     //   recyclerView=view.findViewById(R.id.rec);
      //  Spinner chapter=v.findViewById(R.id.chapter);

        Typeface railwayrethin1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/proximanova-bold.otf");
        Typeface railwayrethi2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/proxima_nova_reg.ttf");


        Typeface raleRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Light.ttf");


        button.setTypeface(ralelight);
       /* recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/
      //  exam.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);
        getrainer();
        //init();
        return view;
    }



        public void getrainer(){

            SharedPreferences sp =getActivity(). getSharedPreferences(Trunks.SHP_NAME, MODE_PRIVATE);
            course_id = sp.getString(Trunks.course_id, null);
            trainer_id = sp.getString(Trunks.trainer_id, null);
            device_token = sp.getString(Trunks.device_toke, null);
            device_type = sp.getString(Trunks.DeviceType, null);
            device_id = sp.getString(Trunks.Device_id, null);
            cust_id = sp.getString(Trunks.cust_id, null);
            Log.d("courseid",course_id);
            Log.d("trainerid",trainer_id);
            Log.d("device_token",device_token);
            Log.d("device_type",device_type);
            Log.d("device_id",device_id);
            Log.d("cust_id",cust_id);
            final String MyTrainerUrl = "http://lms.sprintzeal.com/lms_new/api/v1/TrainerChapterz";

            final StringRequest request = new StringRequest(Request.Method.POST, MyTrainerUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //  Log.d("Url",LoginUrl);
                    Log.d("fulldata", response);

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
                            String courseimg=res.getString("courseImgURL");
                            String studyGuideURL=res.getString("studyGuideURL");
                            String access_type=res.getString("access_type");
                            Log.d("access_type",access_type);

                            JSONArray courses_trainerz = (JSONArray) res.get("courses_trainerz");

                            for (int t= 0; t < courses_trainerz.length(); t++) {
                                JSONObject json_messagetrainer= courses_trainerz.getJSONObject(t);
                               ChapterModel chapterModel=new ChapterModel();
                                String chapterid = json_messagetrainer.getString("chapterId");
                                String chapterName = json_messagetrainer.getString("chapterName");
                                Log.d("chapterName",chapterName);
                                Log.d("chapterid",chapterid);



                                String chapterDesc = json_messagetrainer.getString("chapterDesc");
                                chapterModel.setChapterId(chapterid);
                                chapterModel.setChapterName(chapterName);
                                chapterModel.setChapterDesc(chapterDesc);

                                Log.d("chapterid",chapterModel.getChapterId());
                                Log.d("chaptername",chapterModel.getChapterName());
                                Log.d("chapterdesc",chapterModel.getChapterDesc());
                              //  Log.d("chaptervideo",chapterModel.getVideo().get(0));
                             //   Log.d("chaptervideo", String.valueOf(chapterModel.getVideo()));
                                list.add(chapterModel.getChapterName());



                                JSONArray videovrl = (JSONArray) json_messagetrainer.get("chapterVideoURL");

                                for (int n=0;n<videovrl.length();n++)
                                {
                                    String result=videovrl.getString(n);
                                    listvideo.add(result);
                                    chapterModel.setVideo(listvideo);

                                }
                             /*   for (int v= 0; v < videovrl.length(); v++){

                                    VideoModel videoModel=new VideoModel();

                                    String video = (String) videovrl.get(v);
                                    Log.d("video",video);

                                    videoModel.setVid(video);
                                    Log.d("videoid",videoModel.getVid());
                                   chaptervideo.add(videoModel);




                                 //   listvideo.add(video);
*//*
                                    ChapterModel chapterModel=new ChapterModel(chapterid,chapterName,chapterDesc,list);
                                    chapter.add(chapterModel);*//*


                                }*/
                              //  chapterModel.setVideo(chaptervideo);
                              //  ChapterModel chapterModel1=new ChapterModel(chapterid,chapterName,chapterDesc,listvideo);
                                chapter.add(chapterModel);



                            }

                            for (int i = 0, size = chapter.size(); i < size; i++) {
                                addListItem(chapter.get(i));
                            }

                        /*    myadapter = new ChapterAdapter(chapter, getContext());
                            recyclerView.setAdapter(myadapter);
                            myadapter.notifyDataSetChanged();*/
                          //  myadapter=new ChapterAdapter(listvideo,getActivity())

                            spinner.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list));

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
                  params.put("device_token",device_token);
                  params.put("device_id",device_id);
                  params.put("device_type",device_type);
                  params.put("cust_id",cust_id);
                  params.put("course_id",course_id);
                  params.put("trainer_id",trainer_id);
                  return params;
                }
            };
            MyApplication.getInstance().addToRequestQueue(request);

    }

    public void init(){

        View v=getLayoutInflater().inflate(R.layout.full_course_list,null);
        TextView exceltraining,vp,tra,pdd;
        Button button;
        button=v.findViewById(R.id.guide);
       /* exceltraining=v.findViewById(R.id.exceltraining);
        vp=v.findViewById(R.id.vp);
        tra=v.findViewById(R.id.tra);
        pdd=v.findViewById(R.id.pdd);*/


       /* exceltraining.setTypeface(railwayrethi2);
        vp.setTypeface(railwayrethi2);
        tra.setTypeface(railwayrethi2);
        pdd.setTypeface(railwayrethi2);
        button.setTypeface(ralelight);*/
        Spinner chapter=v.findViewById(R.id.chapter);
        Spinner exam=v.findViewById(R.id.exam);


       /* exam.setOnItemSelectedListener(this);
        chapter.setOnItemSelectedListener(this);*/

      /*  list.add("Chapter");
        list.add("Chapter 1");
        list.add("Chapter 2");
        list.add("Chapter 3");
        list.add("Chapter 4");
        list.add("Chapter 5");
        list.add("Chapter 6");
        list.add("Chapter 7");
        list.add("Chapter 8");
        list.add("Chapter 9");
        list.add("Chapter 10");*/

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity(),R.layout.support_simple_spinner_dropdown_item,list );
        chapter.setAdapter(spinnerArrayAdapter);

        list1.add("Mock Test");
        list1.add("Mock Test 1");
        list1.add("Mock Test 2");
        list1.add("Mock Test 3");
        list1.add("Mock Test 4");
        list1.add("Mock Test 5");
        list1.add("Mock Test 6");
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                getActivity(),R.layout.support_simple_spinner_dropdown_item,list1 );
        exam.setAdapter(spinnerArrayAdapter1);
        /*chapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    Toast.makeText(getContext(), "Chapter clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
 /*    exam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent i = new Intent(getActivity(), TestDetailsActivity.class);
             startActivity(i);
         }
     });*/
 button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Toast.makeText(getActivity(), "Downloading", Toast.LENGTH_SHORT).show();
     }
 });

        box.addView(v);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




        Spinner spinner= (Spinner) parent;

        if(spinner.getId() == R.id.chapter)




        {
            if (parent.getItemAtPosition(position).toString()
                    .equals("Chapter 1")) {






            }
              else {

            }
            //do this


        }
        if(spinner.getId() == R.id.exam)
        {

            if (parent.getItemAtPosition(position).toString()
                    .equals("Mock Test")) {

            }
            else {
                Intent intent=new Intent(getActivity(),TestDetailsActivity.class);
                startActivity(intent);
            }
          /*  //do this
            Intent intent=new Intent(getActivity(),TestDetailsActivity.class);
            startActivity(intent);*/
          //  Toast.makeText(getActivity(), list1.get(position), Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(getActivity(), "please select", Toast.LENGTH_SHORT).show();

    }

    public void addListItem(final ChapterModel bean){

        Log.d("beandata",bean.getChapterName());

        View v=getLayoutInflater().inflate(R.layout.chapter_test,null);
        //   View v = getLayoutInflater(s).inflate(R.layout.course_list_item, null);
        TextView title = (TextView) v.findViewById(R.id.desc);
        TextView title1 = (TextView) v.findViewById(R.id.title);
        title.setText(bean.getChapterDesc());
        title1.setText(bean.getChapterId());
       /* title.setText(bean.getTitle());
        TextView chapter = (TextView) v.findViewById(R.id.chapters);
        chapter.setText(bean.getChapters() + " Chapters");
        TextView videos = (TextView) v.findViewById(R.id.videos);
        videos.setText(bean.getVideos() + " Videos");
        TextView studyGuides = (TextView) v.findViewById(R.id.study_guide);
        studyGuides.setText(bean.getStudyGuide() + " Study guide");*/
        box.addView(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
