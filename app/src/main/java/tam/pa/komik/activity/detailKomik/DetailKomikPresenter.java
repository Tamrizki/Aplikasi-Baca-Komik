package tam.pa.komik.activity.detailKomik;

import android.app.Activity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.komik.helper.LoadingHelper;
import tam.pa.komik.model.response.DataDetailKomikResponse;
import tam.pa.komik.network.ApiClient;
import tam.pa.komik.network.ApiService;

public class DetailKomikPresenter {
    private IViewDetailKomik iView;
    private Activity activity;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;

    public DetailKomikPresenter(IViewDetailKomik iView, Activity activity) {
        this.iView = iView;
        this.activity = activity;
        loadingHelper = new LoadingHelper(activity);
    }
    void onGetDetailKomik(String endpoint){
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.getDetailKomik(endpoint)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataDetailKomikResponse>() {
                    @Override
                    public void onNext(DataDetailKomikResponse dataDetailKomikResponse) {
                        iView.onGetDetailKomik(dataDetailKomikResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.onErrorMsg(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                })
        );
    }
}
