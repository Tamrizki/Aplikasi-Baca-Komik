package tam.pa.komik.activity.bacaKomik.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.detailKomik.adapter.ChapterAdapter;
import tam.pa.komik.model.DetailChapterItem;

public class BacaAdapter extends RecyclerView.Adapter<BacaAdapter.viewHolder> {
    private Context context;
    private List<DetailChapterItem>listChapter;

    public BacaAdapter(Context context, List<DetailChapterItem> listChapter) {
        this.context = context;
        this.listChapter = listChapter;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_baca_komik, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        if (position != 0 && position != 1){
            holder.bind(listChapter.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return listChapter.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivKomik) ImageView ivKomik;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(DetailChapterItem detailChapterItem) {
            Picasso.get()
                    .load(detailChapterItem.getChapterImageLink())
                    .fit()
                    .error(R.drawable.logo_komik)
                    .into(ivKomik);
        }
    }
}
