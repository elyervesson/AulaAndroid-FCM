package com.example.elyervesson.aulaandroid_fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                textView.setText(SharedPreferenceManager.getInstance(MainActivity.this).getToken());
            }
        };

        if (SharedPreferenceManager.getInstance(this).getToken() != null) {
            textView.setText(SharedPreferenceManager.getInstance(this).getToken());
            Log.d("Firebase", "Refreshed token: " + SharedPreferenceManager.getInstance(this).getToken());
        }
        registerReceiver(broadcastReceiver, new IntentFilter(MyFirebaseInstanceIDService.TOKEN_BROADCAST));
    }
}
