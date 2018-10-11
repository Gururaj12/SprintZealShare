package com.sprintzeal.sprint.sprintzeal;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;
import android.widget.TextView;

public class GiftsFragment extends Fragment {
    SearchView searchView;
    TextView search_text;
    String[] fruits = {"Project Management", "Quality Management", "Digital Marketing", "Marketing Research", "Big Data", "PMP", "Six Sigma", "Java"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gift_fragment, container, false);
        search_text=view.findViewById(R.id.search_text);
        Typeface proximaRegular= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");

       // Typeface proximaRegular= Typeface.createFromAsset(getActivity().getAssets(), "fonts/proxima_nova_reg.ttf");
        search_text.setTypeface(proximaRegular);

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.select_dialog_item, fruits);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView)view. findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(8);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.BLACK);*/
        return view;
    }
}
