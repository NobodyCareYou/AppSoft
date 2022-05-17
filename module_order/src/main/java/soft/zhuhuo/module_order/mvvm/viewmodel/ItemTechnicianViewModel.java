package soft.zhuhuo.module_order.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_order.mvvm.repository.ItemTechnicianRepository;

public class ItemTechnicianViewModel extends BaseViewModel<ItemTechnicianRepository> {

    public final MutableLiveData<ItemTechnician> itemTechnician = new MutableLiveData<>();

    @Override
    public ItemTechnicianRepository getInstance() {
        return ItemTechnicianRepository.getInstance();
    }

    public void getItemTechnician(String param) {
        repository.getItemTechnician(param, new BaseObserver<ItemTechnician>(null, null) {
            @Override
            public void onSuccess(ItemTechnician info) {
                itemTechnician.setValue(info);
            }
        });
    }

}
