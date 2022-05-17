package soft.zhuhuo.module_home.ui.dialog;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.PickRoomAdapter;
import soft.zhuhuo.module_home.databinding.DialogUpdateRoomBinding;

public class D_UpdateRoom extends BaseNoModelDialogFragment<DialogUpdateRoomBinding> {

    private final OnUpdateRoomListener onUpdateRoomListener;
    private PickRoomAdapter mAdapter;
    private List<RoomTechnicianInfo.RoomInfoDTO> mInfo;

    public interface OnUpdateRoomListener {
        void updateRoom(String roomCode);
    }

    public D_UpdateRoom(Builder builder) {
        this.onUpdateRoomListener = builder.onUpdateRoomListener;
    }

    public static class Builder {
        private OnUpdateRoomListener onUpdateRoomListener;


        public Builder setOnUpdateRoomListener(OnUpdateRoomListener onUpdateRoomListener) {
            this.onUpdateRoomListener = onUpdateRoomListener;
            return this;
        }

        public D_UpdateRoom build() {
            return new D_UpdateRoom(this);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_update_room;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.cancel.setOnClickListener(view -> {
            dismiss();
        });
        binding.confirm.setOnClickListener(view -> {
            if (onUpdateRoomListener != null) {
                if (mAdapter == null) {
                    return;
                }

                RoomTechnicianInfo.RoomInfoDTO selectedData = mAdapter.getSelectedData();
                if (selectedData == null) {
                    TUtils.show("请选择要换房的房间");
                    return;
                }

                onUpdateRoomListener.updateRoom(selectedData.getRoomCode());
            }
            dismiss();
        });

        binding.rvUpdateRoom.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mAdapter = new PickRoomAdapter(context);
        binding.rvUpdateRoom.setAdapter(mAdapter);

        Global.getInstance().getRoomTechnicianInfo().observe(this, roomTechnicianInfo -> {
            if (mInfo == null) {
                mInfo = roomTechnicianInfo.getRoomInfo().stream()
                        .filter(t -> TextUtils.equals("1", t.getStateID()))
                        .collect(Collectors.toList());
            }
            mAdapter.setData(mInfo);
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
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }
}
