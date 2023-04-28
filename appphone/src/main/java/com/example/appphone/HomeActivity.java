package com.example.appphone;

import static com.example.appphone.R.id.imageView21;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;



public class HomeActivity extends AppCompatActivity {

    TextView docUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        docUsername = findViewById(R.id.usernameTitle);

        showUserData();

        ImageView exit = findViewById(imageView21);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));

            }
        });

        ImageView pat;
        pat = findViewById(R.id.imageView8);
        pat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HomeActivity.this, PatientsActivity.class));
            }
        });

        ImageView profile;
        profile = findViewById(R.id.imageView6);
        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //pass the data using intent
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);

                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("docEmail", getIntent().getStringExtra("email"));
                intent.putExtra("specialty", getIntent().getStringExtra("specialty"));
                intent.putExtra("numpatientdoc", getIntent().getStringExtra("numpat"));
                intent.putExtra("phone", getIntent().getStringExtra("phone"));
                intent.putExtra("docUsername", docUsername.getText().toString());
                startActivity(intent);
            }
        });





    }

    public void showUserData(){
        Intent intent = getIntent();
        String usernameDoc = intent.getStringExtra("username");

        docUsername.setText(usernameDoc);

    }



}