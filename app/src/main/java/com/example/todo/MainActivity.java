package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE=1;
    ArrayList<Task> listTask;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTask = new ArrayList<Task>();
        updateAdapter();

        Button addTask = (Button) findViewById(R.id.addButton);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(getApplicationContext(), addTaskActivity.class);
                startActivityForResult(myIntent, REQUEST_CODE);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            String title = data.getStringExtra("titre");
            String priority = data.getStringExtra("priority");
            String start = data.getStringExtra("start");
            String end = data.getStringExtra("end");
            String avancement = data.getStringExtra("avancement");
            String desc = data.getStringExtra("desc");
            String url = data.getStringExtra("url");

            Task task = new Task(title,priority,start,end,avancement,desc,url);
            listTask.add(task);
            updateAdapter();
        } else {

        }
    }

    private void updateAdapter(){
        Adapter adapter = new Adapter(this, listTask);
        ListView list = (ListView) findViewById(R.id.taskList);
        list.setAdapter(adapter);
    }
}