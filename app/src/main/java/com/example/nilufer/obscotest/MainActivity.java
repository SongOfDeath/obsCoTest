package com.example.nilufer.obscotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
private EditText passwordFieldInput, usernameFieldInput;
private ImageButton loginButton;

public void LoginButton()
{
        usernameFieldInput = (EditText)findViewById(R.id.editText1);
        passwordFieldInput = (EditText)findViewById(R.id.password1);
        loginButton = (ImageButton)findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener()
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
                        Toast.makeText(MainActivity.this, testString, Toast.LENGTH_LONG).show();

                        //Open new page
                        Intent intent = new Intent("android.intent.action.HOME");
                        startActivity(intent);
                }
        });
}

@Override
protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();

        }

}