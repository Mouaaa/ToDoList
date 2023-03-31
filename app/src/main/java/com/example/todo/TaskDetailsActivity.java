package com.example.todo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.R;
import com.example.todo.Task;

public class TaskDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);


        /*
        Task task = getIntent().getParcelableExtra("task");

        // Display the task details in the UI
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(task.getTitle());
        */
    }
}
