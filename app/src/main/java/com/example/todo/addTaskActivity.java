package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class addTaskActivity extends AppCompatActivity {
    EditText title;
    Spinner priority;
    EditText start;
    EditText end;
    Spinner progress;
    Spinner context;
    EditText description;
    EditText url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        title = (EditText) findViewById(R.id.addTitle);
        priority = (Spinner) findViewById(R.id.addPriority);
        List<String> optionsPrior = Arrays.asList("Low priority", "Medium priority", "High priority");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsPrior);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priority.setAdapter(adapter);
        priority.setSelection(0);

        start = (EditText) findViewById(R.id.addStartDate);
        end = (EditText) findViewById(R.id.addEndDate);
        progress = (Spinner) findViewById(R.id.addProgress);
        List<String> optionsProg = Arrays.asList("ToDo", "In progress", "Closed");
        ArrayAdapter<String> adapterProg = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsProg);
        adapterProg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        progress.setAdapter(adapterProg);
        progress.setSelection(0);

        context = (Spinner) findViewById(R.id.addContext);
        List<String> optionsCont = Arrays.asList("HomeWork", "Job", "Hobby", "Secondary", "Other");
        ArrayAdapter<String> adapterCont = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsCont);
        adapterCont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        context.setAdapter(adapterCont);
        context.setSelection(0);

        description = (EditText) findViewById(R.id.addDescription);
        url = (EditText) findViewById(R.id.addUrl);

        Button addTask = (Button) findViewById(R.id.buttonAdd);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    public void finish(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("title", title.getText().toString());
        returnIntent.putExtra("priority", priority.getSelectedItem().toString());
        returnIntent.putExtra("start", start.getText().toString());
        returnIntent.putExtra("end", end.getText().toString());
        returnIntent.putExtra("progress", progress.getSelectedItem().toString().toString());
        returnIntent.putExtra("context", context.getSelectedItem().toString().toString());
        returnIntent.putExtra("desc", description.getText().toString());
        returnIntent.putExtra("url", url.getText().toString());
        setResult(RESULT_OK, returnIntent);
        super.finish();
    }
}
