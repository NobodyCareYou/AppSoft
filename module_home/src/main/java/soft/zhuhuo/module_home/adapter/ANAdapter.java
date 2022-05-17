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
import soft.zhuhuo.module_home.databinding.ItemAnBinding;

/**
 * AN - Additional notice
 */
public class ANAdapter extends RecyclerView.Adapter<ANAdapter.ANViewHolder> {

    private List<RoomTechnicianInfo.AddItemNoticeDTO> data;
    private OnItemClickListener<RoomTechnicianInfo.AddItemNoticeDTO> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.AddItemNoticeDTO> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public void setData(List<RoomTechnicianInfo.AddItemNoticeDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ANViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAnBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_an, parent, false);
        return new ANViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ANViewHolder holder, int position) {
        ItemAnBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position!=0){
            binding.setData(data.get(position-1));
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

    static class ANViewHolder extends RecyclerView.ViewHolder {


        public ANViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
