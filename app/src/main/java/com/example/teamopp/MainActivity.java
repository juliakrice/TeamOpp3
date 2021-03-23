package com.example.teamopp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            TextView textView=findViewById(R.id.date);
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            String currentDateandTime = sdf.format(new Date());
            textView.setText(currentDateandTime);

        TextView date2=findViewById(R.id.date2);
        SimpleDateFormat sdf2 = new SimpleDateFormat(" MMM d yyyy HH:mm");

        String currentDateandTime2 = sdf2.format(new Date());

        date2.setText(currentDateandTime2);


        }
    }
