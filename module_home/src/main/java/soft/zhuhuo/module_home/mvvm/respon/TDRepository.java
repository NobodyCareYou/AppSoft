package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import com.google.gson.JsonObject;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;

public class TDRepository extends BaseRepository {


    public static TDRepository getInstance() {
        return new TDRepository();
    }


    @SuppressLint("CheckResult")
    public void requestTechnicianInfo(String p, Observer<? super TD> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.getTechnicianInfo(body).compose(NetworkApi.applySchedulers(callback));
    }

    @SuppressLint("CheckResult")
    public void upClock(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.upClock(body).compose(NetworkApi.applySchedulers(callback));
    }

    @SuppressLint("CheckResult")
    public void downClock(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.downClock(body).compose(NetworkApi.applySchedulers(callback));
    }


    @SuppressLint("CheckResult")
    public void downClockAlert(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.downClockAlert(body).compose(NetworkApi.applySchedulers(callback));
    }


    @SuppressLint("CheckResult")
    public void cancelItem(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.cancelItem(body).compose(NetworkApi.applySchedulers(callback));
    }


}
