package soft.zhuhuo.module_home.adapter;


import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemTdBinding;

public class TDAdapter extends BaseAdapter<ItemTdBinding, TD.TecClockInfoDTO> {

    public TDAdapter() {
        super(R.layout.item_td);
    }

    @Override
    public void bindData(ItemTdBinding binding, TD.TecClockInfoDTO tecClockInfoDTO) {
        binding.setData(tecClockInfoDTO);
    }

    public TD.TecClockInfoDTO getSelectedData() {
        for (TD.TecClockInfoDTO datum : data) {
            if (datum.isSelected) {
                return datum;
            }
        }
        return null;
    }


    @Override
    public void bindEvent(ItemTdBinding binding, int position) {
        binding.getRoot().setOnClickListener(view -> {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).isSelected = i == position;
            }
            notifyDataSetChanged();
        });
    }

}
