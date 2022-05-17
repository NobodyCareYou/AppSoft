package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.RoomOptRepository;

public class RoomOptViewModel extends BaseViewModel<RoomOptRepository> {

    public MutableLiveData<Boolean> openRoomResult = new MutableLiveData<>();

    public MutableLiveData<Boolean> result = new MutableLiveData<>();

    @Override
    public RoomOptRepository getInstance() {
        return RoomOptRepository.getInstance();
    }


    public void openRoom(String roomCode) {
        repository.openRoom(roomCode,new BaseObserver<BaseObResult>(isShow,error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                openRoomResult.setValue(true);
            }
        });
    }

    public void setRoomState(String p) {
        repository.setRoomState(p,new BaseObserver<BaseObResult>(isShow,error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                result.setValue(true);
            }
        });
    }

    public void cleanRoom(String roomCode,String type) {
        repository.cleanRoom(roomCode,type,new BaseObserver<BaseObResult>(isShow,error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                result.setValue(true);
            }
        });
    }
}
