/*The purpose of this app is to obtain information from a server to display a message.
* The user will then be able to act on the message by pressing two buttons.
* The pressing of the two buttons will send data back to a google Spreadsheet.
*
* References:
* http://www.wikihow.com/Execute-HTTP-POST-Requests-in-Android
* https://developer.android.com/reference/java/net/HttpURLConnection.html
* */

package com.example.programmingpenguin.icaremilestone2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void obtainServerInfo() {

        //try to access server
        try{
            URL url = new URL("http://creative.colorado.edu/~beardn/example.php");
            HttpURLConnection info = (HttpURLConnection) url.openConnection();


            //To post output request and handle exceptions
            info.setRequestMethod("POST");
            info.setRequestProperty("Key","Value"); //how do you know key/value
            info.setDoOutput(true);

            //Once connected, use getInputStream (https://developer.android.com/reference/java/net/URLConnection.html#getInputStream())
            //to get data from server - set this data to be displayed at label
        }

        //handles incorrectly entered URL
        catch(MalformedURLException error){ //is this needed?

        }
        //handles URL access timeout
        catch(SocketTimeoutException error){

        }
        //handles input and output errors
        catch(IOException error){

        }

        finally {
            if(info != null){
                info.disconnect();
            }
        }

        //To display message
        TextView displayMessage = (TextView) findViewById(R.id.textView2);
        displayMessage.setText("message obtained from server");

    }

    public void pleaseWait(View view){
        //If the red button is clicked - then the message of "please wait" will be sent

        /*
        Modify the code below to deal with uploading message information to server

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            writeStream(out);

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } finally {
            urlConnection.disconnect();*/
        }
    }

    public void onMyWay(View view){
        //If the green button is clicked - then the message of "on my way" will be sent and stored in google spreadsheet
    }

}


