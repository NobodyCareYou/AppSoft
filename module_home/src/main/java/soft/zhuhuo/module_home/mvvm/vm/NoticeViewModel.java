package soft.zhuhuo.module_home.mvvm.vm;

import soft.zhuhuo.lib.adapter.mvvm.BaseViewModel;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.mvvm.respon.NoticeRepository;

public class NoticeViewModel extends BaseViewModel<NoticeRepository> {
    @Override
    public NoticeRepository getInstance() {
        return NoticeRepository.getInstance();
    }

    public void completeGoods(String p) {
        repository.completeGoods(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
            }
        });
    }

    public void cancelAdditional(String tucParam) {
        repository.cancelAdditional(tucParam, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
            }
        });
    }

    public void cancelItem(String p) {
        repository.cancelItem(p, new BaseObserver<BaseObResult>(isShow, error) {
            @Override
            public void onSuccess(BaseObResult info) {
                TUtils.show(info.getMsgInfo());
            }
        });
    }


}
