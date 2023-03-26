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
    EditText titre;
    Spinner priority;
    EditText start;
    EditText end;
    Spinner avancement;
    EditText description;
    EditText url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        titre = (EditText) findViewById(R.id.titre);
        priority = (Spinner) findViewById(R.id.priority);
        List<String> optionsPrior = Arrays.asList("Low priority", "Medium priority", "High priority");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsPrior);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priority.setAdapter(adapter);
        priority.setSelection(0);

        start = (EditText) findViewById(R.id.start);
        end = (EditText) findViewById(R.id.end);
        avancement = (Spinner) findViewById(R.id.avancement);
        List<String> optionsProg = Arrays.asList("ToDo", "In progress", "Closed");
        ArrayAdapter<String> adapterProg = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsProg);
        adapterProg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        avancement.setAdapter(adapterProg);
        avancement.setSelection(0);

        description = (EditText) findViewById(R.id.description);
        url = (EditText) findViewById(R.id.url);

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
        returnIntent.putExtra("titre", titre.getText().toString());
        returnIntent.putExtra("priority", priority.getSelectedItem().toString());
        returnIntent.putExtra("start", start.getText().toString());
        returnIntent.putExtra("end", end.getText().toString());
        returnIntent.putExtra("avancement", avancement.getSelectedItem().toString().toString());
        returnIntent.putExtra("desc", description.getText().toString());
        returnIntent.putExtra("url", url.getText().toString());
        setResult(RESULT_OK, returnIntent);
        super.finish();
    }
}
