package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button Login,Signup;
    RelativeLayout Rellayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= findViewById(R.id.user);
        password= findViewById(R.id.pass);
        Login=findViewById(R.id.Login);
        Signup=findViewById(R.id.SignUp);
        Rellayout=findViewById(R.id.Rellayout);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.trim().isEmpty())
                {

                    Snackbar snack=Snackbar.make(Rellayout,"Please Enter username",Snackbar.LENGTH_SHORT);
                    View svView =snack.getView();
                    svView.setBackgroundColor(Color.BLUE);
                    TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textview.setTextColor(Color.YELLOW);
                    textview.setAllCaps(true);
                    snack.show();

                }
                else if(user.length() < 5)
                {
                    Toast.makeText(getApplicationContext(),"Username is too short min length required is 5 ",Toast.LENGTH_SHORT).show();

                }
                else if(pass.trim().isEmpty())
                {
                    Snackbar snack=Snackbar.make(Rellayout,"Please Enter Passowrd",Snackbar.LENGTH_SHORT);
                    View svView =snack.getView();
                    svView.setBackgroundColor(Color.BLUE);
                    TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textview.setTextColor(Color.YELLOW);
                    textview.setAllCaps(true);
                    snack.show();


                }
                else if(pass.length()<5)
                {
                    Toast.makeText(getApplicationContext(),"Password can't less then 5",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Welcome Mr "+user,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                    Intent i= new Intent(getApplicationContext(),restraunt.class);
                    i.putExtra("user", user);
                    i.putExtra("pass",pass);
                    startActivity(i);

                }
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(getApplicationContext(),Signup.class);
                startActivity(i2);

            }
        });

    }
}