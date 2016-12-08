package com.example.programmingpenguin.icecreamfinalrobledo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private iceCream myIcecream = new iceCream();
    private String suggestedIcecream = "";
    private String suggestedIcecreamURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button2);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveNext(view);
            }
        };

        button.setOnClickListener(onClick);


    }

    public void treatButton(View view){

        EditText name = (EditText)findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        String dairyFree = "";
        Switch dairyFreeSwitch = (Switch) findViewById(R.id.switch1);
        boolean switchChecked = dairyFreeSwitch.isChecked();
        if(switchChecked){
            dairyFree = " dairy free ";
        }
        else {
            dairyFree = " regular ";
        }

        Spinner icecreamSelection = (Spinner) findViewById(R.id.spinner);
        Integer spinnerSelection = icecreamSelection.getSelectedItemPosition();
        myIcecream.setSelectIceCream(spinnerSelection);
        myIcecream.setSelectIceCreamURL(spinnerSelection);
        suggestedIcecream = myIcecream.getSelectIceCream();
        suggestedIcecreamURL = myIcecream.getSelectIceCreamURL();

        String myChoiceIcecream = "";
        switch(spinnerSelection){
            case 0:
                myChoiceIcecream= "salted caramel";
                break;
            case 1:
                myChoiceIcecream="death by chocolate";
                break;
            case 2:
                myChoiceIcecream="cookies and cream";
                break;

        }

        ImageView iceImage = (ImageView) findViewById(R.id.imageView);
        int iceImagePosition = icecreamSelection.getSelectedItemPosition();
        switch(iceImagePosition){
            case 0:
                iceImage.setImageResource(R.drawable.caramel);
                break;
            case 1:
                iceImage.setImageResource(R.drawable.chocolate);
                break;
            case 2:
                iceImage.setImageResource(R.drawable.cookiescream);
                break;
        }

        RadioGroup type = (RadioGroup) findViewById(R.id.radioGroup);
        String ice_type="";
        int type_id = type.getCheckedRadioButtonId();
        switch(type_id){
            case -1:
                ice_type="none";
                break;
            case R.id.radioButton:
                ice_type="ice cream";
                break;
            case R.id.radioButton3:
                ice_type="frozen yogurt";
                break;
            case R.id.radioButton4:
                ice_type="gelato";
                break;
        }

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        boolean container = toggle.isChecked();
        String typeOfContainer = "";
        if(container){
            typeOfContainer = " cup";
        } else{
            typeOfContainer = " cone";
        }

        String checkbox_string = "";
        CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        boolean checked1 = check1.isChecked();
        if(checked1){
            checkbox_string += "sprinkles ";
        }

        CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean checked2 = check2.isChecked();
        if(checked2){
            checkbox_string += "hot fudge ";
        }

        CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);
        boolean checked3 = check3.isChecked();
        if(checked3){
            checkbox_string += "nuts ";
        }



        //Display information
        TextView summary = (TextView) findViewById(R.id.display);
        summary.setText("My " + nameValue + " is a " + myChoiceIcecream + dairyFree + ice_type + typeOfContainer + " with " + checkbox_string);
    }

    public void moveNext(View view){

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("icecreamSelected", suggestedIcecream);
        intent.putExtra("icecreamURL", suggestedIcecreamURL);
        startActivity(intent);
    }

}
