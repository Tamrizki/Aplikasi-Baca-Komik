package tam.pa.komik.model.response;

import java.util.List;

import tam.pa.komik.model.PopulerListItem;

public class DataPencarianResponse {
    List<PopulerListItem> listPencarian = null;

    public DataPencarianResponse(List<PopulerListItem> listPencarian) {
        this.listPencarian = listPencarian;
    }

    public List<PopulerListItem> getListPencarian() {
        return listPencarian;
    }
}
