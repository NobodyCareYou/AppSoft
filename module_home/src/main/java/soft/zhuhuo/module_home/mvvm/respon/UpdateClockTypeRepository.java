package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import com.google.gson.JsonObject;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.BaseResult;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;

public class UpdateClockTypeRepository extends BaseRepository {



    public static UpdateClockTypeRepository getInstance() {
        return new UpdateClockTypeRepository();
    }


    @SuppressLint("CheckResult")
    public void updateClockType(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.updateClockType(body).compose(NetworkApi.applySchedulers(callback));

    }

}
