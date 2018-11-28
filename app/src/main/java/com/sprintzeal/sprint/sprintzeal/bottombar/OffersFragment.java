package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sprintzeal.sprint.sprintzeal.CategoryCourses;
import com.sprintzeal.sprint.sprintzeal.MovieAdapter;
import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class OffersFragment extends Fragment {
    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private List<CategoryCourses> movieList;

    private RecyclerView.Adapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        mList = view.findViewById(R.id.main_list);

        movieList = new ArrayList<>();
//        movieList.get(1);
    //    System.out.print(movieList.get(1));
     //   Log.d("array", String.valueOf(movieList.get(1)));


        adapter = new MovieAdapter(getActivity(),movieList);
        Log.d("ad", String.valueOf(adapter));

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        return view;
    }
}
