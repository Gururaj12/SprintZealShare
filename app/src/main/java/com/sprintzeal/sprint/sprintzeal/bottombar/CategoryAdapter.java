package com.sprintzeal.sprint.sprintzeal.bottombar;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sprintzeal.sprint.sprintzeal.Listeners.RecycleListener;
import com.sprintzeal.sprint.sprintzeal.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<TestCategoryModel> categoryCourseBeanList;
    private List<ExampleCourseList> categoryCourseBeanList1;
    private RecycleListener clicklistener = null;
    Context context;
    private RecycleListener listener = null;
    View.OnClickListener onClickListener;
    ExampleCourseAdapter feedsAdapter;
    int size = 8;

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements View.OnClickListener {


        TextView TXT_Catwegory;
        RecyclerView courseList;

        public ViewHolder(View view) {
            super(view);
            this.courseList = (RecyclerView) view.findViewById(R.id.testrec);
            this.TXT_Catwegory = (TextView) view.findViewById(R.id.text);
        }

        public void onClick(View view) {
          /*  if (CategoryAdapter.this.clicklistener != null) {
                int adapterPosition = getAdapterPosition();
                CategoryAdapter.this.clicklistener.itemClicked("", String.valueOf(CategoryAdapter.this.categoryCourseBeanList.get(adapterPosition)), "", "", "", view, adapterPosition, 2);
            }*/
        }
    }

    public CategoryAdapter(Context context, List<TestCategoryModel> list, RecycleListener recycleListener) {
        this.context = context;
        this.listener = recycleListener;
        this.categoryCourseBeanList = list;
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_example_course_list, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.TXT_Catwegory.setText(((TestCategoryModel) this.categoryCourseBeanList.get(i)).getCatName());


//        viewHolder.TXT_Catwegory.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "fonts/Roboto-Regular.ttf"));

        viewHolder.courseList.setLayoutManager(new LinearLayoutManager(this.context, 0, false));

        this.feedsAdapter = new ExampleCourseAdapter(this.context, ((TestCategoryModel) this.categoryCourseBeanList.get(i)).getExampleCourseLists(), 0);
        viewHolder.courseList.setAdapter(this.feedsAdapter);
        this.feedsAdapter.notifyDataSetChanged();
        this.feedsAdapter.setClickListener(this.listener);
    }

    public void setClickListener(RecycleListener recycleListener) {
        this.clicklistener = recycleListener;
    }

    public int getItemCount() {
        this.categoryCourseBeanList.size();
        return this.categoryCourseBeanList.size();
    }
}
