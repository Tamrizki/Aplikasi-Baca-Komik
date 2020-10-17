package tam.pa.komik.activity.genrePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.genrePage.adapter.GenreAdapter;
import tam.pa.komik.activity.genrePage.adapter.PopulerAdapter;
import tam.pa.komik.model.response.DataGenresResponse;
import tam.pa.komik.model.response.DataListResponse;
import tam.pa.komik.model.response.DataPopulerResponse;

public class GenreActivity extends AppCompatActivity implements IViewGenre, View.OnClickListener {
    private IViewGenre iViewGenre;
    private GenrePresenter presenter;
    private GenreAdapter genreAdapter;
    private PopulerAdapter populerAdapter;
    private RecyclerView.LayoutManager lmGenre, lmPopuler;
    @BindView(R.id.rvGenres) RecyclerView rvGenres;
    @BindView(R.id.rvPopuler) RecyclerView rvPopuler;
    @BindView(R.id.compAppbar) View compAppbar;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        ButterKnife.bind(this);
        iViewGenre = this;
        ivBack = compAppbar.findViewById(R.id.ivBack);
        presenter = new GenrePresenter(this, iViewGenre);
        presenter.onGetListGenres();
        presenter.onGetPopuler("1");
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onGetListGenre(DataGenresResponse dataGenre) {
        lmGenre = new GridLayoutManager(this, 3);
        genreAdapter = new GenreAdapter(this, dataGenre.getListGenre());
        rvGenres.setHasFixedSize(true);
        rvGenres.setLayoutManager(lmGenre);
        rvGenres.setAdapter(genreAdapter);
    }

    @Override
    public void onGetListPopuler(DataPopulerResponse dataPopuler) {
        lmPopuler = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        populerAdapter = new PopulerAdapter(this, dataPopuler.getMangaList());
        rvPopuler.setHasFixedSize(true);
        rvPopuler.setLayoutManager(lmPopuler);
        rvPopuler.setAdapter(populerAdapter);
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
