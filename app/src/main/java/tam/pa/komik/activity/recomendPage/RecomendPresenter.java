package tam.pa.komik.activity.recomendPage;

import android.app.Activity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.response.DataRecomendResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class RecomendPresenter {
    private IViewRecomend iViewRecomend;
    private Activity activity;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;

    public RecomendPresenter(IViewRecomend iViewRecomend, Activity activity) {
        this.iViewRecomend = iViewRecomend;
        this.activity = activity;
        loadingHelper = new LoadingHelper(activity);
    }
    void onGetRecomend(){
        loadingHelper.startLoading();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getRecomended()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<DataRecomendResponse>() {
                            @Override
                            public void onNext(DataRecomendResponse dataRecomendResponse) {
                                iViewRecomend.onGetRecomend(dataRecomendResponse.getMangaList());
                            }

                            @Override
                            public void onError(Throwable e) {
                                iViewRecomend.onErrorMsg(e.getMessage());
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
