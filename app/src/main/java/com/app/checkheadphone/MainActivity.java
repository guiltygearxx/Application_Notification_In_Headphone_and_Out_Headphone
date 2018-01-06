package com.app.checkheadphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        BroadcastReceiver receiver=new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                if (audioManager.isWiredHeadsetOn())
                {
                    textView.setText("ON");
                }
                else
                {
                    textView.setText("OFF");
                }
            }
        };

        IntentFilter filter=new IntentFilter(AudioManager.ACTION_HEADSET_PLUG);
        registerReceiver(receiver,filter);


    }
}
