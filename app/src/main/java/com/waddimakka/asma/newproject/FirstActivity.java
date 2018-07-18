package com.waddimakka.asma.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button SignUpButton = (Button) findViewById(R.id.Signupbutton);
        Button SignInButton = (Button) findViewById(R.id.Signinbutton);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(FirstActivity.this, SignInActivity.class));
            }
        });


        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(FirstActivity.this, SignInActivity.class));
            }
        });
    }
}
