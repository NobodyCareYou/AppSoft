package soft.zhuhuo.module_home.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import java.util.Objects;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemGnBinding;

/**
 * AN - Additional notice
 */
public class GNAdapter extends RecyclerView.Adapter<GNAdapter.GNViewHolder> {

    private List<RoomTechnicianInfo.GoodsNoticeDTO> data;

    private OnItemClickListener<RoomTechnicianInfo.GoodsNoticeDTO> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.GoodsNoticeDTO> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<RoomTechnicianInfo.GoodsNoticeDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GNViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGnBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_gn, parent, false);
        return new GNViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull GNViewHolder holder, int position) {
        ItemGnBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position != 0) {
            binding.setData(data.get(position - 1));
        }
        binding.executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
            if (position==0){
                return;
            }
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(data.get(position - 1),position-1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    static class GNViewHolder extends RecyclerView.ViewHolder {
        public GNViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
