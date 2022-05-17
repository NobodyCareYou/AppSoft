package soft.zhuhuo.module_home.ui.dialog;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.List;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.PickRoomAdapter;
import soft.zhuhuo.module_home.databinding.DialogSplitItemBinding;

public class SplitItem extends BaseNoModelDialogFragment<DialogSplitItemBinding> {


    private OnSplitListener onSplitListener;
    private PickRoomAdapter mAdapter;
    private List<RoomTechnicianInfo.RoomInfoDTO> mInfo;


    public interface OnSplitListener {
        void split(String roomCode);
    }

    public SplitItem(Builder builder) {
        this.onSplitListener = builder.onSplitListener;
    }

    public static class Builder {
        private OnSplitListener onSplitListener;


        public Builder setOnSplitListener(OnSplitListener onSplitListener) {
            this.onSplitListener = onSplitListener;
            return this;
        }

        public SplitItem build() {
            return new SplitItem(this);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_split_item;
    }

    @Override
    protected void initView() {
        binding.ivClose.setOnClickListener(view -> dismiss());

        binding.cancel.setOnClickListener(view -> {
            dismiss();
        });
        binding.confirm.setOnClickListener(view -> {
            if (onSplitListener != null) {
                if (mAdapter == null) {
                    return;
                }

                RoomTechnicianInfo.RoomInfoDTO selectedData = mAdapter.getSelectedData();
                if (selectedData == null) {
                    TUtils.show("请选择要拆单的房间");
                    return;
                }

                onSplitListener.split(selectedData.getRoomCode());
            }
            dismiss();
        });

        binding.rvSplitRoom.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mAdapter = new PickRoomAdapter(context);
        binding.rvSplitRoom.setAdapter(mAdapter);

        Global.getInstance().getRoomTechnicianInfo().observe(this, new Observer<RoomTechnicianInfo>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(RoomTechnicianInfo roomTechnicianInfo) {
                if (mInfo == null) {
                    mInfo = roomTechnicianInfo.getRoomInfo().stream()
                            .filter(t -> TextUtils.equals("1", t.getStateID()) || TextUtils.equals("8", t.getStateID()) || TextUtils.equals("4", t.getStateID()) || TextUtils.equals("6", t.getStateID()))
                            .collect(Collectors.toList());
                }
                mAdapter.setData(mInfo);
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
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }
}
