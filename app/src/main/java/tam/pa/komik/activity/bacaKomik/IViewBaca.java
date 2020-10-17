package tam.pa.komik.activity.bacaKomik;

import tam.pa.komik.model.response.DataBacaResponse;

interface IViewBaca {
    void onGetDetailChapter(DataBacaResponse dataBacaResponse);
    void onErrorMsg(String msg);
}
