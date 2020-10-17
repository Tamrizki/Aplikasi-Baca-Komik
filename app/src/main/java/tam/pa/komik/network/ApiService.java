package tam.pa.komik.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tam.pa.komik.model.PopulerListItem;
import tam.pa.komik.model.response.DataBacaResponse;
import tam.pa.komik.model.response.DataDetailKomikResponse;
import tam.pa.komik.model.response.DataGenresResponse;
import tam.pa.komik.model.response.DataKomikByGenreResponse;
import tam.pa.komik.model.response.DataListResponse;
import tam.pa.komik.model.response.DataPencarianResponse;
import tam.pa.komik.model.response.DataPopulerResponse;
import tam.pa.komik.model.response.DataRecomendResponse;

public interface ApiService {
    //List Komik
    @GET("manga/page/{pageNumber}")
    Observable<DataListResponse> getListKomik(@Path("pageNumber") String pageNumber);
    // Pencarian
    @GET("cari/{query}")
    Observable<List<PopulerListItem>> cariKomik(@Path("query") String query);
    //Detail Komik
    @GET("manga/detail/{endpoint}")
    Observable<DataDetailKomikResponse> getDetailKomik(@Path("endpoint") String endpoint);
    // Genre Komik
    @GET("genres")
    Observable<DataGenresResponse> getGenres();
    // Detail Genre Komik
    @GET("genres/{endpoint}/{pagenumber}")
    Observable<DataKomikByGenreResponse> getListByGenres(@Path("endpoint") String endpoint, @Path("pagenumber") String pagenumber);
    // Recomended Komik
    @GET("recommended")
    Observable<DataRecomendResponse> getRecomended();
    // Detail Chapter
    @GET("chapter/{chapterEndpoint}")
    Observable<DataBacaResponse> getDetailChapter(@Path("chapterEndpoint") String chapterEndpoint);
    // Populer
    @GET("manga/popular/{pageNumber}")
    Observable<DataPopulerResponse> getPopuler(@Path("pageNumber") String pageNumber);
}

