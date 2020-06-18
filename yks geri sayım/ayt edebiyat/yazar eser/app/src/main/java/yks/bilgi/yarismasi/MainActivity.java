package yks.bilgi.yarismasi;


import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private String EVENT_DATE_TIME = "2021-06-19 10:15:00";
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private TextView tv_days, tv_hour, tv_minute, tv_second;
    private Handler handler = new Handler();
    private Runnable runnable;
    public TextView tv_kalangun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tv_kalangun=findViewById(R.id.tv_kalangun);
        tv_days = findViewById(R.id.tv_days);
        tv_hour = findViewById(R.id.tv_hour);
        tv_minute = findViewById(R.id.tv_minute);
        tv_second = findViewById(R.id.tv_second);



            runnable = new Runnable() {
                @Override
                public void run() {
                    try {


                        handler.postDelayed(this, 1000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                        Date event_date = dateFormat.parse(EVENT_DATE_TIME);
                        Date current_date = new Date();
                        if (!current_date.after(event_date)) {
                            long diff = event_date.getTime() - current_date.getTime();
                            long Days = diff / (24 * 60 * 60 * 1000);
                            long Hours = diff / (60 * 60 * 1000) % 24;
                            long Minutes = diff / (60 * 1000) % 60;
                            long Seconds = diff / 1000 % 60;
                            //

                            Long gunler_saati=Days*24;
                            Long totalsaat=gunler_saati+Hours;
                            Long minuss=Minutes;


                            Float totalsaatf=totalsaat.floatValue();
                            Float sorusayisisa=(totalsaatf/12)*60;
                            int sss=sorusayisisa.intValue();
                            Float sss1=minuss.floatValue();
                            int ssg=sss1.intValue();
                            Long sorusayisi=(Days*120);
                            int tamsonuc=sss+ssg;



                            tv_days.setText(String.format("%02d", Days)+(getResources().getString(R.string.gunler)));
                            tv_hour.setText(String.format("%02d", Hours)+(getResources().getString(R.string.saatler)));
                            tv_minute.setText(String.format("%02d", Minutes)+(getResources().getString(R.string.dakikalar)));
                            tv_second.setText(String.format("%02d", Seconds)+(getResources().getString(R.string.saniyeler)));
                            tv_kalangun.setText(getResources().getString(R.string.yks_ye));

                        } else {

                            handler.removeCallbacks(runnable);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };


            handler.postDelayed(runnable, 0);



        }





    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }
}
