package com.example.nilufer.obscotest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            rowTextView.setText("This is row #" + i);
            rowTextView.setBackgroundColor( Color.parseColor("#4DC2FF") );
            // add the textview to the linearlayout
            ll.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
    }
// MAHIR






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page1);

        addUserTraits();
    }
}
