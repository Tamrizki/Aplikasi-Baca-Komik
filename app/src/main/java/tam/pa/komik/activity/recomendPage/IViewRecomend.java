package tam.pa.komik.activity.recomendPage;

import java.util.List;

import tam.pa.komik.model.RecomendKomikList;

interface IViewRecomend {
    void onGetRecomend(List<RecomendKomikList> listRecomend);
    void onErrorMsg(String msg);
}
