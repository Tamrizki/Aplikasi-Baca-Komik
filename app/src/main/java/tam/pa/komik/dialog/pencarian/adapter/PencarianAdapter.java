package tam.pa.komik.dialog.pencarian.adapter;

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
import tam.pa.komik.model.PopulerListItem;

public class PencarianAdapter extends RecyclerView.Adapter<PencarianAdapter.viewHolder> {
    private Context context;
    private List<PopulerListItem> listPencarian;

    public PencarianAdapter(Context context, List<PopulerListItem> listPencarian) {
        this.context = context;
        this.listPencarian = listPencarian;
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
        holder.bind(listPencarian.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKomikActivity.class);
                intent.putExtra("endpoint", listPencarian.get(position).getEndpoint());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPencarian.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivThumbnail) ImageView ivThumbnail;
        @BindView(R.id.tvChapter) TextView tvType;
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvUpdate) TextView tvUpdate;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(PopulerListItem data) {
            Picasso.get()
                    .load(data.getThumb())
                    .fit()
                    .into(ivThumbnail);
            tvType.setText(data.getType());
            tvTitle.setText(data.getTitle());
            tvUpdate.setText(data.getUploadOn());
        }
    }
}
