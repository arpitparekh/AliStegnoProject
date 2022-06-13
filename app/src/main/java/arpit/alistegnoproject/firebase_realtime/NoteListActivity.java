package arpit.alistegnoproject.firebase_realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
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
    private ArrayList<Note> noteArrayList;
    private ArrayList<String> noteKeys;
    private boolean bool = false;
    private int location = 0;
    ArrayAdapter<Note> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noteArrayList = new ArrayList<>();
        noteKeys = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Note").child("NoteData");

        ////////////////////////////  click event on listView ///////////////////////


        binding.listViewNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Note note = noteArrayList.get(pos);
                String key = noteKeys.get(pos);

                new AlertDialog.Builder(NoteListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // update

                                binding.edtTitle.setText(note.title);
                                binding.edtDes.setText(note.description);

                                binding.btnSend.setText("Update");

                                bool = true;

                                location = pos;

                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // delete
                                ref.child(key).removeValue();

                            }
                        }).create().show();

            }
        });

        ////////////////////////////  show data  ////////////////////////

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noteArrayList.clear();
                noteKeys.clear();
                for(DataSnapshot childSnap  :  snapshot.getChildren()){

                    Note note = childSnap.getValue(Note.class);
                    String key = childSnap.getKey();

                   noteArrayList.add(note);
                   noteKeys.add(key);

                    // adapter

                }
                adapter = new ArrayAdapter<>(NoteListActivity.this, android.R.layout.simple_list_item_1,noteArrayList);

                binding.listViewNote.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ////////////////////  add and update data  /////////////////////////////

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bool){

                    // update

                    String title = binding.edtTitle.getText().toString();
                    String des = binding.edtDes.getText().toString();

                    Note updatedNote = new Note(title,des);

                    ref.child(noteKeys.get(location)).setValue(updatedNote);

                    bool = false;

                    binding.btnSend.setText("Send");

                    clear();


                }else{

                    // add

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

                    clear();
                }
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


    }

    void clear(){

        binding.edtTitle.setText("");
        binding.edtDes.setText("");

    }
}