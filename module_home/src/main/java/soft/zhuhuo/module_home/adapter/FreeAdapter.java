package soft.zhuhuo.module_home.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemFreeBinding;
import soft.zhuhuo.module_home.databinding.ItemQorBinding;

/**
 * AN - Additional notice
 */
public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.FreeRViewHolder> {

    private List<RoomTechnicianInfo.FreeTecDTO> data;

    public void setData(List<RoomTechnicianInfo.FreeTecDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FreeRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFreeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_free, parent, false);
        return new FreeRViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull FreeRViewHolder holder, int position) {
        ItemFreeBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position != 0){
            binding.setData(data.get(position-1));
        }
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    static class FreeRViewHolder extends RecyclerView.ViewHolder {


        public FreeRViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
