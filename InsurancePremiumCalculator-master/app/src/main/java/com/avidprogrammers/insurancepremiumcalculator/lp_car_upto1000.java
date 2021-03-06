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

public class lp_car_upto1000 extends AppCompatActivity implements View.OnClickListener {


    Button lp_car_upto1000btn;

    EditText lp_car_upto1000_act;
    EditText lp_car_upto1000_paod;
    EditText lp_car_upto1000_ll;
    EditText lp_car_upto1000_tax;

    RadioGroup lp_car_upto1000_lpgkit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp_car_upto1000);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Car Liability Policy");

        findViewById(R.id.lp_car_upto1000btn).setOnClickListener(listener_lp_car_upto1000btn);


        //start-passthevalues
        //Get the ids of view objects
        findAllViewsId();

        lp_car_upto1000btn.setOnClickListener(this);
        //stop-passthevalues



    }

    View.OnClickListener listener_lp_car_upto1000btn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(lp_car_upto1000.this, lpdisplay_car_upto1000.class);
            startActivity(intent);
        }

    };



    //start-passthevalues
    private void findAllViewsId() {
        lp_car_upto1000btn = (Button) findViewById(R.id.lp_car_upto1000btn);

        lp_car_upto1000_act = (EditText) findViewById(R.id.lp_car_upto1000_act);
        lp_car_upto1000_paod = (EditText) findViewById(R.id.lp_car_upto1000_paod);
        lp_car_upto1000_ll = (EditText) findViewById(R.id.lp_car_upto1000_ll);
        lp_car_upto1000_tax = (EditText) findViewById(R.id.lp_car_upto1000_tax);

        lp_car_upto1000_lpgkit = (RadioGroup) findViewById(R.id.lp_car_upto1000_lpgkit);

    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), lpdisplay_car_upto1000.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("lp_car_upto1000_act", lp_car_upto1000_act.getText().toString());
        b.putString("lp_car_upto1000_paod", lp_car_upto1000_paod.getText().toString());
        b.putString("lp_car_upto1000_ll", lp_car_upto1000_ll.getText().toString());
        b.putString("lp_car_upto1000_tax", lp_car_upto1000_tax.getText().toString());


        int id1 = lp_car_upto1000_lpgkit.getCheckedRadioButtonId();
        RadioButton radioButton1 = (RadioButton) findViewById(id1);
        b.putString("lp_car_upto1000_lpgkit", radioButton1.getText().toString());


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