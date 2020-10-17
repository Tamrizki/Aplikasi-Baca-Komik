package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tam.pa.komik.model.GenreItems;

public class DataGenresResponse {
    @SerializedName("list_genre")
    @Expose
    private List<GenreItems> listGenre = null;

    public List<GenreItems> getListGenre() {
        return listGenre;
    }
}
