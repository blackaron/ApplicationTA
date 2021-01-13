package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnLogout;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        //fungsi logout
        btnLogout = findViewById(R.id.Logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent inToMAin = new Intent(HomeActivity.this, SignUpActivity.class);
                startActivity(inToMAin);
            }
        });

    }
}
