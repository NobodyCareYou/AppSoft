package soft.zhuhuo.module_home.ui;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.RoomDetail;
import soft.zhuhuo.lib.bean.UpdateItemInfo;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ActivityRoomDetailBinding;
import soft.zhuhuo.module_home.mvvm.vm.RoomDetailViewModel;
import soft.zhuhuo.module_home.adapter.RoomDetailAdapter;
import soft.zhuhuo.module_home.ui.dialog.D_AddClock;
import soft.zhuhuo.module_home.ui.dialog.LeaveMessage;
import soft.zhuhuo.module_home.ui.dialog.SplitItem;
import soft.zhuhuo.module_home.ui.dialog.UpdateClockType;
import soft.zhuhuo.module_home.ui.dialog.UpdateDownTime;
import soft.zhuhuo.module_home.ui.dialog.UpdateItem;
import soft.zhuhuo.module_home.ui.dialog.D_UpdateRoom;
import soft.zhuhuo.module_home.ui.dialog.UpdateTechnician;

@Route(path = RouteConfig.ROOM_DETAIL)
public class RoomDetailActivity extends BaseActivity<RoomDetailViewModel, ActivityRoomDetailBinding> {

    private RoomDetailAdapter mAdapter;

    @Autowired
    String roomCode;
    @Autowired
    String isNight;

    private String msg;
    private String mNewRoomCode;


    @Override
    protected RoomDetailViewModel createViewModel() {
        return new ViewModelProvider(this).get(RoomDetailViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room_detail;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle(String.format("%s房间详情", roomCode));
        binding.rvDetail.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RoomDetailAdapter(context);
        mAdapter.setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
            @Override
            public void onItemClick(String data, int position) {
                RoomDetail.ConsumDetailDTO info = mAdapter.getData().get(position);
                super.onItemClick(data, position);
                if (TextUtils.equals("起钟", data)) {
                    BaseRequest.TechnicianUpClockP p1 = new BaseRequest.TechnicianUpClockP();
                    p1.TecCode = info.getTecCode();
                    p1.ItemID = info.getItemID();
                    p1.RoomCode = info.getRoomCode();
                    viewModel.upClock(BaseRequest.getTechnicianUpClockParam(p1));

                } else if (TextUtils.equals("落钟", data)) {
                    BaseRequest.TechnicianDownClockP p1 = new BaseRequest.TechnicianDownClockP();
                    p1.TecCode = info.getTecCode();
                    p1.IsForceEnd = "0";
                    p1.RoomCode = info.getRoomCode();
                    viewModel.downClock(BaseRequest.getTechnicianDownClockP(p1));
                } else if (TextUtils.equals("加钟", data)) {
                    D_AddClock.getInstance(info.getTecID(), info.getTecCode(), info.getRoomCode()).setOnAddClockSuccessListener(() -> viewModel.getRoomDetailInfo(roomCode)).showNow(getSupportFragmentManager(), "加钟");
                } else if (TextUtils.equals("催落钟", data)) {
                    BaseRequest.DownClockAlertP p1 = new BaseRequest.DownClockAlertP(info.getConsumerDetailID());
                    viewModel.downClockAlert(BaseRequest.getDownClockAlertP(p1));
                } else if (TextUtils.equals("换技师", data)) {
                    UpdateTechnician.getInstance(info.getRoomCode(), info.getItemID(), info.getConsumerDetailID(), info.getTecCode(), info.getClockType()).show(getSupportFragmentManager(), "换技师");
                } else if (TextUtils.equals("换项目", data)) {
                    TUtils.show("换项目");
                    UpdateItemInfo updateItemInfo = new UpdateItemInfo();
                    updateItemInfo.consumeId = info.getConsumerDetailID();
                    updateItemInfo.roomCode = info.getRoomCode();
                    updateItemInfo.technicianId = info.getTecID();
                    updateItemInfo.technicianCode = info.getTecCode();
                    updateItemInfo.itemId = info.getItemID();
                    updateItemInfo.itemCode = info.getItemCode();
                    updateItemInfo.itemName = info.getItemName();
                    UpdateItem.getInstance(updateItemInfo).setOnUpdateItemSuccessListener(() -> {
//                        roomCode = mNewRoomCode;
                        viewModel.getRoomDetailInfo(roomCode);
                    }).show(getSupportFragmentManager(), "换项目");
                } else if (TextUtils.equals("拆单", data)) {
                    new SplitItem.Builder().setOnSplitListener(newRoomCode -> {
                        BaseRequest.SplitP p = new BaseRequest.SplitP();
                        p.ConsumerDetailID = info.getConsumerDetailID();
                        p.RoomCode = roomCode;
                        p.NewRoomCode = newRoomCode;
                        viewModel.split(BaseRequest.getSplitP(p));
                    }).build().show(getSupportFragmentManager(), "拆单");
                } else if (TextUtils.equals("退单", data)) {
                    BaseRequest.CancelItemParam p1 = new BaseRequest.CancelItemParam(info.getConsumerDetailID());
                    viewModel.cancelItem(BaseRequest.getCancelItemParam(p1));
                } else if (TextUtils.equals("改类型", data)) {
                    UpdateClockType.getInstance(info.getClockType(), info.getConsumerDetailID())
                            .show(getSupportFragmentManager(), "改类型");
                } else if (TextUtils.equals("改余时", data)) {
                    UpdateDownTime.getInstance(info.getConsumerDetailID()).setOnUpdateDownTimeSuccessListener(() -> viewModel.getRoomDetailInfo(roomCode)).show(getSupportFragmentManager(), "改到点");
                }
            }
        });
        binding.rvDetail.setAdapter(mAdapter);
        binding.order.setOnClickListener(v -> ARouter.getInstance().build(RouteConfig.ORDER_PAGE).withString("roomCode", roomCode).navigation());
        binding.union.setOnClickListener(v -> {
            ARouter.getInstance().build(RouteConfig.UNION_ROOM_PAGE).navigation();
        });
        binding.changeRoom.setOnClickListener(v -> new D_UpdateRoom.Builder().
                setOnUpdateRoomListener(newRoomCode -> {
                    mNewRoomCode = newRoomCode;
                    viewModel.updateRoom(BaseRequest.getUpdateRoomP(roomCode, newRoomCode));
                })
                .build().show(getSupportFragmentManager(), "换房"));
        binding.nightRoom.setOnClickListener(v -> {
            if (TextUtils.equals("1", isNight)) {
                viewModel.setRoomState(BaseRequest.getUpdateRoomStateP("1", roomCode));
            } else {
                viewModel.setRoomState(BaseRequest.getUpdateRoomStateP("0", roomCode));
            }
        });
        binding.message.setOnClickListener(v -> {
            new LeaveMessage.Builder()
                    .setMsg(msg)
                    .setOnLeaveMessageListener(msg -> {
                        BaseRequest.LeaveMessageP p = new BaseRequest.LeaveMessageP(msg, roomCode);
                        viewModel.leaveMessage(BaseRequest.getLeaveMessageP(p));
                    })
                    .build()
                    .show(getSupportFragmentManager(), "留言");

        });
        binding.clear.setOnClickListener(v -> {
            viewModel.clearRoom(roomCode, "0");
        }); //0 请求 1完成
        binding.payment.setOnClickListener(v -> {
            TUtils.show("改功能暂未开放");
        });
    }

    @Override
    protected void initData() {
        viewModel.refreshResult.observe(this, aBoolean -> {
            if (aBoolean) {
                viewModel.getRoomDetailInfo(roomCode);
                viewModel.refreshResult.setValue(false);
            }
        });

        viewModel.updateRoomResult.observe(this, aBoolean -> {
            if (aBoolean) {
                roomCode = mNewRoomCode;
                binding.setTitle(String.format("%s房间详情", roomCode));
                viewModel.getRoomDetailInfo(roomCode);
            }
        });
        viewModel.mRoomDetail.observe(this, roomDetail -> {
            msg = roomDetail.getRoomMess();
            String money = roomDetail.getPayMoney();
            mAdapter.setData(roomDetail.getConsumDetail(),money);
        });
        viewModel.cleanRoomResult.observe(this, baseObResult -> finish());
        viewModel.setNightResult.observe(this, baseObResult -> {
            if (TextUtils.equals("1", isNight)) {
                isNight = "0";
            } else {
                isNight = "1";
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getRoomDetailInfo(roomCode);
    }
}