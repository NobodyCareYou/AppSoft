package soft.zhuhuo.lib.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import org.greenrobot.eventbus.EventBus;

public abstract class BMVVMActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends AppCompatActivity {

    protected VM viewModel;
    protected VDB binding;
    private ProgressDialog loading;
    private boolean isNeedEventBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = createViewModel();

        if (isNeedEventBus) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
    }


    private void show() {
        if (loading == null) {
            loading = new ProgressDialog(this);
            loading.setCancelable(false);
        }

        if (!loading.isShowing()) {
            loading.show();
        }

    }

    private void dismiss() {
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
    }

    protected void setLoadingView(boolean isShow) {
        if (isShow) {
            show();
        } else {
            dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (binding != null) {
            binding.unbind();
        }

        if (isNeedEventBus && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected abstract VM createViewModel();

    protected abstract @LayoutRes
    int getLayoutId();

}
