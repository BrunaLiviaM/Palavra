import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.junit.runner.manipulation.Ordering;

public class LetrasAdapter extends RecyclerView.Adapter<LetrasAdapter.ViewHolder> {
    private Context context;

    private List<Character> letras;

    public LetrasAdapter(Context context){
        this.context = context;

        letras = new ArrayList<>(23);
        for(char c = 'a'; c<= 'z'; c++){
            letras.add(c);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemButton.settext(letras.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return letras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button itemButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemButton = itemView.findViewById(R.id.button_item);
        }
    }
}
