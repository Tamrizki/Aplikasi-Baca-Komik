package tam.pa.komik.activity.detailKomik.adapter;

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
import tam.pa.komik.activity.bacaKomik.BacaKomikActivity;
import tam.pa.komik.model.ChapterItem;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.viewHolder> {
    private Context context;
    private List<ChapterItem>lisChapter;

    public ChapterAdapter(Context context, List<ChapterItem> lisChapter) {
        this.context = context;
        this.lisChapter = lisChapter;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_chapter, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.bind(lisChapter.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BacaKomikActivity.class);
                intent.putExtra("chapter_endpoint", lisChapter.get(position).getChapterEndpoint());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lisChapter.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvChapter)
        TextView tvChapter;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(ChapterItem chapterItem) {
            String[] chapter = chapterItem.getChapterTitle().split(" ");
            tvChapter.setText("C-"+chapter[1]);
        }
    }
}
