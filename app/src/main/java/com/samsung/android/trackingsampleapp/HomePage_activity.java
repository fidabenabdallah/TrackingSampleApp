package com.samsung.android.trackingsampleapp;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Wearable;


public class HomePage_activity extends AppCompatActivity {

    private Button urgent;
    private Button sendmessage;
    private Button senddata;
    private TextView textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_page);


        // Initialize the TextView
        textView2 = findViewById(R.id.textView2);

        showUserData();

        // Set the username to the TextView


        urgent = findViewById(R.id.urgent);
        sendmessage = findViewById(R.id.sendmessage);
        senddata = findViewById(R.id.senddata);



        /*SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "").toString();
        Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();

        textView2.setText("Welcome, " + username);*/

        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();*/
                startActivity(new Intent(HomePage_activity.this, sendmsg_activity.class));

            }
        });

        urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();*/
                startActivity(new Intent(HomePage_activity.this, MainActivity2.class));

            }
        });


        senddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();*/
                startActivity(new Intent(HomePage_activity.this, choiceActivity.class));

            }
        });

    }
    public void showUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("username");
        textView2.setText(nameUser);
    }


    public void urgent(View view) {
        // Create a notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Urgent Notification")
                .setContentText("This is an urgent notification from your wearable device.")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        // Create a wearable extender and add additional information
        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender()
                .setBackground(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                .setContentIcon(R.drawable.ic_launcher_background)
                .setHintHideIcon(true);

        // Add the wearable extender to the notification builder
        builder.extend(wearableExtender);

        // Build the notification
        Notification notification = builder.build();

        // Set vibration and sound on the notification object
        long[] vibrationPattern = new long[0];
        notification.vibrate = vibrationPattern;
        notification.sound = Settings.System.DEFAULT_NOTIFICATION_URI;

        // Use the notification manager to send the notification to the phone
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manager.notify(1, notification);

        // Send a message to the phone to vibrate
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();
        googleApiClient.connect();
        Wearable.MessageApi.sendMessage(googleApiClient, "", "/vibrate", null);
        googleApiClient.disconnect();


    }
}
    /*public void urgent(View view){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("title page 1");
        builder.setContentText("this is urgent");
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        Notification notification = builder.build();

        NotificationManagerCompat managerCompt = NotificationManagerCompat.from(this);
        managerCompt.notify(1,notification);
    }*/


