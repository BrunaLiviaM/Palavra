package br.edu.ifsp.dmo.palavras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private boolean linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout= false;
        recyclerView = findViewById(R.id.recyclerview_letras);
        recyclerView.setAdapter(new LetrasAdapter(this));
        alterarLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.Menu.menu, menu);
        MenuItem trocarLayoutButton = menu.findItem(R.id.trocar_layout);
        alterarIconeMenu(trocarLayoutButton);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull menuItem item){
        if(item.getItemId() == R.id.trocar_layout){
            alterarLayout();
            alterarIconeMenu(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alterarLayout(){
        linearLayout = !linearLayout;
        if(linearLayout){
            recyclerView.setLayoutManagr(new LinearLayoutManager(this));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }
    }

    private void alterarIconeMenu(MenuItem itemMenu){
        if(itemMenu != null){
            if(linearLayout){
                itemMenu.setIcon(getDrawable(R.drawable.ic_grid));
            }else{
                itemMenu.setIcon(getDrawable(R.drawable.ic_lista));
            }
        }
    }
}