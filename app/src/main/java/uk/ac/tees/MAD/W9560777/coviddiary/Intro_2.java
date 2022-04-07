package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Intro_2 extends AppCompatActivity {
    ImageView weather;
    ImageView news;
    TextView logout;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        weather = findViewById(R.id.weather1);
        news = findViewById(R.id.news1);
        logout = findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(Intro_2.this, "Successfully Logged Out!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intro_2.this, Login__Activity.class);
                startActivity(i);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro_2.this, MainActivity_Weather.class);
                startActivity(intent);
            }
        });


        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}