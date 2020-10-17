package tam.pa.komik.dialog.genre;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.komik.R;
import tam.pa.komik.dialog.genre.adapter.KomikByGenreAdapter;
import tam.pa.komik.model.ListKomikByGenreItem;

public class DialogListByGenre extends BottomSheetDialog implements IViewDialogGenre {
    private Context context;
    private IViewDialogGenre iViewDialogGenre;
    private DialogGenrePresenter presenter;
    private RecyclerView.LayoutManager lmKomik;
    private String endPoint = "", page = "";
    private KomikByGenreAdapter adapter;
    @BindView(R.id.tvGenre) TextView tvGenre;
    @BindView(R.id.rvKomik) RecyclerView rvKomik;
    public DialogListByGenre(@NonNull Context context, String endPoint, String title) {
        super(context, R.style.BottomSheetDialogTheme);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_komik_by_genre);
        iViewDialogGenre = this;
        ButterKnife.bind(this);
        tvGenre.setText(title);
        presenter = new DialogGenrePresenter((Activity) context, iViewDialogGenre);
        presenter.onGetListKomik(endPoint, "1");
    }

    @Override
    public void onGetListKomik(List<ListKomikByGenreItem> dataKomik) {
        lmKomik = new GridLayoutManager(context, 2);
        adapter = new KomikByGenreAdapter(context, dataKomik);
        rvKomik.setHasFixedSize(true);
        rvKomik.setLayoutManager(lmKomik);
        rvKomik.setAdapter(adapter);
    }

    @Override
    public void onErrorMsg(String msg) {
        Log.d("ErrorPresenter", msg);
    }
}
