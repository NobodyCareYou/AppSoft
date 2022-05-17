package soft.zhuhuo.module_home.ui.fragment;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.PickerPopupWindow;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.TechnicianInfo;
import soft.zhuhuo.lib.bean.TechnicianState;
import soft.zhuhuo.lib.bean.TechnicianType;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.TechnicianAdapter;
import soft.zhuhuo.module_home.databinding.FragmentTechnicianBinding;
import soft.zhuhuo.module_home.ui.dialog.TechnicianOptDialog;


@RequiresApi(api = Build.VERSION_CODES.N)
public class TechnicianFragment extends BaseNoModelFragment<FragmentTechnicianBinding> {

    private int typeConditionHeight, stateConditionHeight;
    private int typeConditionWidth, stateConditionWidth;
    private TechnicianAdapter mTechnicianAdapter;

    private List<TechnicianState> technicianState;
    private List<String> stateNames;
    private List<TechnicianType.DataBean> mTechnicianTypeData;
    private List<String> typeNames;

    private String defaultTypeText = "全部";
    private String defaultStateText = "全部";
    private String technicianTypeId;
    private String stateId;

    private RoomTechnicianInfo mRoomTechnicianInfo;


    public static TechnicianFragment getInstance() {
        return new TechnicianFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_technician;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        requestWidthAndHeight();
        Global.getInstance().getTechnicianTypeInfo().observe(this, info -> {
            mTechnicianTypeData = info.getData();
            typeNames = mTechnicianTypeData.stream().map(TechnicianType.DataBean::getPostName).collect(Collectors.toList());
            typeNames.add(0, "全部");
        });
        technicianState = TechnicianState.getTechnicianState();
        stateNames = (ArrayList<String>) technicianState.stream().map(roomState1 -> roomState1.StateName).collect(Collectors.toList());
        stateNames.add(0, "全部");

        binding.refresh.setEnableRefresh(false);
        binding.refresh.setEnableLoadMore(false);
        binding.rvTechnician.setLayoutManager(new LinearLayoutManager(context));
        mTechnicianAdapter = new TechnicianAdapter(context);
        binding.rvTechnician.setAdapter(mTechnicianAdapter);

        Global.getInstance().getRoomTechnicianInfo().observe(this, info -> {
            mRoomTechnicianInfo = info;
            setAdapter();

        });

        binding.type.setOnClickListener(view -> showTechnicianType());
        binding.state.setOnClickListener(view -> showTechnicianState());

    }

    private void requestWidthAndHeight() {
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
        mTechnicianAdapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.TecInfoDTO>() {

            @Override
            public void onItemClick(RoomTechnicianInfo.TecInfoDTO data, int position) {
                new TechnicianOptDialog(data).show(getChildFragmentManager(), "技师操作");
            }
        });
    }

    private void showTechnicianType() {
        int[] location = new int[2];
        binding.type.getLocationOnScreen(location);
        if (typeConditionWidth != 0 && typeConditionHeight != 0 && typeNames.size() > 0) {
            new PickerPopupWindow.Build()
                    .setWidth(typeConditionWidth)
                    .setHeight(typeConditionHeight)
                    .setData(typeNames)
                    .setDefaultText(defaultTypeText)
                    .setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
                        @Override
                        public void onItemClick(View v, int position) {
                            defaultTypeText = typeNames.get(position);
                            if (position==0){
                                technicianTypeId = "";
                            }else {
                                technicianTypeId = mTechnicianTypeData.get(position-1).getPostTypeID();
                            }

                            setAdapter();
                        }
                    })
                    .build(context)
                    .show(binding.type);
        }
    }

    private void showTechnicianState() {
        int[] location = new int[2];
        binding.state.getLocationOnScreen(location);
        if (stateConditionWidth != 0 && stateConditionHeight != 0 && stateNames.size() > 0) {
            new PickerPopupWindow.Build()
                    .setWidth(stateConditionWidth)
                    .setHeight(stateConditionHeight)
                    .setData(stateNames)
                    .setDefaultText(defaultStateText)
                    .setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
                        @Override
                        public void onItemClick(View v, int position) {
                            defaultStateText = stateNames.get(position);
                            if (position == 0) {
                                stateId = "";
                            } else {
                                stateId = technicianState.get(position-1).StateId;
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

        if (mRoomTechnicianInfo.getTecInfo() == null || mRoomTechnicianInfo.getTecInfo().size() == 0) {
            TUtils.show("没有查询到技师数据");
            return;
        }

        List<RoomTechnicianInfo.TecInfoDTO> techInfo = mRoomTechnicianInfo.getTecInfo();
        techInfo = techInfo.stream().filter(t -> (TextUtils.isEmpty(technicianTypeId) || technicianTypeId.equals(t.getPostTypeID()))
                && (TextUtils.isEmpty(stateId) || stateId.equals(t.getStateID()))).collect(Collectors.toList());

        List<TechnicianInfo> data = new ArrayList<>();
        List<String> names = techInfo.stream().map(RoomTechnicianInfo.TecInfoDTO::getPostName).distinct().collect(Collectors.toList());
        for (String name : names) {
            TechnicianInfo tmp = new TechnicianInfo();
            tmp.name = name;
            tmp.count = (int) techInfo.stream().filter(t -> t.getPostName().equals(name)).count();
            tmp.data = techInfo.stream().filter(t -> t.getPostName().equals(name)).collect(Collectors.toList());
            data.add(tmp);
        }
        if (mTechnicianAdapter != null) {
            mTechnicianAdapter.setData(data);
        }
    }

}
