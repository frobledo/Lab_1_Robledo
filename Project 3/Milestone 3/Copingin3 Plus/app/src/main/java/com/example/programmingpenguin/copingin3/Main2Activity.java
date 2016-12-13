package com.example.programmingpenguin.copingin3;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import java.text.Format;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class Main2Activity extends AppCompatActivity {

    private int [] userDeck = new int[20];
    private String feelingValue = "";
    private int count = 0;
    private int interval = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        userDeck = intent.getIntArrayExtra("userDeck");
        feelingValue = intent.getStringExtra("userFeeling");

        setRandomDeck();

        final ViewFlipper copingImages = (ViewFlipper) findViewById(R.id.viewFlipper);

        int coping = 0;

        for(int i = 0; i<count; i++){
            ImageView imageView = new ImageView(this);
            coping = userDeck[i];
            imageView = determineImages(coping, imageView);
            copingImages.addView(imageView);
        }

        final Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        final Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        copingImages.setInAnimation(in);
        copingImages.setOutAnimation(out);
        copingImages.setFlipInterval(interval);
        copingImages.setAutoStart(true);

        //To show next image
        ImageButton next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copingImages.showNext();
            }
        });


        //To show previous image
        ImageButton previous = (ImageButton) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copingImages.showPrevious();
            }
        });

        final TextView timer =(TextView)findViewById(R.id.textView2);
        new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Time remaining: " +(millisUntilFinished/1000) + " seconds!");
            }

            public void onFinish() {
                timer.setText("All done!");
                Toast toast = Toast.makeText(getApplicationContext(), "Time is up. Click done to continue!",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0,0);
                toast.show();
                copingImages.stopFlipping();
            }
        }.start();


        noCoping();
    }


    public void setRandomDeck(){

        //Will select three random coping mechanisms based on array built from user selection
        Random number = new Random();
        int randomNumber = 0;
        int temp;

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

    public void allDone(View view){

        Intent intent2 = new Intent(this,Main3Activity.class);
        intent2.putExtra("userFeeling", feelingValue);
        startActivity(intent2);
    }


}
