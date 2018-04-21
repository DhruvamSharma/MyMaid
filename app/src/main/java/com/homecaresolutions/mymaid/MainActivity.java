package com.homecaresolutions.mymaid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.homecaresolutions.mymaid.activity.HomeActivity;
import com.homecaresolutions.mymaid.activity.SignInActivity;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
        }
        else {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        setContentView(R.layout.activity_main);


    }
}
