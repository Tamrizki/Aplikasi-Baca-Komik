package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterItem {
    @SerializedName("chapter_title")
    @Expose
    private String chapterTitle;
    @SerializedName("chapter_endpoint")
    @Expose
    private String chapterEndpoint;

    public String getChapterTitle() {
        return chapterTitle;
    }

    public String getChapterEndpoint() {
        return chapterEndpoint;
    }
}
