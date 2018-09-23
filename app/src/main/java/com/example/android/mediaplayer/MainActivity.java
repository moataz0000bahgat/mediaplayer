package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         mp = MediaPlayer.create(this, R.raw.abhimp337837);

        Button boton = (Button) findViewById(R.id.play);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
            }
        });

        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });


        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {

                Log.i("Completion Listener", "Song Complete");
                Toast.makeText(MainActivity.this, "I am done", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void  releaseMediaPlayer() {

        if (mp != null) {

            // Regardless of the current state of the media player, release its resources

            // because we no longer need it.

            mp.release();


            // Set the media player back to null. For our code, we've decided that

            // setting the media player to null is an easy way to tell that the media player

            // is not configured to play an audio file at the moment.

            mp = null;

        }
        return ;

    }
}
