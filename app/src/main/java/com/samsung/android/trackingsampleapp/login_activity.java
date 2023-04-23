package com.samsung.android.trackingsampleapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login_activity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginButton = findViewById(R.id.loginButton);
        tv = findViewById(R.id.textViewreg);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valideUsername() | !validePassword()) {

                } else {
                    checkUser();
                }
            }
               /* String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();*/

        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //open register activity
                startActivity(new Intent(login_activity.this, Register_activity.class));

            }
        });

    }

    public Boolean valideUsername() {
        String val = usernameEditText.getText().toString();
        if (val.isEmpty()) {
            usernameEditText.setError("Username cannot be empty");
            return false;
        } else {
            usernameEditText.setError(null);
            return true;
        }
    }

    public Boolean validePassword() {
        String val = passwordEditText.getText().toString();
        if (val.isEmpty()) {
            passwordEditText.setError("Password cannot be empty");
            return false;
        } else {
            passwordEditText.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String patUsername = usernameEditText.getText().toString().trim();
        String patPassword = passwordEditText.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Patient_users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(patUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    usernameEditText.setError(null);
                    String passwordFromDB = snapshot.child(patUsername).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDB, patPassword)) {
                        usernameEditText.setError(null);
                        Intent intent = new Intent(login_activity.this, HomePage_activity.class);
                        startActivity(intent);
                    } else {
                        usernameEditText.setError("patient does not exist");
                        usernameEditText.requestFocus();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();


                //PaUserDB db = new PaUserDB(getApplicationContext(), "SAYFR", null, 1);
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {

                   /* //if (db.login(username, password) == 1 || db.login(username, password) == 0) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("username", username);
                    //to save our data with key and value
                    editor.apply();
                    startActivity(new Intent(login_activity.this, HomePage_activity.class));

                    //}else {
                    //    Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                    //}*/





