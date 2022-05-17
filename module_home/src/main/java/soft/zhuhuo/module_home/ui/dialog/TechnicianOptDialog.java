package soft.zhuhuo.module_home.ui.dialog;

import android.view.View;

import androidx.appcompat.widget.ViewUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.lib.bean.UpdateItemInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.DialogTechnicianOptBinding;
import soft.zhuhuo.module_home.mvvm.vm.TechnicianOptViewModel;

public class TechnicianOptDialog extends BaseDialogFragment<TechnicianOptViewModel, DialogTechnicianOptBinding> {


    RoomTechnicianInfo.TecInfoDTO data;

    public TechnicianOptDialog(RoomTechnicianInfo.TecInfoDTO data) {
        this.data = data;
    }

    @Override
    protected TechnicianOptViewModel createViewModel() {
        return new ViewModelProvider(this).get(TechnicianOptViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_technician_opt;
    }

    private TD technicianDetail;


    @Override
    protected void initView() {
        //获取技师详情
        viewModel.requestTechnicianDetail(BaseRequest.getTDParam(data.getTecCode()));
        viewModel.technicianInfo.observe(this, td -> technicianDetail = td);


        viewModel.result.observe(this, aBoolean -> {
            if (aBoolean) {
                dismiss();
            }
        });


        switch (data.getStateID()) {
            case "2"://上钟
                binding.upclock.setText("下钟");
                break;
            case "3"://圈牌
                binding.circle.setText("取消圈牌");
                break;
            case "5"://下班
                binding.work.setText("上班");
                break;
            case "6"://休假
                binding.work.setText("取消休假");
                break;
            case "7"://待钟
                binding.upclock.setText("上钟");
                break;
        }

        binding.work.setOnClickListener(v -> {
            if (data.getStateID().equals("5")) {
                //上班
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("1", data.getTecCode()));
            } else {
                //下班
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("2", data.getTecCode()));
            }
        });
        binding.circle.setOnClickListener(v -> {
            if (!data.getStateID().equals("3")) {
                //圈牌
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("3", data.getTecCode()));
            } else {
                //取消圈牌
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("4", data.getTecCode()));
            }
        });
        binding.upclock.setOnClickListener(v -> {
            if (data.getStateID().equals("7")) {
                //上钟
                BaseRequest.TechnicianUpClockP p1 = new BaseRequest.TechnicianUpClockP();
                p1.RoomCode = data.getRoomCode();
                p1.ItemID = data.getItemID();
                p1.TecCode = data.getTecCode();
                viewModel.upClock(BaseRequest.getTechnicianUpClockParam(p1));
            } else if (data.getStateID().equals("2")) {
                //落钟
                BaseRequest.TechnicianDownClockP p2 = new BaseRequest.TechnicianDownClockP();
                p2.IsForceEnd = "0";
                p2.RoomCode = data.getRoomCode();
                p2.TecCode = data.getTecCode();
                viewModel.downClock(BaseRequest.getTechnicianDownClockP(p2));
            } else {
                TUtils.show("当前技师无待钟项或上钟项");
                return;
            }
        });

        binding.rest.setOnClickListener(v -> {
            if (data.getStateID().equals("6")) {
                //取消休假
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("6", data.getTecCode()));
            } else {
                //休假
                viewModel.setTechnicianState(BaseRequest.getSetTechnicianStateP("5", data.getTecCode()));
            }
        });
        binding.appointment.setOnClickListener(v -> TUtils.show("该功能暂未开放"));
        binding.ivClose.setOnClickListener(v -> dismiss());


    }

    @Override
    protected void initData() {
        //更换项目
        binding.updateItem.setOnClickListener(v -> {

            if (technicianDetail.getTecClockInfo() == null || technicianDetail.getTecClockInfo().size() == 0) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法更换项目");
                return;
            }

            TD.TecClockInfoDTO datum = null;
            for (TD.TecClockInfoDTO td : technicianDetail.getTecClockInfo()) {
                if (td.getStateID().equals("2")) {
                    datum = td;
                    break;
                }
                if (td.getStateID().equals("1")) {
                    datum = td;
                    break;
                }
            }

            if (datum == null) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法更换项目");
                return;
            }

            dismiss();

            UpdateItemInfo info = new UpdateItemInfo();
            info.roomCode = datum.getRoomCode();
            info.consumeId = datum.getConsumerDetailID();
            info.itemId = datum.getItemID();
            info.itemCode = datum.getItemCode();
            info.technicianId = datum.getTecID();
            info.itemName = datum.getItemName();
            info.technicianId = data.getTecID();
            info.technicianCode = data.getTecCode();
            UpdateItem.getInstance(info).show(getChildFragmentManager(), "");
        });
        //更换技师
        binding.updateTechnician.setOnClickListener(v -> {


            if (technicianDetail.getTecClockInfo() == null || technicianDetail.getTecClockInfo().size() == 0) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法更换技师");
                return;
            }
            TD.TecClockInfoDTO datum = null;
            for (TD.TecClockInfoDTO td : technicianDetail.getTecClockInfo()) {
                if (td.getStateID().equals("2")) {
                    datum = td;
                    break;
                }
                if (td.getStateID().equals("1")) {
                    datum = td;
                    break;
                }
            }

            if (datum == null) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法更换技师");
                return;
            }

            dismiss();


            UpdateTechnician.getInstance(datum.getRoomCode(), datum.getItemID(), datum.getConsumerDetailID(), datum.getTecCode(), datum.getClockType())
                    .show(getChildFragmentManager(), "换技师");
        });
        //加钟
        binding.addClock.setOnClickListener(v -> {
            if (technicianDetail.getTecClockInfo() == null || technicianDetail.getTecClockInfo().size() == 0) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法加钟");
                return;
            }

            TD.TecClockInfoDTO datum = null;
            for (TD.TecClockInfoDTO td : technicianDetail.getTecClockInfo()) {
                if (td.getStateID().equals("2")) {
                    datum = td;
                    break;
                }
                if (td.getStateID().equals("1")) {
                    datum = td;
                    break;
                }
            }

            if (datum == null) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法加钟");
                return;
            }

            dismiss();
            D_AddClock.getInstance(data.getTecID(), data.getTecCode(), datum.getRoomCode()).showNow(getChildFragmentManager(), "加钟");

        });
        //提前下钟
        binding.advanceDownClock.setOnClickListener(v -> {
            if (data.getStateID().equals("2")) {
                BaseRequest.TechnicianDownClockP p2 = new BaseRequest.TechnicianDownClockP();
                p2.IsForceEnd = "1";
                p2.RoomCode = data.getRoomCode();
                p2.TecCode = data.getTecCode();
                viewModel.downClock(BaseRequest.getTechnicianDownClockP(p2));
            }else {
                TUtils.show("当前技师没有在上钟的项目，无法提前下钟");
            }
        });
        //退单
        binding.cancelItem.setOnClickListener(v -> {
            if (technicianDetail.getTecClockInfo() == null || technicianDetail.getTecClockInfo().size() == 0) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法退单");
                return;
            }
            TD.TecClockInfoDTO datum = null;
            for (TD.TecClockInfoDTO td : technicianDetail.getTecClockInfo()) {
                if (td.getStateID().equals("2")) {
                    datum = td;
                    break;
                }
                if (td.getStateID().equals("1")) {
                    datum = td;
                    break;
                }
            }

            if (datum == null) {
                TUtils.show("当前技师没有待钟项目或上钟项目,无法退单");
                return;
            }

            dismiss();
            BaseRequest.CancelItemParam p1 = new BaseRequest.CancelItemParam(datum.getConsumerDetailID());
            viewModel.cancelItem(BaseRequest.getCancelItemParam(p1));

        });



    }
}
