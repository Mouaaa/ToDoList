package com.example.todo;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class taskListActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> listTask = new ArrayList<Task>();
        Adapter adapter = new Adapter(this, listTask);
        ListView list = (ListView) findViewById(R.id.taskList);
        list.setAdapter(adapter);



    }

}
