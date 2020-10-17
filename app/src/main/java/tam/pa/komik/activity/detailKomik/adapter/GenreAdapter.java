package tam.pa.komik.activity.detailKomik.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.model.GenreListItem;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.viewHolder> {
    private Context context;
    private List<GenreListItem> listGenre;

    public GenreAdapter(Context context, List<GenreListItem> listGenre) {
        this.context = context;
        this.listGenre = listGenre;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_genre_white, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(listGenre.get(position));
    }

    @Override
    public int getItemCount() {
        return listGenre.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvGenre)
        TextView tvGenre;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(GenreListItem genreListItem) {
            tvGenre.setText(genreListItem.getGenreName());
        }
    }
}
