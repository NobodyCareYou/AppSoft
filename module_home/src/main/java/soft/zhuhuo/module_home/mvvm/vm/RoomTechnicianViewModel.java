package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.bean.FloorInfo;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.RoomType;
import soft.zhuhuo.lib.bean.TechnicianType;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.module_home.mvvm.respon.RoomTechnicianBaseRepository;

public class RoomTechnicianViewModel extends BaseViewModel<RoomTechnicianBaseRepository> {

    public MutableLiveData<FloorInfo> mFloorInfo = new MutableLiveData<>();
    public MutableLiveData<RoomType> mRoomTypeInfo = new MutableLiveData<>();
    public MutableLiveData<TechnicianType> mTechnicianTypeInfo = new MutableLiveData<>();
    public MutableLiveData<ItemInfo> mItemInfo = new MutableLiveData<>();

    @Override
    public RoomTechnicianBaseRepository getInstance() {
        return RoomTechnicianBaseRepository.getInstance();
    }


    public void getItems() {
        repository.getItems(new BaseObserver<ItemInfo>(null, null) {
            @Override
            public void onSuccess(ItemInfo info) {
                mItemInfo.setValue(info);
            }
        });
    }

    public void getFloorInfo() {
        repository.requestRoomOtherInfo(new BaseObserver<FloorInfo>(null, null) {
            @Override
            public void onSuccess(FloorInfo info) {
                mFloorInfo.setValue(info);
            }
        });
    }

    public void getRoomTypeInfo() {
        repository.requestRoomTypeInfo(new BaseObserver<RoomType>(null, null) {
            @Override
            public void onSuccess(RoomType info) {
                mRoomTypeInfo.setValue(info);
            }
        });
    }

    public void getTechnicianTypeInfo() {
        repository.getTechnicianTypeInfo(new BaseObserver<TechnicianType>(null, null) {
            @Override
            public void onSuccess(TechnicianType info) {
                mTechnicianTypeInfo.setValue(info);
            }
        });
    }
}
