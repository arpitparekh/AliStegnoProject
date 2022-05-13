package arpit.alistegnoproject.pass_string_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import arpit.alistegnoproject.R;

public class AnotherHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_holder);

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.add(R.id.fcv_another_holder,new AhmFragment());
//        transaction.commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcv_another_holder,new AhmFragment())
                .commit();

    }
}