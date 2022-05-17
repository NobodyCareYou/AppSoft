package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.BaseResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;

public class UpdateItemRepository extends BaseRepository {


    public static UpdateItemRepository getInstance() {
        return new UpdateItemRepository();
    }


    @SuppressLint("CheckResult")
    public void requestTechnicianCanDoItem(String p, Observer<? super TCItem> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.getTechnicianCanDoItem(body).compose(NetworkApi.applySchedulers(callback));
    }
    @SuppressLint("CheckResult")
    public void updateItem(String p, BaseObserver<BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.updateItem(body).compose(NetworkApi.applySchedulers(callback));
    }
}
