package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.sprintzeal.sprint.sprintzeal.R;

import java.util.ArrayList;
import java.util.List;

public class TrainerAdapter  extends BaseAdapter {

    private List<TrainerModel> listData;

    private LayoutInflater layoutInflater;

    public TrainerAdapter(Context context, List<TrainerModel> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }
    public void refreshEvents(List<TrainerModel> events) {
        this.listData.clear();
        this.listData.addAll(events);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.trainer_activity_listview, null);
            holder = new ViewHolder();
            holder.unitView = (Button) convertView.findViewById(R.id.trainername);
          //  holder.quantityView = (TextView) convertView.findViewById(R.id.quantity);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.unitView.setText(listData.get(position).getTrainerNAme().toString());
        Log.d("nameoftrainer",listData.get(position).getTrainerNAme().toString());
    //    holder.quantityView.setText(listData.get(position).getUnit().toString());

        return convertView;
    }

    static class ViewHolder {
        Button unitView;
       // TextView quantityView;
    }

}