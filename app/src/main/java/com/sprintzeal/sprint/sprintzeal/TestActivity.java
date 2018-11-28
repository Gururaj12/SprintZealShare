package com.sprintzeal.sprint.sprintzeal;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sprintzeal.sprint.sprintzeal.bottombar.CourseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static android.media.MediaExtractor.MetricsConstants.FORMAT;

public class TestActivity extends AppCompatActivity implements NumberedAdapter.ItemClickListener {
    TextView questions,time,numquestion,swipeup;
    RadioGroup radioGroup;
     RadioButton radioButton;
    RadioButton r1,r2,r3,r4;
    public int counter;
    private int questioncounter;
    private int questioncounttotal;

    Button next,skip;
    private Questions mquestion=new Questions();
    private String manswer;
    private int score=0;
    private int wrong_score=0;
    private int skiped=0;
    private int questionlength=mquestion.mQuestions.length;
    Random r;
    Context context;
    NumberedAdapter adapter;



    private List<ModelMovie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;

  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        questions=findViewById(R.id.question);
        radioGroup=findViewById(R.id.radiogroup);
        r1=findViewById(R.id.ans1);
        r2=findViewById(R.id.ans2);
        r3=findViewById(R.id.ans3);
        r4=findViewById(R.id.ans4);
        next=findViewById(R.id.next);
        skip=findViewById(R.id.skip);
        time=findViewById(R.id.time);
        numquestion=findViewById(R.id.numquestion);
        swipeup=findViewById(R.id.swipe);
      //  swipe=findViewById(R.id.swipe);

      //  manageBlinkEffect();

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48","50","51","52","53","54","55","56","57","58","59","60"};

        Typeface railwayrethi2 = Typeface.createFromAsset(getAssets(), "fonts/proxima_nova_reg.ttf");


        Typeface raleRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface ralelight = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");

        questions.setTypeface(ralelight);
        time.setTypeface(railwayrethi2);
        numquestion.setTypeface(railwayrethi2);
        r1.setTypeface(ralelight);
        r2.setTypeface(ralelight);
        r3.setTypeface(ralelight);
        r4.setTypeface(ralelight);


        next.setTypeface(raleRegular);
        skip.setTypeface(raleRegular);
        swipeup.setTypeface(ralelight);





        r=new Random();
        updateQuestion(r.nextInt(questionlength));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new NumberedAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                time.setText(String.valueOf(counter));
                counter++;
            }
            public  void onFinish(){
                time.setText("FINISH!!");
            }
        }.start();


      /*  new CountDownTimer(50000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                time.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                time.setText("Time Over!");
            }
        }.start();*/
     //   numquestion.setText(movieList.size());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    next.setBackgroundColor(Color.CYAN);
//                v.startAnimation(buttonClick);
                int selectedId=radioGroup.getCheckedRadioButtonId();

                radioButton=(RadioButton)findViewById(selectedId);
                String a=radioButton.getText().toString();
                Toast.makeText(TestActivity.this, a, Toast.LENGTH_SHORT).show();
                if (a==manswer){
                    score++;


                    updateQuestion(r.nextInt(questionlength));
                }else {
                    wrong_score++;
                    updateQuestion(r.nextInt(questionlength));

                }

                Toast.makeText(TestActivity.this, "correct"+score+"wrong"+wrong_score+"skiped"+skiped, Toast.LENGTH_SHORT).show();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                skiped++;
                updateQuestion(r.nextInt(questionlength));
            }
        });
    }

    private void updateQuestion(int i) {
        questions.setText(mquestion.getquestions(i));
        r1.setText(mquestion.getchoice1(i));
        r2.setText(mquestion.getchoice2(i));
        r3.setText(mquestion.getchoice3(i));
        r4.setText(mquestion.getchoice4(i));
        manswer=mquestion.getanswer(i);

    }
    public void gameover(){
        AlertDialog.Builder builder=new AlertDialog.Builder(TestActivity.this);
      builder.setMessage("Test over your score"+score);
      builder.setCancelable(false);
      builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {

          }
      }).setNegativeButton("no", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {

          }
      });
    }



    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(TestActivity.this, "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position, Toast.LENGTH_SHORT).show();

        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
       // Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
    }
    public void alertmsg(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
//inflate view for alertdialog since we are using multiple views inside a viewgroup (root = Layout top-level) (linear, relative, framelayout etc..)
        View view = inflater.inflate(R.layout.my_alert_dialog,null);

     //   Button button1 = (Button) view.findViewById(R.id.button1); // etc.. for button2,3,4.
        Button reviewtest=view.findViewById(R.id.review);
        Button submittest=view.findViewById(R.id.submittest);

        reviewtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "Review test", Toast.LENGTH_SHORT).show();
            }
        });
        submittest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TestActivity.this, "Submit test", Toast.LENGTH_SHORT).show();

            }
        });
        alert.setView(view);
        alert.show();
    }
    @SuppressLint("WrongConstant")
    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(swipeup, "backgroundColor", Color.WHITE, Color.GRAY,
                Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

/*
    @Override
    public void onBackPressed() {
       alertmsg();
    }*/
}

