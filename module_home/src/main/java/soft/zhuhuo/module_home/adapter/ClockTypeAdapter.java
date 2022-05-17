package soft.zhuhuo.module_home.adapter;


import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.bean.ClockType;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemClockBinding;

public class ClockTypeAdapter extends BaseAdapter<ItemClockBinding, ClockType> {


    private final Context mContext;

    public ClockTypeAdapter(Context context, int clockType) {
        super(R.layout.item_clock);
        mContext = context;

        data = new ArrayList<>();
        data.add(new ClockType(0, "轮钟"));
        data.add(new ClockType(1, "点钟"));
        data.add(new ClockType(2, "加钟"));
        data.add(new ClockType(3, "Call钟"));
        data.add(new ClockType(4, "选钟"));

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).clockType == clockType) {
                data.get(i).isSelected = true;
            }
        }
    }


    public ClockType getSelectedData() {
        for (ClockType datum : data) {
            if (datum.isSelected) {
                return datum;
            }
        }
        return null;
    }


    @Override
    public void bindEvent(ItemClockBinding binding, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        int dp10 = DisplayUtil.dip2px(mContext, 10f);
        layoutParams.leftMargin = dp10;
        layoutParams.rightMargin = dp10;
        layoutParams.bottomMargin = dp10;
        binding.getRoot().setLayoutParams(layoutParams);
        binding.getRoot().setOnClickListener(view -> {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).isSelected = (i == position);
            }
            notifyDataSetChanged();
        });
    }

    @Override
    public void bindData(ItemClockBinding binding, ClockType clockType) {
        binding.setData(clockType);
    }
}
