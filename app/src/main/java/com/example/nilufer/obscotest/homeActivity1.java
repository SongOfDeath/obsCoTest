package com.example.nilufer.obscotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class homeActivity1 extends AppCompatActivity {
// MAHIR
private Button profilButton;
private Button gruplarimButton;

    public void InitializeProfilButton()
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
                String testString = "AAAAAAAATest";
                Toast.makeText(homeActivity1.this, testString, Toast.LENGTH_LONG).show();

                //Open new page
                Intent intent = new Intent("android.intent.action.HOME");
                startActivity(intent);
            }
        });
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

        InitializeProfilButton();
        InitializeGruplarimButton();
    }
}
