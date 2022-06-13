package arpit.alistegnoproject.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import arpit.alistegnoproject.databinding.FacultyItemLayoutBinding;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder> {

    private ArrayList<Faculty> list; // make a copy of arraylist from activity
    FacultyItemLayoutBinding binding;

    FacultyAdapter(ArrayList<Faculty> list){
        this.list = list;
    }

    @NonNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // make each and every items layout

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = FacultyItemLayoutBinding.inflate(inflater,parent,false);
        return new FacultyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewHolder holder, int position) {

        // show data inside each and every item

        Faculty faculty = list.get(position);

        binding.setObj(faculty);  // data binding

    }

    @Override
    public int getItemCount() {   // number of items inside a list
        return list.size();
    }

    public class FacultyViewHolder extends RecyclerView.ViewHolder {  // inner class
        FacultyViewHolder(@NonNull FacultyItemLayoutBinding binding) {
            super(binding.getRoot());
        }
    }
}
