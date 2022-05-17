package soft.zhuhuo.module_order.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.FloorInfo;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.module_order.mvvm.repository.OrderRepository;

public class OrderViewModel extends BaseViewModel<OrderRepository> {

    public MutableLiveData<ItemInfo> mItemInfo = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> orderMainResult = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> orderAdditionalResult = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> orderGoodsResult = new MutableLiveData<>();

    @Override
    public OrderRepository getInstance() {
        return OrderRepository.getInstance();
    }



    public void orderMain(String param) {
        repository.orderMain(param, new BaseObserver<BaseObResult>(isShow, error) {

            @Override
            public void onSuccess(BaseObResult info) {
                orderMainResult.setValue(info);
            }

        });
    }

    public void orderAdditional(String param) {
        repository.orderAdditional(param, new BaseObserver<BaseObResult>(isShow, error) {

            @Override
            public void onSuccess(BaseObResult info) {
                orderAdditionalResult.setValue(info);
            }

        });
    }

    public void orderGoods(String param) {
        repository.orderGoods(param, new BaseObserver<BaseObResult>(isShow, error) {

            @Override
            public void onSuccess(BaseObResult info) {
                orderGoodsResult.setValue(info);
            }

        });
    }


}
