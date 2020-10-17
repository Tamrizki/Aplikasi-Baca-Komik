package tam.pa.komik.activity.homePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tam.pa.komik.R;
import tam.pa.komik.activity.homePage.adapter.ListGenresAdapter;
import tam.pa.komik.activity.homePage.adapter.ListKomikAdapter;
import tam.pa.komik.activity.homePage.adapter.ListRecomendAdapter;
import tam.pa.komik.activity.recomendPage.RecomendActivity;
import tam.pa.komik.dialog.pencarian.DialogListPencarian;
import tam.pa.komik.model.GenreItems;
import tam.pa.komik.model.KomikListItem;
import tam.pa.komik.model.PopulerListItem;
import tam.pa.komik.model.RecomendKomikList;

public class MainActivity extends AppCompatActivity implements IViewHome, View.OnClickListener {
    private IViewHome iView;
    private HomePresenter presenter;
    private RecyclerView.LayoutManager lmListKomik, lmListGenres, lmRecomend;
    private ListKomikAdapter listKomikAdapter;
    private ListGenresAdapter genresAdapter;
    private ListRecomendAdapter recomendAdapter;
    private int page = 1;
    private List<KomikListItem> listFull = new ArrayList<>();
    @BindView(R.id.rvListKomik) RecyclerView rvListKomik;
    @BindView(R.id.rvListGenre) RecyclerView rvListGenre;
    @BindView(R.id.rvRecomendList) RecyclerView rvRecomendList;
    @BindView(R.id.tvViewAllRecomend) TextView tvViewAllRecomend;
    @BindView(R.id.compAppbar) View compAppbar;
    @BindView(R.id.btnLoad) Button btnLoad;
    private EditText etSearch;
    private ImageButton ibSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iView = this;
        ButterKnife.bind(this);
        etSearch = compAppbar.findViewById(R.id.etSearch);
        ibSearch = compAppbar.findViewById(R.id.ibSearch);

        presenter = new HomePresenter(this, iView);
        presenter.onGetListKomik(String.valueOf(page));
        presenter.onGetListGenres();
        presenter.onGetRecomend();
        SetListKomik(listFull);
        tvViewAllRecomend.setOnClickListener(this);
        ibSearch.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
    }


    private void SetListKomik(List<KomikListItem> listKomik) {
        lmListKomik = new GridLayoutManager(this, 2);
        listKomikAdapter = new ListKomikAdapter(this, listKomik);
        rvListKomik.setHasFixedSize(true);
        rvListKomik.setLayoutManager(lmListKomik);
        rvListKomik.setAdapter(listKomikAdapter);
    }

    private void SetListGenres(List<GenreItems> listGenre) {
        lmListGenres = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        genresAdapter = new ListGenresAdapter(this, listGenre);
        rvListGenre.setHasFixedSize(true);
        rvListGenre.setLayoutManager(lmListGenres);
        rvListGenre.setAdapter(genresAdapter);
    }

    private void SetListRecomend(List<RecomendKomikList> listRecomend) {
        lmRecomend = new GridLayoutManager(this, 2);
        recomendAdapter = new ListRecomendAdapter(this, listRecomend);
        rvRecomendList.setHasFixedSize(true);
        rvRecomendList.setLayoutManager(lmRecomend);
        rvRecomendList.setAdapter(recomendAdapter);
    }

    @Override
    public void onGetListKomik(List<KomikListItem> listKomik) {
        for (int i = 0; i < listKomik.size(); i++) {
            listFull.add(new KomikListItem(listKomik.get(i).getTitle(), listKomik.get(i).getThumb(), listKomik.get(i).getType(), listKomik.get(i).getUpdatedOn(), listKomik.get(i).getEndpoint(), listKomik.get(i).getChapter()));
        }
        listKomikAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetListGenres(List<GenreItems> listGenre) {
        SetListGenres(listGenre);
    }

    @Override
    public void onGetListRecomend(List<RecomendKomikList> listRecomend) {
        SetListRecomend(listRecomend);
    }

    @Override
    public void onGetPencarian(List<PopulerListItem> listPencarian) {
        DialogListPencarian dialog = new DialogListPencarian(this, listPencarian, etSearch.getText().toString());
        dialog.show();
    }

    @Override
    public void onErrorMsg(String msg) {
        Log.d("errorPresenter", msg);
    }

    @Override
    public void onClick(View view) {
        if (view == tvViewAllRecomend) {
            startActivity(new Intent(this, RecomendActivity.class));
        }
        else if (view == ibSearch){
            if (etSearch.getText().toString().equals("")){
                etSearch.setError("Form pencarian masih kosong!");
            }else {
                presenter.onGetPencarian(etSearch.getText().toString());
            }
        }else if (view == btnLoad){
            page++;
            presenter.onGetListKomik(String.valueOf(page));
        }
    }
}
