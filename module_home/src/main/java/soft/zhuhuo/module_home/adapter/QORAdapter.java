package soft.zhuhuo.module_home.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
import java.util.Objects;

import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemQorBinding;

/**
 * AN - Additional notice
 */
public class QORAdapter extends RecyclerView.Adapter<QORAdapter.QORViewHolder> {

    private List<RoomTechnicianInfo.FastRoomDTO> data;

    public void setData(List<RoomTechnicianInfo.FastRoomDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QORViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemQorBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_qor, parent, false);
        return new QORViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull QORViewHolder holder, int position) {
        ItemQorBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position!=0){
            binding.setData(data.get(position-1));
        }
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    static class QORViewHolder extends RecyclerView.ViewHolder {


        public QORViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
