package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class ppdisplay_motorcycle_upto350 extends AppCompatActivity {

    long diffInDays;
    double dop_value;
    int pp_lgkit_assumevalue,pp_scpass_value,pp_pa_pass_value;
    float rounded_dop_value;
    int pp_tax_value=15;
    float value_nd;
    float rounded_lgptype_value;
    float rounded_value_nd,rounded_value_antitheft,rounded_uw_value,rounded_ncb_value;
    double value_lgptype1,value_uw1,value_spin1;
    double value_lgptype2;
    double pp_total_premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppdisplay_motorcycle_upto350);


        Bundle b = getIntent().getExtras();
        TextView pp_motorcycle_upto350_IDV_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_IDV_value);
        TextView pp_motorcycle_upto350_date_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_date_value);
        TextView pp_motorcycle_upto350_zone_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_zone_value);
        TextView pp_motorcycle_upto350_cc_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_cc_value);
        TextView pp_motorcycle_upto350_nd_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_nd_value);
        TextView pp_motorcycle_upto350_uwd_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_uwd_value);
        TextView pp_motorcycle_upto350_ncb_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_ncb_value);
        TextView pp_motorcycle_upto350_od_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_od_value);
        TextView pp_motorcycle_upto350_ab_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_ab_value);
        TextView pp_motorcycle_upto350_b_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_b_value);
        TextView ppdisplay_motorcycle_upto350_total_value = (TextView) findViewById(R.id.ppdisplay_motorcycle_upto350_total_value);

        pp_motorcycle_upto350_IDV_value.setText(b.getCharSequence("pp_motorcycle_upto350_idv_value"));
        pp_motorcycle_upto350_date_value.setText(b.getCharSequence("pp_motorcycle_upto350_date_value"));
        pp_motorcycle_upto350_zone_value.setText(b.getCharSequence("pp_motorcycle_upto350_zone"));
        pp_motorcycle_upto350_cc_value.setText(b.getCharSequence("pp_motorcycle_upto350_cc_value"));
        pp_motorcycle_upto350_nd_value.setText(b.getCharSequence("pp_motorcycle_upto350_nd_value"));
        pp_motorcycle_upto350_uwd_value.setText(b.getCharSequence("pp_motorcycle_upto350_uwd_value"));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Motorcycle Package Policy");

        findViewById(R.id.ppdisplay_motorcycle_upto350_home).setOnClickListener(listener_ppdisplay_motorcycle_upto350_home);


        //Calculation
        String d1 = b.getString("pp_motorcycle_upto350_date_value").toString();
        String s = d1;
        int y = b.getInt("year");
        int m = b.getInt("month");
        int d = b.getInt("day");


        int old_day = d;
        int old_month = m;
        int old_year = y;

        int mYear;
        int mMonth;
        int mDay;
        // Create Calendar instance
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        mYear = calendar1.get(Calendar.YEAR);
        mMonth = calendar1.get(Calendar.MONTH);
        mDay = calendar1.get(Calendar.DAY_OF_MONTH);

        // Set the values for the calendar fields YEAR, MONTH, and DAY_OF_MONTH.
        calendar1.set(mYear, mMonth, mDay);
        calendar2.set(old_year, old_month, old_day);

            /*
            * Use getTimeInMillis() method to get the Calendar's time value in
            * milliseconds. This method returns the current time as UTC
            * milliseconds from the epoch
            */
        long miliSecondForDate1 = calendar1.getTimeInMillis();
        long miliSecondForDate2 = calendar2.getTimeInMillis();

        // Calculate the difference in millisecond between two dates
        long diffInMilis = miliSecondForDate1 - miliSecondForDate2;

             /*
              * Now we have difference between two date in form of millsecond we can
              * easily convert it Minute / Hour / Days by dividing the difference
              * with appropriate value. 1 Second : 1000 milisecond 1 Hour : 60 * 1000
              * millisecond 1 Day : 24 * 60 * 1000 milisecond
              */

        long diffInSecond = diffInMilis / 1000;
        long diffInMinute = diffInMilis / (60 * 1000);
        long diffInHour = diffInMilis / (60 * 60 * 1000);
        diffInDays = diffInMilis / (24 * 60 * 60 * 1000);


        //Calculation of Dop value

        if ((b.getString("pp_motorcycle_upto350_zone")).equals("A")) {
            if (diffInDays < 1825) {
                double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                dop_value = idv_value * 1.793 / 100;
                double round_value = dop_value;
                rounded_dop_value = new Float(Math.round(round_value));

            } else if (diffInDays >= 1825) {
                if (diffInDays < 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                    dop_value = idv_value * 1.883 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                } else if (diffInDays >= 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                    dop_value = idv_value * 1.928 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                }
            }
        } else if ((b.getString("pp_motorcycle_upto350_zone")).equals("B")) {
            if (diffInDays < 1825) {
                double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                dop_value = idv_value * 1.760 / 100;
                double round_value = dop_value;
                rounded_dop_value = new Float(Math.round(round_value));

            } else if (diffInDays >= 1825) {
                if (diffInDays < 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                    dop_value = idv_value * 1.848 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                } else if (diffInDays >= 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_idv_value"));
                    dop_value = idv_value * 1.892 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                }
            }

        }

        else {
            Toast.makeText(getApplicationContext(), "Please enter correct Date", Toast.LENGTH_SHORT).show();

        }
//Calculation of ND value
        double nd_value1 = 0;
        String x2 = "No";
        if ((b.getString("pp_motorcycle_upto350_nd")).equals(x2)) {

            rounded_value_nd = rounded_dop_value;

        } else {

            if (diffInDays < 365) {
                nd_value1 = 15;
            } else if (diffInDays >= 365) {
                if (diffInDays < 1825) {
                    nd_value1 = 25;
                } else if (diffInDays >= 1825) {
                    nd_value1 = 0;
                }
            }

            //  double nd_value1 = Integer.valueOf(b.getString("pp_motorcycle_upto75_nd_value"));
            double value_nd1 = (nd_value1) * rounded_dop_value / 100;
            double value_nd2 = rounded_dop_value + value_nd1;
            double value_nd3 = value_nd2;
            rounded_value_nd = new Float(Math.round(value_nd3));
        }
        int rounded_value_nd_int = (int) rounded_value_nd;
        if(nd_value1==0) {
            pp_motorcycle_upto350_nd_value.setText(String.valueOf("0"));
        }else {

            pp_motorcycle_upto350_nd_value.setText(b.getString("pp_motorcycle_upto350_nd_value"));
            //pp_motorcycle_upto150_nd_value.setText(String.valueOf(rounded_value_nd_int));
        }
        //Calculation of U/W discount
        double uw_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_uwd_value"));
        double val = ((uw_value) * rounded_value_nd) / 100;
        value_uw1 = rounded_value_nd - val;
        double value_uw2 = value_uw1;
        rounded_uw_value = new Float(Math.round(value_uw2));


        // Calculation of NCB
        double spinner_value = Integer.valueOf(b.getString("pp_motorcycle_upto350_spinner_value"));
        double spin_val = ((spinner_value) * rounded_uw_value) / 100;
        value_spin1 = rounded_uw_value - spin_val;
        double value_spin2 = value_spin1;
        rounded_ncb_value = new Float(Math.round(value_spin2));
        int rounded_ncb_value_int = (int) rounded_ncb_value;

        pp_motorcycle_upto350_ncb_value.setText(b.getString("pp_motorcycle_upto350_spinner_value"));
        //pp_motorcycle_upto150_ncb_value.setText(String.valueOf(rounded_ncb_value_int));

        pp_motorcycle_upto350_od_value.setText(String.valueOf(rounded_ncb_value_int));

        //Calculation of B part
        pp_total_premium = 693 + 50;


        double total=693+50;

        pp_total_premium = total;


        //rounding of total_premium value
        double round_value=pp_total_premium;
        float rounded_total_premium=new Float(Math.round(round_value));
        int rounded_total_premium_int = (int) rounded_total_premium;

        pp_motorcycle_upto350_b_value.setText(String.valueOf(rounded_total_premium_int));

        double total_ab=(double)rounded_total_premium+(double)rounded_ncb_value;
        int total_ab_int = (int) total_ab;
        pp_motorcycle_upto350_ab_value.setText(String.valueOf(total_ab_int));
        double total_plus_service_tax=total_ab+total_ab*15/100;
        double total_AB=total_plus_service_tax;
        float rounded_total_AB=new Float(Math.round(total_AB));
        int rounded_total_AB_int = (int) rounded_total_AB;
        ppdisplay_motorcycle_upto350_total_value.setText(String.valueOf(rounded_total_AB_int));


    }
    View.OnClickListener listener_ppdisplay_motorcycle_upto350_home = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ppdisplay_motorcycle_upto350.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
