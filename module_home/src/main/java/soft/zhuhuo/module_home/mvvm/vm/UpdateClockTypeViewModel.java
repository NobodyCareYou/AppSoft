package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.UpdateClockTypeRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpdateItemRepository;

public class UpdateClockTypeViewModel extends BaseViewModel<UpdateClockTypeRepository> {

    public MutableLiveData<BaseObResult> updateClockTypeResult = new MutableLiveData<>();

    @Override
    public UpdateClockTypeRepository getInstance() {
        return UpdateClockTypeRepository.getInstance();
    }


    public void updateClockType(String p) {
        repository.updateClockType(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                updateClockTypeResult.setValue(info);
            }
        });
    }
}
