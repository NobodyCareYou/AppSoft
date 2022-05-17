package soft.zhuhuo.lib.adapter.mvvm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends BaseRepository> extends ViewModel {

    public T repository;

    public abstract T getInstance();

    public BaseViewModel() {
        repository = getInstance();
        isShow = repository.isShow;
        error = repository.error;
    }

    /**
     * 用来通知 Activity／Fragment 是否显示等待Dialog
     */
    protected MutableLiveData<Boolean> isShow;
    /**
     * 当ViewModel层出现错误需要通知到Activity／Fragment
     */
    protected MutableLiveData<Object> error;

    public void getShowDialog(LifecycleOwner owner, Observer<Boolean> observer) {
        if (isShow!=null){
            isShow.observe(owner, observer);
        }
    }

    public void getError(LifecycleOwner owner, Observer<Object> observer) {
        error.observe(owner, observer);
    }

    /**
     * ViewModel销毁同时也取消请求
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        if (repository.compositeDisposable != null) {
            repository.compositeDisposable.dispose();
            repository.compositeDisposable = null;
        }
        isShow = null;
        error = null;
    }
}
