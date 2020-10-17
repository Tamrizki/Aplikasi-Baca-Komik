package tam.pa.komik.activity.homePage.adapter;

import android.content.Context;
import android.content.Intent;
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
import tam.pa.komik.activity.detailKomik.DetailKomikActivity;
import tam.pa.komik.model.RecomendKomikList;

public class ListRecomendAdapter extends RecyclerView.Adapter<ListRecomendAdapter.viewHolder> {
    private Context context;
    private List<RecomendKomikList>listRecomend;

    public ListRecomendAdapter(Context context, List<RecomendKomikList> listRecomend) {
        this.context = context;
        this.listRecomend = listRecomend;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_text_recomend, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.bind(listRecomend.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKomikActivity.class);
                intent.putExtra("endpoint", listRecomend.get(position).getEndpoint());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(RecomendKomikList data) {
            tvTitle.setText(data.getTitle());
        }
    }
}
