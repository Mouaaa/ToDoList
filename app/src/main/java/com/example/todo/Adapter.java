package com.example.todo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Adapter extends BaseAdapter{

    /**
     * The Tasks list
     */
    private List<Task> tasks;

    /**
     * The courant context of the application
     */
    private Context context;

    /**
     * The inflater
     */
    private LayoutInflater inflater;

    /**
     * The constructor of Adapter
     * @param context the context of the application
     * @param list The list of Tasks
     */
    public Adapter(Context context, List<Task> list){
        this.context = context;
        tasks = list;
        inflater = LayoutInflater.from(context);
    }

    /**
     * Get the count of tasks
     * @return the size
     */
    @Override
    public int getCount() {
        return tasks.size();
    }

    /**
     * Get the an item at the index
     * @param i the index
     * @return the item
     */
    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    /**
     * Get the id of the item at the index
     * @param i the index
     * @return the id
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Get the view of the item at the index
     * @param i the index
     * @param convertView the view
     * @param viewGroup the view group
     * @return the view
     */
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;

        if (convertView == null){
            view = (View) inflater.inflate(R.layout.task_list_item, viewGroup, false);
        }else{
            view = (View) convertView;
        }

        //Initialisation of the views of the layout
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView progress = (TextView) view.findViewById(R.id.progress);
        EditText startDate = (EditText) view.findViewById(R.id.editStartDate);
        EditText endDate= (EditText) view.findViewById(R.id.editEndDate);

        //Modification of the views
        title.setText(tasks.get(i).getTitle());
        progress.setText(tasks.get(i).getState());
        startDate.setText(tasks.get(i).getStartDate());
        endDate.setText(tasks.get(i).getEndDate());

        // Set the policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        return view;
    }
}
