package com.sprintzeal.sprint.sprintzeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GroupTraining extends AppCompatActivity {
    Spinner spinnertraining,spinnergroup,spinnercourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_training);
        spinnertraining=findViewById(R.id.spinnertraining);
        spinnergroup=findViewById(R.id.spinnergroup);

        spinnercourse=findViewById(R.id.spinnercourse);

        List group = new ArrayList();
        group.add("01");
        group.add("02");
        group.add("03");
        group.add("04");
        group.add("05");
        group.add("06");
        group.add("07");
        group.add("08");
        group.add("09");
        group.add("10");
        group.add("11");
        group.add("12");

        List training = new ArrayList();
        training.add("ClassRoom Training");
        training.add("Online Training");
        training.add("Live Virtual Training");

        List course = new ArrayList();
        course.add("PMP");
        course.add("Prince2");
        course.add("Six Sigma");
        course.add("Others");
        // Creating array adapter for spinner
        ArrayAdapter e_group = new ArrayAdapter(this, android.R.layout.simple_spinner_item, group);
        ArrayAdapter e_training= new ArrayAdapter(this, android.R.layout.simple_spinner_item, training);
    ArrayAdapter e_course = new ArrayAdapter(this, android.R.layout.simple_spinner_item, course);


        // Drop down style will be listview with radio button
        e_group.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        e_training.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
      e_course.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        // attaching data adapter to spinner
        spinnertraining.setAdapter(e_training);
        spinnergroup.setAdapter(e_group);
       spinnercourse.setAdapter(e_course);
    }
}
