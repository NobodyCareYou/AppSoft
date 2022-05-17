package soft.zhuhuo.lib.net;


import androidx.lifecycle.MutableLiveData;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import soft.zhuhuo.lib.base.BaseObResult;

/**
 * 自定义Observer
 *
 * @author llw
 */
public abstract class BaseObserver<T extends BaseObResult> implements Observer<T> {

    private Disposable disposable;

    public BaseObserver(MutableLiveData<Boolean> isShow, MutableLiveData<Object> error) {
        this.isShow = isShow;
        this.error = error;
    }

    //开始
    @Override
    public void onSubscribe(Disposable disposable) {
        this.disposable = disposable;
        if (isShow != null) {
            isShow.setValue(true);
        }
    }

    //继续
    @Override
    public void onNext(T t) {
        if ("0".equals(t.getMsgID())) {
            if (isShow != null) {
                isShow.setValue(false);
            }
            onSuccess(t);
        } else {
            onError(new Exception(t.getMsgInfo()));
        }

    }

    private MutableLiveData<Boolean> isShow;
    private MutableLiveData<Object> error;

    //异常
    @Override
    public void onError(Throwable e) {
        if (isShow != null) {
            isShow.setValue(false);
        }
        if (error != null) {
            error.setValue(e.getMessage());
        }


        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    //完成
    @Override
    public void onComplete() {
        if (isShow!=null){
            isShow.setValue(false);
        }

        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    //成功
    public abstract void onSuccess(T t);

}