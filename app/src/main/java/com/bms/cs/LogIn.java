package com.bms.cs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LogIn extends AppCompatActivity {
    EditText logInEmail,logInPassword;
    Button  confirm_butt;
    TextView redirect_2;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logInEmail = findViewById(R.id.logInUsername);
        logInPassword = findViewById(R.id.logInPassword);
        confirm_butt = findViewById(R.id.confirm_button_login);
        redirect_2 = findViewById(R.id.dontacct);
        progressBar = findViewById(R.id.progress_circular);

        mAuth = FirebaseAuth.getInstance();

        redirect_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                startActivity(i);
            }
        });


        //Button
        confirm_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Conversion of EditText to Strings
               String usname = logInEmail.getText().toString();
               String passwrd = logInPassword.getText().toString();


               //Validation Parameters
               if(usname.isEmpty()){
                   logInEmail.setError("Email cannot be Empty");
                   logInEmail.requestFocus();
                   return;
               }
               if(passwrd.length()<6){
                   logInPassword.setError("Password cannot be less than 6 characters");
                   logInPassword.requestFocus();
                   return;
               }

                progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(usname,passwrd)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (FirebaseAuth.getInstance().getCurrentUser() != null){
                            Toast.makeText(getApplicationContext(), "User does exists", Toast.LENGTH_SHORT).show();
                                }
                            if(task.isSuccessful()){
                                FirebaseUser currentUser = mAuth.getCurrentUser();

                                //This gets the User data and gets his Email Address and Displays in a Toast
                                assert currentUser != null;// This is just to make sure it doesn't bring back a null Value
                                Toast.makeText(getApplicationContext(),currentUser.getEmail().toString() + " just Signed In",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LogIn.this,HomeScreen.class);
                                startActivity(i);
                            }
                           else {
                               progressBar.setVisibility(View.INVISIBLE);
                               Toast.makeText(getApplicationContext(), "LogIn Failed try Again Later", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });


            }
        });

    }
}