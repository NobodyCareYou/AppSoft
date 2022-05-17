package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.UnionRepository;

public class UnionViewModel extends BaseViewModel<UnionRepository> {

    public MutableLiveData<UnionRoomInfo> mUnionRoomInfo = new MutableLiveData<>();
    public MutableLiveData<Boolean> refreshResult = new MutableLiveData<>();

    @Override
    public UnionRepository getInstance() {
        return UnionRepository.getInstance();
    }


    public void getRoomTechnicianInfo(String p) {
        repository.getUnionInfo(p, new BaseObserver<UnionRoomInfo>(isShow, error) {
            @Override
            public void onSuccess(UnionRoomInfo info) {
                mUnionRoomInfo.setValue(info);
            }
        });
    }

    public void linkedRoom(String p) {
        repository.linkedRoom(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
                refreshResult.setValue(true);
            }
        });
    }


}
