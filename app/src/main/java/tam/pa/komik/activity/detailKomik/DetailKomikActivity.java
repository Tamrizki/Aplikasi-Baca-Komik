package tam.pa.komik.activity.detailKomik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.detailKomik.adapter.ChapterAdapter;
import tam.pa.komik.activity.detailKomik.adapter.GenreAdapter;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.ChapterItem;
import tam.pa.komik.model.GenreListItem;
import tam.pa.komik.model.response.DataDetailKomikResponse;

public class DetailKomikActivity extends AppCompatActivity implements IViewDetailKomik, View.OnClickListener {
    private IViewDetailKomik iView;
    private DetailKomikPresenter presenter;
    private String endpoint = "";
    private GenreAdapter genreAdapter;
    private ChapterAdapter chapterAdapter;
    private RecyclerView.LayoutManager lmGenre, lmChapter;
    private ImageView ivBack;
    @BindView(R.id.compAppbar) View compAppbar;
    @BindView(R.id.ivThumbnail) ImageView ivThumbnail;
    @BindView(R.id.tvType) TextView tvType;
    @BindView(R.id.tvStatus) TextView tvStatus;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvAuthor) TextView tvAuthor;
    @BindView(R.id.tvSynopsis) TextView tvSynopsis;
    @BindView(R.id.rvGenre) RecyclerView rvGenre;
    @BindView(R.id.rvChapter) RecyclerView rvChapter;
    @BindView(R.id.collapsingToolbar) CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_komik);
        ButterKnife.bind(this);
        iView = this;
        ivBack = compAppbar.findViewById(R.id.ivBack);
        if (getIntent()!=null){
            endpoint = getIntent().getStringExtra("endpoint");
            presenter = new DetailKomikPresenter(iView, this);
            presenter.onGetDetailKomik(endpoint);
        }
        ivBack.setOnClickListener(this);
    }

    private void SetListChapter(List<ChapterItem> chapter) {
        lmChapter = new GridLayoutManager(this, 4);
        chapterAdapter = new ChapterAdapter(this, chapter);
        rvChapter.setHasFixedSize(true);
        rvChapter.setLayoutManager(lmChapter);
        rvChapter.setAdapter(chapterAdapter);
    }

    private void SetListGenre(List<GenreListItem> genreList) {
        lmGenre = new GridLayoutManager(this, 4);
        genreAdapter = new GenreAdapter(this, genreList);
        rvGenre.setHasFixedSize(true);
        rvGenre.setLayoutManager(lmGenre);
        rvGenre.setAdapter(genreAdapter);
    }

    @Override
    public void onGetDetailKomik(DataDetailKomikResponse detailKomik) {
        SetListGenre(detailKomik.getGenreList());
        SetListChapter(detailKomik.getChapter());
        Picasso.get()
                .load(detailKomik.getThumb())
                .fit()
                .into(ivThumbnail);
        tvType.setText(detailKomik.getType());
        tvStatus.setText(detailKomik.getStatus());
        tvTitle.setText(detailKomik.getTitle());
        tvAuthor.setText(detailKomik.getAuthor());
        tvSynopsis.setText(detailKomik.getSynopsis());
        collapsingToolbar.setTitle(detailKomik.getTitle());
        collapsingToolbar.setCollapsedTitleTextColor(this.getResources().getColor(R.color.colorBlue));
        collapsingToolbar.setExpandedTitleColor(this.getResources().getColor(R.color.colorTransparan));
    }

    @Override
    public void onErrorMsg(String msg) {
        Log.d("ErrorPresenter", msg);
    }

    @Override
    public void onClick(View view) {
        if (view == ivBack){
            onBackPressed();
        }
    }
}
