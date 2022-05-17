package soft.zhuhuo.module_home.mvvm.vm;

import androidx.lifecycle.MutableLiveData;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.AddClockRepository;
import soft.zhuhuo.module_home.mvvm.respon.FirstRepository;

public class FirstViewModel extends BaseViewModel<FirstRepository> {


    @Override
    public FirstRepository getInstance() {
        return FirstRepository.getInstance();
    }


    public void first(String param) {
        repository.first(param, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
            }
        });
    }


}
