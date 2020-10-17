package tam.pa.komik.activity.recomendPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.activity.recomendPage.adapter.RecomendAdapter;
import tam.pa.komik.model.RecomendKomikList;

public class RecomendActivity extends AppCompatActivity implements IViewRecomend{
    private IViewRecomend iViewRecomend;
    private RecomendPresenter presenter;
    private RecyclerView.LayoutManager lmRecomend;
    private RecomendAdapter adapter;
    @BindView(R.id.rvRecomend)
    RecyclerView rvRecomend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomend);
        ButterKnife.bind(this);
        iViewRecomend = this;
        presenter = new RecomendPresenter(iViewRecomend, this);
        presenter.onGetRecomend();
    }

    private void SetListRecomend(List<RecomendKomikList> listRecomend) {
        adapter = new RecomendAdapter(this, listRecomend);
        lmRecomend = new LinearLayoutManager(this);
        rvRecomend.setHasFixedSize(true);
        rvRecomend.setLayoutManager(lmRecomend);
        rvRecomend.setAdapter(adapter);
    }

    @Override
    public void onGetRecomend(List<RecomendKomikList> listRecomend) {
        SetListRecomend(listRecomend);
    }

    @Override
    public void onErrorMsg(String msg) {
        Log.d("ErrorPresenter", msg);
    }
}
