package soft.zhuhuo.module_home.adapter;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemPickRoomBinding;


public class PickRoomAdapter extends BaseAdapter<ItemPickRoomBinding, RoomTechnicianInfo.RoomInfoDTO> {

    private final Context mContext;

    public PickRoomAdapter(Context context) {
        super(R.layout.item_pick_room);
        mContext = context;
    }

    public RoomTechnicianInfo.RoomInfoDTO getSelectedData() {
        for (RoomTechnicianInfo.RoomInfoDTO datum : data) {
            if (datum.isSelected) {
                return datum;
            }
        }
        return null;
    }

    @Override
    public void bindData(ItemPickRoomBinding binding, RoomTechnicianInfo.RoomInfoDTO roomInfoDTO) {
        binding.setData(roomInfoDTO);
    }


    @Override
    public void bindEvent(ItemPickRoomBinding binding, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        int dp10 = DisplayUtil.dip2px(mContext, 10f);
        layoutParams.leftMargin = dp10;
        layoutParams.rightMargin = dp10;
        layoutParams.bottomMargin = dp10;
        binding.getRoot().setLayoutParams(layoutParams);
        binding.getRoot().setOnClickListener(view -> {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).isSelected = i == position;
            }
            notifyDataSetChanged();
        });
    }
}
