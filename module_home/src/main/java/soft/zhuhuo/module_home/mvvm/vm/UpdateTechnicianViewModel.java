package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.UpdateItemRepository;
import soft.zhuhuo.module_home.mvvm.respon.UpdateTechnicianRepository;

public class UpdateTechnicianViewModel extends BaseViewModel<UpdateTechnicianRepository> {

    public MutableLiveData<ItemTechnician> itemTechnician = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> updateTechnicianResult = new MutableLiveData<>();

    @Override
    public UpdateTechnicianRepository getInstance() {
        return UpdateTechnicianRepository.getInstance();
    }


    public void getItemTechnician(String param) {
        repository.requestItemTechnician(param, new BaseObserver<ItemTechnician>(isShow, error) {
            @Override
            public void onSuccess(ItemTechnician info) {
                itemTechnician.setValue(info);
            }
        });
    }


    public void updateTechnician(String p) {
        repository.updateTechnician(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                updateTechnicianResult.setValue(info);
            }
        });
    }
}
