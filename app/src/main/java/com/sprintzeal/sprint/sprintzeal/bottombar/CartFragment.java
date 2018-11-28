package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.Toast;

import com.sprintzeal.sprint.sprintzeal.FullCourseFragment;
import com.sprintzeal.sprint.sprintzeal.Movie;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class CartFragment extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fab1,fab2;




    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<LvcModel> data;
    public int count=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_fragment, container, false);
    Chronometer simpleChronometer = (Chronometer) view.findViewById(R.id.simpleChronometer); // initiate a chronometer
        recyclerView=view.findViewById(R.id.rec);
        fab1=view.findViewById(R.id.fab);
        fab2=view.findViewById(R.id.fab2);
        Typeface railwayrethi2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/proxima_nova_reg.ttf");
       simpleChronometer.start();


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<LvcModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new LvcModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

  //      removedItems = new ArrayList<Integer>();

        adapter = new LvcAdapter(data);
        recyclerView.setAdapter(adapter);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareTextUrl();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(getActivity(), "likes"+count, Toast.LENGTH_SHORT).show();

            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
              //  Movie movie = movieList.get(position);

                FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LvcDetails lvclist = new LvcDetails();
                fragmentTransaction.replace(R.id.frame_container,lvclist).addToBackStack("one").commit();

              //  Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "PMP® EXAM PREP BOOT CAMP");
        share.putExtra(Intent.EXTRA_TEXT, "https://www.sprintzeal.com");

        startActivity(Intent.createChooser(share, "Share link!"));
    }




}



