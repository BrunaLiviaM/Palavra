import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PalavrasAdapter extends RecyclerView.Adapter<PalavrasAdapter.ViewHolder> {
    private Context context;
    private List<String> palavras;

    public PalavrasAdapter(Context context, String letraId){
        this.context = context;
        palavras = new ArrayList<>();

        for(String s : todas){
            if(s.startsWith(letraId)){
                palavras.add(s);
            }
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(r.layout.item_lista, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
}
