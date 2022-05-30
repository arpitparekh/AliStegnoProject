package arpit.alistegnoproject.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

import arpit.alistegnoproject.R;
import arpit.alistegnoproject.databinding.ActivityDialogsBinding;
import arpit.alistegnoproject.databinding.MyDialogBinding;

public class DialogsActivity extends AppCompatActivity {

    private ActivityDialogsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);

                builder.setTitle("This is title");

                builder.setMessage("This is Message");

                builder.setIcon(R.drawable.ic_login);

                builder.setCancelable(false);

                builder.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogsActivity.this, "This is Toast", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("SnackBar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(binding.getRoot(),"This is SnackBar",Snackbar.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });

        binding.btnProgressDialog.setOnClickListener(view -> {

            ProgressDialog dialog = new ProgressDialog(this);

            dialog.setTitle("Downloading");

            dialog.setMessage("Please Wait...");

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            dialog.show();

//            dialog.dismiss();  // to dismiss the dialog

        });

        binding.btnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog progressDialog = new ProgressDialog(DialogsActivity.this);

                progressDialog.setTitle("This is Progress Dialog");

                progressDialog.setMessage("This is Message");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                progressDialog.setMax(100);
                progressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for(int i=1;i<=100;i++){

                            try {

                                Thread.sleep(100);
                                progressDialog.setProgress(i);

                                if(i==100){

                                    progressDialog.dismiss();

                                }


                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }

                    }
                }).start();


            }
        });

        binding.btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY) ;
                int minuet = calendar.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(DialogsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(DialogsActivity.this, i+":"+i1, Toast.LENGTH_SHORT).show();
                    }
                },hour,minuet,true);

                dialog.show();
            }
        });

        binding.btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                DatePickerDialog dialog = new DatePickerDialog()

            }
        });

        binding.btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // initialize a binding on button click

                MyDialogBinding binding1 = MyDialogBinding.inflate(getLayoutInflater());

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);

                builder.setView(binding1.getRoot());

                builder.show();

            }
        });
    }
}