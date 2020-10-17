package tam.pa.komik.activity.homePage.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.detailKomik.DetailKomikActivity;
import tam.pa.komik.model.KomikListItem;

public class ListKomikAdapter extends RecyclerView.Adapter<ListKomikAdapter.viewHolder> {
    private Context context;
    private List<KomikListItem> listKomik;

    public ListKomikAdapter(Context context, List<KomikListItem> listKomik) {
        this.context = context;
        this.listKomik = listKomik;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_komik, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.bind(listKomik.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKomikActivity.class);
                intent.putExtra("endpoint", listKomik.get(position).getEndpoint());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKomik.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivThumbnail)
        ImageView ivThumbnail;
        @BindView(R.id.tvChapter)
        TextView tvChapter;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvUpdate)
        TextView tvUpdate;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(KomikListItem data) {
            Picasso.get()
                    .load(data.getThumb())
                    .fit()
                    .into(ivThumbnail);
            tvChapter.setText(data.getChapter());
            tvTitle.setText(data.getTitle());
            tvUpdate.setText(data.getUpdatedOn());
        }
    }
}
