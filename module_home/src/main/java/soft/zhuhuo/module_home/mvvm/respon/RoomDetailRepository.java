package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.RoomDetail;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;

public class RoomDetailRepository extends BaseRepository {


    public static RoomDetailRepository getInstance() {
        return new RoomDetailRepository();
    }


    @SuppressLint("CheckResult")
    public void requestRoomDetail(String roomCode, Observer<? super RoomDetail> callback) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "2002");
        jsonObject.addProperty("OptTypeID", "3");
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("RoomCode", roomCode);
        obj.addProperty("OpenOrgID", MVUtils.getString(Key.ORG_ID));
        obj.addProperty("MemberTypeID", "");
        data.add(obj);
        jsonObject.add("Data", data);
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        apiService.getRoomDetail(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void cleanRoom(String roomCode, String type, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), BaseRequest.getCleanRoomP(type,roomCode));
        apiService.cleanRoom(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void setRoomState(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.setRoomState(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void upClock(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.upClock(body).compose(NetworkApi.applySchedulers(callback));
    }

    @SuppressLint("CheckResult")
    public void leaveMessage(String p, Observer<? super BaseObResult> callback) {
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

    @SuppressLint("CheckResult")
    public void split(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.cancelItem(body).compose(NetworkApi.applySchedulers(callback));
    }

  @SuppressLint("CheckResult")
    public void updateRoom(String p, Observer<? super BaseObResult> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
      RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), p);
        apiService.updateRoom(body).compose(NetworkApi.applySchedulers(callback));
    }

}
