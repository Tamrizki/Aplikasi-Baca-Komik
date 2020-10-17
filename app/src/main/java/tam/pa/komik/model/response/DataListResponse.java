package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tam.pa.komik.model.KomikListItem;

public class DataListResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("manga_list")
    @Expose
    private List<KomikListItem> mangaList = null;

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<KomikListItem> getMangaList() {
        return mangaList;
    }
}
