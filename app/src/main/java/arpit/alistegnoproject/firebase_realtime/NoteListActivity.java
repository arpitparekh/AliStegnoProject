package arpit.alistegnoproject.firebase_realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import arpit.alistegnoproject.databinding.ActivityNoteListBinding;

public class NoteListActivity extends AppCompatActivity {

    private ActivityNoteListBinding binding;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ref = FirebaseDatabase.getInstance().getReference("Note").child("NoteData");

        ////////////////////////////  sho data  ////////////////////////

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot childSnap  :  snapshot.getChildren()){

                    Note note = childSnap.getValue(Note.class);

                    Log.i("object",note.toString());

                    // adapter

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ////////////////////  add data  /////////////////////////////

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = binding.edtTitle.getText().toString();
                String des = binding.edtDes.getText().toString();

                Note note = new Note(title,des);

                ref.push().setValue(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(NoteListActivity.this, "Data Added SuccessFully", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NoteListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}