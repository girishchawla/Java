package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class pt_car_upto1000 extends AppCompatActivity {

    private static final String TAG = "pt_car_upto1000";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pt_car_upto1000);
        getSupportActionBar().setTitle("Car Policy Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        findViewById(R.id.car_upto1000_pp).setOnClickListener(listener_car_upto1000_pp);
        findViewById(R.id.car_upto1000_lp).setOnClickListener(listener_car_upto1000_lp);
    };


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    View.OnClickListener listener_car_upto1000_pp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(pt_car_upto1000.this, pp_car_upto1000.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_car_upto1000_lp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(pt_car_upto1000.this, lp_car_upto1000.class);
            startActivity(intent);
        }
    };

}
