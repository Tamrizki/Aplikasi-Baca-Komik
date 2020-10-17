package tam.pa.komik.dialog.pencarian;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
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
import tam.pa.komik.dialog.pencarian.adapter.PencarianAdapter;
import tam.pa.komik.model.PopulerListItem;

public class DialogListPencarian extends BottomSheetDialog {
    private Context context;
    private RecyclerView.LayoutManager lmKomik;
    private PencarianAdapter adapter;
    @BindView(R.id.tvCaption) TextView tvCaptoin;
    @BindView(R.id.tvNotFound) TextView tvNotFound;
    @BindView(R.id.rvKomik) RecyclerView rvKomik;
    public DialogListPencarian(@NonNull Context context, List<PopulerListItem>listKomik, String caption) {
        super(context, R.style.BottomSheetDialogTheme);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_pencarian);
        ButterKnife.bind(this);
        tvCaptoin.setText("Pencarian : "+caption);
        if (listKomik.size()==0){
            tvNotFound.setVisibility(View.VISIBLE);
            rvKomik.setVisibility(View.GONE);
        }else {
            SetListKomik(listKomik);
        }
    }

    private void SetListKomik(List<PopulerListItem> listKomik) {
        lmKomik = new GridLayoutManager(context, 2);
        adapter = new PencarianAdapter(context, listKomik);
        rvKomik.setHasFixedSize(true);
        rvKomik.setLayoutManager(lmKomik);
        rvKomik.setAdapter(adapter);
    }
}
