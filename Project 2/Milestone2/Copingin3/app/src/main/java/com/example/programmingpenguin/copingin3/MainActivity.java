/*
* The purpose of this app is to help individuals select coping skills to help encourage positive mood.
* The user will select their current mood and enjoyable activities.
* The algorithm will select three random coping skills based on enjoyable activites selected by the user.
* The three activities will be displayed along with an optional timer (the activities are each meant to
* last a minute each). The user will then be prompted to evaluate their mood once completing the activities.
*
* References
*Tutorial for multiple activities:https://www.youtube.com/watch?v=MCf7EWLVWO8
* Convert string to int: https://www.mkyong.com/java/java-convert-string-to-int/
*Triforce image (icon): http://icepoodle.deviantart.com/art/Wallpaper-Triforce-186307296
*Yoga pose images: http://www.123rf.com/photo_9778109_woman-practicing-yoga-25-poses-for-your-design.html
*Exercise pose images: http://www.globalhealingcenter.com/natural-health/9-reasons-exercise-best-medicine/
*Sing and dance image: http://www.dancexcitement.com/
*Re-organize image: http://www.demeterclarc.com/2014/11/10/rearrange/
*Hill image: http://www.clker.com/clipart-13461.html
*Animal image: http://www.clipartpanda.com/categories/hillside-20clipart
*Scroll image: http://www.clipartpanda.com/categories/free-clip-art-borders-scroll
* */
package com.example.programmingpenguin.copingin3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //This function moves on to the next activity when the button is clicked.
    //Need to pass mood information and copingOptions()
    public void moveOn() {

        final Button copingList = (Button) findViewById(R.id.doneButton);

        Spinner determineMood = (Spinner) findViewById(R.id.listCurrentFeelings);
        final String moodValue=String.valueOf(determineMood.getSelectedItem());

        final int[] getValues = copingOptions();
        final int coping1;
        final int coping2;
        final int coping3;

        coping1=getValues[0];
        coping2=getValues[1];
        coping3=getValues[2];

        copingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent copingListIntent = new Intent(MainActivity.this, Main2Activity.class );
                copingListIntent.putExtra("coping1", coping1);
                copingListIntent.putExtra("coping2", coping2);
                copingListIntent.putExtra("coping3", coping3);
                copingListIntent.putExtra("user_mood", moodValue);
                startActivity(copingListIntent);
            }
        });
    }


    //This function will return coping mechanisms in the specific categories selected by the user
    //An array is used to determine user selection - the array is initialized below
    public int[] copingOptions(){
        int[] copingMechanisms = new int [0];
        int x=0;


        CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        boolean checked1 = check1.isChecked();
        if(checked1) {
            for (int i = 1; i < 5; i++) {
                copingMechanisms[x] = i;
                x++;
            }
        }

        CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean checked2 = check2.isChecked();
        if(checked2){
            for(int i =5; i<9 ; i++){
                copingMechanisms[x]=i;
                x++;
            }
        }

        CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);
        boolean checked3 = check3.isChecked();
        if(checked3) {
            for (int i = 9; i < 13; i++) {
                copingMechanisms[x] = i;
                x++;
            }
        }

            CheckBox check4 = (CheckBox) findViewById(R.id.checkBox4);
            boolean checked4 = check4.isChecked();
            if (checked4) {
                for (int i = 13; i < 17; i++) {
                    copingMechanisms[x] = i;
                    x++;
                }
            }

            //Will select three random coping mechanisms based on array built from user selection
            int[] selectedMechanisms = new int[0];
            Random number = new Random();
            int randomNumber = 0;
            int min = 0;

            //Will select three random coping mechanisms based on array built from user selection
            for (int count = 0; count < 3; count++) {
                randomNumber = number.nextInt((copingMechanisms.length - min) + 1) + min;
                selectedMechanisms[count] = copingMechanisms[randomNumber];
            }

        return selectedMechanisms;
    }

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);
        moveOn();
    }
}
