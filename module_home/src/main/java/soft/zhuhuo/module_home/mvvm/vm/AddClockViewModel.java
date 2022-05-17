package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.AddClockRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpdateItemRepository;

public class AddClockViewModel extends BaseViewModel<AddClockRepository> {

    public MutableLiveData<TCItem> technicianItems = new MutableLiveData<>();
    public MutableLiveData<Boolean> addClockResult = new MutableLiveData<>();

    @Override
    public AddClockRepository getInstance() {
        return AddClockRepository.getInstance();
    }


    public void getTechnicianCanDoItem(String param) {
        repository.requestTechnicianCanDoItem(param, new BaseObserver<TCItem>(isShow, error) {
            @Override
            public void onSuccess(TCItem info) {
                technicianItems.setValue(info);
            }
        });
    }


    public void add(String p) {
        repository.addClock(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                addClockResult.setValue(true);
            }
        });
    }
}
