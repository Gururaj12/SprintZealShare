package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sprintzeal.sprint.sprintzeal.DemoCourseBean;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.Trunks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseList extends Fragment{
    View view;
    Bundle s;
    //Components
    LinearLayout box;
    //--

    //ResultValues
    String email;

    //--
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.course_list, container, false);
        s = savedInstanceState;
        //Components
        box = (LinearLayout) view.findViewById(R.id.box);
        //--

        //ResultValues
        email = HomeBottomNavigationActivity.pref.getString(Trunks.SHP_EMAIL, "");
       // email ="dhannajaykumar61@gmail.com";
        //--

        //Init
        retCourseList();
        //--

        return view;
    }

    public void retCourseList() {
        final ProgressDialog dialog = new ProgressDialog(view.getContext());
        dialog.setTitle("Loading");
        dialog.setMessage("Getting Demo Courses..");
        dialog.setCancelable(false);
        dialog.show();

        String url = Trunks.demoCoursesUrl + "" + email;
        Toast.makeText(getContext(), url, Toast.LENGTH_SHORT).show();
        Log.d("DemoCoursesResponse", url);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Log.d("DemoCoursesResponse", response);
                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    JSONObject status = jsonArray.getJSONObject(0);

                    List<DemoCourseBean> demoCourseBeans = new ArrayList<>();
                    for (int i = 1; i < jsonArray.length(); i++) {
                        JSONObject job = jsonArray.getJSONObject(i);
                        DemoCourseBean bean = new DemoCourseBean(
                                job.getString("title"),
                                job.getString("chapters_count"),
                                job.getString("video_count"),
                                job.getString("study_guide_count"),
                                job.getString("categories_id"),
                                job.getString("course_id")
                        );
                        demoCourseBeans.add(bean);
                    }
                    Collections.sort(demoCourseBeans, new Comparator<DemoCourseBean>() {
                        @Override
                        public int compare(DemoCourseBean bean1, DemoCourseBean bean2) {
                            return bean1.getTitle().compareToIgnoreCase(bean2.getTitle());
                        }
                    });
                    for (int i = 0, size = demoCourseBeans.size(); i < size; i++) {
                        addListItem(demoCourseBeans.get(i));
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
                Log.d("DemoCoursesResponse", error.toString());
            }
        });

        Trunks.retryPolicy(request);
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        requestQueue.add(request);
    }

    public void addListItem(final DemoCourseBean bean) {
        View v=getLayoutInflater().inflate(R.layout.course_list_item,null);
      //   View v = getLayoutInflater(s).inflate(R.layout.course_list_item, null);
        TextView title = (TextView) v.findViewById(R.id.title);
        title.setText(bean.getTitle());
        TextView chapter = (TextView) v.findViewById(R.id.chapters);
        chapter.setText(bean.getChapters() + " Chapters");
        TextView videos = (TextView) v.findViewById(R.id.videos);
        videos.setText(bean.getVideos() + " Videos");
        TextView studyGuides = (TextView) v.findViewById(R.id.study_guide);
        studyGuides.setText(bean.getStudyGuide() + " Study guide");
        box.addView(v);

        studyGuides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
            /*    MainActivity.currentCourse = bean.getTitle();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DemoCourses demoCourses = new DemoCourses();
                fragmentTransaction.replace(R.id.content, demoCourses).addToBackStack("tag");
                fragmentTransaction.commit();

                MainActivity.editor.putString(Trunks.COURSE_ID, bean.getCourseId());
                MainActivity.editor.putString(Trunks.FROM, "demo");
                MainActivity.editor.putString(Trunks.COURSE_NAME, bean.getTitle());
                MainActivity.editor.putString(Trunks.CATEGORY_ID, bean.getCategoryId());
                MainActivity.editor.commit();*/
            }
        });
    }
}


