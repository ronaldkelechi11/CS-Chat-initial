package com.bms.cs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    int splashScreen = 5000;
    boolean notLoggedIn = FirebaseAuth.getInstance().getCurrentUser() == null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (notLoggedIn = true) {
                    Intent i = new Intent(MainActivity.this, SignUp.class);
                    startActivity(i);
                }
                else if (notLoggedIn = false){
                    Intent n = new Intent(MainActivity.this,HomeScreen.class);
                    startActivity(n);
                }
                else{
                    Toast.makeText(getApplicationContext(), "User verification failed", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, SignUp.class);
                    startActivity(i);
                }
                finish();
            }
        },splashScreen);






    }
}