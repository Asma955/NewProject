package com.waddimakka.asma.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_SHORT;

public class SignInActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    Button btnSignIn;
    TextView resetPass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        auth = FirebaseAuth.getInstance();
        //Firebase auththentication instance
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignInActivity.this, FirstActivity.class));
            finish();
        }

        //view initlilaztion
        inputEmail = (EditText) findViewById(R.id.Adress_email);
        inputPassword = (EditText) findViewById(R.id.EPassword);
        btnSignIn = (Button) findViewById(R.id.SignInButton);
        resetPass = (TextView) findViewById(R.id.resetPass);

        //if user forget password


        //sign In
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get user inputs
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                //checking user inputs, if it is empty or not and return response
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email Adderss !", LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", LENGTH_SHORT).show();
                    return;
                }

                //Sign In to user account using email and password ,
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError("your password is too short");
                                    } else {
                                        Toast.makeText(SignInActivity.this, "Authenticaion faild ", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(SignInActivity.this, FirstActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
