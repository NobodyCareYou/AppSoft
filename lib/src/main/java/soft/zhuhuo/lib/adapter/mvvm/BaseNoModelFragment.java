package soft.zhuhuo.lib.adapter.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

import soft.zhuhuo.lib.utils.ActivityUtil;
import soft.zhuhuo.lib.utils.TUtils;


public abstract class BaseNoModelFragment<VDB extends ViewDataBinding> extends Fragment {

    private static final String TAG = "BaseNoModelActivity";

    protected VDB binding;
    private boolean isNeedRegisterEventBus = false;
    protected Context context;
    private CustomDialog loadingDialog;


    public boolean registerEventBus() {
        return false;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        initObserve();
        initView();
        initData();
        isNeedRegisterEventBus = registerEventBus();
        if (isNeedRegisterEventBus) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        return binding.getRoot();
    }


    protected void initObserve() {

    }


    protected abstract @LayoutRes
    int getLayoutId();


    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    protected void setLoadingView(boolean s) {
        if (s) {
            showLoadingView();
        } else {
            dismissLoadingView();
        }
    }


    /**
     * 发送普通事件
     *
     * @param obj 数据
     */
    protected void sendEvent(Object obj) {
        EventBus.getDefault().post(obj);
    }

    /**
     * 发送黏性事件
     *
     * @param obj 数据
     */
    protected void sendStickyEvent(Object obj) {
        EventBus.getDefault().postSticky(obj);
    }


    /**
     * 显示消息
     *
     * @param msg 消息内容
     */
    protected void showToast(String msg) {
        TUtils.show(msg);
    }


    /**
     * 显示用户等待框
     */
    private void showLoadingView() {
        if (loadingDialog == null) {
            loadingDialog = new CustomDialog.Builder().create(context);
        }

        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }

        Log.d(TAG, "showLoadingView: ");
    }

    /**
     * 隐藏等待框
     */
    private void dismissLoadingView() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
        Log.d(TAG, "dismissLoadingView: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isNeedRegisterEventBus && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }

        if (binding != null) {
            binding.unbind();
        }
    }


}
