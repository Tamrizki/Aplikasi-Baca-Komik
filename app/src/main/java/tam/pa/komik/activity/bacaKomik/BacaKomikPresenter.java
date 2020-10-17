package tam.pa.komik.activity.bacaKomik;

import android.app.Activity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.response.DataBacaResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class BacaKomikPresenter {
    private IViewBaca iViewBaca;
    private Activity activity;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;

    public BacaKomikPresenter(IViewBaca iViewBaca, Activity activity) {
        this.iViewBaca = iViewBaca;
        this.activity = activity;
        loadingHelper = new LoadingHelper(activity);
    }
    void onGetDetailChapter(String endpoint){
        loadingHelper.startLoading();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getDetailChapter(endpoint)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataBacaResponse>() {
                    @Override
                    public void onNext(DataBacaResponse dataBacaResponse) {
                        iViewBaca.onGetDetailChapter(dataBacaResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewBaca.onErrorMsg(e.getMessage());
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
