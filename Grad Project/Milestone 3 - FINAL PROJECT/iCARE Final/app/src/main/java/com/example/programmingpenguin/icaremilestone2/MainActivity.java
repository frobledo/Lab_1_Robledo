/*The purpose of this app is to send a value to server and retrieve the value in a textfield.
*
* Firebase link: https://icare-369f1.firebaseio.com/
*
* References:
* https://www.youtube.com/watch?v=KEp5RAZNMng&index=6&list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt
* http://articles.tvac.in/faqs/
* */

package com.example.programmingpenguin.icaremilestone2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private String value = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        TextView displayMessage = (TextView) findViewById(R.id.textView2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference message = database.getReference();

        RadioGroup messageType = (RadioGroup) findViewById(R.id.messageRadioGroup);
        int messageTypeID = messageType.getCheckedRadioButtonId();

        switch (messageTypeID){
            case -1:
                value = "Message Error!";
                break;
            case R.id.radioButton:
                message.child("Emergency").setValue("Emergency! Please come right away!");

                message.child("Emergency").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        value = dataSnapshot.getValue(String.class);
                        Log.d("Success", "Message: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("Error", "Failed to get message", databaseError.toException());

                    }
                });

                displayMessage.setText(value);
                break;
            case R.id.radioButton2:
                message.child("Help").setValue("Yes, I need some help.");

                message.child("Help").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        value = dataSnapshot.getValue(String.class);
                        Log.d("Success", "Message: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("Error", "Failed to get message", databaseError.toException());

                    }
                });

                displayMessage.setText(value);
                break;
            case R.id.radioButton3:
                message.child("OK").setValue("Yes, I am ok.");

                message.child("OK").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        value = dataSnapshot.getValue(String.class);
                        Log.d("Success", "Message: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("Error", "Failed to get message", databaseError.toException());

                    }
                });

                displayMessage.setText(value);
                break;

        }
    }


}