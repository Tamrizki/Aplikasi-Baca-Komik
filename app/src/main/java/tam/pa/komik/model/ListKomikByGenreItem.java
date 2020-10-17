package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListKomikByGenreItem {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("endpoint")
    @Expose
    private String endpoint;

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getThumb() {
        return thumb;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
