package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;

public class UnionRepository extends BaseRepository {

    public static UnionRepository getInstance() {
        return new UnionRepository();
    }

    @SuppressLint("CheckResult")
    public void getUnionInfo(String p, Observer<? super UnionRoomInfo> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.getUnionInfo(body).compose(NetworkApi.applySchedulers(callback));
    }

    @SuppressLint("CheckResult")
    public void linkedRoom(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.linkedRoom(body).compose(NetworkApi.applySchedulers(callback));
    }



}
