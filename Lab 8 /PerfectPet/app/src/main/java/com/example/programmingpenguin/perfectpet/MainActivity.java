package com.example.programmingpenguin.perfectpet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private DogSelection myDog = new DogSelection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);

        View.OnClickListener onClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                findDog(view);
            }
        };

        button.setOnClickListener(onClick);
    }

    public void findDog (View view){
        Spinner personSpinner = (Spinner) findViewById(R.id.spinner);
        Integer personType = personSpinner.getSelectedItemPosition();
        myDog.setDog(personType);
        myDog.setDogURL(personType);
        String suggestedDog = myDog.getSelectedDog();
        String suggestedDogURL = myDog.getDogURL();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("dogSelected", suggestedDog);
        intent.putExtra("dogURL", suggestedDogURL);
        startActivity(intent);

    }
}
