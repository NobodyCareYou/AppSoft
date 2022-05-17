package soft.zhuhuo.lib;

import android.util.DisplayMetrics;
import android.view.ViewGroup;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.databinding.DialogAlertBinding;


public class XAlertDialog extends BaseNoModelDialogFragment<DialogAlertBinding> {


    private String title = "提示", content = "温馨提示", negativeText = "取消", positiveText = "确认";

    private OnNegativeClickListener onNegativeClickListener;
    private OnPositiveClickListener onPositiveClickListener;
    public interface OnNegativeClickListener {
        void negativeClick();
    }



    public interface OnPositiveClickListener {
        void positiveClick();
    }

    public XAlertDialog(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.negativeText = builder.negativeText;
        this.positiveText = builder.positiveText;
        this.onNegativeClickListener = builder.onNegativeClickListener;
        this.onPositiveClickListener = builder.onPositiveClickListener;
    }

    public static class Builder {
        private String title, content, negativeText, positiveText;
        private OnNegativeClickListener onNegativeClickListener;
        private OnPositiveClickListener onPositiveClickListener;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setNegativeText(String negativeText) {
            this.negativeText = negativeText;
            return this;
        }

        public Builder setNegativeText(String negativeText, OnNegativeClickListener onNegativeClickListener) {
            this.negativeText = negativeText;
            this.onNegativeClickListener = onNegativeClickListener;
            return this;
        }

        public Builder setPositiveText(String positiveText) {
            this.positiveText = positiveText;
            return this;
        }


        public Builder setPositiveText(String positiveText, OnPositiveClickListener onPositiveClickListener) {
            this.positiveText = positiveText;
            this.onPositiveClickListener = onPositiveClickListener;
            return this;
        }

        public XAlertDialog build() {
            return new XAlertDialog(this);
        }
    }



    @Override
    protected int getLayoutId() {
        return R.layout.dialog_alert;
    }

    @Override
    protected void initView() {
        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.title.setText(title);
        binding.content.setText(content);
        binding.cancel.setText(negativeText);
        binding.confirm.setText(positiveText);

        binding.cancel.setOnClickListener(view -> {
            if (onNegativeClickListener != null) {
                onNegativeClickListener.negativeClick();
            }
            dismiss();
        });
        binding.confirm.setOnClickListener(view -> {
            if (onPositiveClickListener != null) {
                onPositiveClickListener.positiveClick();
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
