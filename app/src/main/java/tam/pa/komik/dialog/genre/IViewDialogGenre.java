package tam.pa.komik.dialog.genre;

import java.util.List;

import tam.pa.komik.model.ListKomikByGenreItem;

interface IViewDialogGenre {
    void onGetListKomik(List<ListKomikByGenreItem> dataKomik);
    void onErrorMsg(String msg);
}
