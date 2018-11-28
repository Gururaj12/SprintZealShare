package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sprintzeal.sprint.sprintzeal.MyCourseBean;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.Trunks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyCources extends Fragment {
    //Components
    LinearLayout box;
    //--

    //ResultValues
    View v;
    Bundle s;
    String email;
    boolean isNew = true;
    //--

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mycourses,container,false);
        s = savedInstanceState;
        //Components
        box = (LinearLayout)v.findViewById(R.id.box);
        //--

        //ResultValues
        email = HomeBottomNavigationActivity.pref.getString(Trunks.SHP_EMAIL,"");
        //--

        //Init
        retMyCources();
        //--

        return v;
    }

    public void addMyCourses(final MyCourseBean bean){
        View view = getLayoutInflater().inflate(R.layout.home_cource_list,null);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView subTitle = (TextView)view.findViewById(R.id.subtitle);
        TextView remainingDays = (TextView)view.findViewById(R.id.remaining_date);
        TextView chapters = (TextView)view.findViewById(R.id.chapters);
        TextView study_guide = (TextView)view.findViewById(R.id.study_guide);
        TextView videos = (TextView)view.findViewById(R.id.videos);
 //       DonutProgress progress = (DonutProgress)view.findViewById(R.id.donut_progress);
        final LinearLayout innerBox = (LinearLayout)view.findViewById(R.id.box);

        title.setText(bean.getTitle());
        subTitle.setText(bean.getSubTitle());
   //     progress.setProgress(Float.parseFloat(bean.getProgress()+".00"));
        remainingDays.setText(bean.getRemainingDays());
        chapters.setText(bean.getChapters());
        study_guide.setText(bean.getStudyGuide()+" Study Guides");
        videos.setText(bean.getVideos()+" Videos");

        box.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshClick();
               /* innerBox.setBackgroundResource(R.drawable.course_list_clicked);
                MainActivity.currentCourse = bean.getSubTitle();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DemoCourses demoCourses = new DemoCourses();
                fragmentTransaction.replace(R.id.content,demoCourses).addToBackStack("tag");
                fragmentTransaction.commit();

                MainActivity.editor.putString(Trunks.COURSE_ID,bean.getCourseId());
                MainActivity.editor.putString(Trunks.FROM,"my");
                MainActivity.editor.putString(Trunks.CATEGORY_ID,bean.getCategoryId());
                MainActivity.editor.commit();*/
            }
        });
    }

    public void retMyCources(){
        final ProgressDialog dialog = new ProgressDialog(v.getContext());
        dialog.setTitle("Loading");
        dialog.setMessage("Getting My Courses..");
        dialog.setCancelable(false);
        dialog.show();

        String url = Trunks.myCoursesUrl+""+email;
        Log.d("MyCoursesResponse",url);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Log.d("MyCoursesResponse",response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject job = jsonArray.getJSONObject(i);
                        MyCourseBean bean = new MyCourseBean(
                                job.getString("course").replace("&reg;"," "),
                                job.getString("title").replace("&reg;"," "),
                                "",
                                job.getString("chapters_count")+" Chapters",
                                job.getString("study_guide_count"),
                                job.getString("video_count"),
                                job.getString("course_progress"),
                                job.getString("categories_id"),
                                job.getString("course_id")
                        );
                        Log.d("ProgressValue",job.getString("course_progress"));
                        addMyCourses(bean);
                    }
                } catch (JSONException e) {
                    dialog.dismiss();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Log.d("MyCoursesResponse",error.toString());
            }
        });

        Trunks.retryPolicy(request);
        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.add(request);
    }

    public void refreshClick(){
        for (int i=0;i<box.getChildCount();i++){
            View view = box.getChildAt(i);
            LinearLayout box = (LinearLayout)view.findViewById(R.id.box);
            box.setBackgroundResource(R.drawable.cource_list);
        }
    }
}
