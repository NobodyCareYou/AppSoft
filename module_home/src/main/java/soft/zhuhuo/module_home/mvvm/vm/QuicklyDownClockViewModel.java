package soft.zhuhuo.module_home.mvvm.vm;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.FirstRepository;
import soft.zhuhuo.module_home.mvvm.respon.QuicklyDownClockRepository;

public class QuicklyDownClockViewModel extends BaseViewModel<QuicklyDownClockRepository> {


    @Override
    public QuicklyDownClockRepository getInstance() {
        return QuicklyDownClockRepository.getInstance();
    }

    public void downClock(String p) {
        repository.downClock(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult baseObResult) {
                TUtils.show(baseObResult.getMsgInfo());
            }
        });
    }


}
