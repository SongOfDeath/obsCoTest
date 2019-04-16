package com.example.nilufer.obscotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class homeActivity1 extends AppCompatActivity {
// MAHIR
private Button profilButton;
private Button gruplarimButton;
static Socket socket = null;

    // HTTP GET request
    private void sendingGetRequest() throws Exception {

        String urlString = "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries";

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("Sending get request : "+ url);
        System.out.println("Response code : "+ responseCode);

        /**
        // Reading response from input Stream
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        //printing result from response
        System.out.println(response.toString());
        */
    }

    public void InitializeProfilButton() throws UnknownHostException, IOException
    {

        profilButton = (Button)findViewById(R.id.profilbutton);

        profilButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //FIND THIS FROM DATABASE
                //usernameFieldInput.getText().toString()
                //MATCH WITH PASSWORD
                //passwordFieldInput.getText().toString()

                /////Log.d("myTag", "This is my message");
                String testString = "profil button clicked";
                Toast.makeText(homeActivity1.this, testString, Toast.LENGTH_LONG).show();

                //Open new page
                Intent intent = new Intent("android.intent.action.PROFILEPAGE");
                startActivity(intent);
            }
        });

        //URL oracle = new URL("http://127.0.0.1:5000/"); //http://localhost:8080
        //URLConnection yc = oracle.openConnection();

        /**
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
         */
    }

    public void InitializeGruplarimButton()
    {
        profilButton = (Button)findViewById(R.id.gruplarimbutton);

        profilButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String testString = "Berkin sayfası açıldı";
                Toast.makeText(homeActivity1.this, testString, Toast.LENGTH_LONG).show();

                //Open new page
                Intent intent = new Intent("android.intent.action.HOME");
                startActivity(intent);
            }
        });
    }
// MAHIR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        try {
            InitializeProfilButton();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("PROFIL ERROR");
        }

        try {
            sendingGetRequest();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GET REQUEST ERROR");
        }

        InitializeGruplarimButton();
    }
}
