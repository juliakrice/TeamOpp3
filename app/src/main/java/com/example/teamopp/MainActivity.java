package com.example.teamopp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.emmy, R.drawable.jin, R.drawable.kate, R.drawable.kim, R.drawable.lilly, R.drawable.sam};


    @TargetApi(Build.VERSION_CODES.O)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView);

    s1 = getResources().getStringArray(R.array.name);
    s2 = getResources().getStringArray(R.array.description);

    MyAdapter myAdapter = new MyAdapter(this,s1, s2, images);
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
