package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class lpdisplay_car_upto1500 extends AppCompatActivity {
    int lp_act_value,lp_paod_value,lp_ll_value,lp_tax_value;
    int lp_lgkit_assumevalue;
    double total_premium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lpdisplay_car_upto1500);


        Bundle b = getIntent().getExtras();
        TextView lp_car_upto1500_act = (TextView) findViewById(R.id.lpdisplay_car_upto1500_act_value);
        TextView lp_car_upto1500_paod = (TextView) findViewById(R.id.lpdisplay_car_upto1500_paod_value);
        TextView lp_car_upto1500_ll = (TextView) findViewById(R.id.lpdisplay_car_upto1500_ll_value);
        TextView lp_car_upto1500_tax = (TextView) findViewById(R.id.lpdisplay_car_upto1500_tax_value);

        TextView lp_car_upto1500_lpgkit = (TextView) findViewById(R.id.lpdisplay_car_upto1500_lpgkit_value);
        TextView lp_car_upto1500_total = (TextView) findViewById(R.id.lpdisplay_car_upto1500_total_value);


        lp_car_upto1500_act.setText(b.getCharSequence("lp_car_upto1500_act"));
        lp_car_upto1500_paod.setText(b.getCharSequence("lp_car_upto1500_paod"));
        lp_car_upto1500_ll.setText(b.getCharSequence("lp_car_upto1500_ll"));
        lp_car_upto1500_tax.setText(b.getCharSequence("lp_car_upto1500_tax"));

        lp_car_upto1500_lpgkit.setText(b.getCharSequence("lp_car_upto1500_lpgkit"));



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Car - Upto 1500cc Liability Policy");

        String radio_button_value=b.getString("lp_car_upto1500_lpgkit");
        String yes=new String("Yes");

        //Setting LPGkit values for radiobutton selected
        if(radio_button_value.equals(yes)){
            lp_lgkit_assumevalue=60;


        }
        else{
            lp_lgkit_assumevalue=0;
        }
        //Getting values from extras and converting into Integer values
        lp_act_value= Integer.valueOf(b.getString("lp_car_upto1500_act"));
        lp_paod_value= Integer.valueOf(b.getString("lp_car_upto1500_paod"));
        lp_ll_value= Integer.valueOf(b.getString("lp_car_upto1500_ll"));
        lp_tax_value= Integer.valueOf(b.getString("lp_car_upto1500_tax"));

        //Calculation of Total by adding LG Kit Value of 60 if Yes 0 if No
        double total=lp_act_value+lp_paod_value+lp_ll_value+lp_lgkit_assumevalue;
        total_premium = total+total*lp_tax_value/100;

        //rounding of total_premium value
        double round_value=total_premium;
        float rounded_total_premium=new Float(Math.round(round_value));
        int rounded_total_premium_int = (int) rounded_total_premium;
        lp_car_upto1500_total.setText(String.valueOf(rounded_total_premium_int));



        findViewById(R.id.lpdisplay_car_upto1500_home).setOnClickListener(listener_lpdisplay_car_upto1500_home);
    }


    View.OnClickListener listener_lpdisplay_car_upto1500_home = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(lpdisplay_car_upto1500.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
