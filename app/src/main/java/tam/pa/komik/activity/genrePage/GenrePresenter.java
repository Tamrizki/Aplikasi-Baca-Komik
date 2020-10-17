package tam.pa.komik.activity.genrePage;

import android.app.Activity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.response.DataGenresResponse;
import tam.pa.komik.model.response.DataListResponse;
import tam.pa.komik.model.response.DataPopulerResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class GenrePresenter {
    private Activity activity;
    private IViewGenre iViewGenre;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;

    public GenrePresenter(Activity activity, IViewGenre iViewGenre) {
        this.activity = activity;
        this.iViewGenre = iViewGenre;
        loadingHelper = new LoadingHelper(activity);
    }
    void onGetListGenres(){
        loadingHelper.startLoading();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataGenresResponse>() {
                    @Override
                    public void onNext(DataGenresResponse dataGenresResponse) {
                        iViewGenre.onGetListGenre(dataGenresResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewGenre.onErrorMsg(e.getMessage());
                        loadingHelper.stopLoading();
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }
    void onGetPopuler(String pageNumber){
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getPopuler(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataPopulerResponse>() {
                    @Override
                    public void onNext(DataPopulerResponse dataListResponse) {
                        iViewGenre.onGetListPopuler(dataListResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewGenre.onErrorMsg(e.getMessage());
                        loadingHelper.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        loadingHelper.stopLoading();
                    }
                })
        );
    }
}
