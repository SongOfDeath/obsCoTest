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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class profilePage2 extends AppCompatActivity {
    // MAHIR
    String idFromGroupPage;
    String groupIdFromGroupPage;
    String age;
    String email;
    String id;
    String name;
    String password;
    String title;
    JSONArray skillsContainingArray;
    boolean isSuperuser;

    private class ConnectionTest extends AsyncTask {
        @Override
        protected Object doInBackground(Object... arg0) {

            try{
                System.out.println("Testing 1 - Send Http GET request");
                getReputation();
                //sendGet();
                sendTest();

            } catch (Exception e) {
                System.err.println("Oops!");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {

            LinearLayout ll = (LinearLayout)findViewById(R.id.texts_layout);
            ll.addView(makeTextView("email: "+email));
            for (int i=0; i<skillsContainingArray.length(); i++)
            {
                String skillName;
                int skillLevel;
                try {
                    JSONObject testObject = (JSONObject) skillsContainingArray.get(i);
                    skillName = testObject.getString("name");//skillsArray.getString(i);
                    skillLevel = testObject.getInt("value");
                    ll.addView( addSkillLayout(skillName + skillLevel) );
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            //addUserTraits();
            //Show the result obtained from doInBackground
        }

    }

    private void sendTest() throws Exception {

        System.out.println("DEBUG POINT 1: ");
        //String url = "http://obsco.me/obsco/api/v1.0/skills/addskill/dogancan"; //"http://127.0.0.1:5000/obsco/api/v1.0/users";
        //String url = "http://obsco.me/obsco/api/v1.0/addskill/androiddev";
        String url = "http://obsco.me/obsco/api/v1.0/skills/21400537";

        //String url = "http://obsco.me/obsco/api/v1.0/reputation/12345671";
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

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println("RESPONSE: ");
        System.out.println(response.toString());

        JSONObject reader = new JSONObject(response.toString());

        skillsContainingArray = reader.getJSONArray("skills");
        JSONObject skillJSON  = (JSONObject)skillsContainingArray.get(1);
        System.out.println(skillJSON.getString("name"));
        System.out.println("DEB1: ");



        //skillsArray = (JSONArray) userJSON.get("skills");
        //System.out.println("LENGTHXD: ");
        //System.out.println(skillsArray.length());
    }

    private void sendGet() throws Exception {

        System.out.println("DEBUG POINT 1: ");
        String url = "http://obsco.me/obsco/api/v1.0/users/12345671"; //"http://127.0.0.1:5000/obsco/api/v1.0/users";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        //con.setRequestProperty("User-Agent",);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        in.close();

        //print result
        System.out.println("RESPONSE: ");
        System.out.println(response.toString());

        JSONObject reader = new JSONObject(response.toString());

        //JSONObject userJSON  = reader.getJSONObject("users");
        JSONArray allContainingArray = reader.getJSONArray("users");
        JSONObject userJSON  = (JSONObject)allContainingArray.get(0);// reader.getJSONObject("users");


    }

    private void getReputation() throws Exception {

        String url = "http://obsco.me/obsco/api/v1.0/reputation/"; //"http://127.0.0.1:5000/obsco/api/v1.0/users";
        id = "12345671";
        url = url + id;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();

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
        Double reputationValue = reader.getDouble("reputation");
        TextView reputationText = (TextView) findViewById(R.id.second_trait);
        reputationText.setText(reputationValue.toString());
    }

    public LinearLayout addSkillLayout(String s)
    {
        final LinearLayout newLayout = new LinearLayout(this);
        newLayout.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        newLayout.setOrientation(LinearLayout.HORIZONTAL);
        newLayout.addView( makeTextView(s) );
        //newLayout.addView( makeTextView("! ! ! ! ! ! ! ! ! !"));
        return newLayout;
    }

    public TextView makeTextView(String s)
    {
        final TextView nameTextView = new TextView(this);
        nameTextView.setText(s);
        nameTextView.setBackgroundColor( Color.argb(255,255,255,255) );
        nameTextView.setTextAppearance(this, R.style.Widget_AppCompat_Button_Borderless);
        nameTextView.setGravity(Gravity.CENTER);
        nameTextView.setMinimumHeight(175);
        //nameTextView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return nameTextView;
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

        /////
        id = getIntent().getStringExtra("ID_FROM_LOGIN");

        makeProfilePicCircular();
        new ConnectionTest().execute("");
        //addUserTraits();
    }
}
