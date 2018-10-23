package com.example.yura.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Thread Mythread = new Thread(null, doBackgroundThreadProcessing, "Background");
        Mythread.start();
    }

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            backgroundThreadProcessing();
        }
    };

    private void backgroundThreadProcessing() {
        handler.sendEmptyMessage(0);
    }



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView mInfoTextView = (TextView) findViewById(R.id.TextView1);
            String msg1 = mInfoTextView.getText().toString();
            Toast toast = Toast.makeText(getApplicationContext(), msg1, Toast.LENGTH_SHORT);
            toast.show();
        }
    };

}

