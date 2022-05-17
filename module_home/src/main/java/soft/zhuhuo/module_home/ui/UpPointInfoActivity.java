package soft.zhuhuo.module_home.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelActivity;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ActivityUpPointInfoBinding;
import soft.zhuhuo.module_home.ui.fragment.FreeFragment;
import soft.zhuhuo.module_home.ui.fragment.QuickDownClockFragment;
import soft.zhuhuo.module_home.ui.fragment.QuickOutRoomFragment;
import soft.zhuhuo.module_home.ui.fragment.WaiteFragment;

@Route(path = RouteConfig.HOME_UP_POINT_PAGE)
public class UpPointInfoActivity extends BaseNoModelActivity<ActivityUpPointInfoBinding> {


    private FragmentManager manager;
    private Fragment currentFragment;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_up_point_info;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("上点动态");
        manager = getSupportFragmentManager();
        binding.rg.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.rb1) {
                switchFragment(WaiteFragment.getInstance());
            } else if (i == R.id.rb2) {
                switchFragment(FreeFragment.getInstance());
            } else if (i == R.id.rb3) {
                switchFragment(QuickDownClockFragment.getInstance());
            } else if (i == R.id.rb4) {
                switchFragment(QuickOutRoomFragment.getInstance());
            }
        });
        binding.rg.check(R.id.rb1);
    }

    @Override
    protected void initData() {
    }


    private void switchFragment(Fragment fragment) {
        if (currentFragment != fragment) {
            FragmentTransaction transaction = manager.beginTransaction();
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.frame, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }


}
