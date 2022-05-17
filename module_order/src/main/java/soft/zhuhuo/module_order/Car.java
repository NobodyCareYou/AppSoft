package soft.zhuhuo.module_order;

import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.text.DecimalFormat;
import java.util.Objects;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_order.adapter.Car1Adapter;
import soft.zhuhuo.module_order.adapter.Car2Adapter;
import soft.zhuhuo.module_order.adapter.Car3Adapter;
import soft.zhuhuo.module_order.databinding.DialogCarBinding;

public class Car extends BaseNoModelDialogFragment<DialogCarBinding> {

    private BaseRequest.OrderMainParam data1;
    private BaseRequest.OrderAdditionalParam data2;
    private BaseRequest.OrderGoodsParam data3;

    private Car(BaseRequest.OrderMainParam data1) {
        this.data1 = data1;
    }

    private Car(BaseRequest.OrderAdditionalParam data2) {
        this.data2 = data2;
    }

    private Car(BaseRequest.OrderGoodsParam data3) {
        this.data3 = data3;
    }

    public static Car getInstance(BaseRequest.OrderMainParam data) {
        return new Car(data);
    }

    public static Car getInstance(BaseRequest.OrderAdditionalParam data) {
        return new Car(data);
    }

    public static Car getInstance(BaseRequest.OrderGoodsParam data) {
        return new Car(data);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    protected void setGravity() {
        super.setGravity();
        Objects.requireNonNull(this.getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = this.getDialog().getWindow();
        Objects.requireNonNull(window).getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        setCancelable(true);
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_car;
    }

    @Override
    protected void initView() {
        binding.car.setLayoutManager(new LinearLayoutManager(context));
        if (data1 != null) {
            double _money = 0.0f;
            Car1Adapter adapter = new Car1Adapter(data1.data);
            binding.car.setAdapter(adapter);
            for (BaseRequest.OrderMainParam.Data datum : data1.data) {
                _money += datum._price;
            }
            binding.money.setText(new DecimalFormat("0.00").format(_money));
        } else if (data2 != null) {
            Car2Adapter adapter = new Car2Adapter(data2.data);
            binding.car.setAdapter(adapter);
            double _money = 0.0f;
            for (BaseRequest.OrderAdditionalParam.Data datum : data2.data) {
                _money += datum._price;
            }
            binding.money.setText(new DecimalFormat("0.00").format(_money));
        } else if (data3 != null) {
            Car3Adapter adapter = new Car3Adapter(data3.data);
            binding.car.setAdapter(adapter);
            double _money = 0.0f;
            for (BaseRequest.OrderGoodsParam.Data datum : data3.data) {
                _money += datum.ItemCount * datum._price;
            }
            binding.money.setText(new DecimalFormat("0.00").format(_money));
        }

    }

    private OnOrderListener mOnOrderListener;

    public Car setOnOrderListener(OnOrderListener onOrderListener) {
        mOnOrderListener = onOrderListener;
        return this;
    }

    public interface OnOrderListener {
        void order();
    }

    private OnClearListener mOnClearListener;

    public interface OnClearListener {
        void clear();
    }

    public Car setOnClearListener(OnClearListener onClearListener) {
        mOnClearListener = onClearListener;
        return this;
    }

    @Override
    protected void initData() {

        binding.clear.setOnClickListener(v -> {
            if (mOnClearListener != null) {
                mOnClearListener.clear();
            }
            dismiss();
        });

        binding.confirm.setOnClickListener(v -> {
            if (mOnOrderListener != null) {
                mOnOrderListener.order();
            }
        });

    }
}
