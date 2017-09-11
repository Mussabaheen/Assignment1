package com.example.mussabaheenmalik.connectinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    String rest;
     static EditText exe1;
    ConnectInternetTask c1;
    static String s2;
    Spinner sp;
    List<String> list;

      static TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView)findViewById(R.id.textView2);
        sp = (Spinner)findViewById(R.id.spinner3);
        exe1 = (EditText)findViewById(R.id.editText);
        list = new ArrayList<>();
        list.add("http://");
        list.add("https://");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s2 = list.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void dosomething(View view) {
        rest = exe1.getText().toString();
        c1  = new ConnectInternetTask(this);
        c1.execute(s2+rest);
    }

}
