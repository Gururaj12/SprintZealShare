package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.R;

import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

public class CatTestAdapter extends RecyclerView.Adapter<CatTestAdapter.ViewHolder> {
    private Context context;
    private List<TestCategoryModel> list;
    private RecyclerView.RecyclerListener listener = null;

    ExampleCourseAdapter exampleCourseAdapter;

    public CatTestAdapter(List<TestCategoryModel> list, Context context, RecyclerView.RecyclerListener recyclerListener) {
        this.context = context;
        this.list = list;
        this.listener=recyclerListener;
    }



    @Override
    public CatTestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example_course_list, parent, false);
        CatTestAdapter.ViewHolder viewHolder = new CatTestAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CatTestAdapter.ViewHolder holder, int position) {
        final TestCategoryModel bean = list.get(position);
        holder.pName.setText(bean.catName);
        Log.d("canteename",bean.getCatName());

       // viewHolder.courseList.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
    //    this.feedsAdapter = new CourseAdapter(this.context, ((CategoryCourseBean) this.categoryCourseBeanList.get(i)).getCourseBeans(), 0);
      //  viewHolder.courseList.setAdapter(this.feedsAdapter);
     /*   this.feedsAdapter.notifyDataSetChanged();
        this.feedsAdapter.setClickListener(this.listener);
*//*
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(this.context,0,false));
        exampleCourseAdapter=new ExampleCourseAdapter(list.get(position).getExampleCourseLists(),this.context,0);
        holder.recyclerView.setAdapter(exampleCourseAdapter);
        exampleCourseAdapter.notifyDataSetChanged();*/


    /*    holder.pName.setText(bean.getMycatname());
        holder.pJobProfile.setText(bean.getMy_CourseName());
        holder.trainer.setText(bean.getMy_trainername());
*/
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView pName;
        RecyclerView recyclerView;
      /*  public TextView pJobProfile;
        public TextView trainer;
        public ImageView image;*/

        public ViewHolder(View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.text);
            recyclerView=itemView.findViewById(R.id.testrec);
          /*  pJobProfile = (TextView) itemView.findViewById(R.id.title);
            trainer = (TextView) itemView.findViewById(R.id.trainer);
            image = (ImageView) itemView.findViewById(R.id.imageview);*/


        }

        @Override
        public void onClick(View v) {

        }
    }

}
