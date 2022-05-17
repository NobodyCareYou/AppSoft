package soft.zhuhuo.module_home.mvvm.respon;

import android.annotation.SuppressLint;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.FloorInfo;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.RoomType;
import soft.zhuhuo.lib.bean.TechnicianType;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;

public class RoomTechnicianBaseRepository extends BaseRepository {



    public static RoomTechnicianBaseRepository getInstance() {
        return new RoomTechnicianBaseRepository();
    }

    @SuppressLint("CheckResult")
    public void requestRoomOtherInfo(Observer<? super FloorInfo> callback) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10005");
        jsonObject.addProperty("OptTypeID", "3");
        jsonObject.addProperty("MecCode", "");
        jsonObject.addProperty("OrgID", MVUtils.getString(Key.ORG_ID));
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("FloorID", "");
        obj.addProperty("FloorName", "");
        obj.addProperty("Sort", "");
        data.add(obj);
        jsonObject.add("Data", data);
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        apiService.getRoomOtherInfo(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void requestRoomTypeInfo(Observer<? super RoomType> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), BaseRequest.getRoomTypesP());
        apiService.getRoomType(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void getTechnicianTypeInfo(Observer<? super TechnicianType> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), BaseRequest.getTechnicianTypeP());
        apiService.getTechnicianType(body).compose(NetworkApi.applySchedulers(callback));

    }

    @SuppressLint("CheckResult")
    public void getItems( Observer<? super ItemInfo> callback) {
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), BaseRequest.getItemParam());
        apiService.getItemInfo(body).compose(NetworkApi.applySchedulers(callback));
    }

}
