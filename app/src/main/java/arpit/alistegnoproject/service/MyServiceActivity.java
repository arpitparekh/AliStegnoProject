package arpit.alistegnoproject.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import arpit.alistegnoproject.databinding.ActivityMyServiceBinding;

public class MyServiceActivity extends AppCompatActivity {

    private ActivityMyServiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMyServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPlaySong.setOnClickListener(view -> {

            Intent i = new Intent(this,PlaySongService.class);
            startService(i);

        });

        binding.btnDownloadFile.setOnClickListener(view -> {

            Intent i = new Intent(this,DownloadFileService.class);
            startService(i);


        });

    }
}