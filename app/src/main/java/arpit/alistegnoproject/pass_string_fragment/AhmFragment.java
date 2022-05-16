package arpit.alistegnoproject.pass_string_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import arpit.alistegnoproject.R;

public class AhmFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.btnSend);
        EditText editText = view.findViewById(R.id.edtSendString);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = editText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("str",data);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fcv_another_holder,RajFragment.class,bundle)
                        .addToBackStack("ahm")
                        .commit();
            }
        });

    }
}