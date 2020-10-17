package tam.pa.komik.activity.recomendPage.adapter;

import android.content.Context;
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
import tam.pa.komik.model.RecomendKomikList;

public class RecomendAdapter extends RecyclerView.Adapter<RecomendAdapter.viewHolder> {
    private Context context;
    private List<RecomendKomikList> list;

    public RecomendAdapter(Context context, List<RecomendKomikList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_recomend, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
       @BindView(R.id.ivThumbnail)
        ImageView ivThumbnail;
       @BindView(R.id.tvTitle)
        TextView tvTitle;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(RecomendKomikList data) {
            Picasso.get()
                    .load(data.getThumb())
                    .fit()
                    .into(ivThumbnail);
            tvTitle.setText(data.getTitle());
        }
    }
}
