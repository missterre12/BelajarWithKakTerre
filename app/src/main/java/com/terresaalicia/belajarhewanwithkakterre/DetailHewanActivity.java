package com.terresaalicia.belajarhewanwithkakterre;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailHewanActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameTextView;
    private TextView soundTextView;
    private MediaPlayer mediaPlayer;

    private Button ButtonUlangiSuara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);

        imageView = findViewById(R.id.detail_image);
        nameTextView = findViewById(R.id.detail_name);
        soundTextView = findViewById(R.id.detail_sound);
        ButtonUlangiSuara = findViewById(R.id.ButtonUlangiSuara);

        // Get data from intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String sound = intent.getStringExtra("sound");
        int imageResId = intent.getIntExtra("imageResId", -1);
        int soundResId = intent.getIntExtra("soundResId", -1);

        // Set data to views
        nameTextView.setText(name);
        soundTextView.setText(sound);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
        ButtonUlangiSuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundResId != -1) {
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                    }
                    mediaPlayer = MediaPlayer.create(DetailHewanActivity.this, soundResId);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }
            }
        });
        if (soundResId != -1) {
            mediaPlayer = MediaPlayer.create(this, soundResId);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release media player resources when activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}