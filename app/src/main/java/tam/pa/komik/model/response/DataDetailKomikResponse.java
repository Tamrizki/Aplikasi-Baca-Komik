package tam.pa.komik.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tam.pa.komik.model.ChapterItem;
import tam.pa.komik.model.GenreListItem;

public class DataDetailKomikResponse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("manga_endpoint")
    @Expose
    private String mangaEndpoint;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("genre_list")
    @Expose
    private List<GenreListItem> genreList = null;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("chapter")
    @Expose
    private List<ChapterItem> chapter = null;

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public String getMangaEndpoint() {
        return mangaEndpoint;
    }

    public String getThumb() {
        return thumb;
    }

    public List<GenreListItem> getGenreList() {
        return genreList;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public List<ChapterItem> getChapter() {
        return chapter;
    }
}
