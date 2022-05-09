package arpit.alistegnoproject.pass_string;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import arpit.alistegnoproject.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvSomething);

        Intent i = getIntent();

        String data = i.getStringExtra("string");

        tv.setText(data);

    }
}