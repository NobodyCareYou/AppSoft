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
import soft.zhuhuo.module_home.databinding.ItemQdcBinding;


public class QDCAdapter extends RecyclerView.Adapter<QDCAdapter.QDCViewHolder> {

    private List<RoomTechnicianInfo.FastDownDTO> data;

    public void setData(List<RoomTechnicianInfo.FastDownDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public RoomTechnicianInfo.FastDownDTO getSelectedData() {
        if (data==null){
            return null;
        }
        for (RoomTechnicianInfo.FastDownDTO datum : data) {
            if (datum.isSelected) return datum;
        }
        return null;
    }

    @NonNull
    @Override
    public QDCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemQdcBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_qdc, parent, false);
        return new QDCViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull QDCViewHolder holder, int position) {
        ItemQdcBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position!=0){
            binding.setData(data.get(position-1));
        }
        binding.executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
            if (position == 0) {
                return;
            }

            for (int i = 0; i < data.size(); i++) {
                data.get(i).isSelected = i == position - 1;
            }
            notifyDataSetChanged();

        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    static class QDCViewHolder extends RecyclerView.ViewHolder {


        public QDCViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
