package soft.zhuhuo.module_home.adapter;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.List;

import soft.zhuhuo.lib.adapter.BaseAdapter;
import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemRoomOptBinding;

public class RoomOptAdapter extends BaseAdapter<ItemRoomOptBinding, String> {
    private Context context;
    private boolean isNotice = false;

    public RoomOptAdapter(Context context,boolean isNotice, List<String> data) {
        super(R.layout.item_room_opt, data);
        this.isNotice = isNotice;
        this.context = context;
    }

    @Override
    public void bindData(ItemRoomOptBinding binding, String s) {
        binding.setData(s);
        binding.setIsNotice(isNotice);
    }

    private OnItemClickListener<String> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void bindEvent(ItemRoomOptBinding binding, int position) {
        int dp4 = DisplayUtil.dip2px(context, 6);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        layoutParams.setMargins(dp4, dp4, dp4, dp4);
        binding.getRoot().setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(data.get(position), position);
            }
        });

    }
}
