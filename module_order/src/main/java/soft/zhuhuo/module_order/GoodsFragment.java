package soft.zhuhuo.module_order;

import android.annotation.SuppressLint;
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

import soft.zhuhuo.lib.XAlertDialog;
import soft.zhuhuo.lib.adapter.mvvm.BaseFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_order.databinding.FragmentItemBinding;
import soft.zhuhuo.module_order.mvvm.viewmodel.OrderViewModel;

public class GoodsFragment extends BaseFragment<OrderViewModel, FragmentItemBinding> {

    public static GoodsFragment getInstance(String roomCode) {
        GoodsFragment instance = new GoodsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RoomCode", roomCode);
        instance.setArguments(bundle);
        return instance;
    }

    private List<String> mNames;
    private final List<Fragment> fragments = new ArrayList<>();

    public List<ItemInfo.DataBean> mItemList;
    private String roomCode;

    private BaseRequest.OrderGoodsParam mOrderGoodsParam;

    @Override
    public boolean registerEventBus() {
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveWaitOrderItem(EventData info) {
        if (info.type == EventData.SINGLE_ITEM_INFO) {
            ItemInfo.DataBean singleItem = info.singleItem;
            if ("3".equals(singleItem.getItemKindID())) {
                if (mOrderGoodsParam == null) {
                    mOrderGoodsParam = new BaseRequest.OrderGoodsParam(roomCode);
                    List<BaseRequest.OrderGoodsParam.Data> data = new ArrayList<>();
                    BaseRequest.OrderGoodsParam.Data tmp = new BaseRequest.OrderGoodsParam.Data();
                    tmp.ItemID = singleItem.getItemID();
                    tmp.ItemCount = 1;
                    tmp.itemName = singleItem.getItemName();
                    tmp._price = singleItem.getLPrice();
                    data.add(tmp);
                    mOrderGoodsParam.data = data;
                } else {
                    List<BaseRequest.OrderGoodsParam.Data> data = mOrderGoodsParam.data;
                    boolean isContains = false;
                    for (BaseRequest.OrderGoodsParam.Data datum : data) {
                        if (datum.ItemID.equals(singleItem.getItemID())) {
                            isContains = true;
                            datum.ItemCount += 1;
                            break;
                        }
                    }
                    if (!isContains) {
                        BaseRequest.OrderGoodsParam.Data tmp = new BaseRequest.OrderGoodsParam.Data();
                        tmp.ItemID = singleItem.getItemID();
                        tmp.ItemCount = 1;
                        tmp.itemName = singleItem.getItemName();
                        tmp._price = singleItem.getLPrice();
                        data.add(tmp);
                    }
                }
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

            mNames = mItemList.stream().filter(t -> "3".equals(t.getItemKindID())).map(ItemInfo.DataBean::getItemTypeName).distinct().collect(Collectors.toList());
            mItemList = mItemList.stream().filter(t -> "3".equals(t.getItemKindID())).collect(Collectors.toList());
            if (mNames.size() > 4) {
                binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            } else {
                binding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
            }

            for (String name : mNames) {
                fragments.add(ItemFragment.getInstance("3", name));
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
        viewModel.orderGoodsResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            Objects.requireNonNull(getActivity()).finish();
        });

        binding.confirm.setOnClickListener(v -> {
            if (mOrderGoodsParam == null) {
                TUtils.show("请选择项目");
                return;
            }
            viewModel.orderGoods(BaseRequest.getOrderGoodsP(mOrderGoodsParam));
        });
    }

    @SuppressLint("SetTextI18n")
    private void showCar() {
        double _money = 0.0f;
        for (BaseRequest.OrderGoodsParam.Data datum : mOrderGoodsParam.data) {
            _money += datum.ItemCount * datum._price;
        }
        binding.money.setText(new DecimalFormat("0.00").format(_money));


        Car.getInstance(mOrderGoodsParam).setOnOrderListener(() -> {
            if (mOrderGoodsParam == null) {
                TUtils.show("请选择项目");
                return;
            }
            viewModel.orderGoods(BaseRequest.getOrderGoodsP(mOrderGoodsParam));
        }).setOnClearListener(() -> {
            mOrderGoodsParam = null;
            binding.money.setText("0.00");
        }).show(getChildFragmentManager(), "购物车");
    }


}
