package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity_Finder_City extends AppCompatActivity {

    private ImageView back_btn;
    private EditText city_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_finder_city);

        back_btn =findViewById(R.id.back_btn);
        city_search = findViewById(R.id.city_search);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        city_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int action, KeyEvent keyEvent) {
                String cityNew = city_search.getText().toString();
                Intent i = new Intent(MainActivity_Finder_City.this, MainActivity_Weather.class);
                i.putExtra("city", cityNew);
                startActivity(i);
                return false;
            }
        });



    }
}