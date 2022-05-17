package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;

public class UpClockRepository extends BaseRepository {


    public static UpClockRepository getInstance() {
        return new UpClockRepository();
    }

    @SuppressLint("CheckResult")
    public void upClock(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.upClock(body).compose(NetworkApi.applySchedulers(callback));
    }

}
