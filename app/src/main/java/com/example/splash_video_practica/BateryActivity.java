package com.example.splash_video_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class BateryActivity extends AppCompatActivity {

    TextView mBatteryLevelText;
    BroadcastReceiver mReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batery);

        mBatteryLevelText = (TextView) findViewById(R.id.txtView_nivel);

        mReciever = new BatteryBroadcastReceiver();
        registerReceiver(mReciever, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mBatteryLevelText.setText("Batería restante : " + level + "%");
        }
    }
}
