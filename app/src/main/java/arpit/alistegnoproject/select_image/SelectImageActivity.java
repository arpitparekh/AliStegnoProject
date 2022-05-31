package arpit.alistegnoproject.select_image;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import arpit.alistegnoproject.databinding.ActivitySelectImageBinding;

public class SelectImageActivity extends AppCompatActivity {

    private ActivitySelectImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ActivityResultLauncher

        ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                // Uri  // unified resource identifier
                // path of my photo

                binding.ivResult.setImageURI(result);

            }
        });

        binding.ivResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launcher.launch("image/*");


            }
        });


    }
}