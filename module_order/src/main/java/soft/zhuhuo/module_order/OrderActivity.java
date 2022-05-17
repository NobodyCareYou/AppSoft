package soft.zhuhuo.module_order;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.module_order.databinding.ActivityOrderBinding;
import soft.zhuhuo.module_order.fragment.ProjectFragment;
import soft.zhuhuo.module_order.mvvm.viewmodel.OrderViewModel;


@Route(path = RouteConfig.ORDER_PAGE)
public class OrderActivity extends BaseActivity<OrderViewModel, ActivityOrderBinding> {

    public List<RoomTechnicianInfo.TecInfoDTO> mTecInfo;

    @Override
    protected OrderViewModel createViewModel() {
        return new ViewModelProvider(this).get(OrderViewModel.class);
    }

    @Autowired
    public String roomCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("下单");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ProjectFragment.getInstance(roomCode));
        fragments.add(AdditionalFragment.getInstance(roomCode));
        fragments.add(GoodsFragment.getInstance(roomCode));
        binding.rgType.check(R.id.main);
        binding.viewPager.setCurrentItem(0);
        binding.rgType.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.main) {
                binding.viewPager.setCurrentItem(0);
            } else if (i == R.id.additional) {
                binding.viewPager.setCurrentItem(1);
            } else if (i == R.id.goods) {
                binding.viewPager.setCurrentItem(2);
            }
        });

        binding.viewPager.setAdapter(new SimpleAdapter(getSupportFragmentManager(), fragments));
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.rgType.check(R.id.main);
                        break;
                    case 1:
                        binding.rgType.check(R.id.additional);
                        break;
                    case 2:
                        binding.rgType.check(R.id.goods);
                        break;
                }
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