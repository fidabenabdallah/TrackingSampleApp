package com.example.appphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView docName, docEmail , docUsername, docPhone, docNumpatient, docSpecialty;
    TextView titleusername;
    Button editp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        docName = findViewById(R.id.name);
        docEmail= findViewById(R.id.email);
        docPhone = findViewById(R.id.phone);
        docUsername = findViewById(R.id.username);
        docNumpatient = findViewById(R.id.numpatients);
        docSpecialty = findViewById(R.id.specialty);
        titleusername = findViewById(R.id.usernameTitle);

        editp = findViewById(R.id.editprofile);

        showUserData();

        editp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                    passUserData();
                }

        });

    }

    public void showUserData(){
        Intent intent = getIntent();
        String nameDoc = intent.getStringExtra("name");
        String usernameDoc = intent.getStringExtra("docUsername");
        String emailDoc = intent.getStringExtra("docEmail");
        String phoneDoc = intent.getStringExtra("phone");
        String specialtyDoc = intent.getStringExtra("specialty");
        String numpatientsDoc = intent.getStringExtra("numpatientsdoc");

        titleusername.setText(usernameDoc);
        docUsername.setText(usernameDoc);
        docEmail.setText(emailDoc);
        docName.setText(nameDoc);
        docPhone.setText(phoneDoc);
        docSpecialty.setText(specialtyDoc);
        docNumpatient.setText(numpatientsDoc);




    }

    public void passUserData(){
        String Username = docUsername.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(Username);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    String nameFromDB = snapshot.child(Username).child("name").getValue(String.class);
                    String usernameFromDB = snapshot.child(Username).child("docUsername").getValue(String.class);
                    String emailFromDB = snapshot.child(Username).child("docEmail").getValue(String.class);
                    String phoneFromDB = snapshot.child(Username).child("phone").getValue(String.class);
                    String numpatFromDB = snapshot.child(Username).child("numpatientsdoc").getValue(String.class);
                    String specialtyFromDB = snapshot.child(Username).child("specialty").getValue(String.class);

                    Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                    intent.putExtra("name",nameFromDB);
                    intent.putExtra("username",usernameFromDB);
                    intent.putExtra("email",emailFromDB);
                    intent.putExtra("phone",phoneFromDB);
                    intent.putExtra("numpat",numpatFromDB);
                    intent.putExtra("specialty",specialtyFromDB);
                    startActivity(intent);




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}