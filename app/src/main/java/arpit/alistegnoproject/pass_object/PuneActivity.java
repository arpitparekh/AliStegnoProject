package arpit.alistegnoproject.pass_object;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import arpit.alistegnoproject.R;

public class PuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pune);

        Intent i = getIntent();

        Student s = (Student) i.getSerializableExtra("object");

        TextView textView = findViewById(R.id.tvObject);

        textView.setText(s.toString());

    }
}