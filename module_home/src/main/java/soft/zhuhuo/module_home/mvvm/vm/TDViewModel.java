package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.TDRepository;

public class TDViewModel extends BaseViewModel<TDRepository> {

    public MutableLiveData<TD> technicianInfo = new MutableLiveData<>();
    public MutableLiveData<Boolean> refreshResult = new MutableLiveData<>();

    @Override
    public TDRepository getInstance() {
        return TDRepository.getInstance();
    }


    public void getTechnicianInfo(String param) {
        repository.requestTechnicianInfo(param, new BaseObserver<TD>(isShow, error) {
            @Override
            public void onSuccess(TD info) {
                technicianInfo.setValue(info);
            }
        });
    }


    public void upClock(String param) {
        repository.upClock(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void downClock(String param) {
        repository.downClock(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void downClockAlert(String param) {
        repository.downClockAlert(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void cancelItem(String param) {
        repository.cancelItem(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }
}
