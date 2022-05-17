package soft.zhuhuo.module_home.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.security.PublicKey;
import java.util.List;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemWaitBinding;


public class WaitAdapter extends RecyclerView.Adapter<WaitAdapter.WaitViewHolder> {

    private List<RoomTechnicianInfo.NoTecDTO> data;
    private OnItemClickListener<RoomTechnicianInfo.NoTecDTO> mNoTecDTOOnItemClickListener;

    public void setNoTecDTOOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.NoTecDTO> noTecDTOOnItemClickListener) {
        mNoTecDTOOnItemClickListener = noTecDTOOnItemClickListener;
    }

    public void setData(List<RoomTechnicianInfo.NoTecDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public RoomTechnicianInfo.NoTecDTO getSelectedData() {
        if (data==null){
            return null;
        }
        for (RoomTechnicianInfo.NoTecDTO datum : data) {
            if (datum.isSelected) return datum;
        }
        return null;
    }

    @NonNull
    @Override
    public WaitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWaitBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_wait, parent, false);
        return new WaitViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull WaitViewHolder holder, int position) {
        ItemWaitBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setPosition(position);
        if (position != 0) {
            binding.setData(data.get(position - 1));
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

    static class WaitViewHolder extends RecyclerView.ViewHolder {

        public WaitViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
