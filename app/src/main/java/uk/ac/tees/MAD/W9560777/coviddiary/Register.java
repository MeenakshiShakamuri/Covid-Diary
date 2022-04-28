package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    Button login_button;
    Button register_btn2;
    EditText nametext;
    EditText email_text;
    EditText password;
    private FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login_button = findViewById(R.id.login_button);
        register_btn2 = findViewById(R.id.register_btn2);

        nametext = findViewById(R.id.nametext);
        email_text = findViewById(R.id.email_text);
        password = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login__Activity.class);
                startActivity(intent);
            }
        });

        register_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(nametext.getText().toString()))
                {
                    nametext.setError("Please Enter Name: ");
                    return;
                }
                else if (TextUtils.isEmpty(email_text.getText().toString()))
                {
                    email_text.setError("Please Enter Email: ");
                    return;
                }
                else if (TextUtils.isEmpty(password.getText().toString()))
                {
                    password.setError("Please Enter password: ");
                    return;
                }
                else {
                    auth.createUserWithEmailAndPassword(email_text.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Register_data_user register_data_user = new Register_data_user(nametext.getText().toString(), email_text.getText().toString(), password.getText().toString());
                            String uid = task.getResult().getUser().getUid();
                            database.getReference().child("User's Data").child(uid).setValue(register_data_user);

                            Toast.makeText(Register.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            nametext.setText("");
                            email_text.setText("");
                            password.setText("");
                            Intent intent = new Intent(Register.this, Login__Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }}
        });
    }

}