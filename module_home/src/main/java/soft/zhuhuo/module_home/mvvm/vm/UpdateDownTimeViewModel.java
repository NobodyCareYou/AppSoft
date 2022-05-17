package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.UpdateClockTypeRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpdateDownTimeRepository;

public class UpdateDownTimeViewModel extends BaseViewModel<UpdateDownTimeRepository> {

    public MutableLiveData<BaseObResult> updateDownTimeResult = new MutableLiveData<>();

    @Override
    public UpdateDownTimeRepository getInstance() {
        return UpdateDownTimeRepository.getInstance();
    }


    public void updateDownTine(String p) {
        repository.updateDownTime(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                updateDownTimeResult.setValue(info);
            }
        });
    }
}
