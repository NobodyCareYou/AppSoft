package soft.zhuhuo.module_home.ui.dialog;

import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.launcher.ARouter;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.DialogRoomOptBinding;
import soft.zhuhuo.module_home.mvvm.vm.RoomOptViewModel;

public class RoomOptDialog extends BaseDialogFragment<RoomOptViewModel, DialogRoomOptBinding> {

    private final String roomCode;
    private final String state;

    private RoomOptDialog(String roomCode, String state) {
        this.roomCode = roomCode;
        this.state = state;
    }

    public static RoomOptDialog getInstance(String roomCode, String state) {
        return new RoomOptDialog(roomCode, state);
    }

    @Override
    protected RoomOptViewModel createViewModel() {
        return new ViewModelProvider(this).get(RoomOptViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_room_opt;
    }

    @Override
    protected void initView() {
        binding.repair.setText(state.equals("7") ? "取消维修房" : "设置维修房");
        binding.clear.setText(state.equals("5") ? "清房完成" : "请求清房");

        viewModel.openRoomResult.observe(this, aBoolean -> {
            if (aBoolean) {
                ARouter.getInstance().build(RouteConfig.ROOM_DETAIL)
                        .withString("roomCode", roomCode)
                        .withString("isNight", "false")
                        .navigation();
            }
        });

        viewModel.result.observe(this, aBoolean -> {
            if (aBoolean) {
                dismiss();
            }
        });

        binding.openRoom.setOnClickListener(v -> viewModel.openRoom(roomCode));

        binding.repair.setOnClickListener(v -> {
            if (!state.equals("7")) {
                //设置维修房
                viewModel.setRoomState(BaseRequest.getUpdateRoomStateP("2", roomCode));
            } else {
                //取消维修房
                viewModel.setRoomState(BaseRequest.getUpdateRoomStateP("3", roomCode));
            }
        });
        binding.clear.setOnClickListener(v -> {
            if (!state.equals("5")) {
                //清房完成
                viewModel.cleanRoom(roomCode, "1");
            } else {
                //请求清房
                viewModel.cleanRoom(roomCode, "0");
            }
        });
        binding.appointment.setOnClickListener(v -> TUtils.show("该功能暂未开放"));
        binding.ivClose.setOnClickListener(v -> dismiss());
        binding.order.setOnClickListener(v -> ARouter.getInstance().build(RouteConfig.ORDER_PAGE).withString("roomCode", roomCode).navigation());
    }

    @Override
    protected void initData() {

    }
}
