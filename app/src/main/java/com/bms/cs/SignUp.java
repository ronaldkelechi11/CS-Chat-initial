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

import com.bms.cs.classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SignUp extends AppCompatActivity {
    EditText Nickname,Email,Password;
    Button Confirm;
    TextView redirect;
    ProgressBar progressBar2;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Nickname = findViewById(R.id.inputNickname);
        Email    = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.inputPassword);
        Confirm  = findViewById(R.id.confirm_button);
        redirect = findViewById(R.id.alreadyacct);
        progressBar2 = findViewById(R.id.progress_circular_2);

        mAuth = FirebaseAuth.getInstance();



        /* It makes clicking on the text send you to login page */
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(SignUp.this, LogIn.class);
                startActivity(i);
            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Converting of all EditText to strings
                String nickname = Nickname.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                String validation = "Auth.txt";



                //Checking the validity opf the Input Fields
                if(nickname.isEmpty()){
                    Nickname.setError("Nickname cannot be Empty");
                    Nickname.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    Email.setError("Email field is not valid");
                    Email.requestFocus();
                    return;
                }
                if(!email.contains("@gmail.com")){
                    Email.setError("Not a valid Email address");
                    Email.requestFocus();
                    return;
                }
                if(password.length()<6){
                    Password.setError("Password must be more than 6 characters");
                    Password.requestFocus();
                    return;
                }




                progressBar2.setVisibility(View.VISIBLE);
                /*
                Creation of User and Input into Database works by creating User class and checking input to database
                and error output on failed.
                */
                mAuth.createUserWithEmailAndPassword(email,nickname).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(email,nickname);

                            FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                   if(task.isSuccessful()){

                                       // File saved locally to see if User has logged in before...


                                       Intent i = new Intent(SignUp.this,HomeScreen.class);
                                       startActivity(i);
                                   }
                                   else {
                                       Toast.makeText(getApplicationContext(),"Input to Database Unsuccessful",Toast.LENGTH_SHORT).show();
                                       System.out.println("Authentication Issues");
                                   }

                                }
                            });
                        }
                        else{
                            progressBar2.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "User Registration Issues", Toast.LENGTH_SHORT).show();
                            System.out.println("Registration Issues");
                        }
                    }
                });




            }
        });

    }
}