package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Passcode extends AppCompatActivity {

    Button button_rst;
    ImageView back_forgot;
    TextView emailAddress;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passcode);

        back_forgot = findViewById(R.id.back_forgot);
        button_rst = findViewById(R.id.button_rst);
        emailAddress = findViewById(R.id.emailAddress);

        back_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Forgot_Passcode.this, Login__Activity.class);
                startActivity(i);
            }
        });

        auth = FirebaseAuth.getInstance();

        button_rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPasscode();
                emailAddress.setText("");

            }
        });

    }
    private void resetPasscode(){
        String emailText = emailAddress.getText().toString().trim();
        if (emailText.isEmpty()){
            emailAddress.setError("Email is Required!");
            emailAddress.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            emailAddress.setError("Please Provide Valid Email!");
            emailAddress.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(emailText).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                Toast.makeText(Forgot_Passcode.this, "Check the above entered Email Id to Reset your Password.", Toast.LENGTH_LONG).show();
            }else {
                    Toast.makeText(Forgot_Passcode.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}