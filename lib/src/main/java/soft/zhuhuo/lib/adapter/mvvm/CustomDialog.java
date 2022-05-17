package soft.zhuhuo.lib.adapter.mvvm;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import soft.zhuhuo.lib.R;

public class CustomDialog extends Dialog {

    TextView tvLoadingTx;
    ImageView ivLoading;

    public static class Builder {
        private String text;
        private @DrawableRes
        int loadingView;

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setLoadingView(int loadingView) {
            this.loadingView = loadingView;
            return this;
        }

        public CustomDialog create(Context context) {
            return new CustomDialog(context, this);
        }
    }

    public CustomDialog(Context context, Builder builder) {
        this(context, R.style.loading_dialog, builder.text, builder.loadingView);
    }

    protected CustomDialog(Context context, int theme, String string, int res) {
        super(context, theme);
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.loading_dialog);//加载布局
        tvLoadingTx = findViewById(R.id.tv_loading_tx);
        tvLoadingTx.setText(TextUtils.isEmpty(string) ? "加载中……" : string);
        ivLoading = findViewById(R.id.iv_loading);
        if (res != 0) {
            ivLoading.setImageResource(res);
        }

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.loading_animation);
        ivLoading.startAnimation(hyperspaceJumpAnimation);
        getWindow().getAttributes().gravity = Gravity.CENTER;//居中显示
        getWindow().getAttributes().dimAmount = 0.5f;//背景透明度  取值范围 0 ~ 1
    }

    //关闭弹窗
    @Override
    public void dismiss() {
        super.dismiss();
    }
}
