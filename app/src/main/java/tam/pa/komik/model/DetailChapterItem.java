package tam.pa.komik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailChapterItem {
    @SerializedName("chapter_image_link")
    @Expose
    private String chapterImageLink;
    @SerializedName("image_number")
    @Expose
    private Integer imageNumber;

    public String getChapterImageLink() {
        return chapterImageLink;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }
}
