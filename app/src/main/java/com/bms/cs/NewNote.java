package com.bms.cs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bms.cs.classes.Notes;

public class NewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

    }
     // When Save is pressed
    public void saveNote(View view) {

    }

    // When Delete Button is tapped
    public void DeleteNote(View view) {

    }

    //Back to All Notes View
    public void backToNotesView(View view) {
        //Will create a dialog that will tell you that you have not saved
        // your work and your data might be lost if you exist
    }

}