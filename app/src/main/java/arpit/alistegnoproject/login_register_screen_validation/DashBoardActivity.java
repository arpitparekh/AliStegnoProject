package arpit.alistegnoproject.login_register_screen_validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import arpit.alistegnoproject.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}