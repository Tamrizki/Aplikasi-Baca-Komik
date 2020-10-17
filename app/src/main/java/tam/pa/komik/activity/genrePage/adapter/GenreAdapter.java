package tam.pa.komik.activity.genrePage.adapter;

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
import tam.pa.komik.dialog.genre.DialogListByGenre;
import tam.pa.komik.model.GenreItems;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.viewHolder> {
    private Context context;
    private List<GenreItems> listGenre;

    public GenreAdapter(Context context, List<GenreItems> listGenre) {
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
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.bind(listGenre.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogListByGenre dialog = new DialogListByGenre(context,
                        listGenre.get(position).getEndpoint(),
                        listGenre.get(position).getTitle());
                dialog.show();
                dialog.setCanceledOnTouchOutside(false);
            }
        });
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

        public void bind(GenreItems genreItems) {
            tvGenre.setText(genreItems.getTitle());
        }
    }
}
