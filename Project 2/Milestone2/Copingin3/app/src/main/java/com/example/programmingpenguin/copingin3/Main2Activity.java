package com.example.programmingpenguin.copingin3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    //Will need to program timer
    //May put in a toast to determine how and if feelings changed

    //This function receives data from main activity and passes it through a function to set the image
    public void setImages(){

        String coping1 = getIntent().getExtras().getString("coping1");
        String coping2 = getIntent().getExtras().getString("coping2");
        String coping3 = getIntent().getExtras().getString("coping3");

        int cope1image = Integer.parseInt(coping1);
        int cope2image = Integer.parseInt(coping2);
        int cope3image = Integer.parseInt(coping3);

        ImageView image1 = (ImageView) findViewById(R.id.imageView);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);

        image1 = determineImage(cope1image);
        image2 = determineImage(cope2image);
        image3 = determineImage(cope3image);


    }

    //This function determines which image to use
    public ImageView determineImage(int coping){
        ImageView image = (ImageView) findViewById(R.id.imageView);

        switch(coping){
            case 1:
                image.setImageResource(R.drawable.dance);
                break;
            case 2:
                image.setImageResource(R.drawable.change);
            break;
            case 3:
                image.setImageResource(R.drawable.hill);
            break;
            case 4:
                image.setImageResource(R.drawable.cow);
            break;
            case 5:
                image.setImageResource(R.drawable.superman);
            break;
            case 6:
                image.setImageResource(R.drawable.burpess);
            break;
            case 7:
                image.setImageResource(R.drawable.cycling);
            break;
            case 8:
                image.setImageResource(R.drawable.kick);
            break;
            case 9:
                image.setImageResource(R.drawable.age);
            break;
            case 10:
                image.setImageResource(R.drawable.proud);
            break;
            case 11:
                image.setImageResource(R.drawable.superpower);
            break;
            case 12:
                image.setImageResource(R.drawable.silly);
            break;
            case 13:
                image.setImageResource(R.drawable.breathe);
            break;
            case 14:
                image.setImageResource(R.drawable.balance);
            break;
            case 15:
                image.setImageResource(R.drawable.warrior);
            break;
            case 16:
                image.setImageResource(R.drawable.forward);
            break;

        };
        return image;
    }


    //Referenced stackoverflow
    //Function to return to main activity
    public void goBack(){
        Button goBack = (Button) findViewById(R.id.doneButton);

        goBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
