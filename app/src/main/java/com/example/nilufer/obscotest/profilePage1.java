package com.example.nilufer.obscotest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class profilePage1 extends AppCompatActivity {
// MAHIR
    String age;
    String email;
    String id;
    String name;
    String password;
    String title;
    boolean isSuperuser;

    private class ConnectionTest extends AsyncTask {
        @Override
        protected Object doInBackground(Object... arg0) {

            try{
                System.out.println("Testing 1 - Send Http GET request");
                sendGet();

            } catch (Exception e) {
                System.err.println("Oops!");
                e.printStackTrace();
            }
            return null;
        }
    }

    private void sendGet() throws Exception {

        System.out.println("DEBUG POINT 1: ");
        String url = "http://obsco.me/obsco/api/v1.0/users/12345671"; //"http://127.0.0.1:5000/obsco/api/v1.0/users";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println("DEBUG POINT 2: ");
        // optional default is GET
        con.setRequestMethod("GET");
        System.out.println("DEBUG POINT 3: ");
        //add request header
        //con.setRequestProperty("User-Agent",);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("DEBUG POINT 4: ");
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        int cntTest1 = 0;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            cntTest1++;
            System.out.println(cntTest1);
        }
        in.close();

        //print result
        System.out.println("RESPONSE: ");
        System.out.println(response.toString());

        JSONObject reader = new JSONObject(response.toString());

        JSONObject userJSON  = reader.getJSONObject("user");
        age = userJSON.getString("age");
        email = userJSON.getString("email");
        id = userJSON.getString("id");
        name = userJSON.getString("name");
        password = userJSON.getString("password");
        title = userJSON.getString("title");
        System.out.println("AGE: ");
        System.out.println(age);

        addUserTraits();
    }

    public TextView makeTextView(String s)
    {
        final TextView nameTextView = new TextView(this);
        nameTextView.setText(s);
        nameTextView.setBackgroundColor( Color.argb(255,255,255,255) );
        nameTextView.setTextAppearance(this, R.style.Widget_AppCompat_Button_Borderless);
        nameTextView.setGravity(Gravity.CENTER);
        nameTextView.setMinimumHeight(175);
        nameTextView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return nameTextView;
    }
    public void addUserTraits()
    {
        LinearLayout ll = (LinearLayout)findViewById(R.id.texts_layout);
        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //ll.addView(myButton, lp);

        ll.addView(makeTextView("name: "+name));
        ll.addView(makeTextView("email: "+email));
        ll.addView(makeTextView("age: "+age));
        ll.addView(makeTextView("title: "+title));

        /*
        final int N = 5; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++)
        {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText("Personel teknik yetenek #" + i);


            Random rnd = new Random();
            int randomColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            rowTextView.setBackgroundColor( Color.argb(255,255,255,255) );
            rowTextView.setTextAppearance(this, R.style.Widget_AppCompat_Button_Borderless);
            rowTextView.setGravity(Gravity.CENTER);
            rowTextView.setMinimumHeight(175);


            //if we already have layout params
            //ViewGroup.LayoutParams params = rowTextView.getLayoutParams();
            //params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //rowTextView.setLayoutParams(params);

            // add the textview to the linearlayout
            rowTextView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
        */
    }

    public void makeProfilePicCircular()
    {
        ImageView profilePic=(ImageView)findViewById(R.id.profile_pic);

//get bitmap of the image
        Bitmap imageBitmap= BitmapFactory.decodeResource(getResources(),  R.drawable.bertcase);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);

//setting radius
        //roundedBitmapDrawable.setCornerRadius(50.0f);
        roundedBitmapDrawable.setCircular(true);
        roundedBitmapDrawable.setAntiAlias(true);
        profilePic.setImageDrawable(roundedBitmapDrawable);
    }
// MAHIR






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page1);

        makeProfilePicCircular();
        new ConnectionTest().execute("");
        //addUserTraits();
    }
}
