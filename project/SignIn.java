package com.example.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignIn extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    EditText name, password, email, city;
    Button register;

    Spinner spin;
    String c;
    String[] category = {"Municipal", "NGO", "Doctor", "Others"};
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        name = (EditText) findViewById(R.id.editTextname);
        email = (EditText) findViewById(R.id.editTextemail);
        password = (EditText) findViewById(R.id.editTextpassword);
        city = (EditText) findViewById(R.id.editTextcity);
        register = (Button) findViewById(R.id.buttonSignup);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        postDataToSQLite();
    }
});

    }
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(),dept[position] , Toast.LENGTH_LONG).show();
        c = category[position];
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void initObjects() {


        user = new User();

    }
    private void postDataToSQLite() {

        if (!databaseHelper.checkUser(email.getText().toString().trim())) {

            user.setName(name.getText().toString().trim());
            user.setEmail(email.getText().toString().trim());
            user.setPassword(password.getText().toString().trim());
            user.setCity(city.getText().toString().trim());
            user.setCategory(c.toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully


        }


    }

    /**
     * This method is to empty all input edit text
     */




}
