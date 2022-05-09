package arpit.alistegnoproject.pass_string;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import arpit.alistegnoproject.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        EditText editText = findViewById(R.id.edtData);
        Button button = findViewById(R.id.btnSend);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = editText.getText().toString();

                Intent i = new Intent(FirstActivity.this,SecondActivity.class);
                i.putExtra("string",data);
                startActivity(i);

                //Context  // is

            }
        });

    }
}