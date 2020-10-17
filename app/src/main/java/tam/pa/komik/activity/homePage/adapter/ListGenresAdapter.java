package tam.pa.komik.activity.homePage.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.genrePage.GenreActivity;
import tam.pa.komik.dialog.genre.DialogListByGenre;
import tam.pa.komik.model.GenreItems;

public class ListGenresAdapter extends RecyclerView.Adapter<ListGenresAdapter.viewHolder> {
    private Context context;
    private List<GenreItems> listGenres;

    public ListGenresAdapter(Context context, List<GenreItems> listGenres) {
        this.context = context;
        this.listGenres = listGenres;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_genres, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {
        if (position == 9){
            holder.SetViewAll(listGenres.get(position));
        }else {
            holder.bind(listGenres.get(position));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 9){
                    Intent intent = new Intent(context, GenreActivity.class);
                    context.startActivity(intent);
                }else {
                    DialogListByGenre dialog = new DialogListByGenre(context,
                            listGenres.get(position).getEndpoint(),
                            listGenres.get(position).getTitle());
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvGenre)
        TextView tvGenre;
        @BindView(R.id.rlGenres)
        RelativeLayout rlGenres;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(GenreItems data) {
            tvGenre.setText(data.getTitle());
        }

        public void SetViewAll(GenreItems genreItems) {
            rlGenres.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.colorWhite)));
            tvGenre.setText(context.getString(R.string.text_view_all));
            tvGenre.setTextColor(context.getResources().getColor(R.color.colorBlue));
        }
    }
}
