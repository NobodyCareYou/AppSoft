package soft.zhuhuo.module_order.fragment;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_order.Car;
import soft.zhuhuo.module_order.ItemFragment;
import soft.zhuhuo.module_order.OrderActivity;
import soft.zhuhuo.module_order.OrderMainDialog;
import soft.zhuhuo.module_order.R;
import soft.zhuhuo.module_order.TabFragmentAdapter;
import soft.zhuhuo.module_order.databinding.FragmentItemBinding;
import soft.zhuhuo.module_order.mvvm.viewmodel.OrderViewModel;

public class ProjectFragment extends BaseFragment<OrderViewModel, FragmentItemBinding> {

    private List<String> mNames;
    private final List<Fragment> fragments = new ArrayList<>();
    public List<ItemInfo.DataBean> mItemList;
    private BaseRequest.OrderMainParam mOrderMainParam;
    private String roomCode;

    public static ProjectFragment getInstance(String roomCode) {
        ProjectFragment instance = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RoomCode", roomCode);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected OrderViewModel createViewModel() {
        return new ViewModelProvider(this).get(OrderViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item;
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveWaitOrderItem(EventData info) {
        if (info.type == EventData.SINGLE_ITEM_INFO) {
            ItemInfo.DataBean singleItem = info.singleItem;
            if ("1".equals(singleItem.getItemKindID())) {
                new OrderMainDialog(roomCode, singleItem).show(getChildFragmentManager(), "主项下单");
            }
        } else if (info.type == EventData.ORDER_MAIN_PARAM) {
            if (mOrderMainParam == null) {
                mOrderMainParam = info.param;
            } else {
                mOrderMainParam.data.addAll(info.param.data);
            }

            double _money = 0.0f;
            for (BaseRequest.OrderMainParam.Data datum : mOrderMainParam.data) {
                _money += datum._price;
            }
            binding.money.setText(new DecimalFormat("0.00").format(_money));

            if (!info.isContinue){
                showCar();
            }

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        if (getArguments() != null) {
            roomCode = getArguments().getString("RoomCode");
        }

        Global.getInstance().getItemInfo().observe(this, info -> {
            List<ItemInfo.DataBean> itemInfo = info.getData();
            mNames = itemInfo.stream().filter(t -> "1".equals(t.getItemKindID())).map(ItemInfo.DataBean::getItemTypeName).distinct().collect(Collectors.toList());
            mItemList = itemInfo.stream().filter(t -> "1".equals(t.getItemKindID())).collect(Collectors.toList());
            if (mNames.size() > 4) {
                binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            } else {
                binding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
            }
            for (String name : mNames) {
                fragments.add(ItemFragment.getInstance("1", name));
            }
            TabFragmentAdapter adapter = new TabFragmentAdapter(fragments, mNames, getChildFragmentManager(), context);
            binding.viewPager.setAdapter(adapter);
            binding.viewPager.setCurrentItem(0);
            binding.tabLayout.setupWithViewPager(binding.viewPager);
            //设置自定义tab
            for (int i = 0; i < binding.tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = binding.tabLayout.getTabAt(i);
                if (tab != null) {
                    tab.setCustomView(adapter.getTabView(i));
                }
            }
            View view = Objects.requireNonNull(binding.tabLayout.getTabAt(0)).getCustomView();
            assert view != null;
            TextView textView = view.findViewById(R.id.tv_header);
            textView.setTextColor(Color.WHITE);
            view.setBackgroundResource(R.drawable.tab_selected);
            binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    View view = tab.getCustomView();
                    assert view != null;
                    view.setBackgroundResource(R.drawable.tab_selected);
                    TextView textView = view.findViewById(R.id.tv_header);
                    textView.setTextColor(Color.WHITE);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    View view = tab.getCustomView();
                    assert view != null;
                    view.setBackgroundResource(R.drawable.tab_unselected);
                    TextView textView = view.findViewById(R.id.tv_header);
                    textView.setTextColor(Color.BLACK);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        });

    }

    @Override
    protected void initData() {
        viewModel.orderMainResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            Objects.requireNonNull(getActivity()).finish();
        });

        binding.money.setOnClickListener(v -> {
            if (mOrderMainParam != null) {
                showCar();
            }
        });

        binding.confirm.setOnClickListener(v -> {
            if (mOrderMainParam == null) {
                TUtils.show("请选择项目");
                return;
            }
            viewModel.orderMain(BaseRequest.getOrderMainParam(mOrderMainParam));
        });


    }

    private void showCar() {


        Car.getInstance(mOrderMainParam).setOnOrderListener(() -> {
            if (mOrderMainParam == null) {
                TUtils.show("请选择项目");
                return;
            }
            viewModel.orderMain(BaseRequest.getOrderMainParam(mOrderMainParam));
        }).setOnClearListener(() -> {
            mOrderMainParam = null;
            binding.money.setText("0.00");
        }).show(getChildFragmentManager(), "购物车");
    }


}
