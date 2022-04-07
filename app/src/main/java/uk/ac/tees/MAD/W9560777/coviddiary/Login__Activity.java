package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login__Activity extends AppCompatActivity {

    Button register_buttonl;
    Button login_btnl;
    TextView forget_Passwordl;
    EditText email_text;
    EditText password;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forget_Passwordl = findViewById(R.id.forget_Passwordl);
        login_btnl = findViewById(R.id.login_btnl);
        register_buttonl = findViewById(R.id.register_buttonl);
        email_text = findViewById(R.id.email_text);
        password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();

        forget_Passwordl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login__Activity.this, Forgot_Passcode.class);
                startActivity(intent);
            }
        });

        login_btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signInWithEmailAndPassword(email_text.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(Login__Activity.this, "Successful User Log-In..", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login__Activity.this, Intro_2.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(Login__Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        register_buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login__Activity.this, Register.class);
                startActivity(intent);
            }
        });


        if(auth.getCurrentUser()!= null)
        {
            Intent intent = new Intent(Login__Activity.this, Intro_2.class);
            startActivity(intent);
        }


    }
}