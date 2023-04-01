package com.example.todo;

import static java.lang.Integer.parseInt;

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

public class ModifyTaskActivity extends AppCompatActivity {
    private int id;
    private EditText title;
    private Spinner priority;
    private CustomDatePicker dateStart;
    private CustomDatePicker dateEnd;
    private Spinner progress;
    private Spinner context;
    private EditText description;
    private EditText url;
    final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_task);

        Bundle bundle = getIntent().getExtras();
        id = parseInt(bundle.getString("id"));
        title = (EditText) findViewById(R.id.modifyTitle);
        title.setText(bundle.getString("title"));
        priority = (Spinner) findViewById(R.id.modifyPriority);
        List<String> optionsPrior = Arrays.asList("Low priority", "Medium priority", "High priority");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsPrior);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priority.setAdapter(adapter);
        int posPrio = -1;
        for(String elem:optionsPrior){
            if(elem.equals(bundle.getString("priority"))){
                posPrio = optionsPrior.indexOf(elem);
            }
        }
        if(posPrio != -1){
            priority.setSelection(posPrio);
        } else {
            priority.setSelection(0);
        }

        EditText start = (EditText) findViewById(R.id.modifyStartDate);
        start.setText(bundle.getString("start"));
        dateStart = new CustomDatePicker(this, start);

        EditText end = (EditText) findViewById(R.id.modifyEndDate);
        end.setText(bundle.getString("end"));
        dateEnd = new CustomDatePicker(this, end);


        progress = (Spinner) findViewById(R.id.modifyProgress);
        List<String> optionsProg = Arrays.asList("ToDo", "In progress", "Closed");
        ArrayAdapter<String> adapterProg = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsProg);
        adapterProg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        progress.setAdapter(adapterProg);
        int posProg = -1;
        for(String elem:optionsProg){
            if(elem.equals(bundle.getString("progress"))){
                posProg = optionsProg.indexOf(elem);
            }
        }
        if(posProg != -1){
            priority.setSelection(posProg);
        } else {
            priority.setSelection(0);
        }

        context = (Spinner) findViewById(R.id.modifyContext);
        List<String> optionsCont = Arrays.asList("HomeWork", "Job", "Hobby", "Secondary", "Other");
        ArrayAdapter<String> adapterCont = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsCont);
        adapterCont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        context.setAdapter(adapterCont);
        context.setSelection(0);
        int posCont = -1;
        for(String elem:optionsCont){
            if(elem.equals(bundle.getString("context"))){
                posCont = optionsCont.indexOf(elem);
            }
        }
        if(posCont != -1){
            priority.setSelection(posCont);
        } else {
            priority.setSelection(0);
        }
        description = (EditText) findViewById(R.id.modifyDescription);
        description.setText(bundle.getString("desc  "));
        url = (EditText) findViewById(R.id.modifyUrl);
        url.setText(bundle.getString("url"));

        Button accessLink = (Button) findViewById(R.id.modifyGoToLink);
        accessLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(getApplicationContext(), WebActivity.class);
                myIntent.putExtra("url", url.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);            }
        });

        Button addTask = (Button) findViewById(R.id.modifySaveChanges);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish(true);
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish(false);
    }


    public void finish(boolean changeTask){
        if(!changeTask){
            setResult(RESULT_CANCELED);
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("id", String.valueOf(id));
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
