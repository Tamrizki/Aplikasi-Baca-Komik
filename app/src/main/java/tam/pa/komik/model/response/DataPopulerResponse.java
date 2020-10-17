package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import tam.pa.komik.model.PopulerListItem;

public class DataPopulerResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("manga_list")
    @Expose
    private List<PopulerListItem> mangaList = null;

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<PopulerListItem> getMangaList() {
        return mangaList;
    }
}
