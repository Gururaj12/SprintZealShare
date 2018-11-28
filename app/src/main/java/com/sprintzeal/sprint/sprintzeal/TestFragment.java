package com.sprintzeal.sprint.sprintzeal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sprintzeal.sprint.sprintzeal.bottombar.CategoryModel;

import java.util.List;

public class TestFragment extends RecyclerView.Adapter<TestFragment.ViewHolder> {
    private Context context;
    private List<CategoryModel> list;

    public TestFragment(List<CategoryModel> list,Context context) {
        this.context = context;
        this.list = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_course_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CategoryModel bean = list.get(position);
        holder.pName.setText(bean.getCatname());
        holder.pJobProfile.setText(bean.getCourseName());
        holder.trainer.setText(bean.getTrainername());

     /*   holder.pName.setText(cat.getCatName());
        holder.pJobProfile.setText(cat.getCourseName());

        Log.d("holderdata", cat.getCatName());
        Log.d("holderdata1", cat.getCourseName());*/
      /*  holder.itemView.setTag(personUtils.get(position));

        CategoryCourses pu = personUtils.get(position);
*/
     //   holder.pName.setText(pu.getCatName()+" "+pu.getCourseName());
       // holder.pJobProfile.setText(pu.getJobProfile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pName;
        public TextView pJobProfile;
        public TextView trainer;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.title2);
            pJobProfile = (TextView) itemView.findViewById(R.id.title);
            trainer = (TextView) itemView.findViewById(R.id.trainer);
            image = (ImageView) itemView.findViewById(R.id.imageview);


        }
    }

}