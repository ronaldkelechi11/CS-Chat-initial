package com.bms.cs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity {
    ImageView logout_butt;
    CardView Timetablebutt,Notesbutt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        logout_butt = findViewById(R.id.logout);
        Timetablebutt = findViewById(R.id.cschatTble);
        Notesbutt = findViewById(R.id.cschatNotes);

        logout_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Signed Out",Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeScreen.this, SignUp.class);
                startActivity(i);
            }
        });

        Timetablebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,Timetable.class);
                startActivity(intent);
            }
        });

        //  Redirect to Notes Page where you see all the notes displayed
        Notesbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,NotesView.class);
                startActivity(intent);
            }
        });


    }
}