package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class addTaskActivity extends AppCompatActivity {

    /**
      * title of the task
     */
    private EditText title;

    /**
     * priority of the task
     */
    private Spinner priority;

    /**
     * start date of the task
     */
    private CustomDatePicker dateStart;

    /**
     * end date of the task
     */
    private CustomDatePicker dateEnd;

    /**
     * progress of the task
     */
    private Spinner progress;

    /**
     * context of the task
     */
    private Spinner context;

    /**
     * description of the task
     */
    private EditText description;

    /**
     * url of the task
     */
    private EditText url;


    /**
     * Create the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        // Get the widgets
        title = (EditText) findViewById(R.id.addTitle);
        priority = (Spinner) findViewById(R.id.addPriority);
        List<String> optionsPrior = Arrays.asList("Low priority", "Medium priority", "High priority");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsPrior);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priority.setAdapter(adapter);
        priority.setSelection(0);

        // Get the date pickers
        EditText start = (EditText) findViewById(R.id.addStartDate);
        dateStart = new CustomDatePicker(this, start);
        EditText end = (EditText) findViewById(R.id.addEndDate);
        dateEnd = new CustomDatePicker(this, end);

        // Get the progress spinner
        progress = (Spinner) findViewById(R.id.addProgress);
        List<String> optionsProg = Arrays.asList("ToDo", "In progress", "Closed");
        ArrayAdapter<String> adapterProg = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsProg);
        adapterProg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        progress.setAdapter(adapterProg);
        progress.setSelection(0);

        // Get the context spinner
        context = (Spinner) findViewById(R.id.addContext);
        List<String> optionsCont = Arrays.asList("HomeWork", "Job", "Hobby", "Secondary", "Other");
        ArrayAdapter<String> adapterCont = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsCont);
        adapterCont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        context.setAdapter(adapterCont);
        context.setSelection(0);

        // Get the other widgets
        description = (EditText) findViewById(R.id.addDescription);
        url = (EditText) findViewById(R.id.addUrl);
        Button addTask = (Button) findViewById(R.id.buttonAdd);

        // Set the listener
        addTask.setOnClickListener(new View.OnClickListener() {
            /**
             * On click listener
             * @param v
             */
            @Override
            public void onClick(View v){
                finish(true);
            }
        });
    }
    /**
     * On back pressed
     */
    @Override
    public void onBackPressed() {
        finish(false);
    }

    /**
     * The method to finish the activity
     * @param addTask
     */
    public void finish(boolean addTask){
        if(!addTask){
            setResult(RESULT_CANCELED);
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("title", title.getText().toString());
            returnIntent.putExtra("priority", priority.getSelectedItem().toString());
            returnIntent.putExtra("start", dateStart.getFormattedDate());
            returnIntent.putExtra("end", dateEnd.getFormattedDate());
            returnIntent.putExtra("progress", progress.getSelectedItem().toString());
            returnIntent.putExtra("context", context.getSelectedItem().toString());
            returnIntent.putExtra("desc", description.getText().toString());
            returnIntent.putExtra("url", url.getText().toString());
            setResult(RESULT_OK, returnIntent);
        }
        super.finish();
    }
}
