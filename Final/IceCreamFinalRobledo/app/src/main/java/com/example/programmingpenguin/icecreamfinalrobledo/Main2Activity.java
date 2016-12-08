package com.example.programmingpenguin.icecreamfinalrobledo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private String icecreamSelected;
    private String icecreamSelectedURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        icecreamSelected = intent.getStringExtra("icecreamSelected");
        icecreamSelectedURL = intent.getStringExtra("icecreamURL");

        TextView viewSelection = (TextView) findViewById(R.id.textView2);
        viewSelection.setText("You should check out " + icecreamSelected);

        final ImageButton goToWeb = (ImageButton) findViewById(R.id.imageButton);
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view){
                loadSite(view);
            }
        };

        goToWeb.setOnClickListener(onClick);
}

    public void loadSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(icecreamSelectedURL));
        startActivity(intent);
    }

}
