package soft.zhuhuo.module_home.adapter;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemUnLinkedBinding;

public class UnLinkedAdapter extends BaseAdapter<ItemUnLinkedBinding, UnionRoomInfo.NoLinkedRoomDTO> {

    public UnLinkedAdapter() {
        super(R.layout.item_un_linked);
    }


    public List<UnionRoomInfo.NoLinkedRoomDTO> getSelectedData() {
        List<UnionRoomInfo.NoLinkedRoomDTO> tmp = new ArrayList<>();
        for (UnionRoomInfo.NoLinkedRoomDTO datum : data) {
            if (datum.isSelected) {
                tmp.add(datum);
            }
        }
        return tmp;
    }


    @Override
    public void bindEvent(ItemUnLinkedBinding binding, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        binding.getRoot().setLayoutParams(layoutParams);
        binding.getRoot().setOnClickListener(view -> {
            data.get(position).isSelected = !data.get(position).isSelected;
            notifyItemChanged(position);
        });
    }

    @Override
    public void bindData(ItemUnLinkedBinding binding, UnionRoomInfo.NoLinkedRoomDTO info) {
        binding.setData(info);
    }
}
