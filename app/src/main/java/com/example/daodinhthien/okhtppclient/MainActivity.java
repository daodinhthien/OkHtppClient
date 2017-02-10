package com.example.daodinhthien.okhtppclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;
    OkHttpClient Client;
    String Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetData = (Button) findViewById(R.id.BtnGetData);
        Client = new OkHttpClient();
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Result = GetData("http://square.github.io/okhttp/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String GetData(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = Client.newCall(request).execute();
        return response.body().toString();
    }

}
