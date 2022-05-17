package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;

public class UpdateTechnicianRepository extends BaseRepository {


    public static UpdateTechnicianRepository getInstance() {
        return new UpdateTechnicianRepository();
    }


    @SuppressLint("CheckResult")
    public void requestItemTechnician(String p, Observer<? super ItemTechnician> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.getItemTechnician(body).compose(NetworkApi.applySchedulers(callback));
    }



    @SuppressLint("CheckResult")
    public void updateTechnician(String p, BaseObserver<BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.updateTechnician(body).compose(NetworkApi.applySchedulers(callback));
    }
}
