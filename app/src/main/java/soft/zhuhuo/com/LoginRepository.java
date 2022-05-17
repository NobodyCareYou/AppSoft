package soft.zhuhuo.com;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.ObservableTransformer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseRepository;
import soft.zhuhuo.lib.bean.User;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;

public class LoginRepository extends BaseRepository {

    public static LoginRepository getInstance() {
        return new LoginRepository();
    }


    @SuppressLint("CheckResult")
    public void sendLoginRequest(String personCode, String pwd, BaseObserver<User> callback) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", "10023");
        jsonObject.addProperty("MecCode", "");
        JsonArray data = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("PeronCode", personCode);
        obj.addProperty("Pwd", pwd);
        data.add(obj);
        jsonObject.add("Data", data);
        ApiService apiService = NetworkApi.createService(ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        apiService.login(body).compose(NetworkApi.applySchedulers(callback));
    }

}
