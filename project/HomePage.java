package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
Button report,alert,setting,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        report=(Button)findViewById(R.id.report);
        alert=(Button)findViewById(R.id.alert);
        setting=(Button)findViewById(R.id.settings);
        logout=(Button)findViewById(R.id.logout);

        report.setOnClickListener(this);
        alert.setOnClickListener(this);
        alert.setOnClickListener(this);
        alert.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        if(view==report)
        {

        }
        else if(view==alert)
        {

        }
        else if(view==setting)
        {

        }
        else if(view==logout)
        {
            Intent l=new Intent(HomePage.this,MainActivity.class);
            startActivity(l);

        }
    }
}
