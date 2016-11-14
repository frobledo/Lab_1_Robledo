/*The purpose of this app is to obtain information from a server to display a message.
* The user will then be able to act on the message by pressing two buttons.
* The pressing of the two buttons will send data back to a google Spreadsheet.*/

package com.example.programmingpenguin.icaremilestone2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getMessage(View view) {
        //When the user clicks on the button, a message will be display
        //The information for this textview will be retrieved from the google spreadsheet
        //This is the link to the spreadsheet: https://docs.google.com/spreadsheets/d/10CDo6pLTbqB6w-h_phoc2F3CmscuAzZ3M2DqWvXlofw/pubhtml
        //A random number generator will select which (out of 3 messages) to show

        TextView displayMessage = (TextView) findViewById(R.id.textView2);
        displayMessage.setText("Message generated randomly by google Spreadsheet");

        //Every time the user clicks on the button, the data from the spreadsheet will be retrieved and randomly shown in text view

    }

    //Another function will determine what happens when either the red or green button are clicked
    //If the red button is clicked - then the message of "please wait" will be sent and stored in google spreadsheet
    //If the green button is clicked - then the message of "on my way" will be sent and stored in google spreadsheet
}


