package arpit.alistegnoproject.pass_object;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import arpit.alistegnoproject.R;

public class AhmedabadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmedabad);

        Button button = findViewById(R.id.btnSendObject);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student s = new Student("Ali","Ahmedabad");

                Intent i = new Intent(AhmedabadActivity.this,PuneActivity.class);
                i.putExtra("object",s);
                startActivity(i);

            }
        });

    }
}