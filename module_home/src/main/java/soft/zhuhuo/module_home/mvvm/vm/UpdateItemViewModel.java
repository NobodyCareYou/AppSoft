package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.TDRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpdateItemRepository;

public class UpdateItemViewModel extends BaseViewModel<UpdateItemRepository> {

    public MutableLiveData<TCItem> technicianItems = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> updateItemResult = new MutableLiveData<>();

    @Override
    public UpdateItemRepository getInstance() {
        return UpdateItemRepository.getInstance();
    }


    public void getTechnicianCanDoItem(String param) {
        repository.requestTechnicianCanDoItem(param, new BaseObserver<TCItem>(isShow, error) {
            @Override
            public void onSuccess(TCItem info) {
                technicianItems.setValue(info);
            }
        });
    }

    public void updateItem(String p) {
        repository.updateItem(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                updateItemResult.setValue(info);
            }
        });
    }
}
