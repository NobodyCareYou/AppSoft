package soft.zhuhuo.module_home.ui;

import android.text.TextUtils;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.bean.UpdateItemInfo;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.TDAdapter;
import soft.zhuhuo.module_home.databinding.ActivityTdBinding;
import soft.zhuhuo.module_home.mvvm.vm.TDViewModel;
import soft.zhuhuo.module_home.ui.dialog.TechnicianUpClock;
import soft.zhuhuo.module_home.ui.dialog.UpdateClockType;
import soft.zhuhuo.module_home.ui.dialog.UpdateDownTime;
import soft.zhuhuo.module_home.ui.dialog.UpdateItem;
import soft.zhuhuo.module_home.ui.dialog.UpdateTechnician;


@Route(path = RouteConfig.TECHNICIAN_INFO_PAGE)
public class TechDetailActivity extends BaseActivity<TDViewModel, ActivityTdBinding> {

    private TDAdapter adapter;
    private TD data;
    @Autowired
    public String technicianCode;

    @Override
    protected TDViewModel createViewModel() {
        return new ViewModelProvider(this).get(TDViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_td;
    }


    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        binding.searchCode.setText(technicianCode);
        binding.searchCode.setSelection(technicianCode.length());
        if (!TextUtils.isEmpty(technicianCode)) {
            viewModel.getTechnicianInfo(BaseRequest.getTDParam(technicianCode));
        }
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("技师详情");
        binding.rvTc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TDAdapter();
        binding.rvTc.setAdapter(adapter);

        viewModel.technicianInfo.observe(this, td -> {
            data = td;
            binding.setData(data);
            adapter.setData(data.getTecClockInfo());
        });

        binding.search.setOnClickListener(view -> {
            technicianCode = binding.searchCode.getText().toString();
            if (TextUtils.isEmpty(technicianCode)) {
                TUtils.show("请输入技师工号");
                return;
            }
            viewModel.getTechnicianInfo(BaseRequest.getTDParam(technicianCode));
        });

        binding.upClock.setOnClickListener(view -> {
            List<TD.TecClockInfoDTO> tecClockInfo = data.getTecClockInfo();
            if (tecClockInfo == null || tecClockInfo.size() == 0) {
                TUtils.show("当前技师没有项目");
                return;
            }
            List<TD.TecClockInfoDTO> tecClockInfoDTO;

            List<TD.TecClockInfoDTO> tmp = new ArrayList<>();
            for (TD.TecClockInfoDTO info : tecClockInfo) {
                if (TextUtils.equals(info.getStateID(), "1")) {
                    tmp.add(info);
                    break;
                }
            }
            tecClockInfoDTO = tmp;

            if (tecClockInfoDTO.size() == 0) {
                TUtils.show("当前技师没有待钟项");
                return;
            }

            TechnicianUpClock.getInstance(tecClockInfoDTO).setOnUpClockSuccessListener(() -> {
                technicianCode = binding.searchCode.getText().toString();
                viewModel.getTechnicianInfo(BaseRequest.getTDParam(technicianCode));
            })
                    .show(getSupportFragmentManager(), "");
        });
        binding.downClock.setOnClickListener(view -> {
            List<TD.TecClockInfoDTO> tecClockInfo = data.getTecClockInfo();
            if (tecClockInfo == null || tecClockInfo.size() == 0) {
                TUtils.show("当前技师没有项目");
                return;
            }
            TD.TecClockInfoDTO tecClockInfoDTO = null;

            for (TD.TecClockInfoDTO info : tecClockInfo) {
                if (TextUtils.equals(info.getStateID(), "2")) {
                    tecClockInfoDTO = info;
                    break;
                }
            }

            if (tecClockInfoDTO == null) {
                TUtils.show("当前技师上钟项目");
                return;
            }
            downClock(tecClockInfoDTO, 0);
        });
        binding.downClockAlert.setOnClickListener(view -> {
            List<TD.TecClockInfoDTO> tecClockInfo = data.getTecClockInfo();
            if (tecClockInfo == null || tecClockInfo.size() == 0) {
                TUtils.show("当前技师没有项目");
                return;
            }
            TD.TecClockInfoDTO tecClockInfoDTO = null;

            for (TD.TecClockInfoDTO info : tecClockInfo) {
                if (TextUtils.equals(info.getStateID(), "2")) {
                    tecClockInfoDTO = info;
                    break;
                }
            }


            if (tecClockInfoDTO == null) {
                TUtils.show("当前技师上钟项目");
                return;
            }

            viewModel.downClockAlert(BaseRequest.getDownClockAlertP(new BaseRequest.DownClockAlertP(tecClockInfoDTO.getConsumerDetailID())));
        });
        binding.advanceDownClock.setOnClickListener(view -> {
            List<TD.TecClockInfoDTO> tecClockInfo = data.getTecClockInfo();
            if (tecClockInfo == null || tecClockInfo.size() == 0) {
                TUtils.show("当前技师没有项目");
                return;
            }
            TD.TecClockInfoDTO tecClockInfoDTO = null;

            for (TD.TecClockInfoDTO info : tecClockInfo) {
                if (TextUtils.equals(info.getStateID(), "2")) {
                    tecClockInfoDTO = info;
                    break;
                }
            }

            if (tecClockInfoDTO == null) {
                TUtils.show("当前没有上钟项目,无法落钟");
                return;
            }

            downClock(tecClockInfoDTO, 1);
        });

        binding.updateClockType.setOnClickListener(view -> {
            if (data.getTecClockInfo() == null || data.getTecClockInfo().size() == 0) {
                return;
            }
            TD.TecClockInfoDTO datum;
            if (data.getTecClockInfo().size() == 1) {
                datum = data.getTecClockInfo().get(0);
            } else {
                datum = adapter.getSelectedData();
            }
            UpdateClockType.getInstance(datum.getClockType(), datum.getConsumerDetailID()).show(getSupportFragmentManager(), "更换上点类型");
        });

        binding.updateDownTime.setOnClickListener(view -> {
            List<TD.TecClockInfoDTO> tecClockInfo = data.getTecClockInfo();
            if (tecClockInfo == null || tecClockInfo.size() == 0) {
                TUtils.show("当前技师没有项目");
                return;
            }
            TD.TecClockInfoDTO tecClockInfoDTO = null;
            for (TD.TecClockInfoDTO info : tecClockInfo) {
                if (TextUtils.equals(info.getStateID(), "2")) {
                    tecClockInfoDTO = info;
                    break;
                }
            }

            if (tecClockInfoDTO == null) {
                TUtils.show("当前没有上钟项目,无法修改落钟时间");
                return;
            }

            UpdateDownTime.getInstance(tecClockInfoDTO.getConsumerDetailID())
                    .setOnUpdateDownTimeSuccessListener(() -> {
                        technicianCode = binding.searchCode.getText().toString();
                        viewModel.getTechnicianInfo(BaseRequest.getTDParam(technicianCode));
                        viewModel.refreshResult.setValue(false);
                    })
                    .show(getSupportFragmentManager(), "");
        });
        binding.updateItem.setOnClickListener(view -> {
            if (data.getTecClockInfo() == null || data.getTecClockInfo().size() == 0) {
                return;
            }
            TD.TecClockInfoDTO datum;
            if (data.getTecClockInfo().size() == 1) {
                datum = data.getTecClockInfo().get(0);
            } else {
                datum = adapter.getSelectedData();
            }
            if (datum == null) {
                TUtils.show("请选择您要更换项目的记录");
                return;
            }

            UpdateItemInfo info = new UpdateItemInfo();
            info.roomCode = datum.getRoomCode();
            info.consumeId = datum.getConsumerDetailID();
            info.itemId = datum.getItemID();
            info.itemCode = datum.getItemCode();
            info.technicianId = datum.getTecID();
            info.itemName = datum.getItemName();
            info.technicianId = data.getTecInfo().get(0).getPersonID();
            info.technicianCode = data.getTecInfo().get(0).getPersonCode();
            UpdateItem.getInstance(info).show(getSupportFragmentManager(), "");
        });
        binding.updateTechnician.setOnClickListener(view -> {
            if (data.getTecClockInfo() == null || data.getTecClockInfo().size() == 0) {
                return;
            }
            TD.TecClockInfoDTO datum;
            if (data.getTecClockInfo().size() == 1) {
                datum = data.getTecClockInfo().get(0);
            } else {
                datum = adapter.getSelectedData();
            }

            if (datum == null) {
                TUtils.show("请选择您要更换技师的项目");
                return;
            }

            UpdateTechnician.getInstance(datum.getRoomCode(), datum.getItemID(), datum.getConsumerDetailID(), datum.getTecCode(), datum.getClockType())
                    .show(getSupportFragmentManager(), "换技师");

        });
        binding.cancelItem.setOnClickListener(view -> {
            if (data.getTecClockInfo() == null || data.getTecClockInfo().size() == 0) {
                return;
            }
            TD.TecClockInfoDTO datum;
            if (data.getTecClockInfo().size() == 1) {
                datum = data.getTecClockInfo().get(0);
            } else {
                datum = adapter.getSelectedData();
            }

            if (datum == null) {
                TUtils.show("请选择您要退单的项目");
                return;
            }

            BaseRequest.CancelItemParam p = new BaseRequest.CancelItemParam(datum.getConsumerDetailID());
            viewModel.cancelItem(BaseRequest.getCancelItemParam(p));
        });
    }


    @Override
    protected void initData() {
        viewModel.refreshResult.observe(this, b -> {
            if (b) {
                technicianCode = binding.searchCode.getText().toString();
                viewModel.getTechnicianInfo(BaseRequest.getTDParam(technicianCode));
                viewModel.refreshResult.setValue(false);
            }
        });
    }

    private void downClock(TD.TecClockInfoDTO tecClockInfoDTO, int isForceEnd) {
        BaseRequest.TechnicianDownClockP param = new BaseRequest.TechnicianDownClockP();
        param.IsForceEnd = String.valueOf(isForceEnd);
        param.RoomCode = tecClockInfoDTO.getRoomCode();
        param.TecCode = tecClockInfoDTO.getTecCode();
        BaseRequest.getTechnicianDownClockP(param);
        viewModel.downClock(BaseRequest.getTechnicianDownClockP(param));
    }


}
