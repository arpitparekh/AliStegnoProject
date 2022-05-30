package arpit.alistegnoproject.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.snackbar.Snackbar;

import arpit.alistegnoproject.R;
import arpit.alistegnoproject.databinding.ActivityMyMenuBinding;

public class MyMenuActivity extends AppCompatActivity {

    private ActivityMyMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // there are three type of menu in android

        // 1 option menu
        // 2 popup menu
        // 3 context menu

        registerForContextMenu(binding.btnContext);

        binding.btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu pop = new PopupMenu(MyMenuActivity.this,binding.btnPopUp);

                pop.getMenuInflater().inflate(R.menu.my_menu,pop.getMenu());

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){

                            case R.id.item1:
                                Snackbar.make(binding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();

                                binding.btnPopUp.setVisibility(View.GONE);

                                break;
                            case R.id.item2:

                                binding.btnPopUp.setVisibility(View.VISIBLE);

                                Snackbar.make(binding.getRoot(),"item2",Snackbar.LENGTH_SHORT).show();
                                break;
                            case R.id.item3:
                                Snackbar.make(binding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                                break;
                            case R.id.item4:
                                Snackbar.make(binding.getRoot(),"item4",Snackbar.LENGTH_SHORT).show();
                                break;
                            case R.id.item5:
                                Snackbar.make(binding.getRoot(),"item5",Snackbar.LENGTH_SHORT).show();
                                break;
                            case R.id.item6:
                                Snackbar.make(binding.getRoot(),"item6",Snackbar.LENGTH_SHORT).show();
                                break;
                            default:
                                Snackbar.make(binding.getRoot(),"defualt",Snackbar.LENGTH_SHORT).show();

                        }

                        return false;
                    }
                });

                pop.show();

            }
        });


    }

    //////////////////////////////  option menu  ////////////////////////////////////////


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        Snackbar.make(binding.getRoot(),"item2",Snackbar.LENGTH_SHORT).show();

//        if(item.getItemId()==R.id.item1){
//            Snackbar.make(binding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();
//        }else if(item.getItemId()==R.id.item2){
//
//        }

        switch (item.getItemId()){

            case R.id.item1:
                Snackbar.make(binding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();

                binding.btnPopUp.setVisibility(View.GONE);

                break;
            case R.id.item2:

                binding.btnPopUp.setVisibility(View.VISIBLE);

                Snackbar.make(binding.getRoot(),"item2",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Snackbar.make(binding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Snackbar.make(binding.getRoot(),"item4",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item5:
                Snackbar.make(binding.getRoot(),"item5",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item6:
                Snackbar.make(binding.getRoot(),"item6",Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(binding.getRoot(),"defualt",Snackbar.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    /////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.my_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item1:
                Snackbar.make(binding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();

                binding.btnPopUp.setVisibility(View.GONE);

                break;
            case R.id.item2:

                binding.btnPopUp.setVisibility(View.VISIBLE);

                Snackbar.make(binding.getRoot(),"item2",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Snackbar.make(binding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Snackbar.make(binding.getRoot(),"item4",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item5:
                Snackbar.make(binding.getRoot(),"item5",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item6:
                Snackbar.make(binding.getRoot(),"item6",Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(binding.getRoot(),"defualt",Snackbar.LENGTH_SHORT).show();

        }

        return super.onContextItemSelected(item);
    }
}