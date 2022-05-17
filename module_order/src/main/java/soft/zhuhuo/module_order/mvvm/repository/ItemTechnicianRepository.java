package soft.zhuhuo.module_order.mvvm.repository;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;

public class ItemTechnicianRepository extends BaseRepository {


    public static ItemTechnicianRepository getInstance() {
        return new ItemTechnicianRepository();
    }

    @SuppressLint("CheckResult")
    public void getItemTechnician(String p, Observer<? super ItemTechnician> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.getItemTechnician(body).compose(NetworkApi.applySchedulers(callback));
    }


}
