package com.example.todo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class CustomDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    /**
     * The EditText to display the date
     */
    private EditText editText;

    /**
     * The calendar
     */
    private Calendar calendar;

    /**
     * The context
     */
    private Context context;

    /**
     * The constructor
     * @param context the context
     * @param editText the EditText
     */
    public CustomDatePicker(Context context, EditText editText) {
        this.context = context;
        this.editText = editText;
        this.editText.setOnClickListener(this);
        calendar = Calendar.getInstance();
    }

    /**
     * onClick, show the DatePickerDialog
     * @param v the view
     */
    @Override
    public void onClick(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    /**
     * When the date is set, update the EditText
     * @param view the view
     * @param year the year
     * @param month the month
     * @param dayOfMonth the day of the month
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateEditText();
    }

    /**
     * Update the EditText
     */
    private void updateEditText() {
        String myFormat = "dd/MM/yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(myFormat);
        editText.setText(sdf.format(calendar.getTime()));
    }

    /**
     * Get the calendar
     * @return the calendar
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * Get the formatted date
     * @return the formatted date
     */
    public String getFormattedDate(){
        String myFormat = "dd/MM/yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(myFormat);
        return sdf.format(calendar.getTime());
    }
}
