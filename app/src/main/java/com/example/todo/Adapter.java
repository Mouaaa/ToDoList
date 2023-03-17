package com.example.todo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
     * he inflater
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
     * @return
     */
    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    /**
     * @param i
     * @return the item
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * @param i
     * @param convertView
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;

        if (convertView == null){
            view = (View) inflater.inflate(R.layout.task_list_item, viewGroup, false);
        }else{
            view = (View) convertView;
        }

        //initialisation des vues du layout
        /*
        TextView titleMovie = (TextView) view.findViewById(R.id.TitletextView);
        TextView directorMovie = (TextView) view.findViewById(R.id.DirectortextView);
        TextView movieDuration = (TextView) view.findViewById(R.id.DureetextView);
        ImageView posterMovie = (ImageView) view.findViewById(R.id.AfficheimageView);

         */

        //modification des vues
        titleMovie.setText(cinemaList.get(i).getMovieTitle());
        directorMovie.setText(cinemaList.get(i).getRealisateurName());
        movieDuration.setText(cinemaList.get(i).getFilmDuration());

        //modification de l'image
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            InputStream in = new java.net.URL(cinemaList.get(i).getImagePath()).openStream();
            Bitmap map = BitmapFactory.decodeStream(in);
            posterMovie.setImageBitmap(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
}
