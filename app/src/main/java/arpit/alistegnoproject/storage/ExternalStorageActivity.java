package arpit.alistegnoproject.storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import arpit.alistegnoproject.databinding.ActivityExternalStorageBinding;

public class ExternalStorageActivity extends AppCompatActivity {

    private ActivityExternalStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = binding.edtExternal.getText().toString();

                checkPermission();

                File file = Environment.getExternalStorageDirectory();   // root folder path of sdcard

                File myFolderFile = new File(file,"AliFolder");  // subfolder path

                myFolderFile.mkdir();  // make directory

                File textFile = new File(myFolderFile,"ali.txt");

                try {

                    FileOutputStream fos = new FileOutputStream(textFile);

                    fos.write(data.getBytes());

                    fos.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        binding.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkPermission();

                File file = Environment.getExternalStorageDirectory();   // root folder path of sdcard

                File myFolderFile = new File(file,"AliFolder");  // subfolder path

                myFolderFile.mkdir();  // make directory

                File textFile = new File(myFolderFile,"ali.txt");

                try {

                    FileInputStream fis = new FileInputStream(textFile);

                    byte arr[] = new byte[fis.available()];

                    fis.read(arr);

                    String result = new String(arr);

                    binding.tvExternal.setText(result);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }

    void checkPermission(){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
        ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){

            // ask for a permission

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},102);

        }else{

            Toast.makeText(this, "Permission is Already Granted", Toast.LENGTH_SHORT).show();

            // permission is already granted
        }

    }

}