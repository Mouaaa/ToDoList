package com.example.todo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class CustomDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private EditText editText;
    private Calendar calendar;
    private Context context;

    public CustomDatePicker(Context context, EditText editText) {
        this.context = context;
        this.editText = editText;
        this.editText.setOnClickListener(this);
        calendar = Calendar.getInstance();
    }

    @Override
    public void onClick(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateEditText();
    }

    private void updateEditText() {
        String myFormat = "dd/MM/yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(myFormat);
        editText.setText(sdf.format(calendar.getTime()));
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
