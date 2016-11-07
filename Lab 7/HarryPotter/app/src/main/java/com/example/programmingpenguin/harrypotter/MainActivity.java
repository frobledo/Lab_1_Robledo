package com.example.programmingpenguin.harrypotter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void aparecium (View view){

        //To obtain value of name
        EditText name= (EditText)findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        System.out.println(nameValue);

        //To set up spinner
        Spinner houseSpinner = (Spinner) findViewById(R.id.houseSpinner);
        String houseValue=String.valueOf(houseSpinner.getSelectedItem());
        ImageView houseImage=(ImageView) findViewById(R.id.imageView2);
        int housePosition = houseSpinner.getSelectedItemPosition();
        switch(housePosition){
            case 0:
                houseImage.setImageResource(R.drawable.gryffindor);
                break;
            case 1:
                houseImage.setImageResource(R.drawable.hufflepuff);
                break;
            case 2:
                houseImage.setImageResource(R.drawable.ravenclaw);
                break;
            case 3:
                houseImage.setImageResource(R.drawable.slytherin);
                break;
        }

        //To set up radio buttons
        RadioGroup pets = (RadioGroup) findViewById(R.id.petRadioGroup);
        String petType="";
        int pets_id=pets.getCheckedRadioButtonId();
        switch(pets_id){
            case -1:
                petType="no";
                break;
            case R.id.radioButton:
                petType="rat";
                break;
            case R.id.radioButton2:
                petType="owl";
                break;
            case R.id.radioButton3:
                petType="pygmy puff";
                break;
        }

        //To set up checkboxes
        String checkbox_string="";
        CheckBox check1= (CheckBox) findViewById(R.id.checkBox);
        boolean checked1 = check1.isChecked();
        if(checked1){
            checkbox_string += "Potions, ";
        }

        CheckBox check2= (CheckBox) findViewById(R.id.checkBox2);
        boolean checked2 = check2.isChecked();
        if(checked2){
            checkbox_string += "Herbology, ";
        }

        CheckBox check3= (CheckBox) findViewById(R.id.checkBox3);
        boolean checked3 = check3.isChecked();
        if(checked3){
            checkbox_string += "Transfiguration, ";
        }

        CheckBox check4= (CheckBox) findViewById(R.id.checkBox4);
        boolean checked4 = check4.isChecked();
        if(checked4){
            checkbox_string += "Defense, ";
        }

        //To set up switch
        String quidditch_string= "";
        Switch quidditch_switch=(Switch)findViewById(R.id.switch1);
        boolean quidditch = quidditch_switch.isChecked();
        if(quidditch){
            quidditch_string="and playing Quidditch";
        }
        else {
            quidditch_string="and watching Quidditch";
        }

        //To print out summary of selection
        System.out.println("in method");
        TextView summary = (TextView) findViewById(R.id.finalTextView);
        summary.setText(nameValue + " lives in " + houseValue + " house with a pet " + petType +  ". " + nameValue + "'s favorite classes are " + checkbox_string + quidditch_string + ".");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
