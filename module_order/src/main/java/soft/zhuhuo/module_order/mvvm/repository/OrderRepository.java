package soft.zhuhuo.module_order.mvvm.repository;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;

public class OrderRepository extends BaseRepository {


    public static OrderRepository getInstance() {
        return new OrderRepository();
    }


    @SuppressLint("CheckResult")
    public void orderMain(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.orderMain(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void orderAdditional(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.orderAdditional(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void orderGoods(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.orderGoods(body).compose(NetworkApi.applySchedulers(callback));

    }

}
