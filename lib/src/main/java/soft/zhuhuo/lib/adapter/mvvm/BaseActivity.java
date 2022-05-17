package soft.zhuhuo.lib.adapter.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<VM extends BaseViewModel<? extends BaseRepository>, VDB extends ViewDataBinding> extends BaseNoModelActivity<VDB> {

    protected VM viewModel;

    protected abstract VM createViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        viewModel = createViewModel();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initObserve() {
        if (viewModel == null) return;
        viewModel.getShowDialog(this, this::setLoadingView);
        viewModel.getError(this, obj -> showToast(obj.toString()));
    }
}
