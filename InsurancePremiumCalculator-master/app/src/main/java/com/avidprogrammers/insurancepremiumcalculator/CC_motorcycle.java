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

public class CC_motorcycle extends AppCompatActivity {

    private static final String TAG = "CC_motorcycle";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cc_motorcycle);
        getSupportActionBar().setTitle("Motorcycle");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        findViewById(R.id.upto75).setOnClickListener(listener_upto75);
        findViewById(R.id.upto150).setOnClickListener(listener_upto150);
        findViewById(R.id.upto350).setOnClickListener(listener_upto350);
        findViewById(R.id.above350).setOnClickListener(listener_above350);
    };

    View.OnClickListener listener_upto75 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_motorcycle.this, pt_motorcycle_upto75.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_upto150 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_motorcycle.this, pt_motorcycle_upto150.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_upto350 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_motorcycle.this, pt_motorcycle_upto350.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_above350 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CC_motorcycle.this, pt_motorcycle_350above.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
