package com.todo.utils

import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat.CLOCK_24H
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class Picker(private var fragmentManager: FragmentManager, private var editText: EditText) {
    init {
        makeDatePicker()
    }

    private fun makeTimePicker() {
        val timePicker: MaterialTimePicker =
            MaterialTimePicker.Builder().setTitleText("Select the deadline time")
                .setTimeFormat(CLOCK_24H).build()
        timePicker.show(fragmentManager, "TimePickerOfAddTask")
        timePicker.addOnPositiveButtonClickListener {
            hour = timePicker.hour
            minute = timePicker.minute
            val result ="$fullDate, $hour:$minute"
            editText.setText(result)

        }
    }

    private fun makeDatePicker() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker().setTitleText("Select the deadline date").build()
        datePicker.show(fragmentManager, "DatePickerOfAddTask")

        datePicker.addOnPositiveButtonClickListener {
            val outputDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            outputDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            fullDate = outputDateFormat.format(it)
            makeTimePicker()
        }
    }


}