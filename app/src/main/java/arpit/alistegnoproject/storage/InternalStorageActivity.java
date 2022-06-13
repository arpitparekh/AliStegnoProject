package arpit.alistegnoproject.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import arpit.alistegnoproject.databinding.ActivityInternalStorageBinding;

public class InternalStorageActivity extends AppCompatActivity {

    private ActivityInternalStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = binding.edtInternal.getText().toString();

                // FileOutputStream

                try {

                    FileOutputStream fos = openFileOutput("ali.txt",MODE_PRIVATE);

                    fos.write(data.getBytes());

                    fos.close();

                    Toast.makeText(InternalStorageActivity.this, "File Written Successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        binding.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    FileInputStream fis = openFileInput("ali.txt");

                    byte arr[] = new byte[fis.available()];

                    fis.read(arr);

                    String result = new String(arr);

                    binding.tvInternal.setText(result);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}