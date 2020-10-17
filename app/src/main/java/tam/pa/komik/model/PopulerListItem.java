package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopulerListItem {
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
    @SerializedName("upload_on")
    @Expose
    private String uploadOn;

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

    public String getUploadOn() {
        return uploadOn;
    }
}
