package com.sprintzeal.sprint.sprintzeal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
  //  private static ArrayList<ModelLvc> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

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

        simpleChronometer.start();


        return view;
    }


/*    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < LvcData.nameArray.length; i++) {
                if (selectedName.equals(LvcData.nameArray[i])) {
                    selectedItemId = LvcData.id_[i];
                }
            }
            removedItems.add(selectedItemId);
            data.remove(selectedItemPosition);
            adapter.notifyItemRemoved(selectedItemPosition);
        }*/

/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_item) {
            //check if any items to add
            if (removedItems.size() != 0) {
                addRemovedItemToList();
            } else {
                Toast.makeText(this, "Nothing to add", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
*/

  /*  private void addRemovedItemToList() {
        int addItemAtListPosition = 3;
        data.add(addItemAtListPosition, new ModelLvc(
                LvcData.nameArray[removedItems.get(0)],
                LvcData.versionArray[removedItems.get(0)],
                LvcData.id_[removedItems.get(0)],
                LvcData.drawableArray[removedItems.get(0)]
        ));
        adapter.notifyItemInserted(addItemAtListPosition);
        removedItems.remove(0);
    }*/
}



