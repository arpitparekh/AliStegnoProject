package arpit.alistegnoproject.view_binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import arpit.alistegnoproject.databinding.ActivityMyBindBinding;

public class MyBindActivity extends AppCompatActivity {

    ActivityMyBindBinding binding; // declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBindBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.ivDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.tvDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}