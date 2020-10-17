package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreListItem {
    @SerializedName("genre_name")
    @Expose
    private String genreName;

    public String getGenreName() {
        return genreName;
    }
}
