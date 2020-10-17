package tam.pa.komik.activity.bacaKomik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.bacaKomik.adapter.BacaAdapter;
import tam.pa.komik.model.response.DataBacaResponse;

public class BacaKomikActivity extends AppCompatActivity implements IViewBaca, View.OnClickListener {
    private IViewBaca iViewBaca;
    private BacaKomikPresenter presenter;
    private RecyclerView.LayoutManager lmBacaKomik;
    private BacaAdapter adapter;
    private String endPoint = "";
    ImageView ivBack;
    @BindView(R.id.compAppbar) View compAppbar;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.rvKomik) RecyclerView rvKomik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_komik);
        ButterKnife.bind(this);
        ivBack = compAppbar.findViewById(R.id.ivBack);
        iViewBaca = this;
        if (getIntent()!=null){
            endPoint = getIntent().getStringExtra("chapter_endpoint");
            presenter = new BacaKomikPresenter(iViewBaca, this);
            presenter.onGetDetailChapter(endPoint);
        }
        ivBack.setOnClickListener(this);
    }

    private void SetListKomik(DataBacaResponse data) {
        lmBacaKomik = new LinearLayoutManager(this);
        adapter = new BacaAdapter(this, data.getChapterImage());
        rvKomik.setHasFixedSize(true);
        rvKomik.setLayoutManager(lmBacaKomik);
        rvKomik.setAdapter(adapter);
    }

    @Override
    public void onGetDetailChapter(DataBacaResponse dataBacaResponse) {
        SetListKomik(dataBacaResponse);
        tvTitle.setText(dataBacaResponse.getTitle());
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
