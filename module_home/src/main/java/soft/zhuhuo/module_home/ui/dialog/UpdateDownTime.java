package soft.zhuhuo.module_home.ui.dialog;

import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.DialogUpdateDownTimeBinding;
import soft.zhuhuo.module_home.mvvm.vm.UpdateDownTimeViewModel;

public class UpdateDownTime extends BaseDialogFragment<UpdateDownTimeViewModel, DialogUpdateDownTimeBinding> {

    private final String consumeId;


    public interface  OnUpdateDownTimeSuccessListener{
        void updateDownTimeSuccess();
    }

    private OnUpdateDownTimeSuccessListener mOnUpdateDownTimeSuccessListener;

    public UpdateDownTime setOnUpdateDownTimeSuccessListener(OnUpdateDownTimeSuccessListener onUpdateDownTimeSuccessListener) {
        mOnUpdateDownTimeSuccessListener = onUpdateDownTimeSuccessListener;
        return this;
    }

    public static UpdateDownTime getInstance(String consumeId) {
        return new UpdateDownTime(consumeId);
    }

    private UpdateDownTime(String consumeId) {
        this.consumeId = consumeId;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_update_down_time;
    }

    @Override
    protected void initView() {
        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.cancel.setOnClickListener(view -> dismiss());
        binding.reduce.setOnClickListener(view -> {
            int countTime = Integer.parseInt(binding.count.getText().toString());
            if (countTime == 5) {
                return;
            }
            binding.count.setText(String.valueOf(countTime - 5));
        });
        binding.add.setOnClickListener(view -> {
            int countTime = Integer.parseInt(binding.count.getText().toString());
            binding.count.setText(String.valueOf(countTime + 5));
        });
        binding.confirm.setOnClickListener(view -> {
            String p = BaseRequest.getUDTParam(new BaseRequest.UDTParam(consumeId, binding.count.getText().toString()));
            viewModel.updateDownTine(p);
        });
    }

    @Override
    protected void initData() {
        viewModel.updateDownTimeResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            if (mOnUpdateDownTimeSuccessListener!=null){
                mOnUpdateDownTimeSuccessListener.updateDownTimeSuccess();
            }
            dismiss();
        });
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

    @Override
    protected UpdateDownTimeViewModel createViewModel() {
        return new ViewModelProvider(this).get(UpdateDownTimeViewModel.class);
    }
}
