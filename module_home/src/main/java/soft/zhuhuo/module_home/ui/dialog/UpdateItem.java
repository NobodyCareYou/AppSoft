package soft.zhuhuo.module_home.ui.dialog;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

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
import soft.zhuhuo.lib.bean.UpdateItemInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.SPItemAdapter;
import soft.zhuhuo.module_home.databinding.DialogUpdateItemBinding;
import soft.zhuhuo.module_home.mvvm.vm.UpdateItemViewModel;


public class UpdateItem extends BaseDialogFragment<UpdateItemViewModel, DialogUpdateItemBinding> {


    private final UpdateItemInfo info;
    private SPItemAdapter mAdapter;

    private UpdateItem(UpdateItemInfo info) {
        this.info = info;
    }

    public static UpdateItem getInstance(UpdateItemInfo info) {
        return new UpdateItem(info);
    }

    @Override
    protected UpdateItemViewModel createViewModel() {
        return new ViewModelProvider(this).get(UpdateItemViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_update_item;
    }

    private ItemInfo mItemInfo;
    private TCItem mTechnicianItems;
    List<String> itemNames;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        binding.setRoomCode(info.roomCode);
        binding.setTechnicianCode(info.technicianCode);
        BaseRequest.TCDItemParam param = new BaseRequest.TCDItemParam();
        param.TecID = info.technicianId;
        param.TecCode = info.technicianCode;
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
        });
        Global.getInstance().getItemInfo().observe(this, itemInfo ->
        {
            if (mItemInfo == null) {
                mItemInfo = itemInfo;
            }
        });

        binding.isForce.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (mItemInfo != null && mItemInfo.getData() != null) {
                    itemNames = mItemInfo.getData().stream().filter(t -> TextUtils.equals(t.getItemKindID(), "1")).map(ItemInfo.DataBean::getItemName).collect(Collectors.toList());
                }
                mAdapter.setData(itemNames);
            } else {
                if (mTechnicianItems == null || mTechnicianItems.getData() == null || mTechnicianItems.getData().size() == 0) {
                    TUtils.show("当前技师无可做项目");
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
        binding.sp.setAdapter(mAdapter);
        binding.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (binding.isForce.isChecked()) {
                    List<ItemInfo.DataBean> collect = mItemInfo.getData().stream().filter(t -> TextUtils.equals(t.getItemKindID(), "1")).collect(Collectors.toList());
                    info.itemId = collect.get(i).getItemID();
                } else {
                    info.itemId = mTechnicianItems.getData().get(i).getItemCode();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.cancel.setOnClickListener(view -> dismiss());
        binding.confirm.setOnClickListener(view -> {
            updateItem();
        });
    }


    public interface OnUpdateItemSuccessListener {
        void updateItemSuccess();
    }

    private OnUpdateItemSuccessListener mOnUpdateItemSuccessListener;

    public UpdateItem setOnUpdateItemSuccessListener(OnUpdateItemSuccessListener onUpdateItemSuccessListener) {
        mOnUpdateItemSuccessListener = onUpdateItemSuccessListener;
        return this;
    }

    @Override
    protected void initData() {

        viewModel.updateItemResult.observe(this, baseObResult -> {
            TUtils.show(baseObResult.getMsgInfo());
            dismiss();
            if (mOnUpdateItemSuccessListener != null) {
                mOnUpdateItemSuccessListener.updateItemSuccess();
            }
        });
    }


    private void updateItem() {
        BaseRequest.UpdateItemParam param = new BaseRequest.UpdateItemParam();
        param.ConsumerDetailID = info.consumeId;
        param.ItemID = info.itemId;
        param.TecCode = info.technicianCode;
        param.IsForce = binding.isForce.isChecked() ? "1" : "0";
        String p = BaseRequest.getUpdateItemParam(param);
        viewModel.updateItem(p);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }


}
