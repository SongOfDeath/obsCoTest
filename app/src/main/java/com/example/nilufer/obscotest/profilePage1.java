package com.example.nilufer.obscotest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class profilePage1 extends AppCompatActivity {
// MAHIR
    public void addUserTraits()
    {
        LinearLayout ll = (LinearLayout)findViewById(R.id.texts_layout);
        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //ll.addView(myButton, lp);

        final int N = 5; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText("Personel yetenegi #" + i);


            Random rnd = new Random();
            int randomColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            rowTextView.setBackgroundColor( Color.argb(255,255,255,255) );
            rowTextView.setTextAppearance(this, R.style.Widget_AppCompat_Button_Borderless);
            rowTextView.setGravity(Gravity.CENTER);
            rowTextView.setMinimumHeight(175);

            /**
            //if we already have layout params
            ViewGroup.LayoutParams params = rowTextView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            rowTextView.setLayoutParams(params);
            */
            // add the textview to the linearlayout
            rowTextView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
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
        addUserTraits();
    }
}
