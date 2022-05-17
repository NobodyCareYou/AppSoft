package soft.zhuhuo.module_home.ui.fragment;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.PickerPopupWindow;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.FloorInfo;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.RoomType;
import soft.zhuhuo.lib.constant.RoomState;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.RoomAdapter;
import soft.zhuhuo.module_home.databinding.FragmentRoomBinding;
import soft.zhuhuo.module_home.ui.dialog.RoomOptDialog;

@RequiresApi(api = Build.VERSION_CODES.N)
public class RoomFragment extends BaseNoModelFragment<FragmentRoomBinding> {

    private int floorConditionHeight, typeConditionHeight, stateConditionHeight;
    private int floorConditionWidth, typeConditionWidth, stateConditionWidth;
    private RoomAdapter mRoomAdapter;
    private ArrayList<String> mFloorNames;
    private ArrayList<String> mRoomTypeNames;
    private ArrayList<String> mStateNames;
    private List<FloorInfo.DataBean> mFloorData;
    private List<RoomType.DataBean> mRoomTypeData;
    private String defaultFloorText = "全部";
    private String defaultTypeText = "全部";
    private String defaultStateText = "全部";
    private String floorId;
    private String roomTypeId;
    private String stateId;
    private List<RoomState> mRoomState;

    private RoomTechnicianInfo mRoomTechnicianInfo;

    public static RoomFragment getInstance() {
        return new RoomFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_room;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        requestWidthAndHeight();
        Global.getInstance().getFloorInfo().observe(this, info -> {
            mFloorData = info.getData();
            mFloorNames = (ArrayList<String>) mFloorData.stream().map(FloorInfo.DataBean::getFloorName).collect(Collectors.toList());
            mFloorNames.add(0, "全部");
        });
        Global.getInstance().getRoomTypeInfo().observe(this, info -> {
            mRoomTypeData = info.getData();
            mRoomTypeNames = (ArrayList<String>) mRoomTypeData.stream().map(RoomType.DataBean::getRoomTypeName).collect(Collectors.toList());
            mRoomTypeNames.add(0, "全部");
        });

        mRoomState = RoomState.getRoomState();
        mStateNames = (ArrayList<String>) mRoomState.stream().map(roomState1 -> roomState1.StateName).collect(Collectors.toList());
        mStateNames.add(0, "全部");


        Global.getInstance().getRoomTechnicianInfo().observe(this, info -> {
            mRoomTechnicianInfo = info;
            setAdapter();
        });


        binding.refresh.setEnableRefresh(false);
        binding.refresh.setEnableLoadMore(false);
        binding.rvRoom.setLayoutManager(new LinearLayoutManager(context));
        mRoomAdapter = new RoomAdapter(context);
        binding.rvRoom.setAdapter(mRoomAdapter);
        binding.floor.setOnClickListener(view -> showRoomFloor());
        binding.type.setOnClickListener(view -> showRoomType());
        binding.state.setOnClickListener(view -> showRoomState());
    }

    /**
     * 计算宽高
     */
    private void requestWidthAndHeight() {
        binding.floor.post(() -> {
            floorConditionHeight = binding.floor.getHeight();
            floorConditionWidth = binding.floor.getWidth();
        });
        binding.type.post(() -> {
            typeConditionHeight = binding.type.getHeight();
            typeConditionWidth = binding.type.getWidth();
        });
        binding.state.post(() -> {
            stateConditionHeight = binding.state.getHeight();
            stateConditionWidth = binding.state.getWidth();
        });
    }

    @Override
    protected void initData() {
        mRoomAdapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.RoomInfoDTO>() {

            @Override
            public void onItemClick(RoomTechnicianInfo.RoomInfoDTO data, int position) {
                if ("1".equals(data.getStateID()) || "5".equals(data.getStateID()) || "7".equals(data.getStateID())) {
                    RoomOptDialog.getInstance(data.getRoomCode(), data.getStateID()).show(getChildFragmentManager(), "房间操作");
                } else {
                    ARouter.getInstance().build(RouteConfig.ROOM_DETAIL)
                            .withString("roomCode", data.getRoomCode())
                            .withString("isNight", data.getIsNight())
                            .navigation();
                }
            }
        });
    }


    private void showRoomFloor() {
        int[] location = new int[2];
        binding.floor.getLocationOnScreen(location);
        if (floorConditionWidth != 0 && floorConditionHeight != 0 && mFloorNames.size() > 0) {
            new PickerPopupWindow.Build()
                    .setWidth(floorConditionWidth)
                    .setHeight(floorConditionHeight)
                    .setData(mFloorNames)
                    .setDefaultText(defaultFloorText)
                    .setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
                        @Override
                        public void onItemClick(View v, int position) {
                            defaultFloorText = mFloorNames.get(position);
                            if (position == 0) {
                                floorId = "";
                            } else {
                                floorId = mFloorData.get(position-1).getFloorID();
                            }

                            setAdapter();
                        }
                    })
                    .build(context)
                    .show(binding.floor);
        }
    }

    private void showRoomType() {
        int[] location = new int[2];
        binding.type.getLocationOnScreen(location);
        if (typeConditionWidth != 0 && typeConditionHeight != 0 && mRoomTypeNames.size() > 0) {
            new PickerPopupWindow.Build()
                    .setWidth(typeConditionWidth)
                    .setHeight(typeConditionHeight)
                    .setData(mRoomTypeNames)
                    .setDefaultText(defaultTypeText)
                    .setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
                        @Override
                        public void onItemClick(View v, int position) {
                            defaultTypeText = mRoomTypeNames.get(position);
                            if (position == 0) {
                                roomTypeId = "";
                            } else {
                                roomTypeId = mRoomTypeData.get(position-1).getRoomTypeID();
                            }
                            setAdapter();
                        }
                    })
                    .build(context)
                    .show(binding.type);
        }
    }

    private void showRoomState() {
        int[] location = new int[2];
        binding.state.getLocationOnScreen(location);
        if (stateConditionWidth != 0 && stateConditionHeight != 0 && mStateNames.size() > 0) {
            new PickerPopupWindow.Build()
                    .setWidth(stateConditionWidth)
                    .setHeight(stateConditionHeight)
                    .setData(mStateNames)
                    .setDefaultText(defaultStateText)
                    .setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
                        @Override
                        public void onItemClick(View v, int position) {
                            defaultStateText = mStateNames.get(position);
                            if (position == 0) {
                                stateId = "";
                            } else {
                                stateId = mRoomState.get(position-1).StateId;
                            }

                            setAdapter();
                        }
                    })
                    .build(context)
                    .show(binding.state);
        }
    }


    private void setAdapter() {
        if (mRoomTechnicianInfo == null) {
            return;
        }

        if (mRoomTechnicianInfo.getRoomInfo() == null || mRoomTechnicianInfo.getRoomInfo().size() == 0) {
            TUtils.show("没有查询到房间数据");
            return;
        }

        List<RoomTechnicianInfo.RoomInfoDTO> roomInfo = mRoomTechnicianInfo.getRoomInfo();

        roomInfo = roomInfo.stream().filter(
                t -> (TextUtils.isEmpty(floorId) || floorId.equals(t.getFloorID()))
                        && (TextUtils.isEmpty(roomTypeId) || roomTypeId.equals(t.getRoomTypeID()))
                        && (TextUtils.isEmpty(stateId) || stateId.equals(t.getStateID()))
        ).collect(Collectors.toList());


        List<RoomInfo> data = new ArrayList<>();
        List<String> names = roomInfo.stream().map(RoomTechnicianInfo.RoomInfoDTO::getRoomTypeName).distinct().collect(Collectors.toList());
        for (String name : names) {
            RoomInfo tmp = new RoomInfo();
            tmp.name = name;
            tmp.count = (int) roomInfo.stream().filter(t -> t.getRoomTypeName().equals(name)).count();
            tmp.data = roomInfo.stream().filter(t -> t.getRoomTypeName().equals(name)).collect(Collectors.toList());
            data.add(tmp);
        }
        if (mRoomAdapter != null) {
            mRoomAdapter.setData(data);
        }
    }

}
