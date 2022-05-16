package arpit.alistegnoproject.data_binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import arpit.alistegnoproject.databinding.ActivityMyDataBinding;

public class MyDataActivity extends AppCompatActivity {

    private ActivityMyDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // data binding

        Student student = new Student("Jaimin","Ahmedabad",23,56.78f);

        binding.setObj(student);

//        binding.tvName.setText(student.name);
//        binding.tvAddress.setText(student.address);
//        binding.tvAge.setText(String.valueOf(student.age));
//        binding.tvHeight.setText(String.valueOf(student.height));
    }
}