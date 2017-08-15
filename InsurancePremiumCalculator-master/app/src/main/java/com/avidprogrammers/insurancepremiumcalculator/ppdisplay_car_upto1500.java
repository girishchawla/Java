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

public class ppdisplay_car_upto1500 extends AppCompatActivity {

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
        setContentView(R.layout.ppdisplay_car_upto1500);


        Bundle b = getIntent().getExtras();
        TextView pp_car_upto1500_IDV_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_IDV_value);
        TextView pp_car_upto1500_date_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_date_value);
        TextView pp_car_upto1500_zone = (TextView) findViewById(R.id.ppdisplay_car_upto1500_zone_value);
        TextView pp_car_upto1500_cc_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_cc_value);
        TextView pp_car_upto1500_nd_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_nd_value);
        TextView pp_car_upto1500_uwd_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_uwd_value);
        TextView pp_car_upto1500_ncb_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_ncb_value);
        TextView pp_car_upto1500_lpg_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_lpg_value);
        TextView pp_car_upto1500_lpgtype_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_lpgtype_value);
        TextView pp_car_upto1500_antitheft = (TextView) findViewById(R.id.ppdisplay_car_upto1500_antitheft_value);

        TextView pp_car_upto1500_od_value = (TextView) findViewById(R.id.ppdisplay_car_upto1500_od_value);
        TextView pp_car_upto1500_value_b = (TextView) findViewById(R.id.ppdisplay_car_upto1500_b_value);
        TextView ppdisplay_car_upto1500_ab_value= (TextView) findViewById(R.id.ppdisplay_car_upto1500_ab_value);
        TextView ppdisplay_car_upto1500_lpgkit_value= (TextView) findViewById(R.id.ppdisplay_car_upto1500_lpgkit_value);
        TextView ppdisplay_car_upto1500_pa_pass_value= (TextView) findViewById(R.id.ppdisplay_car_upto1500_pa_pass_value);
        TextView ppdisplay_car_upto1500_total_value  = (TextView) findViewById(R.id.ppdisplay_car_upto1500_total_value);


        pp_car_upto1500_IDV_value.setText(b.getCharSequence("pp_car_upto1500_idv_value"));
        pp_car_upto1500_date_value.setText(b.getCharSequence("pp_car_upto1500_date_value"));
        pp_car_upto1500_zone.setText(b.getCharSequence("pp_car_upto1500_zone"));
        pp_car_upto1500_cc_value.setText(b.getCharSequence("pp_car_upto1500_cc_value"));
        pp_car_upto1500_nd_value.setText(b.getCharSequence("pp_car_upto1500_nd_value"));
        pp_car_upto1500_uwd_value.setText(b.getCharSequence("pp_car_upto1500_uwd_value"));
        pp_car_upto1500_lpgtype_value.setText(b.getCharSequence("pp_car_upto1500_lpgtype_value"));

        //   pp_car_upto1500_lpg.setText(b.getCharSequence("pp_car_upto1500_lpg"));
        //  pp_car_upto1500_lpgtype.setText(b.getCharSequence("pp_car_upto1500_lpgtype"));
        pp_car_upto1500_antitheft.setText(b.getCharSequence("pp_car_upto1500_antitheft"));



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Car - Upto 1500cc Package Policy");

        findViewById(R.id.ppdisplay_car_upto1500_home).setOnClickListener(listener_ppdisplay_car_upto1500_home);
        //Calculation
        String d1=b.getString("pp_car_upto1500_date_value").toString();
        String s = d1;
        int y=b.getInt("year");
        int m=b.getInt("month");
        int d=b.getInt("day");


        int old_day=d;
        int old_month=m;
        int old_year=y;

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
              * with appropriate value. 1 Second : 1500 milisecond 1 Hour : 60 * 1500
              * millisecond 1 Day : 24 * 60 * 1500 milisecond
              */

        long diffInSecond = diffInMilis / 1500;
        long diffInMinute = diffInMilis / (60 * 1500);
        long diffInHour = diffInMilis / (60 * 60 * 1500);
        diffInDays = diffInMilis / ( 24 * 60 * 60 * 1500);



        //Calculation of Dop value

        if((b.getString("pp_car_upto1500_zone")).equals("A")) {
            if (diffInDays < 1825) {
                double idv_value=Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                dop_value=idv_value*3.283/100;
                double round_value=dop_value;
                rounded_dop_value=new Float(Math.round(round_value));

            }else if(diffInDays >= 1825 ) {
                if (diffInDays < 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                    dop_value = idv_value * 3.447 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                } else if (diffInDays >=3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                    dop_value = idv_value * 3.529 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                }
            }
        }
        else if((b.getString("pp_car_upto1500_zone")).equals("B")){
            if (diffInDays < 1825) {
                double idv_value = Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                dop_value = idv_value * 3.191 / 100;
                double round_value = dop_value;
                rounded_dop_value = new Float(Math.round(round_value));

            } else if (diffInDays >=1825 ) {
                if (diffInDays < 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                    dop_value = idv_value * 3.351 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                } else if (diffInDays >= 3650) {
                    double idv_value = Integer.valueOf(b.getString("pp_car_upto1500_idv_value"));
                    dop_value = idv_value * 3.430 / 100;
                    double round_value = dop_value;
                    rounded_dop_value = new Float(Math.round(round_value));
                }
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter correct DoP",Toast.LENGTH_SHORT).show();
        }

        //LPG selection
        String radio_button_value=b.getString("pp_car_upto1500_lpg");
        String yes=new String("Yes");

        //Setting LPGkit values for radiobutton selected
        if(radio_button_value.equals(yes)){
            pp_lgkit_assumevalue=60;
            pp_car_upto1500_lpg_value.setText("Yes");

        }
        else{
            pp_lgkit_assumevalue=0;
            pp_car_upto1500_lpg_value.setText("No");

        }
        //Calculation part of L P G type


        String x="Inbuilt";
        String fx="Fixed";
        String button_value=b.getString("pp_car_upto1500_lpgtype");
        b.getString("pp_car_upto1500_lpgtype_value");

        if((button_value.equals(x) && radio_button_value.equals(yes))){
            rounded_lgptype_value=rounded_dop_value;

        }else if((button_value.equals(fx) && radio_button_value.equals(yes))) {
            double lgptype_value = Integer.valueOf(b.getString("pp_car_scpassengers_lpgtype_value"));
            value_lgptype1=rounded_dop_value + ((lgptype_value)*4)/100;
            double value_lgptype2=value_lgptype1;
            rounded_lgptype_value = new Float(Math.round(value_lgptype2));
            int rounded_lgptype_value_int = (int) rounded_lgptype_value;

            pp_car_upto1500_lpgtype_value.setText(b.getString("pp_car_upto1500_lpgtype"));
            //pp_car_upto1500_lpgtype_value.setText(String.valueOf(rounded_lgptype_value_int));


        }else {
            rounded_lgptype_value=rounded_dop_value;
            pp_car_upto1500_lpgtype_value.setText("N/A");
        }



        //Calculation of N/D Value
        String x2="No";
        if((b.getString("pp_car_upto1500_nd")).equals(x2))
        {

            rounded_value_nd=rounded_lgptype_value;

        }
        else
        {
            double nd_value1=0.00;
            if (diffInDays < 365) {
                nd_value1=15;
            }else if (diffInDays >=365 ) {
                if (diffInDays < 1825) {
                    nd_value1 = 25;
                } else if (diffInDays >= 1825) {
                    nd_value1 = 0;
                }
            }

            //  double nd_value1 = Integer.valueOf(b.getString("pp_car_upto1500_nd_value"));
            double value_nd1=(nd_value1)*rounded_lgptype_value/100;
            double value_nd2=rounded_lgptype_value + value_nd1;
            double value_nd3=value_nd2;
            rounded_value_nd = new Float(Math.round(value_nd3));
        }
        int rounded_value_nd_int = (int) rounded_value_nd;

        pp_car_upto1500_nd_value.setText(b.getString("pp_car_upto1500_nd_value"));



        //Calculation of Anti-Theft value
        //
        String x3="No";
        String a3="Yes";
        if((b.getString("pp_car_upto1500_antitheft")).equals(x3))
        {

            rounded_value_antitheft=rounded_value_nd ;

        }
        else if((b.getString("pp_car_upto1500_antitheft")).equals(a3))
        {
            double l=rounded_value_nd*2.5/100;
            double antitheft_value1 = Math.min((double)500,l);
            double value_antitheft1=(rounded_value_nd)-(antitheft_value1);
            double value_antitheft2=value_antitheft1;
            rounded_value_antitheft = new Float(Math.round(value_antitheft2));
        }

        //Calculation of U/W discount
        double uw_value = Integer.valueOf(b.getString("pp_car_upto1500_uwd_value"));
        double val=((uw_value)*rounded_value_antitheft)/100;
        value_uw1=rounded_value_antitheft - val;
        double value_uw2=value_uw1;
        rounded_uw_value = new Float(Math.round(value_uw2));



        // Calculation of NCB
        double spinner_value = Integer.valueOf(b.getString("pp_car_spinner_value"));
        double spin_val=((spinner_value)*rounded_uw_value)/100;
        value_spin1=rounded_uw_value - spin_val;
        double value_spin2=value_spin1;
        rounded_ncb_value = new Float(Math.round(value_spin2));
        int rounded_ncb_value_int = (int) rounded_ncb_value;
        pp_car_upto1500_ncb_value.setText(b.getString("pp_car_spinner_value"));

        pp_car_upto1500_od_value.setText(String.valueOf(rounded_ncb_value_int));






        //Calculation of Total of B part

        pp_scpass_value= Integer.valueOf(b.getString("pp_car_scpassengers_upto1500"));
        String no="No";
        String oneLac="1 Lacs";
        String twoLac="2 Lacs";
        if(b.getString("pp_car_patooccupants_upto1500").equals(oneLac)) {
            pp_pa_pass_value=(pp_scpass_value)*50;
        }else if(b.getString("pp_car_patooccupants_upto1500").equals(twoLac)){
            pp_pa_pass_value=(pp_scpass_value)*100;
        }else if(b.getString("pp_car_patooccupants_upto1500").equals(no)){
            pp_pa_pass_value=0;
        }
        int pp_pa_pass_value_int = (int) pp_pa_pass_value;
        ppdisplay_car_upto1500_pa_pass_value.setText(String.valueOf(pp_pa_pass_value_int));

        //Calculation of Total by adding LG Kit Value of 60 if Yes 0 if No
        if(radio_button_value.equals(yes)){
            pp_lgkit_assumevalue=60;


        }
        else{
            pp_lgkit_assumevalue=0;
        }
        ppdisplay_car_upto1500_lpgkit_value.setText(String.valueOf(pp_lgkit_assumevalue));
        double total=2387.00+pp_lgkit_assumevalue+(double) pp_pa_pass_value;

        pp_total_premium = total;

        //rounding of total_premium value
        double round_value=pp_total_premium;
        float rounded_total_premium=new Float(Math.round(round_value));
        int rounded_total_premium_int = (int) rounded_total_premium;
        pp_car_upto1500_value_b.setText(String.valueOf(rounded_total_premium_int));

        double total_ab=(double)rounded_total_premium+(double)rounded_ncb_value;
        int total_ab_int = (int) total_ab;
        ppdisplay_car_upto1500_ab_value.setText(String.valueOf(total_ab_int));
        double total_plus_service_tax=total_ab+total_ab*15/100;
        double total_AB=total_plus_service_tax;
        float rounded_total_AB=new Float(Math.round(total_AB));
        int rounded_total_AB_int = (int) rounded_total_AB;
        ppdisplay_car_upto1500_total_value.setText(String.valueOf(rounded_total_AB_int));

    }

    View.OnClickListener listener_ppdisplay_car_upto1500_home = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ppdisplay_car_upto1500.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


}
