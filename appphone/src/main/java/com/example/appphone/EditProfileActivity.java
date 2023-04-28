package com.example.appphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail , editSpecialty , editPhone;
    ImageView savebut;
    String nameDoc, emailDoc, specialtyDoc, phoneDoc, usernameDoc;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("Doctors");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editSpecialty = findViewById(R.id.editSpecialty);
        editPhone = findViewById(R.id.editPhone);
        savebut = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        usernameDoc = intent.getStringExtra("username");

        usernameDoc= "fida";

        showData();

        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isSpecialtyChanged() || isPhoneChanged()){
                    Toast.makeText(EditProfileActivity.this, "saved", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(EditProfileActivity.this, "No changes found", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public boolean isNameChanged(){
        if (!nameDoc.equals(editName.getText().toString())){

            reference.child(usernameDoc).child("name").setValue(editName.getText().toString());
            nameDoc = editName.getText().toString();
            Log.d("EditProfileActivity", "Name changed to " + nameDoc);
            return true;
        }else{
            Log.d("EditProfileActivity", "No changes found for name");
            return false;
        }
    }

    public boolean isEmailChanged(){
        if (!emailDoc.equals(editEmail.getText().toString())){
            reference.child(usernameDoc).child("email").setValue(editEmail.getText().toString());
            emailDoc = editEmail.getText().toString();
            return true;

        }else{
            return false;
        }
    }

    public boolean isSpecialtyChanged(){
        if (!specialtyDoc.equals(editSpecialty.getText().toString())){
            reference.child(usernameDoc).child("specialty").setValue(editSpecialty.getText().toString());
            specialtyDoc = editSpecialty.getText().toString();
            return true;

        }else{
            return false;
        }
    }

    public boolean isPhoneChanged(){
        if (!phoneDoc.equals(editPhone.getText().toString())){
            reference.child(usernameDoc).child("phone").setValue(editPhone.getText().toString());
            phoneDoc = editPhone.getText().toString();
            return true;

        }else{
            return false;
        }
    }

    public void showData(){
        Intent intent = getIntent();

        nameDoc = intent.getStringExtra("name");
        emailDoc = intent.getStringExtra("email");
        phoneDoc = intent.getStringExtra("phone");
        specialtyDoc = intent.getStringExtra("specialty");

        editName.setText(nameDoc);
        editPhone.setText(phoneDoc);
        editEmail.setText(emailDoc);
        editSpecialty.setText(specialtyDoc);
    }
}