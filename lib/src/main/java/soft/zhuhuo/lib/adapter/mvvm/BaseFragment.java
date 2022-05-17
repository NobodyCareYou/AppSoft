package soft.zhuhuo.lib.adapter.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

public abstract class BaseFragment<VM extends BaseViewModel<? extends BaseRepository>, VDB extends ViewDataBinding> extends BaseNoModelFragment<VDB> {

    protected VM viewModel;

    protected abstract VM createViewModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = createViewModel();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected void initObserve() {
        if (viewModel == null) return;
        viewModel.getShowDialog(this, this::setLoadingView);
        viewModel.getError(this, obj -> showToast(obj.toString()));
    }
}
