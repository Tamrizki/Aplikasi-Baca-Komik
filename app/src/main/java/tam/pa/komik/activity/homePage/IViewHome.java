package tam.pa.komik.activity.homePage;

import java.util.List;

import tam.pa.komik.model.GenreItems;
import tam.pa.komik.model.KomikListItem;
import tam.pa.komik.model.PopulerListItem;
import tam.pa.komik.model.RecomendKomikList;

interface IViewHome {
    void onGetListKomik(List<KomikListItem>listKomik);
    void onGetListGenres(List<GenreItems> listGenre);
    void onGetListRecomend(List<RecomendKomikList> listGenre);
    void onGetPencarian(List<PopulerListItem> listPencarian);
    void onErrorMsg(String msg);
}
