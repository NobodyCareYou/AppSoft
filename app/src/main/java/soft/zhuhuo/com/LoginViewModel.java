package soft.zhuhuo.com;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.bean.User;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.TUtils;

public class LoginViewModel extends BaseViewModel<LoginRepository> {

    @Override
    public LoginRepository getInstance() {
        return LoginRepository.getInstance();
    }

    public MutableLiveData<String> account = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Boolean> isCheck = new MutableLiveData<>();
    public MutableLiveData<User> mUser = new MutableLiveData<>();


    public void login(String personCode, String pwd) {
        if (TextUtils.isEmpty(NetworkApi.getBaseUrl())){
            TUtils.show("请先设置请求地址");
            return;
        }
        if (TextUtils.isEmpty(personCode)) {
            TUtils.show("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            TUtils.show("密码不能为空");
            return;
        }

        repository.sendLoginRequest(personCode, pwd, new BaseObserver<User>(isShow, error) {
            @Override
            public void onSuccess(User user) {
                mUser.setValue(user);
            }
        });

    }

}
