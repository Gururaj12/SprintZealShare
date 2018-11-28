package com.sprintzeal.sprint.sprintzeal.home;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.Trunks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Help extends AppCompatActivity {
    /*  TextView title, textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,
              textView10,textView11,textView12,textView13,textView14,textView15,textView16,title2,title3,title4,title5,title6,title7,title8,title9,title10,
              title11,title12,title13,title14,title15,title16;
      Toolbar toolbar;
  */
    LinearLayout box;
    //--

    //ResultValues
    View view;
    Bundle s;
    //--


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
      /*  toolbar=findViewById(R.id.tool);
        toolbar.setSubtitle("HELP AND SUPPORT");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        textView=findViewById(R.id.conte);
        textView2=findViewById(R.id.conte2);
        textView3=findViewById(R.id.conte3);
        textView4=findViewById(R.id.conte4);
        textView5=findViewById(R.id.conte5);
        textView6=findViewById(R.id.conte6);
        textView7=findViewById(R.id.conte7);
        textView8=findViewById(R.id.conte8);
        textView9=findViewById(R.id.conte9);
        textView10=findViewById(R.id.conte10);
        textView11=findViewById(R.id.conte11);
        textView12=findViewById(R.id.conte12);
        textView13=findViewById(R.id.conte13);
        textView14=findViewById(R.id.conte14);
        textView15=findViewById(R.id.conte15);
        textView16=findViewById(R.id.conte16);
        title=findViewById(R.id.title);
        title2=findViewById(R.id.title2);
        title4=findViewById(R.id.title4);
        title3=findViewById(R.id.title3);
        title5=findViewById(R.id.title5);
        title6=findViewById(R.id.title6);
        title7=findViewById(R.id.title7);
        title8=findViewById(R.id.title8);
        title9=findViewById(R.id.title9);
        title10=findViewById(R.id.title10);
        title11=findViewById(R.id.title11);
        title12=findViewById(R.id.title12);
        title13=findViewById(R.id.title13);
        title14=findViewById(R.id.title14);
        title15=findViewById(R.id.title15);
        title16=findViewById(R.id.title16);

        textView.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        textView7.setVisibility(View.GONE);
        textView8.setVisibility(View.GONE);
        textView9.setVisibility(View.GONE);
        textView10.setVisibility(View.GONE);
        textView11.setVisibility(View.GONE);
        textView12.setVisibility(View.GONE);
        textView13.setVisibility(View.GONE);
        textView14.setVisibility(View.GONE);
        textView15.setVisibility(View.GONE);
        textView16.setVisibility(View.GONE);

        title2.setOnClickListener(this);
        title3.setOnClickListener(this);
        title4.setOnClickListener(this);
        title5.setOnClickListener(this);
        title6.setOnClickListener(this);
        title7.setOnClickListener(this);
        title8.setOnClickListener(this);
        title9.setOnClickListener(this);
        title10.setOnClickListener(this);
        title11.setOnClickListener(this);
        title12.setOnClickListener(this);
        title13.setOnClickListener(this);
        title14.setOnClickListener(this);
        title15.setOnClickListener(this);
        title16.setOnClickListener(this);

        title.setOnClickListener(this);


*/
        box = (LinearLayout) findViewById(R.id.box);
        //--

        //Init
        loadQuestions();

    }


    /* @Override
     public void onClick(View v) {
         switch (v.getId()) {
             case R.id.title:
                 textView.setVisibility( textView.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title2:
                 textView2.setVisibility( textView2.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;

             case R.id.title3:
                 textView3.setVisibility( textView3.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title4:
                 textView4.setVisibility( textView4.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title5:
                 textView5.setVisibility( textView5.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title6:
                 textView6.setVisibility( textView6.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;

             case R.id.title7:
                 textView7.setVisibility( textView7.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title8:
                 textView8.setVisibility( textView8.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title9:
                 textView9.setVisibility( textView9.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title10:
                 textView10.setVisibility( textView10.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;

             case R.id.title11:
                 textView11.setVisibility( textView11.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title12:
                 textView12.setVisibility( textView12.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title13:
                 textView13.setVisibility( textView13.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title14:
                 textView14.setVisibility( textView14.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;

             case R.id.title15:
                 textView15.setVisibility( textView15.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;
             case R.id.title16:
                 textView16.setVisibility( textView16.isShown()
                         ? View.GONE
                         : View.VISIBLE );
                 break;



         }
     }*/
    public void loadQuestions() {

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait");
        dialog.show();
        dialog.setCancelable(false);
        StringRequest request = new StringRequest(Trunks.helpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 1; i < jsonArray.length(); i++) {

                        final View view = getLayoutInflater().inflate(R.layout.help_list_item, null);
                        //Components
                        final TextView count = (TextView) view.findViewById(R.id.number);
                        final TextView text = (TextView) view.findViewById(R.id.text);
                        final TextView answer = (TextView) view.findViewById(R.id.answer);
                        final ImageView icon = (ImageView) view.findViewById(R.id.icon);
                        final CardView card = (CardView) view.findViewById(R.id.card);
                        //--

                        JSONObject job = jsonArray.getJSONObject(i);
                        String question = job.getString("question");
                        question = question.replace("\t", "");
                        question = question.replace((i) + ")", "");

                        String ans = job.getString("answer");
                        //Result
                        answer.setText(ans);
                        count.setText((i) + "");
                        text.setText(question);
                        box.addView(view);
                        final boolean[] isOpen = {false};
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (isOpen[0]) {
                                    isOpen[0] = false;
                                    card.setVisibility(View.GONE);
                                    icon.setImageResource(R.drawable.right);
                                } else {
                                    isOpen[0] = true;
                                    card.setVisibility(View.VISIBLE);
                                    icon.setImageResource(R.drawable.bottom);
                                }
                            }
                        });
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
}
