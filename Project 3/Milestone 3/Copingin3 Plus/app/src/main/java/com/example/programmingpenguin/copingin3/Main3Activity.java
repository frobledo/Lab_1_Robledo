package com.example.programmingpenguin.copingin3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {

    private String userFeeling = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent1 = getIntent();
        userFeeling = intent1.getStringExtra("userFeeling");

        TextView feelingOld = (TextView) findViewById(R.id.textView);
        feelingOld.setText("How " + userFeeling + " do you feel now?");

    }

    public void submit (View view){
        //Obtain rating bar information and send to Firebase database
        RatingBar feelingRating = (RatingBar) findViewById(R.id.ratingBar2);
        Float ratingNumberAfter = feelingRating.getRating();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Feeling After");

        myRef.setValue(ratingNumberAfter);
    }

    public void home (View view){
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);

    }
}
