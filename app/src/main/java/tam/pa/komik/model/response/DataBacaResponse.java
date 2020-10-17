package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tam.pa.komik.model.DetailChapterItem;

public class DataBacaResponse {
    @SerializedName("chapter_endpoint")
    @Expose
    private String chapterEndpoint;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("download_link")
    @Expose
    private String downloadLink;
    @SerializedName("chapter_pages")
    @Expose
    private Integer chapterPages;
    @SerializedName("chapter_image")
    @Expose
    private List<DetailChapterItem> chapterImage = null;

    public String getChapterEndpoint() {
        return chapterEndpoint;
    }

    public String getTitle() {
        return title;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public Integer getChapterPages() {
        return chapterPages;
    }

    public List<DetailChapterItem> getChapterImage() {
        return chapterImage;
    }
}
