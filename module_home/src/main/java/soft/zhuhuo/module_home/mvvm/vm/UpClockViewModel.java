package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.AddClockRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpClockRepository;

public class UpClockViewModel extends BaseViewModel<UpClockRepository> {

    public MutableLiveData<Boolean> upClockResult = new MutableLiveData<>();

    @Override
    public UpClockRepository getInstance() {
        return UpClockRepository.getInstance();
    }


    public void upClock(String param) {
        repository.upClock(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                upClockResult.setValue(true);
            }
        });
    }


}
