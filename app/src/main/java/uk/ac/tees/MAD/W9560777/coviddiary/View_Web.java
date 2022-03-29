package uk.ac.tees.MAD.W9560777.coviddiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class View_Web extends AppCompatActivity {

    WebView web_View;
    ImageView back;
    Toolbar tool_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_web);
        tool_bar = findViewById(R.id.toolbar);
        web_View = findViewById(R.id.view_web);
        setSupportActionBar(tool_bar);
        back = findViewById(R.id.back);


        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        web_View.setWebViewClient(new WebViewClient());
        web_View.loadUrl(url);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(View_Web.this, MainActivity.class));
                finish();
            }
        });
    }
}