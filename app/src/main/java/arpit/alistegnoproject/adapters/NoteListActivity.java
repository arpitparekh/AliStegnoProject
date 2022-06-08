package arpit.alistegnoproject.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import arpit.alistegnoproject.R;
import arpit.alistegnoproject.databinding.ActivityNoteList2Binding;

public class NoteListActivity extends AppCompatActivity {

    private ActivityNoteList2Binding binding;
//    private ArrayList<String> list;
    private ArrayList<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteList2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        list = new ArrayList<>();

        personList = new ArrayList<>();
//
//        list.add("Car");
//        list.add("Bus");
//        list.add("Bike");
//        list.add("AeroPlane");
//        list.add("Boat");

        personList.add(new Person("Arpit","Ahmedabad"));
        personList.add(new Person("Ali","Ahmedabad"));
        personList.add(new Person("Sumit","Surat"));
        personList.add(new Person("Kajal","Baroda"));

        // adapter
        // adapter is used to display a large amount of data into layout

        ArrayAdapter<Person> adapter = new ArrayAdapter<>(this,R.layout.vehicle_type,personList);

        binding.listView.setAdapter(adapter);

    }
}