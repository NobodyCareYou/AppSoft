package soft.zhuhuo.module_home.adapter;

import android.os.Build;


import java.util.List;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemTucBinding;

public class TUCAdapter extends BaseAdapter<ItemTucBinding, TD.TecClockInfoDTO> {

    public TUCAdapter(List<TD.TecClockInfoDTO> tecClockInfoDTOS) {
        super(R.layout.item_tuc, tecClockInfoDTOS);
        if (tecClockInfoDTOS != null && tecClockInfoDTOS.size() > 0) {
            tecClockInfoDTOS.get(0).isSelected = true;
        }
    }

    @Override
    public void bindData(ItemTucBinding binding, TD.TecClockInfoDTO tecClockInfoDTO) {
        binding.setData(tecClockInfoDTO);
    }

    public TD.TecClockInfoDTO getSelectedData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return data.stream().filter(t -> t.isSelected).findFirst().get();
        } else {
            for (TD.TecClockInfoDTO datum : data) {
                if (datum.isSelected) {
                    return datum;
                }
            }
            return null;
        }
    }

    private int lastIndex = -1;

    @Override
    public void bindEvent(ItemTucBinding binding, int position) {
        binding.getRoot().setOnClickListener(view -> {
            if (lastIndex == -1) {
                lastIndex = position;
                data.get(position).isSelected = true;
                notifyItemChanged(position);
            } else {
                if (position != lastIndex) {
                    data.get(lastIndex).isSelected = false;
                    data.get(position).isSelected = true;
                    lastIndex = position;
                    notifyItemChanged(lastIndex);
                    notifyItemChanged(position);
                }
            }
        });
    }
}
