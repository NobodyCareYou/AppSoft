package soft.zhuhuo.com;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.com.databinding.ActivitySettingBinding;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelActivity;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.RouteConfig;


@Route(path = RouteConfig.SETTING)
public class SettingActivity extends BaseNoModelActivity<ActivitySettingBinding> {

    private final MutableLiveData<String> mAddress = new MutableLiveData<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("设置");
        mAddress.setValue(MVUtils.getString(Key.URL));
        binding.etAddress.setText(mAddress.getValue());
        binding.etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mAddress.setValue(s.toString());
                NetworkApi.updateBaseUrl(s.toString());
            }
        });
    }

    @Override
    protected void initData() {
        binding.confirm.setOnClickListener(v -> {
            MVUtils.put(Key.URL, mAddress.getValue());
            finish();
        });
    }
}
