package soft.zhuhuo.module_home.ui.dialog;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.SPItemAdapter;
import soft.zhuhuo.module_home.databinding.DialogUpdateTechnicianBinding;
import soft.zhuhuo.module_home.mvvm.vm.UpdateTechnicianViewModel;

public class UpdateTechnician extends BaseDialogFragment<UpdateTechnicianViewModel, DialogUpdateTechnicianBinding> {

    private String roomCode;
    private String itemId;
    private String sex = "0";
    private String consumeId;
    private String oldTechnicianCode;
    private String newTechnicianCode;
    private String clockType;
    private SPItemAdapter mAdapter1;

    private UpdateTechnician(String roomCode, String itemId, String consumeId, String oldTechnicianCode, String clockType) {
        this.roomCode = roomCode;
        this.itemId = itemId;
        this.consumeId = consumeId;
        this.oldTechnicianCode = oldTechnicianCode;
        this.clockType = clockType;
    }

    public static UpdateTechnician getInstance(String roomCode, String itemId, String consumeId, String oldTechnicianCode, String clockType) {
        return new UpdateTechnician(roomCode, itemId, consumeId, oldTechnicianCode, clockType);
    }


    @Override
    protected UpdateTechnicianViewModel createViewModel() {
        return new ViewModelProvider(this).get(UpdateTechnicianViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_update_technician;
    }

    List<String> technicianCodes;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        binding.roomCode.setText(roomCode);
        binding.oldTechnicianCode.setText(oldTechnicianCode);

        SPItemAdapter adapter = new SPItemAdapter();
        List<String> sexList = new ArrayList<>();
        sexList.add("女");
        sexList.add("男");
        adapter.setData(sexList);
        binding.spSex.setAdapter(adapter);
        binding.spSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    sex = "0";
                } else {
                    sex = "1";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mAdapter1 = new SPItemAdapter();
        binding.spTechnician.setAdapter(mAdapter1);

        viewModel.itemTechnician.observe(this, itemTechnician -> {
            mItemTechnician = itemTechnician;
            technicianCodes = mItemTechnician.getData().stream().map(ItemTechnician.DataDTO::getTecCode).collect(Collectors.toList());
            mAdapter1.setData(technicianCodes);
        });
        Global.getInstance().getRoomTechnicianInfo().observe(this, roomTechnicianInfo -> mAllTechnician = roomTechnicianInfo.getTecInfo());

        binding.isForceChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    technicianCodes = mAllTechnician.stream().map(RoomTechnicianInfo.TecInfoDTO::getTecCode).collect(Collectors.toList());
                } else {
                    if (mItemTechnician != null) {
                        technicianCodes = mItemTechnician.getData().stream().map(ItemTechnician.DataDTO::getTecCode).collect(Collectors.toList());
                    }
                }
                mAdapter1.setData(technicianCodes);
            }
        });


        binding.spTechnician.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (binding.isForceChange.isChecked()) {
                    if (mAllTechnician != null) {
                        newTechnicianCode = mAllTechnician.get(i).getTecCode();
                    }
                } else {
                    if (mItemTechnician != null) {
                        newTechnicianCode = mItemTechnician.getData().get(i).getTecCode();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.confirm.setOnClickListener(v -> {
            BaseRequest.UpdateTechnicianP p = new BaseRequest.UpdateTechnicianP();
            p.consumerDetailID = consumeId;
            p.dTecCode = newTechnicianCode;
            p.isForce = binding.isForceChange.isChecked() ? "1" : "0";
            p.nextOrderSex = sex;
            p.isRingTec = binding.circle.isChecked() ? "1" : "0";
            p.roomCode = roomCode;
            p.newClockType = clockType;
            p.optTypeID = "1";
            viewModel.updateTechnician(BaseRequest.getUpdateTechnicianP(p));
        });

        binding.cancel.setOnClickListener(v -> {
            BaseRequest.UpdateTechnicianP p = new BaseRequest.UpdateTechnicianP();
            p.consumerDetailID = consumeId;
            p.dTecCode = newTechnicianCode;
            p.isForce = binding.isForceChange.isChecked() ? "1" : "0";
            p.nextOrderSex = sex;
            p.isRingTec = binding.circle.isChecked() ? "1" : "0";
            p.roomCode = roomCode;
            p.newClockType = clockType;
            p.optTypeID = "0";
            viewModel.updateTechnician(BaseRequest.getUpdateTechnicianP(p));
        });
        binding.ivClose.setOnClickListener(v -> dismiss());
    }


    private ItemTechnician mItemTechnician;
    private List<RoomTechnicianInfo.TecInfoDTO> mAllTechnician;

    @Override
    protected void initData() {
        BaseRequest.ItemAvailableTechnicianP p1 = new BaseRequest.ItemAvailableTechnicianP(itemId);
        viewModel.getItemTechnician(BaseRequest.getItemAvailableTechnicianP(p1));
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
