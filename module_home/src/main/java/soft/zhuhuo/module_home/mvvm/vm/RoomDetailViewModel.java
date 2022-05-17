package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.RoomDetail;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.RoomDetailRepository;

public class RoomDetailViewModel extends BaseViewModel<RoomDetailRepository> {

    public MutableLiveData<RoomDetail> mRoomDetail = new MutableLiveData<>();
    public MutableLiveData<BaseObResult> cleanRoomResult = new MutableLiveData<>();

    public MutableLiveData<BaseObResult> setNightResult = new MutableLiveData<>();
    public MutableLiveData<Boolean> refreshResult = new MutableLiveData<>();
    public MutableLiveData<Boolean> updateRoomResult = new MutableLiveData<>();

    @Override
    public RoomDetailRepository getInstance() {
        return RoomDetailRepository.getInstance();
    }


    public void getRoomDetailInfo(String roomCode) {
        repository.requestRoomDetail(roomCode, new BaseObserver<RoomDetail>(isShow, error) {
            @Override
            public void onSuccess(RoomDetail roomDetail) {
                mRoomDetail.setValue(roomDetail);
            }
        });
    }

    public void clearRoom(String roomCode, String type) {
        repository.cleanRoom(roomCode, type, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseResult) {
                cleanRoomResult.setValue(baseResult);
            }
        });
    }


    public void leaveMessage(String p) {
        repository.leaveMessage(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void setRoomState(String nightP) {
        repository.setRoomState(nightP, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseResult) {
                TUtils.show(baseResult.getMsgInfo());
                setNightResult.setValue(baseResult);
            }
        });

    }

    public void upClock(String p) {
        repository.upClock(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void downClock(String p) {
        repository.downClock(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void downClockAlert(String p) {
        repository.downClockAlert(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void cancelItem(String p) {
        repository.cancelItem(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }

    public void split(String p) {
        repository.split(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }


    public void updateRoom(String p) {
        repository.updateRoom(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
                updateRoomResult.setValue(true);
            }
        });
    }
}
