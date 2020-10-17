package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreItems {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("endpoint")
    @Expose
    private String endpoint;

    public String getTitle() {
        return title;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
