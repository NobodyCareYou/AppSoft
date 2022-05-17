package soft.zhuhuo.lib.adapter.mvvm;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

import soft.zhuhuo.lib.utils.TUtils;


public abstract class BaseNoModelDialogFragment<VDB extends ViewDataBinding> extends DialogFragment {

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

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }


    protected void setGravity() {
        Objects.requireNonNull(this.getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = this.getDialog().getWindow();
        //去掉dialog默认的padding
        Objects.requireNonNull(window).getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        setCancelable(false);
        //设置dialog的动画
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setGravity();


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

    private void a() {

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
        Log.d(TAG, "setLoadingView: " + s);
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
