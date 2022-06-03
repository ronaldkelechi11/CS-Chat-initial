package com.bms.cs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddTimetableItem extends AppCompatActivity {
    ImageView bckbttn;
    Button add;
    EditText course,date,time,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timetable_item);


        //Initializing all Fields
        bckbttn = findViewById(R.id.backtblett);
        course = findViewById(R.id.inputCourse);
        date = findViewById(R.id.inputDate);
        time = findViewById(R.id.inputTime);
        location = findViewById(R.id.inputLocation);
        add = findViewById(R.id.add_button);


        //Converting all EditText's to String's
    String coursetxt = course.getText().toString();
    String datetxt = date.getText().toString();
    String timetxt = time.getText().toString();
    String locationtxt = location.getText().toString();

    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            //Validation Of Text Fields
            if(coursetxt.isEmpty()){
                course.setError("Field can't be Empty");
                course.requestFocus();
                return;
            }
            if(datetxt.isEmpty()){
                date.setError("Field can't be Empty");
                date.requestFocus();
                return;
            }
            if (timetxt.isEmpty()){
                time.setError("Time can't be Empty");
                time.requestFocus();
                return;
            }
            if (locationtxt.isEmpty()){
                location.setError("Location Cant Be empty");
                location.requestFocus();
                return;
            }


            //Passing the Information into the 
            Intent i = new Intent(getApplicationContext(),Timetable.class);
            i.putExtra("ncourse",coursetxt);
            i.putExtra("ndate",datetxt);
            i.putExtra("ntime",timetxt);
            i.putExtra("nlocation",locationtxt);
            startActivity(i);




        }
    });



    }
}