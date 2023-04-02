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

public class TaskDetailsActivity extends AppCompatActivity {

    /**
     * title of the task
     */
    private EditText title;

    /**
     * priority of the task
     */
    private EditText priority;

    /**
     * start date of the task
     */
    private EditText dateStart;

    /**
     * end date of the task
     */
    private EditText dateEnd;

    /**
     * progress of the task
     */
    private EditText progress;

    /**
     * context of the task
     */
    private EditText context;

    /**
     * description of the task
     */
    private EditText description;

    /**
     * url of the task
     */
    private EditText url;

    /**
     * request code
     */
    final int REQUEST_CODE = 1;


    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_details);

        Bundle bundle = getIntent().getExtras();
        title = (EditText) findViewById(R.id.detailTitle);
        title.setText(bundle.getString("title"));
        priority = (EditText) findViewById(R.id.detailPriority);
        priority.setText(bundle.getString("priority"));
        dateStart = (EditText) findViewById(R.id.detailStartDate);
        dateStart.setText(bundle.getString("start"));
        dateEnd = (EditText) findViewById(R.id.detailEndDate);
        dateEnd.setText(bundle.getString("end"));
        progress = (EditText) findViewById(R.id.detailProgress);
        progress.setText(bundle.getString("progress"));
        context = (EditText) findViewById(R.id.detailContext);
        context.setText(bundle.getString("context"));
        description = (EditText) findViewById(R.id.detailDescription);
        description.setText(bundle.getString("desc  "));
        url = (EditText) findViewById(R.id.detailUrl);
        url.setText(bundle.getString("url"));

        Button accessLink = (Button) findViewById(R.id.detailGoToLink);

        accessLink.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when the user clicks the button
             * @param v
             */
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(getApplicationContext(), WebActivity.class);
                myIntent.putExtra("url", url.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);            }
        });
    }

    /**
     * Called when the activity is about to be destroyed.
     */
    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * Called when the activity is about to be destroyed.
     */
    public void finish(){
        setResult(RESULT_CANCELED);
        super.finish();
    }
}
