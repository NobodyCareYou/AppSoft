package soft.zhuhuo.module_home.ui.dialog;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.bean.TCItem;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.SPItemAdapter;
import soft.zhuhuo.module_home.databinding.DialogAddClockBinding;
import soft.zhuhuo.module_home.mvvm.vm.AddClockViewModel;


public class D_AddClock extends BaseDialogFragment<AddClockViewModel, DialogAddClockBinding> {

    private String technicianId;
    private String technicianCode;
    private String roomCode;
    private String itemId;
    private SPItemAdapter mAdapter;

    public D_AddClock(String technicianId, String technicianCode, String roomCode) {
        this.technicianId = technicianId;
        this.technicianCode = technicianCode;
        this.roomCode = roomCode;
    }

    public static D_AddClock getInstance(String technicianId, String technicianCode, String roomCode) {
        return new D_AddClock(technicianId, technicianCode, roomCode);
    }

    public interface OnAddClockSuccessListener {
        void onAddClockSuccess();
    }

    private OnAddClockSuccessListener mOnAddClockSuccessListener;

    public D_AddClock setOnAddClockSuccessListener(OnAddClockSuccessListener onAddClockSuccessListener) {
        mOnAddClockSuccessListener = onAddClockSuccessListener;
        return this;
    }

    @Override
    protected AddClockViewModel createViewModel() {
        return new ViewModelProvider(this).get(AddClockViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_add_clock;
    }

    private ItemInfo mItemInfo;
    private TCItem mTechnicianItems;
    List<String> itemNames;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        binding.setRoomCode(roomCode);
        binding.setTechnicianCode(technicianCode);
        binding.tvAdd.setOnClickListener(v -> {
            double v1 = Double.parseDouble(binding.tvNum.getText().toString());
            binding.tvNum.setText(String.valueOf(v1 + 0.5));
        });
        binding.tvReduce.setOnClickListener(v -> {
            double v1 = Double.parseDouble(binding.tvNum.getText().toString());
            if (v1 <= 0.5) {
                return;
            }
            binding.tvNum.setText(String.valueOf(v1 - 0.5));
        });

        BaseRequest.TCDItemParam param = new BaseRequest.TCDItemParam();
        param.TecID = technicianId;
        param.TecCode = technicianCode;
        viewModel.getTechnicianCanDoItem(BaseRequest.getTCDParam(param));
        viewModel.technicianItems.observe(this, tcItem -> {
            mTechnicianItems = tcItem;
            if (mTechnicianItems == null || mTechnicianItems.getData() == null || mTechnicianItems.getData().size() == 0) {
                TUtils.show("当前技师无可做项目");
                return;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                itemNames = mTechnicianItems.getData().stream().map(TCItem.DataDTO::getItemName).collect(Collectors.toList());
            } else {
                List<String> tmp = new ArrayList<>();
                for (TCItem.DataDTO datum : mTechnicianItems.getData()) {
                    tmp.add(datum.getItemName());
                }
                itemNames = tmp;
            }
            mAdapter.setData(itemNames);

            //设置默认选中
            int defaultPosition = 0;
            for (int i = 0; i < mTechnicianItems.getData().size(); i++) {
                if (itemId.equals(mTechnicianItems.getData().get(i).getItemID())) {
                    defaultPosition = i;
                    break;
                }
            }
            binding.spItem.setSelection(defaultPosition);
        });

        Global.getInstance().getItemInfo().observe(this, itemInfo -> mItemInfo = itemInfo);


        binding.isForceAdd.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (mItemInfo != null && mItemInfo.getData() != null) {
                    itemNames = mItemInfo.getData().stream().filter(t -> TextUtils.equals(t.getItemKindID(), "1") || TextUtils.equals(t.getItemKindID(), "2")).map(ItemInfo.DataBean::getItemName).collect(Collectors.toList());
                    mAdapter.setData(itemNames);
                }
            } else {
                if (mTechnicianItems == null || mTechnicianItems.getData() == null || mTechnicianItems.getData().size() == 0) {
                    TUtils.show("当前技师无可做项目");
                    return;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    itemNames = mTechnicianItems.getData().stream().map(TCItem.DataDTO::getItemName).collect(Collectors.toList());
                } else {
                    List<String> tmp = new ArrayList<>();
                    for (TCItem.DataDTO datum : mTechnicianItems.getData()) {
                        tmp.add(datum.getItemName());
                    }
                    itemNames = tmp;
                }
                mAdapter.setData(itemNames);
            }
        });


        mAdapter = new SPItemAdapter();
        binding.spItem.setAdapter(mAdapter);

        binding.spItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (binding.isForceAdd.isChecked()) {
                    List<ItemInfo.DataBean> collect = mItemInfo.getData().stream().filter(t -> TextUtils.equals(t.getItemKindID(), "1") || TextUtils.equals(t.getItemKindID(), "2")).collect(Collectors.toList());
                    itemId = collect.get(i).getItemID();
                } else {
                    itemId = mTechnicianItems.getData().get(i).getItemCode();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.cancel.setOnClickListener(view -> dismiss());
        binding.confirm.setOnClickListener(view -> {
            BaseRequest.AddClockP p = new BaseRequest.AddClockP();
            p.IsForce = binding.isForceAdd.isChecked() ? "1" : "0";
            p.ItemCount = binding.tvNum.getText().toString();
            p.ItemID = itemId;
            p.RoomCode = roomCode;
            p.TecCode = technicianCode;
            viewModel.add(BaseRequest.getAddClockP(p));
        });

        viewModel.addClockResult.observe(this, aBoolean -> {
            if (aBoolean) {
                if (mOnAddClockSuccessListener != null) {
                    mOnAddClockSuccessListener.onAddClockSuccess();
                }
                dismiss();
            }
        });
    }


    @Override
    protected void initData() {
    }


    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.85f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }


}
