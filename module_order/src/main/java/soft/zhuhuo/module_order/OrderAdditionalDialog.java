package soft.zhuhuo.module_order;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_order.adapter.PickTechnicianAdapter;
import soft.zhuhuo.module_order.databinding.DialogOrderMainBinding;
import soft.zhuhuo.module_order.mvvm.viewmodel.ItemTechnicianViewModel;

public class OrderAdditionalDialog extends BaseDialogFragment<ItemTechnicianViewModel, DialogOrderMainBinding> {

    private List<ItemTechnician.DataDTO> technicianInfo;
    private final String roomCode;
    private final ItemInfo.DataBean itemInfo;
    private PickTechnicianAdapter mAdapter;
    private List<ItemTechnician.DataDTO> mTech;

    public OrderAdditionalDialog(String roomCode, ItemInfo.DataBean itemInfo) {
        this.roomCode = roomCode;
        this.itemInfo = itemInfo;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
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
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    @Override
    protected ItemTechnicianViewModel createViewModel() {
        return new ViewModelProvider(this).get(ItemTechnicianViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_order_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        binding.rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.wheel_clock) {
                clockType = 0;
                binding.wheel.setVisibility(View.VISIBLE);
                binding.other.setVisibility(View.GONE);
            } else if (checkedId == R.id.point_clock) {
                clockType = 1;
                binding.other.setVisibility(View.VISIBLE);
                binding.wheel.setVisibility(View.GONE);
            } else if (checkedId == R.id.call_clock) {
                clockType = 3;
                binding.other.setVisibility(View.VISIBLE);
                binding.wheel.setVisibility(View.GONE);
            } else if (checkedId == R.id.select_clock) {
                clockType = 4;
                binding.other.setVisibility(View.VISIBLE);
                binding.wheel.setVisibility(View.GONE);
            }
        });

        BaseRequest.ItemAvailableTechnicianP p1 = new BaseRequest.ItemAvailableTechnicianP(itemInfo.getItemID());
        viewModel.getItemTechnician(BaseRequest.getItemAvailableTechnicianP(p1));

        viewModel.itemTechnician.observe(this, itemTechnician -> {
            if (technicianInfo == null) {
                technicianInfo = itemTechnician.getData();
            }

            if (technicianInfo == null) {
                TUtils.show("?????????????????????????????????");
                return;
            }

            List<String> names = technicianInfo.stream().map(ItemTechnician.DataDTO::getPostName).distinct().collect(Collectors.toList());
            for (String name : names) {
                TabLayout.Tab mTab = binding.tabLayout.newTab();
                mTab.setText(name);
                binding.tabLayout.addTab(mTab);
            }
            binding.rv.setLayoutManager(new GridLayoutManager(context, 4));
            mAdapter = new PickTechnicianAdapter(context);
            mTech = technicianInfo.stream().filter(t -> t.getPostName().equals(names.get(0))).distinct().collect(Collectors.toList());
            binding.rv.setAdapter(mAdapter);
            mAdapter.setData(mTech);
//            mAdapter.setOnPickTechnicianCodeListener(code -> binding.etCode.setText(code));

            binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    CharSequence text = tab.getText();
                    List<ItemTechnician.DataDTO> tech = technicianInfo.stream().filter(t -> t.getPostName().contentEquals(text)).distinct().collect(Collectors.toList());
                    mAdapter.setData(tech);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        });


    }

    private int clockType = 0;

    @Override
    protected void initData() {
        binding.etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    mAdapter.setData(mTech);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        mAdapter.setData(mTech.stream().filter(t -> t.getTecCode().contains(s)).collect(Collectors.toList()));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        binding.setData(itemInfo);

        binding.ivClose.setOnClickListener(v -> dismiss());

        binding.tvManReduce.setOnClickListener(v -> {
            int manCount = Integer.parseInt(binding.tvManNum.getText().toString());
            if (manCount == 0) {
                return;
            }
            binding.tvManNum.setText(String.valueOf(manCount - 1));
        });

        binding.tvManAdd.setOnClickListener(v -> {
            int manCount = Integer.parseInt(binding.tvManNum.getText().toString());
            binding.tvManNum.setText(String.valueOf(manCount + 1));
        });


        binding.tvWomanReduce.setOnClickListener(v -> {
            int womanCount = Integer.parseInt(binding.tvWomanNum.getText().toString());
            if (womanCount == 0) {
                return;
            }
            binding.tvWomanNum.setText(String.valueOf(womanCount - 1));
        });

        binding.tvWomanAdd.setOnClickListener(v -> {
            int womanCount = Integer.parseInt(binding.tvWomanNum.getText().toString());
            binding.tvWomanNum.setText(String.valueOf(womanCount + 1));
        });

        binding.tvAnyAdd.setOnClickListener(v -> {
            int anyCount = Integer.parseInt(binding.tvAnyNum.getText().toString());
            if (anyCount == 0) {
                return;
            }
            binding.tvAnyNum.setText(String.valueOf(anyCount - 1));
        });


        binding.tvAnyAdd.setOnClickListener(v -> {
            int anyCount = Integer.parseInt(binding.tvAnyNum.getText().toString());
            binding.tvAnyNum.setText(String.valueOf(anyCount + 1));
        });


        binding.addContinue.setOnClickListener(v -> {
            if (add(true)) return;
            String a = "";
            switch (clockType) {
                case 0:
                    a = "??????";
                    break;
                case 1:
                    a = "??????";
                    break;
                case 3:
                    a = "Call???";
                    break;
                case 4:
                    a = "??????";
                    break;
            }

            TUtils.show(String.format("%s(%s)??????????????????", itemInfo.getItemName(), a));
        });
        binding.add.setOnClickListener(v -> {
            if (add(false)) return;
            dismiss();
        });
    }

    private boolean add(boolean isContinue) {
        BaseRequest.OrderAdditionalParam param = new BaseRequest.OrderAdditionalParam(roomCode);
        List<BaseRequest.OrderAdditionalParam.Data> data = new ArrayList<>();

        if (clockType == 0) {
            int manCount = Integer.parseInt(binding.tvManNum.getText().toString());
            int womanCount = Integer.parseInt(binding.tvWomanNum.getText().toString());
            int anyCount = Integer.parseInt(binding.tvAnyNum.getText().toString());
            if (manCount == 0 && womanCount == 0 && anyCount == 0) {
                TUtils.show("???????????????");
                return true;
            }
            for (int i = 0; i < manCount; i++) {
                BaseRequest.OrderAdditionalParam.Data tmp = new BaseRequest.OrderAdditionalParam.Data();
                tmp.clockType = 0;
                tmp.isForce = 0;
                tmp.itemID = itemInfo.getItemID();
                tmp.tecCode = "";
                tmp.orderSex = 1;
                tmp.itemName = itemInfo.getItemName();
                tmp._price = itemInfo.getLPrice();
                data.add(tmp);
            }
            for (int i = 0; i < womanCount; i++) {
                BaseRequest.OrderAdditionalParam.Data tmp = new BaseRequest.OrderAdditionalParam.Data();
                tmp.clockType = 0;
                tmp.isForce = 0;
                tmp.itemID = itemInfo.getItemID();
                tmp.tecCode = "";
                tmp.orderSex = 0;
                tmp.itemName = itemInfo.getItemName();
                tmp._price = itemInfo.getLPrice();
                data.add(tmp);
            }
            for (int i = 0; i < anyCount; i++) {
                BaseRequest.OrderAdditionalParam.Data tmp = new BaseRequest.OrderAdditionalParam.Data();
                tmp.clockType = 0;
                tmp.isForce = 0;
                tmp.itemID = itemInfo.getItemID();
                tmp.tecCode = "";
                tmp.orderSex = 2;
                tmp.itemName = itemInfo.getItemName();
                tmp._price = itemInfo.getLPrice();
                data.add(tmp);
            }

        } else {
//            ItemTechnician.DataDTO technician = mAdapter.getSelectedData();
//            if (technician == null) {
//                TUtils.show("???????????????");
//                return true;
//            }
//            BaseRequest.OrderAdditionalParam.Data tmp = new BaseRequest.OrderAdditionalParam.Data();
//            tmp.clockType = clockType;
//            tmp.isForce = binding.isForce.isChecked() ? 1 : 0;
//            tmp.itemID = itemInfo.getItemID();
//            tmp.tecCode = technician.getTecCode();
//            tmp.orderSex = technician.getSex();
//            tmp.itemName = itemInfo.getItemName();
//            tmp._price = getPrice(clockType, itemInfo);
//            data.add(tmp);

            List<ItemTechnician.DataDTO> selectedData = mAdapter.getSelectedData();
            if (selectedData == null || selectedData.size() == 0) {
                TUtils.show("???????????????");
                return true;
            }

            for (ItemTechnician.DataDTO selectedDatum : selectedData) {
                BaseRequest.OrderAdditionalParam.Data tmp = new BaseRequest.OrderAdditionalParam.Data();
                tmp.clockType = clockType;
                tmp.isForce = binding.isForce.isChecked() ? 1 : 0;
                tmp.itemID = itemInfo.getItemID();
                tmp.tecCode = selectedDatum.getTecCode();
                tmp.orderSex = selectedDatum.getSex();
                tmp.itemName = itemInfo.getItemName();
                tmp._price = getPrice(clockType, itemInfo);
                data.add(tmp);
            }
        }

        param.data = data;
        sendEvent(new EventData(isContinue, param));
        return false;
    }

    private double getPrice(int clockType, ItemInfo.DataBean info) {
        double price = info.getLPrice();
        switch (clockType) {
            case 1:
                price = info.getDPrice();
                break;
            case 2:
                price = info.getJPrice();
                break;
            case 3:
                price = info.getCPrice();
                break;
            case 4:
                price = info.getXPrice();
                break;
        }
        return price;
    }
}
