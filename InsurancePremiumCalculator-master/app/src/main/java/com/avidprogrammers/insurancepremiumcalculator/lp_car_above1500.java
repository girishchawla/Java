package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class lp_car_above1500 extends AppCompatActivity implements View.OnClickListener {


    Button lp_car_above1500btn;

    EditText lp_car_above1500_act;
    EditText lp_car_above1500_paod;
    EditText lp_car_above1500_ll;
    EditText lp_car_above1500_tax;

    RadioGroup lp_car_above1500_lpgkit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp_car_above1500);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Car Liability Policy");

        findViewById(R.id.lp_car_above1500btn).setOnClickListener(listener_lp_car_above1500btn);


        //start-passthevalues
        //Get the ids of view objects
        findAllViewsId();

        lp_car_above1500btn.setOnClickListener(this);
        //stop-passthevalues



    }

    View.OnClickListener listener_lp_car_above1500btn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(lp_car_above1500.this, lpdisplay_car_above1500.class);
            startActivity(intent);
        }

    };



    //start-passthevalues
    private void findAllViewsId() {
        lp_car_above1500btn = (Button) findViewById(R.id.lp_car_above1500btn);

        lp_car_above1500_act = (EditText) findViewById(R.id.lp_car_above1500_act);
        lp_car_above1500_paod = (EditText) findViewById(R.id.lp_car_above1500_paod);
        lp_car_above1500_ll = (EditText) findViewById(R.id.lp_car_above1500_ll);
        lp_car_above1500_tax = (EditText) findViewById(R.id.lp_car_above1500_tax);

        lp_car_above1500_lpgkit = (RadioGroup) findViewById(R.id.lp_car_above1500_lpgkit);

    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), lpdisplay_car_above1500.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("lp_car_above1500_act", lp_car_above1500_act.getText().toString());
        b.putString("lp_car_above1500_paod", lp_car_above1500_paod.getText().toString());
        b.putString("lp_car_above1500_ll", lp_car_above1500_ll.getText().toString());
        b.putString("lp_car_above1500_tax", lp_car_above1500_tax.getText().toString());


        int id1 = lp_car_above1500_lpgkit.getCheckedRadioButtonId();
        RadioButton radioButton1 = (RadioButton) findViewById(id1);
        b.putString("lp_car_above1500_lpgkit", radioButton1.getText().toString());


        //Add the bundle to the intent.
        intent.putExtras(b);

        //start the DisplayActivity
        startActivity(intent);
    }
    //stop-passthevalues


    //BackButton in title bar
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}