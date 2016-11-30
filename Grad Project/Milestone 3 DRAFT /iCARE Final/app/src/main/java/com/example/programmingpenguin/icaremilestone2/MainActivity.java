/*The purpose of this app is to obtain information from a server to display a message once a button is pressed.
*
* References:
* http://www.wikihow.com/Execute-HTTP-POST-Requests-in-Android
* https://developer.android.com/reference/java/net/HttpURLConnection.html
* http://www.androidhive.info/2012/05/how-to-connect-android-with-php-mysql/
* https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
* */

package com.example.programmingpenguin.icaremilestone2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {

        HttpURLConnection request = null;
        String inputLine = "";

        try {
            String myURL = "http://creative.colorado.edu/~furo0108/iCARE/iCAREscript.php";
            URL url = new URL(myURL);

            request = (HttpURLConnection) url.openConnection();

            //To post output request
            request.setDoOutput(true);
            request.setRequestMethod("POST");
            request.setRequestProperty("message", "text/plain");

            String input = "I am ok";

            OutputStream outputPost = new BufferedOutputStream(request.getOutputStream());
            outputPost.write(input.getBytes());
            outputPost.flush();
            outputPost.close();

            request.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));

            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        }

        catch (Exception ex) {
        }

        finally {
            if (request != null) {
                request.disconnect();
            }
        }

        TextView displayMessage = (TextView) findViewById(R.id.textView2);
        displayMessage.setText(inputLine);

    }
}


