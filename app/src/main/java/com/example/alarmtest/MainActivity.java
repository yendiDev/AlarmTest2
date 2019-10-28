package com.example.alarmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button stopButton;
    private EditText timeInput;
    private TextView displaySeconds;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopButton = findViewById(R.id.start_button);
        timeInput = findViewById(R.id.time_input);
        displaySeconds = findViewById(R.id.seconds_textView);
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);


    }

    public void setTimer(View view) {
        try {

            int time = Integer.parseInt(timeInput.getText().toString());
            final int milisecond = time*1000;
            new CountDownTimer(milisecond, 1000) {

                @Override
                public void onTick(long l) {
                    displaySeconds.setText(String.valueOf(l/1000));
                }

                @Override
                public void onFinish() {
                    mediaPlayer.start();

                }
            }.start();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter time in seconds", Toast.LENGTH_SHORT).show();
        }

    }

    //This function stops the alarm
    public void stopAlarm(View view)
    {
        mediaPlayer.stop();
    }

}
