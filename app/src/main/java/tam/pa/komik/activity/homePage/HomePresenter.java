package tam.pa.komik.activity.homePage;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.PopulerListItem;
import tam.pa.komik.model.response.DataGenresResponse;
import tam.pa.komik.model.response.DataListResponse;
import tam.pa.komik.model.response.DataRecomendResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class HomePresenter {
    private Activity activity;
    private IViewHome iView;
    private LoadingHelper loadingHelper;
    private ApiService apiService;

    public HomePresenter(Activity activity, IViewHome iView) {
        this.activity = activity;
        this.iView = iView;
        loadingHelper = new LoadingHelper(activity);
    }
    void onGetListKomik(final String pageNumber){
        loadingHelper.startLoading();
        apiService = ApiClient.getRetrofit().create(ApiService.class);
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getListKomik(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataListResponse>() {
                    @Override
                    public void onNext(DataListResponse dataListResponse) {
                        iView.onGetListKomik(dataListResponse.getMangaList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("errorPresenter", e.getMessage());
                        iView.onErrorMsg(e.getMessage());
                        loadingHelper.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        if (!pageNumber.equals("1")){
                            loadingHelper.stopLoading();
                        };
                    }
                })
        );
    }
    void onGetListGenres(){
//        loadingHelper.startLoading();
        apiService = ApiClient.getRetrofit().create(ApiService.class);
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataGenresResponse>() {
                    @Override
                    public void onNext(DataGenresResponse dataGenresResponse) {
                        iView.onGetListGenres(dataGenresResponse.getListGenre());
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.onErrorMsg(e.getMessage());
                        loadingHelper.stopLoading();
                    }

                    @Override
                    public void onComplete() {
//                        loadingHelper.stopLoading();
                    }
                })
        );
    }
    void onGetRecomend(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getRecomended()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataRecomendResponse>() {
                    @Override
                    public void onNext(DataRecomendResponse dataRecomendResponse) {
                        iView.onGetListRecomend(dataRecomendResponse.getMangaList());
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
                })
        );
    }
    void onGetPencarian(String query){
        loadingHelper.startLoading();
        apiService = ApiClient.getRetrofit().create(ApiService.class);
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.cariKomik(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<PopulerListItem>>() {
                    @Override
                    public void onNext(List<PopulerListItem> listResponse) {
                        iView.onGetPencarian(listResponse);
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
                })
        );
    };
}
