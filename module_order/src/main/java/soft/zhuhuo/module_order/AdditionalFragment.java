package soft.zhuhuo.module_order;

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
import java.util.stream.Collectors;

import soft.zhuhuo.lib.XAlertDialog;
import soft.zhuhuo.lib.adapter.mvvm.BaseFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_order.databinding.FragmentItemBinding;
import soft.zhuhuo.module_order.mvvm.viewmodel.OrderViewModel;

public class AdditionalFragment extends BaseFragment<OrderViewModel, FragmentItemBinding> {


    public static AdditionalFragment getInstance(String roomCode) {
        AdditionalFragment instance = new AdditionalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RoomCode", roomCode);
        instance.setArguments(bundle);
        return instance;
    }

    private List<String> mNames;
    private List<Fragment> fragments = new ArrayList<>();

    public List<ItemInfo.DataBean> mItemList;
    private BaseRequest.OrderAdditionalParam mOrderAdditionalParam;
    private String roomCode;

    @Override
    public boolean registerEventBus() {
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveWaitOrderItem(EventData info) {
        if (info.type == EventData.SINGLE_ITEM_INFO) {
            ItemInfo.DataBean singleItem = info.singleItem;
            if ("2".equals(singleItem.getItemKindID())) {
                new OrderAdditionalDialog(roomCode, singleItem).show(getChildFragmentManager(), "附项下单");
            }
        } else if (info.type == EventData.ORDER_ADDITIONAL_PARAM) {
            if (mOrderAdditionalParam == null) {
                mOrderAdditionalParam = info.orderAdditionalParam;
            } else {
                mOrderAdditionalParam.data.addAll(info.orderAdditionalParam.data);
            }

            double _money = 0.0f;
            for (BaseRequest.OrderAdditionalParam.Data datum : mOrderAdditionalParam.data) {
                _money += datum._price;
            }
            binding.money.setText(new DecimalFormat("0.00").format(_money));

            if (!info.isContinue) {
                showCar();
            }

        }
    }

    @Override
    protected OrderViewModel createViewModel() {
        return new ViewModelProvider(this).get(OrderViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        if (getArguments() != null) {
            roomCode = getArguments().getString("RoomCode");
        }

        Global.getInstance().getItemInfo().observe(this, info -> {
            if (mItemList == null) {
                mItemList = info.getData();
            }

            mNames = mItemList.stream().filter(t -> "2".equals(t.getItemKindID())).map(ItemInfo.DataBean::getItemTypeName).distinct().collect(Collectors.toList());
            mItemList = mItemList.stream().filter(t -> "2".equals(t.getItemKindID())).collect(Collectors.toList());


            if (mNames.size() > 4) {
                binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            } else {
                binding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
            }


            for (String name : mNames) {
                fragments.add(ItemFragment.getInstance("2", name));
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
            //设置第一页为选中状态时的tab文字颜色为红色
            View view = binding.tabLayout.getTabAt(0).getCustomView();
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
        viewModel.orderAdditionalResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            getActivity().finish();
        });

        binding.money.setOnClickListener(v -> {
            if (mOrderAdditionalParam != null) {
                showCar();
            }
        });

        binding.confirm.setOnClickListener(v -> {
            if (mOrderAdditionalParam == null) {
                TUtils.show("请选择项目");
                return;
            }

        });
    }


    private void showCar() {



        Car.getInstance(mOrderAdditionalParam).setOnOrderListener(() -> {
            if (mOrderAdditionalParam == null) {
                TUtils.show("请选择项目");
                return;
            }
            new XAlertDialog.Builder()
                    .setTitle("提示")
                    .setContent("请选择下单方式")
                    .setNegativeText("消费下单", () -> {
                        for (BaseRequest.OrderAdditionalParam.Data datum : mOrderAdditionalParam.data) {
                            datum.AddItemNotice = 0;
                        }
                        viewModel.orderAdditional(BaseRequest.getOrderAdditionalP(mOrderAdditionalParam));
                    }).setPositiveText("通知下单", () -> {
                for (BaseRequest.OrderAdditionalParam.Data datum : mOrderAdditionalParam.data) {
                    datum.AddItemNotice = 1;
                }
                viewModel.orderAdditional(BaseRequest.getOrderAdditionalP(mOrderAdditionalParam));
            })
                    .build().show(getChildFragmentManager(), "附项下单");


        }).setOnClearListener(() -> {
            mOrderAdditionalParam = null;
            binding.money.setText("0.00");
        }).show(getChildFragmentManager(), "购物车");
    }


}
