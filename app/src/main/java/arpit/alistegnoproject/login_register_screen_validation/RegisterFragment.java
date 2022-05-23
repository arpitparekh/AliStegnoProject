package arpit.alistegnoproject.login_register_screen_validation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arpit.alistegnoproject.R;
import arpit.alistegnoproject.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

   private FragmentRegisterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}