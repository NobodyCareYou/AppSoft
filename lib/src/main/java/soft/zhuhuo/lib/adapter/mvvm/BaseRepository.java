package soft.zhuhuo.lib.adapter.mvvm;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public  class BaseRepository {


    /**
     * 用来通知 Activity／Fragment 是否显示等待Dialog
     */
    public MutableLiveData<Boolean> isShow = new MutableLiveData<>();
    /**
     * 当ViewModel层出现错误需要通知到Activity／Fragment
     */
    public MutableLiveData<Object> error = new MutableLiveData<>();

    /**
     * 管理RxJava请求
     */
    public CompositeDisposable compositeDisposable;

    /**
     * 添加 rxJava 发出的请求
     */
    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }



}
