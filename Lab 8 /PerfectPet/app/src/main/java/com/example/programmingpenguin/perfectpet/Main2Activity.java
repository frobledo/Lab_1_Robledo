package com.example.programmingpenguin.perfectpet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String dogSelected;
    private String dogURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        dogSelected = intent.getStringExtra("dogSelected");
        dogURL = intent.getStringExtra("dogURL");

        TextView viewMatch = (TextView) findViewById(R.id.dogMatch);
        viewMatch.setText("Your perfect pet is a: " + dogSelected);

        final ImageButton dogImage = (ImageButton) findViewById(R.id.imageButton);
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSite(view);
            }
        };

        dogImage.setOnClickListener(onClick);
    }

    public void loadSite (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(dogURL));
        startActivity(intent);

    }
}
