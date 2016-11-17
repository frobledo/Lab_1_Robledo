package com.example.programmingpenguin.copingin3;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import java.text.Format;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main2Activity extends AppCompatActivity {

    private int [] userDeck = new int[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        userDeck = intent.getIntArrayExtra("userDeck");

        final TextView timer =(TextView)findViewById(R.id.textView2);

        new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {

                timer.setText("Time remaining: " +(millisUntilFinished/1000) + " seconds!");
            }

            public void onFinish() {
                timer.setText("All done!");
            }
        }.start();


        setRandomDeck();
        noCoping();
    }

    public void setRandomDeck(){

        //Will select three random coping mechanisms based on array built from user selection
        Random number = new Random();
        int randomNumber = 0;
        int temp;
        int count=0;

        //This for loop determines how many elements are in the array
        for(int i = 0; i<userDeck.length; i++){
            if(userDeck[i]!= 0){
                count++;
            }
        }

        //Will select three random coping mechanisms based on array built from user selection
        for (int i = 0; i<count; i++) {
            randomNumber = number.nextInt(count);
            temp = userDeck[i];
            userDeck[i]=userDeck[randomNumber];
            userDeck[randomNumber]=temp;
        }


        int cope1 = userDeck[0];
        int cope2 = userDeck[1];
        int cope3 = userDeck[2];

        //Populate image view with random coping skills
        ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        image1 = determineImages(cope1,image1);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        image2 = determineImages(cope2,image2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        image3 = determineImages(cope3,image3);

    }

    public void noCoping(){
        int count=0;

        for(int i = 0; i<userDeck.length; i++){
            if(userDeck[i]!= 0){
                count++;
            }
        }

        if(count == 0){
            ImageView error = (ImageView) findViewById(R.id.imageView);
            error.setImageResource(R.drawable.ohmy);

        }
    }

    public ImageView determineImages(int coping, ImageView image){


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



}
