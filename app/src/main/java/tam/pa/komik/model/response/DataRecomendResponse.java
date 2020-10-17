package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tam.pa.komik.model.RecomendKomikList;

public class DataRecomendResponse {
    @SerializedName("manga_list")
    @Expose
    private List<RecomendKomikList> mangaList = null;

    public List<RecomendKomikList> getMangaList() {
        return mangaList;
    }
}
