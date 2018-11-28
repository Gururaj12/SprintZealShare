package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.Listeners.RecycleListener;
import com.sprintzeal.sprint.sprintzeal.R;

import java.util.List;

public class ExampleCourseAdapter extends RecyclerView.Adapter<ExampleCourseAdapter.ViewHolder> {

    private RecycleListener clicklistener = null;
    Context context;
    Context context1;
    private List<ExampleCourseList> courseBeans;
    int myList = -1;
    View.OnClickListener onClickListener;



    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements View.OnClickListener {
        RecyclerView courseList;
        ImageView imgCourse;
        TextView name1,name2,name3;

        public ViewHolder(View view) {
            super(view);
            this.name1=view.findViewById(R.id.title2);
            this.name2=view.findViewById(R.id.title);
          //  this.name3=view.findViewById(R.id.trainer);
          //  this.imgCourse = (ImageView) view.findViewById(C0371R.id.imgCourse);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
           /* if (ExampleCourseAdapter.this.clicklistener != null) {
                int adapterPosition = getAdapterPosition();
                ExampleCourseAdapter.this.clicklistener.itemClicked(((ExampleCourseAdapter) ExampleCourseAdapter.this.courseBeans.get(adapterPosition)).getChpCount(),
                        ((ExampleCourseAdapter) ExampleCourseAdapter.this.courseBeans.get(adapterPosition)).getCourseID(),
                        ((ExampleCourseAdapter) ExampleCourseAdapter.this.courseBeans.get(adapterPosition)).getChpCount(),
                        ((ExampleCourseAdapter) ExampleCourseAdapter.this.courseBeans.get(adapterPosition)).getCourseName(),
                        ((ExampleCourseAdapter) ExampleCourseAdapter.this.courseBeans.get(adapterPosition)).getDes(),
                        view, adapterPosition, ExampleCourseAdapter.this.myList);
            }*/
        }
    }

    public ExampleCourseAdapter(Context context, List<ExampleCourseList> list, int i) {
        this.myList = i;
        this.context = context;
        this.courseBeans = list;
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_course_list, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {


          String  count=courseBeans.get(i).getCourseId();
          Log.d("courseid",count);

        viewHolder.name1.setText(courseBeans.get(i).getCourseName());
//        viewHolder.name2.setText(courseBeans.get(i).getExampleTrainers().get(i).getTrainerName());
      //  viewHolder.name2.setText(courseBeans.get(i).getCourseId());

       // Glide.with(this.context).load(((CourseBean) this.courseBeans.get(i)).getImage()).placeholder(this.context.getResources().getDrawable(C0371R.drawable.background)).into(viewHolder.imgCourse);
    }

    public void setClickListener(RecycleListener recycleListener) {
        this.clicklistener = recycleListener;
    }

    public int getItemCount() {
        return this.courseBeans.size();
      //  return this.categoryCourseBeanList.size();
    }
}
