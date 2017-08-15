package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class lp_motorcycle_upto350 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp_motorcycle_upto350);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Motorcycle Liability Policy");

        findViewById(R.id.homebtnupto350).setOnClickListener(listener_homebtnupto350);
    }

    View.OnClickListener listener_homebtnupto350 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(lp_motorcycle_upto350.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
