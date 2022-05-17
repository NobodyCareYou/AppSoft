package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.RoomOptRepository;
import soft.zhuhuo.module_home.mvvm.respon.TechnicianOptRepository;

public class TechnicianOptViewModel extends BaseViewModel<TechnicianOptRepository> {

    public MutableLiveData<Boolean> result = new MutableLiveData<>();
    public MutableLiveData<TD> technicianInfo = new MutableLiveData<>();


    @Override
    public TechnicianOptRepository getInstance() {
        return TechnicianOptRepository.getInstance();
    }

    public void setTechnicianState(String p) {
        repository.setTechnicianState(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                result.setValue(true);
            }
        });
    }




    public void upClock(String tucParam) {
        repository.upClock(tucParam, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                result.setValue(true);
            }
        });
    }

    public void downClock(String p) {
        repository.downClock(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                result.setValue(true);
            }
        });
    }


    public void  requestTechnicianDetail(String p ){
        repository.requestTechnicianInfo(p, new BaseObserver<TD>(isShow, error) {
            @Override
            public void onSuccess(TD info) {
                technicianInfo.setValue(info);
            }
        });
    }

    public void cancelItem(String p) {
        repository.cancelItem(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                result.setValue(true);
            }
        });
    }


}
