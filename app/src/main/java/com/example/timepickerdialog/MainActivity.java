package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edtTimepicker);
        editText.requestFocus();
        editText.setOnClickListener(v -> {
            openTimepickerDialog();
        });
    }

    private void openTimepickerDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
                String hour = "" + hourOfDay;
                String minute = "" + minuteOfHour;

                if (hourOfDay < 10) {
                    hour = "0" + hour;
                }
                if (minuteOfHour < 10) {
                    minute = "0" + minute;
                }
                String time = hour + ":" + minute;
                editText.setText(time);
            }
        }, hour, minute, false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}