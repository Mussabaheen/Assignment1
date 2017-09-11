package com.example.mussabaheenmalik.connectinternet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mussabaheenmalik on 9/10/17.
 */

public class ConnectInternetTask extends AsyncTask<String,Void,String> {
    Context ctx;
    public  ConnectInternetTask(Context ct){

    }
    @Override
    protected String doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream in;
        try {
            URL myurl = new URL(s1);
            HttpURLConnection myCon = (HttpURLConnection) myurl.openConnection();
            myCon.setReadTimeout(10000);
            myCon.setConnectTimeout(20000);
            myCon.setRequestMethod("GET");
            myCon.connect();
            in = myCon.getInputStream();
            BufferedReader mybuf =  new BufferedReader(new InputStreamReader(in));
            StringBuilder st = new StringBuilder();
            String Line  = " ";
            while ((Line =mybuf.readLine())!= null)
            {
                st.append(Line+"   ");

            }
            mybuf.close();
            in.close();
            return  st.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.txt1.setText(s);
    }
}
