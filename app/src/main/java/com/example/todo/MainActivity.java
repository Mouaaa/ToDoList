package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The request code for the addTaskActivity
     */
    final int REQUEST_CODE = 1;

    /**
     * The list of tasks
     */
    ArrayList<Task> listTask;

    /**
     * The adapter for the list
     */
    Adapter adapter;

    /**
     * The list view
     */
    ListView list;

    /**
     * Create the main activity
     */
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

        // When the add button is clicked, go to the addTaskActivity
        addTask.setOnClickListener(new View.OnClickListener() {

            /**
             * When the add button is clicked, go to the addTaskActivity
             * @param v the view
             */
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), addTaskActivity.class);
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            /**
             * When the delete button is clicked, delete the selected tasks
             * @param v the view
             */
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

        //initiate the spinner for the priority filter
        Spinner filterPriority = (Spinner) findViewById(R.id.filterPriority);
        List<String> optionsFiltPrior = Arrays.asList( "", "Low priority", "Medium priority", "High priority");
        ArrayAdapter<String> adapterFiltPrior = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsFiltPrior);
        adapterFiltPrior.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterPriority.setAdapter(adapterFiltPrior);
        filterPriority.setSelection(0);

        //initiate the spinner for the progress filter
        Spinner filterProgress = (Spinner) findViewById(R.id.filterProgress);
        List<String> optionsFiltPro = Arrays.asList( "", "ToDo", "In progress", "Closed");
        ArrayAdapter<String> adapterFiltPro = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsFiltPro);
        adapterFiltPro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterProgress.setAdapter(adapterFiltPro);
        filterProgress.setSelection(0);


        list = (ListView) findViewById(R.id.taskList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * When a task is clicked, go to the taskDetailsActivity
             * @param parent the parent
             * @param view the view
             * @param position the position
             * @param id the id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), TaskDetailsActivity.class);
                intent.putExtra("title", task.getTitle());
                intent.putExtra("priority", task.getPriority());
                intent.putExtra("start", task.getStartDate());
                intent.putExtra("end", task.getEndDate());
                intent.putExtra("progress", task.getProgress());
                intent.putExtra("context", task.getContext());
                intent.putExtra("desc", task.getDescription());
                intent.putExtra("url", task.getUrl());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            /**
             * When a task is long clicked, go to the modifyTaskActivity
             * @param parent the parent
             * @param view the view
             * @param position the position
             * @param id the id
             * @return true
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ModifyTaskActivity.class);
                intent.putExtra("id", String.valueOf(position));
                intent.putExtra("title", task.getTitle());
                intent.putExtra("priority", task.getPriority());
                intent.putExtra("start", task.getStartDate());
                intent.putExtra("end", task.getEndDate());
                intent.putExtra("progress", task.getProgress());
                intent.putExtra("context", task.getContext());
                intent.putExtra("desc", task.getDescription());
                intent.putExtra("url", task.getUrl());
                startActivityForResult(intent, REQUEST_CODE);
                return false;
            }
        });
        initSearch();
        initPriorityFilter();
        initProgressFilter();
    }

    /**
     * Update the tasks
     */
    private void saveArrayList(ArrayList<Task> listTask) {
        SharedPreferences preferences = getSharedPreferences("AgileZen", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listTask);
        editor.putString("taskList", json);
        editor.apply();
    }

    /**
     * Update the display list
     */
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

            if(data.getStringExtra("id") != null) {
                int idTask = Integer.parseInt(data.getStringExtra("id"));
                Task task = listTask.get(idTask);
                task.setTitle(title);
                task.setPriority(priority);
                task.setStartDate(start);
                task.setEndDate(end);
                task.setProgress(progress);
                task.setContext(context);
                task.setDescription(desc);
                task.setUrl(url);
                updateAdapter();
            } else {
                Task task = new Task(title, priority, start, end, progress, context, desc, url);
                listTask.add(task);
            }
            updateAdapter();
            saveArrayList(listTask);
        } else {

        }
    }

    /**
     * Initiate the search
     */
    private void initSearch(){
        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /**
             * When the search is submitted
             * @param query the query
             * @return false
             */
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            /**
             * When the text is changed
             * @param s the text
             * @return true
             */
            @Override
            public boolean onQueryTextChange(String s) {
                    ArrayList<Task> listFound = new ArrayList<Task>();
                    for (Task task : listTask) {
                        if (task.getTitle().toLowerCase().contains(s.toLowerCase())) {
                            listFound.add(task);
                        }
                    }
                    Adapter adapter = new Adapter(getApplicationContext(), listFound);
                    list.setAdapter(adapter);
                    return true;
            }
        });
    }

    /**
     * Initiate the priority filter
     */
    private void initPriorityFilter(){
        Spinner filterPriority = (Spinner) findViewById(R.id.filterPriority);
        filterPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * When an item is selected
             * @param parent the parent
             * @param view the view
             * @param position the position
             * @param id the id
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String priority = parent.getItemAtPosition(position).toString();
                ArrayList<Task> listFound = new ArrayList<Task>();
                for (Task task : listTask) {
                    if (task.getPriority().toLowerCase().contains(priority.toLowerCase() ) || priority.toLowerCase() == "") {
                        listFound.add(task);
                    }
                }
                Adapter adapter = new Adapter(getApplicationContext(), listFound);
                list.setAdapter(adapter);
            }

            /**
             * When nothing is selected
             * @param parent the parent
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Initiate the progress filter
     */
    private void initProgressFilter(){
        Spinner filterProgress = (Spinner) findViewById(R.id.filterProgress);
        filterProgress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * When an item is selected
             * @param parent the parent
             * @param view the view
             * @param position the position
             * @param id the id
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String progress = parent.getItemAtPosition(position).toString();
                ArrayList<Task> listFound = new ArrayList<Task>();
                for (Task task : listTask) {
                    if (task.getProgress().toLowerCase().contains(progress.toLowerCase()) ||  progress.toLowerCase()== "") {
                        listFound.add(task);
                    }
                }
                Adapter adapter = new Adapter(getApplicationContext(), listFound);
                list.setAdapter(adapter);
            }

            /**
             * When nothing is selected
             * @param parent the parent
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * Update the adapter
     */
    private void updateAdapter() {
        Adapter adapter = new Adapter(this, listTask);
        ListView list = (ListView) findViewById(R.id.taskList);
        list.setAdapter(adapter);
    }
}