package com.sprintzeal.sprint.sprintzeal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private Context context;
    private List<ChapterModel> list;



    public ChapterAdapter(List<ChapterModel> list,Context context) {
        this.context = context;
        this.list = list;
    }



    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_test, parent, false);
        ChapterAdapter.ViewHolder viewHolder = new ChapterAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChapterAdapter.ViewHolder holder, int position) {
        final ChapterModel bean = list.get(position);

        Log.d("getChapterId",bean.chapterId);
        Log.d("nzme",bean.getChapterName());
        holder.title.setText(bean.getChapterId());
        holder.desc.setText(bean.getChapterName());
        holder.title2.setText(bean.getChapterDesc());

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

        public TextView title;
        public TextView desc;
        public TextView title2;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            title2 = (TextView) itemView.findViewById(R.id.title2);
           // image = (ImageView) itemView.findViewById(R.id.imageview);


        }
    }
}
