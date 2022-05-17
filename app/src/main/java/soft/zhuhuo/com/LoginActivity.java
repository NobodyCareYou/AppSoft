package soft.zhuhuo.com;

import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.com.databinding.ActivityLoginBinding;
import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;


@Route(path = RouteConfig.Login)
public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {

    @Override
    protected LoginViewModel createViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).init();
        viewModel.account.setValue(MVUtils.getString(Key.PERSON_CODE));
        viewModel.password.setValue(MVUtils.getString(Key.PASSWORD));
        viewModel.isCheck.setValue(MVUtils.getBoolean(Key.REMEMBER));
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initData() {
        viewModel.mUser.observe(this, user -> {
            TUtils.show("登录成功");
            MVUtils.put(Key.REMEMBER, binding.cbRemember.isChecked());
            if (binding.cbRemember.isChecked()) {
                MVUtils.put(Key.PASSWORD, binding.etPassword.getText().toString());
            } else {
                MVUtils.removeKey(Key.PASSWORD);
            }
            MVUtils.put(Key.ORG_ID, user.getOrgID());
            MVUtils.put(Key.PERSON_CODE, binding.etStaffCode.getText().toString());
            MVUtils.put(Key.ORG_Name, user.getOrgName());
            MVUtils.put(Key.PERSON_ID, user.getPersonID());
            MVUtils.put(Key.PERSON_NAME, user.getPersonName());
            MVUtils.put(Key.ROLE_NAME, user.getPostName());
            MVUtils.put(Key.ROOM_NUM, user.getRoomCount());
            MVUtils.put(Key.TECH_NUM, user.getClassTecCount());
            ARouter.getInstance().build(RouteConfig.HOME_PAGE).navigation();
        });

        binding.login.setOnClickListener(view -> {
            String personCode = binding.etStaffCode.getText().toString();
            String password = binding.etPassword.getText().toString();
            viewModel.login(personCode, password);
        });

        binding.setting.setOnClickListener(v -> ARouter.getInstance().build(RouteConfig.SETTING).navigation());
    }

}