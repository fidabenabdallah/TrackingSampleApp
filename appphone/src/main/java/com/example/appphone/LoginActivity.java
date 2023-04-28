package com.example.appphone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.appphone.Entity.UserDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    ImageView btn;
    TextView tv;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        edEmail = findViewById(R.id.editTextLoginEmail);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (!valideUsername() | !validePassword()) {

               } else {
                    checkUser();
               }
           }

        });



                 /*UserDB db = new UserDB(getApplicationContext(),"SAYFR",null,1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all details", Toast.LENGTH_SHORT ).show();
                }else{
                    if(db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT ).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("username",username);
                        //to save our data with key and value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid Username and Password", Toast.LENGTH_SHORT ).show();
                    }
                   }*/





        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });



    }

    public Boolean valideUsername() {
        String val = edEmail.getText().toString();
        if (val.isEmpty()) {
            edEmail.setError("Username cannot be empty");
            return false;
        } else {
            edEmail.setError(null);
            return true;
        }
    }

    public Boolean validePassword() {
        String val = edPassword.getText().toString();
        if (val.isEmpty()) {
            edPassword.setError("Password cannot be empty");
            return false;
        } else {
            edPassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String DocUsername = edEmail.getText().toString().trim();
        String DocPassword = edPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(DocUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    edEmail.setError(null);
                    String passwordFromDB = snapshot.child(DocUsername).child("password").getValue(String.class);
                    String emailFromDB = snapshot.child(DocUsername).child("email").getValue(String.class);

                    if (passwordFromDB.equals(DocPassword)) {
                        edEmail.setError(null);

                        //pass the data using intent

                        String usernameFromDB = snapshot.child(DocUsername).child("username").getValue(String.class);
                        String nameFromDB = snapshot.child(DocUsername).child("name").getValue(String.class);
                        String phoneFromDB = snapshot.child(DocUsername).child("phone").getValue(String.class);
                        String specialtyFromDB = snapshot.child(DocUsername).child("specialty").getValue(String.class);
                        int numpatFromDB = snapshot.child(DocUsername).child("numpat").getValue(int.class);


                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("password",passwordFromDB);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("phone",phoneFromDB);
                        intent.putExtra("specialty",specialtyFromDB);
                        intent.putExtra("numpat",numpatFromDB);
                        startActivity(intent);
                    } else {
                        edEmail.setError("Invalid Credentials");
                        edEmail.requestFocus();
                    }
                    }else{
                        edEmail.setError("Doctor does not exist");
                        edEmail.requestFocus();
                    }
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}