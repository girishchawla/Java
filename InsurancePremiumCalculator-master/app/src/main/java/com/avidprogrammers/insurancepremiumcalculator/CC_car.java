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

public class CC_car extends AppCompatActivity {

    private static final String TAG = "CC_car";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cc_car);
        getSupportActionBar().setTitle("Private Car");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        findViewById(R.id.car_upto1000).setOnClickListener(listener_car_upto1000);
        findViewById(R.id.car_upto1500).setOnClickListener(listener_car_upto1500);
        findViewById(R.id.car_above1500).setOnClickListener(listener_car_above1500);

    };

    View.OnClickListener listener_car_upto1000 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_car.this, pt_car_upto1000.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_car_upto1500 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_car.this, pt_car_upto1500.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_car_above1500 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_car.this, pt_car_above1500.class);
            startActivity(intent);
        }
    };


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
