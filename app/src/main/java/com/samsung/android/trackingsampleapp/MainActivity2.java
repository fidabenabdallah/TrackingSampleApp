package com.samsung.android.trackingsampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity2 extends AppCompatActivity {

    private EditText mTitle, mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome " + username, Toast.LENGTH_SHORT ).show();
        mTitle = findViewById(R.id.mTitle);
        mMessage = findViewById(R.id.mMessage);


        findViewById(R.id.mSend).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String title = mTitle.getText().toString().trim();
                String message = mMessage.getText().toString().trim();
                if (!title.equals("") && !message.equals("")){
                    notifsend.pushNotification(
                            MainActivity2.this,
                            "e0_pI5l4QY-uyG5vnRyMvn:APA91bE3WcET4Tx02IedgLtSPYoh5AxJxVHImIJGBBJ3C3YnAiLJurcVTCiBoBEd6ueCeh3HXomoIVOtR5lftyIpZX6OVDVjS3lOi8l0LSRK6BhWqbOMAZ5nQPgxt9wRzEeZq1YGeslO",
                            title,
                            message
                    );

                }

            }
        });


        //get device id
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            String token = task.getResult();
                            Log.d("FCM", "FCM token: " + token);
                        } else {
                            Log.e("FCM", "getToken() failed: ", task.getException());
                        }
                    }
                });
        //device 1 : e0_pI5l4QY-uyG5vnRyMvn:APA91bE3WcET4Tx02IedgLtSPYoh5AxJxVHImIJGBBJ3C3YnAiLJurcVTCiBoBEd6ueCeh3HXomoIVOtR5lftyIpZX6OVDVjS3lOi8l0LSRK6BhWqbOMAZ5nQPgxt9wRzEeZq1YGeslO

        //device 2 : dhOhK7fhQIGKEvkIrnvF68:APA91bHuGixnIvALiAz4xm4v89bwdD6JEvh1Ilp5rxn2yF-ez0jbVxdNMYjelnindtTOENcBD0EGQmrGkkjCsjOTntnyNY6Ui6DnXenx2bG3tsEu4SqFemEmo4hk7vF0BQfcqBxTaE_q


        //smartwatch : dhOhK7fhQIGKEvkIrnvF68:APA91bHuGixnIvALiAz4xm4v89bwdD6JEvh1Ilp5rxn2yF-ez0jbVxdNMYjelnindtTOENcBD0EGQmrGkkjCsjOTntnyNY6Ui6DnXenx2bG3tsEu4SqFemEmo4hk7vF0BQfcqBxTaE_q

        //create notification service
    }
}