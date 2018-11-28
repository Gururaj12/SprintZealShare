package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

import java.util.ArrayList;
import java.util.List;

public class LvcAdapter extends RecyclerView.Adapter<LvcAdapter.MyViewHolder> {
    private ArrayList<LvcModel> dataSet;
    private int selectedPosition = -1;



    public LvcAdapter(ArrayList<LvcModel> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lvc_card_data, viewGroup, false);

        Typeface typeface = Typeface.createFromAsset(viewGroup.getContext().getAssets(), "fonts/proxima_nova_reg.ttf");

        MyViewHolder myViewHolder=new MyViewHolder(view);
        myViewHolder.textViewName.setTypeface(typeface);
        myViewHolder.textViewVersion.setTypeface(typeface);

        return myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        TextView textViewName = myViewHolder.textViewName;
        TextView textViewVersion = myViewHolder.textViewVersion;
        ImageView imageView = myViewHolder.imageViewIcon;


    /*    if (selectedPosition == i) {
            myViewHolder.mlayout.setBackgroundColor(Color.WHITE);
        } else {
            myViewHolder.mlayout.setBackgroundColor(Color.DKGRAY);
        }
*/


        textViewName.setText(dataSet.get(i).getName());
        textViewVersion.setText(dataSet.get(i).getVersion());
        imageView.setImageResource(dataSet.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
     //   LinearLayout mlayout;
        private  SparseBooleanArray sSelectedItems;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textName);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        //    this.mlayout = (LinearLayout) itemView.findViewById(R.id.mlayout);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
          /*  if(sSelectedItems.get(getAdapterPosition(),false)){
                sSelectedItems.delete(getAdapterPosition());
                mlayout.setSelected(false);


            }else {
                sSelectedItems.put(getAdapterPosition(),true);
                mlayout.setSelected(true);
            }*/

          /*  selectedPosition = getAdapterPosition();
            notifyDataSetChanged();*/

        }
    }
}
