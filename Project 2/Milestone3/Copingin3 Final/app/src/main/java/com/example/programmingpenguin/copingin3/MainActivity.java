/*
* The purpose of this app is to help individuals select coping skills to help encourage positive mood.
* The user will select their current mood and enjoyable activities.
* The algorithm will select three random coping skills based on enjoyable activites selected by the user.
* The three activities will be displayed along with an optional timer (the activities are each meant to
* last a minute each). The user will then be prompted to evaluate their mood once completing the activities.
*
* References
*Tutorial for multiple activities:https://www.youtube.com/watch?v=MCf7EWLVWO8
*Random number generator: http://codereview.stackexchange.com/questions/124124/creating-an-array-of-random-numbers-with-no-duplicates
*Convert string to int: https://www.mkyong.com/java/java-convert-string-to-int/
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
import android.widget.CheckBox;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);

        final ImageButton cope = (ImageButton) findViewById(R.id.copeButton);

        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                buildCopingDeck(view);
            }
        };

        cope.setOnClickListener(onclick);

    }

    //This function will build the user coping deck based on selection of activity
    public void buildCopingDeck(View view) {

        int [] userDeck = new int [20];
        int x = 0; //This is used to build the array for the user deck

        //Check if user selected randomness checkbox
        CheckBox random = (CheckBox) findViewById(R.id.random);
        boolean randomChecked = random.isChecked();
        if(randomChecked){
            for(int i=1; i<=4; i++){
                userDeck[x]=i;
                x++;
            }
        }

        //Check if user selected exercise checkbox
        CheckBox exercise = (CheckBox) findViewById(R.id.exercising);
        boolean exerciseChecked = exercise.isChecked();
        if(exerciseChecked){
            for(int i=5; i<=8; i++){
                userDeck[x]=i;
                x++;
            }
        }

        //Check if user selected writing checkbox
        CheckBox writing = (CheckBox) findViewById(R.id.writing);
        boolean writingChecked = writing.isChecked();
        if(writingChecked){
            for(int i=9; i<=12; i++){
                userDeck[x]=i;
                x++;
            }
        }

        //Check if user selected yoga checkbox
        CheckBox yoga = (CheckBox) findViewById(R.id.yoga);
        boolean yogaChecked = yoga.isChecked();
        if(yogaChecked){
            for(int i=13; i<=16; i++){
                userDeck[x]=i;
                x++;
            }
        }


        //Set up intent
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("userDeck", userDeck);
        startActivity(intent);

    }

}
