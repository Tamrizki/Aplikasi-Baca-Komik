package tam.pa.komik.activity.genrePage;

import tam.pa.komik.model.response.DataGenresResponse;
import tam.pa.komik.model.response.DataListResponse;
import tam.pa.komik.model.response.DataPopulerResponse;

interface IViewGenre {
    void onGetListGenre(DataGenresResponse dataGenre);
    void onGetListPopuler(DataPopulerResponse dataPopuler);
    void onErrorMsg(String msg);
}
