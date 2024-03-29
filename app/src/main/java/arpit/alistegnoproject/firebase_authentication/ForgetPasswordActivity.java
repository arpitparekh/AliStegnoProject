package arpit.alistegnoproject.firebase_authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import arpit.alistegnoproject.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {

    private ActivityForgetPasswordBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.edtEmail.getText().toString();

                auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(ForgetPasswordActivity.this, "Email Successfully Send", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetPasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}