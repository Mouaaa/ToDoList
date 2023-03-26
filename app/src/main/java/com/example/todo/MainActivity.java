package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE = 1;
    ArrayList<Task> listTask;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the shared preference
        SharedPreferences preferences = getSharedPreferences("AgileZen", MODE_PRIVATE);

        // Get the json for the taskList
        String json = preferences.getString("taskList", null);

        // if the key hadn't been initialized
        if (json == null) {
            listTask = new ArrayList<Task>();
        } else {
            // Conversion of the json into an exploitable arraylist
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Task>>() {
            }.getType();
            listTask = gson.fromJson(json, type);
        }

        // Update the display list
        updateAdapter();

        Button addTask = (Button) findViewById(R.id.addButton);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), addTaskActivity.class);
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Task> selectedTasks = new ArrayList<Task>();
                for (int i = 0; i < listTask.size(); i++) {
                    if (listTask.get(i).isSelected()) {
                        selectedTasks.add(listTask.get(i));
                    }
                }
                listTask.removeAll(selectedTasks);
                updateAdapter();
                saveArrayList(listTask);
            }
        });

    }

    // Dans la méthode onActivityResult() que vous avez déjà, ajoutez le code suivant pour stocker l'ArrayList dans les SharedPreferences:
    private void saveArrayList(ArrayList<Task> listTask) {
        SharedPreferences preferences = getSharedPreferences("AgileZen", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listTask);
        editor.putString("taskList", json);
        editor.apply();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String title = data.getStringExtra("title");
            String priority = data.getStringExtra("priority");
            String start = data.getStringExtra("start");
            String end = data.getStringExtra("end");
            String progress = data.getStringExtra("progress");
            String context = data.getStringExtra("context");
            String desc = data.getStringExtra("desc");
            String url = data.getStringExtra("url");

            Task task = new Task(title, priority, start, end, progress, context, desc, url);
            listTask.add(task);
            updateAdapter();
            saveArrayList(listTask);
        } else {

        }
    }

    private void updateAdapter() {
        Adapter adapter = new Adapter(this, listTask);
        ListView list = (ListView) findViewById(R.id.taskList);
        list.setAdapter(adapter);
    }
}