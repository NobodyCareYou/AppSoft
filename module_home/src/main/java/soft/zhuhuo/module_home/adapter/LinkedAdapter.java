package soft.zhuhuo.module_home.adapter;

import androidx.recyclerview.widget.GridLayoutManager;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemLinkedBinding;


public class LinkedAdapter extends BaseAdapter<ItemLinkedBinding, UnionRoomInfo.LinkedRoomDTO> {

    public LinkedAdapter() {
        super(R.layout.item_linked);
    }


    public UnionRoomInfo.LinkedRoomDTO getSelectedData() {
        for (UnionRoomInfo.LinkedRoomDTO datum : data) {
            if (datum.isSelected) {
                return datum;
            }
        }
        return null;
    }


    @Override
    public void bindEvent(ItemLinkedBinding binding, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        binding.getRoot().setLayoutParams(layoutParams);

        binding.getRoot().setOnClickListener(view -> {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).isSelected = i == position;
            }
            notifyDataSetChanged();
        });
    }

    @Override
    public void bindData(ItemLinkedBinding binding, UnionRoomInfo.LinkedRoomDTO info) {

        binding.setData(info);
    }
}
