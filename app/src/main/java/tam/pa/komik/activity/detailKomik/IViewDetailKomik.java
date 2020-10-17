package tam.pa.komik.activity.detailKomik;

import tam.pa.komik.model.response.DataDetailKomikResponse;

interface IViewDetailKomik {
    void onGetDetailKomik(DataDetailKomikResponse detailKomik);
    void onErrorMsg(String msg);
}
