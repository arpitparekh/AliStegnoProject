package arpit.alistegnoproject.checkbox_toggle_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;

import arpit.alistegnoproject.databinding.ActivityCtsBinding;

public class CtsActivity extends AppCompatActivity {

    private ActivityCtsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCtsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cbGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){

                    binding.cbGender.setText("Male");
                    binding.getRoot().setBackgroundColor(Color.GREEN);

                }else{

                    binding.cbGender.setText("Female");
                    binding.getRoot().setBackgroundColor(Color.WHITE);

                }

            }
        });

        binding.tbGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){

                    binding.tbGender.setText("Male");
                    binding.getRoot().setBackgroundColor(Color.GREEN);

                }else{

                    binding.tbGender.setText("Female");
                    binding.getRoot().setBackgroundColor(Color.WHITE);

                }

            }
        });

        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){

                    binding.switch1.setText("Male");
                    binding.getRoot().setBackgroundColor(Color.GREEN);

                }else{

                    binding.switch1.setText("Female");
                    binding.getRoot().setBackgroundColor(Color.WHITE);

                }

            }
        });

    }
}