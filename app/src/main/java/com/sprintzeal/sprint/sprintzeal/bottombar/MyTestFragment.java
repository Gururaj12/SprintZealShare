package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;
import com.sprintzeal.sprint.sprintzeal.TestFragment;

import java.util.List;

public class MyTestFragment extends RecyclerView.Adapter<MyTestFragment.ViewHolder> {
    private Context context;
    private List<MyListModel> list;

    public MyTestFragment(List<MyListModel> list,Context context) {
        this.context = context;
        this.list = list;
    }



    @Override
    public MyTestFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_course_list, parent, false);
        MyTestFragment.ViewHolder viewHolder = new MyTestFragment.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyTestFragment.ViewHolder holder, int position) {
        final MyListModel bean = list.get(position);
        holder.pName.setText(bean.getMycatname());
        holder.pJobProfile.setText(bean.getMy_CourseName());
        holder.trainer.setText(bean.getMy_trainername());

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
