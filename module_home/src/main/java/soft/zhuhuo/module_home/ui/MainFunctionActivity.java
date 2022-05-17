package soft.zhuhuo.module_home.ui;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.JsonObject;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import soft.zhuhuo.lib.adapter.SimplePagerAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelActivity;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ActivityMainFunctionBinding;
import soft.zhuhuo.module_home.mvvm.vm.RoomTechnicianViewModel;
import soft.zhuhuo.module_home.ui.fragment.RoomFragment;
import soft.zhuhuo.module_home.ui.fragment.TechnicianFragment;


@Route(path = RouteConfig.MAIN_FUNCTION_PAGE)
public class MainFunctionActivity extends BaseNoModelActivity<ActivityMainFunctionBinding> {

    @Autowired
    public int mCurrentPosition;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_function;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle(mCurrentPosition == 0 ? "房间状态" : "技师状态");
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(RoomFragment.getInstance());
        mFragments.add(TechnicianFragment.getInstance());
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(), mFragments);
        binding.vp.setAdapter(adapter);
        binding.vp.setCurrentItem(mCurrentPosition);
        binding.rgMainFunction.check(mCurrentPosition == 0 ? R.id.room : R.id.technician);
        binding.rgMainFunction.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.room) {
                mCurrentPosition = 0;
                binding.setTitle("房间状态");
            } else if (i == R.id.technician) {
                mCurrentPosition = 1;
                binding.setTitle("技师状态");
            }
            binding.vp.setCurrentItem(mCurrentPosition);
        });
        binding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
                binding.rgMainFunction.check(mCurrentPosition == 0 ? R.id.room : R.id.technician);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }


}