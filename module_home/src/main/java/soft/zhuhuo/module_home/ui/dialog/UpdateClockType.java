package soft.zhuhuo.module_home.ui.dialog;

import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.Objects;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.base.BaseObResult;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.BaseResult;
import soft.zhuhuo.lib.bean.ClockType;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.BaseObserver;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.ClockTypeAdapter;
import soft.zhuhuo.module_home.databinding.DialogUpdateClockTypeBinding;
import soft.zhuhuo.module_home.mvvm.vm.UpdateClockTypeViewModel;

public class UpdateClockType extends BaseDialogFragment<UpdateClockTypeViewModel, DialogUpdateClockTypeBinding> {

    private final String clockType;
    private final String consumeId;

    private UpdateClockType(String clockType, String consumeId) {
        this.clockType = clockType;
        this.consumeId = consumeId;
    }


    public static UpdateClockType getInstance(String clockType, String consumeId) {
        return new UpdateClockType(clockType, consumeId);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_update_clock_type;
    }

    @Override
    protected void initView() {
        binding.rvClockType.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        ClockTypeAdapter adapter = new ClockTypeAdapter(context, Integer.parseInt(clockType));
        binding.rvClockType.setAdapter(adapter);
        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.cancel.setOnClickListener(view -> dismiss());
        binding.confirm.setOnClickListener(view -> {
            ClockType datum = adapter.getSelectedData();
            if (datum == null) {
                return;
            }
            String p1 = BaseRequest.getUCTParam(new BaseRequest.UCTParam(consumeId, String.valueOf(datum.clockType)));
            viewModel.updateClockType(p1);
        });
    }


    @Override
    protected void initData() {
        viewModel.updateClockTypeResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            dismiss();
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }

    @Override
    protected UpdateClockTypeViewModel createViewModel() {
        return new ViewModelProvider(this).get(UpdateClockTypeViewModel.class);
    }
}
