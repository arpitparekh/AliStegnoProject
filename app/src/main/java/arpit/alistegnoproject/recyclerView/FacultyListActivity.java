package arpit.alistegnoproject.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import arpit.alistegnoproject.databinding.ActivityFacultyListBinding;

public class FacultyListActivity extends AppCompatActivity {

    private ActivityFacultyListBinding binding;
    private ArrayList<Faculty> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFacultyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // give layout manager to recyclerView
        binding.rvFacultyList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        list = new ArrayList<>();

        list.add(new Faculty("arpit","android","ahmedabad"));
        list.add(new Faculty("rahul","java","ahmedabad"));
        list.add(new Faculty("jigar","python","surat"));
        list.add(new Faculty("jigar","python","surat"));
        list.add(new Faculty("jigar","python","surat"));
        list.add(new Faculty("jigar","python","surat"));


        // adapter // listView -> ArrayAdapter // recyclerView -> custom Adapter

        FacultyAdapter adapter = new FacultyAdapter(list);

        binding.rvFacultyList.setAdapter(adapter);

    }
}