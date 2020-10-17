package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KomikListItem {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("endpoint")
    @Expose
    private String endpoint;
    @SerializedName("chapter")
    @Expose
    private String chapter;

    public KomikListItem(String title, String thumb, String type, String updatedOn, String endpoint, String chapter) {
        this.title = title;
        this.thumb = thumb;
        this.type = type;
        this.updatedOn = updatedOn;
        this.endpoint = endpoint;
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public String getThumb() {
        return thumb;
    }

    public String getType() {
        return type;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getChapter() {
        return chapter;
    }
}
