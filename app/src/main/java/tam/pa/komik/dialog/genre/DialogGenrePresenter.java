package tam.pa.komik.dialog.genre;

import android.app.Activity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.response.DataKomikByGenreResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class DialogGenrePresenter {
    private Activity activity;
    private IViewDialogGenre iView;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;

    public DialogGenrePresenter(Activity activity, IViewDialogGenre iView) {
        this.activity = activity;
        this.iView = iView;
        loadingHelper = new LoadingHelper(activity);
    }

    void onGetListKomik(String endpoint, String pagenumber){
        loadingHelper.startLoading();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getListByGenres(endpoint, pagenumber)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<DataKomikByGenreResponse>() {
                            @Override
                            public void onNext(DataKomikByGenreResponse dataKomikByGenreResponse) {
                                iView.onGetListKomik(dataKomikByGenreResponse.getMangaList());
                            }

                            @Override
                            public void onError(Throwable e) {
                                iView.onErrorMsg(e.getMessage());
                                loadingHelper.stopLoading();
                            }

                            @Override
                            public void onComplete() {
                                loadingHelper.stopLoading();
                            }
                        }
        ));
    }
}
