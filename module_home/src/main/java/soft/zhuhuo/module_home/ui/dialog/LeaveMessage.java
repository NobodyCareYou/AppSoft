package soft.zhuhuo.module_home.ui.dialog;

import android.util.DisplayMetrics;
import android.view.ViewGroup;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.DialogLeaveMessageBinding;

public class LeaveMessage extends BaseNoModelDialogFragment<DialogLeaveMessageBinding> {


    private String msg;
    private OnLeaveMessageListener mOnLeaveMessageListener;



    public interface OnLeaveMessageListener {
        void leaveMessage(String msg);
    }

    public LeaveMessage(Builder builder) {
        this.msg = builder.msg;
        this.mOnLeaveMessageListener = builder.mOnLeaveMessageListener;
    }

    public static class Builder {
        private OnLeaveMessageListener mOnLeaveMessageListener;

       private String msg;

        public Builder setMsg(String msg) {
            this.msg = msg;
            return  this;
        }

        public Builder setOnLeaveMessageListener(OnLeaveMessageListener onLeaveMessageListener) {
            mOnLeaveMessageListener = onLeaveMessageListener;
            return this;
        }

        public LeaveMessage build() {
            return new LeaveMessage(this);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_leave_message;
    }


    @Override
    protected void initView() {
        binding.content.setText(msg);
        binding.ivClose.setOnClickListener(view -> dismiss());


        binding.cancel.setOnClickListener(view -> {
            dismiss();
        });
        binding.confirm.setOnClickListener(view -> {
            if (mOnLeaveMessageListener != null) {
                mOnLeaveMessageListener.leaveMessage(binding.content.getText().toString());
            }
            dismiss();
        });
    }

    @Override
    protected void initData() {

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
}
