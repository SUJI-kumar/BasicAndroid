package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public  class restraunt extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button login,generate,clear;
    TextView price, price2, price3, price4, price5, price6,fb,bill;
    String[] mood = {"0","1", "2", "3", "4", "5"};
    Spinner spin, spin2,spin3, spin4,spin5;
    Integer result=0, a, b, c, d, e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restraunt);
        price = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);
        price6 = findViewById(R.id.price6);
        generate=findViewById(R.id.genrate);
        clear=findViewById(R.id.clear);
        bill=findViewById(R.id.bill);
        fb=findViewById(R.id.fb);
        Intent intent =getIntent();
        final String addition= (String)intent.getSerializableExtra("user");
        final String pass= (String)intent.getSerializableExtra("pass");
        final String admin= (String)intent.getSerializableExtra("Admin_name");
        final String admin_pass= (String)intent.getSerializableExtra("Admin_pass");
        if(addition.equals(admin)&&pass.equals(admin_pass))
        {
            fb.setText("Welcome Admin"+"\n Good to See you");

        }else
        {
            fb.setText("Welcome "+addition+"\n what would you like to order");
        }

        login = findViewById(R.id.login);
        spin2=(Spinner) findViewById(R.id.rate2);
        final ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mood);
        aa1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin2.setAdapter(aa1);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l)
            {
                b = Integer.parseInt(mood[i]) * 90;
                Toast.makeText(getApplicationContext(), "Amount:" + Integer.parseInt(mood[i]) * 90, Toast.LENGTH_LONG).show();
                price2.setText("$" + b);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        spin3=(Spinner) findViewById(R.id.rate3);
        final ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mood);
        aa2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin3.setAdapter(aa2);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l)
            {
                c = Integer.parseInt(mood[i]) * 90;
                Toast.makeText(getApplicationContext(), "Amount:" + Integer.parseInt(mood[i]) * 90, Toast.LENGTH_LONG).show();
                price3.setText("$" + c);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        spin4=(Spinner) findViewById(R.id.rate4);
        final ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mood);
        aa3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin4.setAdapter(aa3);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l)
            {
                d = Integer.parseInt(mood[i]) * 90;
                Toast.makeText(getApplicationContext(), "Amount:" + Integer.parseInt(mood[i]) * 90, Toast.LENGTH_LONG).show();
                price4.setText("$" + d);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        spin5=(Spinner) findViewById(R.id.rate5);
        final ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mood);
        aa4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin5.setAdapter(aa3);
        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l)
            {
                e = Integer.parseInt(mood[i]) * 90;
                Toast.makeText(getApplicationContext(), "Amount:" + Integer.parseInt(mood[i]) * 90, Toast.LENGTH_LONG).show();
                price5.setText("$" + e);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });


        spin = (Spinner) findViewById(R.id.rate1);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        final ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mood);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=a+b+c+d+e;

                Toast.makeText(getApplicationContext(), "Bill:" +result, Toast.LENGTH_SHORT).show();
                price6.setText("$ "+ result);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result == 0)
                {
                    Toast.makeText(getApplicationContext(),"First Order something",Toast.LENGTH_SHORT).show();

                }else {
                    DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                    Calendar obj = Calendar.getInstance();
                    bill.setBackgroundColor(Color.WHITE);
                    bill.setText("PLAZA RESTAURANT\n" + "Date:" + dform.format(obj.getTime()) + "\nCustomer name:" + addition + "\nTotal Amount:" + result);
                    clear.setText("Clear");
                    clear.setAlpha(1);
                    clear.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bill.setText(" ");
                            bill.setBackgroundColor(Color.TRANSPARENT);
                            clear.setAlpha(0);
                        }
                    });
                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        a = Integer.parseInt(mood[i]) * 90;
        Toast.makeText(getApplicationContext(), "Amount:" + Integer.parseInt(mood[i]) * 90, Toast.LENGTH_LONG).show();
        price.setText("$" + a);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
