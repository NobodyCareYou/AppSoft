package soft.zhuhuo.module_order.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import soft.zhuhuo.lib.bean.ItemTechnician;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_order.R;
import soft.zhuhuo.module_order.databinding.ItemOrderTechnicianBinding;

public class PickTechnicianAdapter extends RecyclerView.Adapter<PickTechnicianAdapter.TechnicianViewHolder> {

    ///
    private Context mContext;
    private List<ItemTechnician.DataDTO> data;

    public List<ItemTechnician.DataDTO> getData() {
        return data;
    }

    public PickTechnicianAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ItemTechnician.DataDTO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

//    public ItemTechnician.DataDTO getSelectedData() {
//        for (ItemTechnician.DataDTO datum : data) {
//            if (datum.isSelected) {
//                return datum;
//            }
//        }
//        return null;
//    }

    public List<ItemTechnician.DataDTO> getSelectedData() {
        List<ItemTechnician.DataDTO> tmp = new ArrayList<>();
        for (ItemTechnician.DataDTO datum : data) {
            if (datum.isSelected) {
                tmp.add(datum);
            }
        }
        return tmp;
    }

//    public interface OnPickTechnicianCodeListener {
//
//        void pickTechnician(String code);
//    }

//    private OnPickTechnicianCodeListener mOnPickTechnicianCodeListener;
//
//    public void setOnPickTechnicianCodeListener(OnPickTechnicianCodeListener onPickTechnicianCodeListener) {
//        mOnPickTechnicianCodeListener = onPickTechnicianCodeListener;
//    }

    @NonNull
    @Override
    public TechnicianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrderTechnicianBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_order_technician, parent, false);
        return new TechnicianViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TechnicianViewHolder holder, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        if (position % 2 == 0 || position % 2 == 1) {
            layoutParams.rightMargin = DisplayUtil.dip2px(mContext, 10f);
            layoutParams.topMargin = DisplayUtil.dip2px(mContext, 10f);
        } else {
            layoutParams.rightMargin = DisplayUtil.dip2px(mContext, 0f);
            layoutParams.topMargin = DisplayUtil.dip2px(mContext, 10f);
        }
        holder.itemView.setLayoutParams(layoutParams);
        ItemOrderTechnicianBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
        mBinding.setData(data.get(position));
        mBinding.executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
//            for (int i = 0; i < data.size(); i++) {
//                data.get(i).isSelected = i == position;
//            }
//            notifyDataSetChanged();
            data.get(position).isSelected = !data.get(position).isSelected;
            notifyItemChanged(position);

//            if (mOnPickTechnicianCodeListener != null) {
//                mOnPickTechnicianCodeListener.pickTechnician(data.get(position).getTecCode());
//            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class TechnicianViewHolder extends RecyclerView.ViewHolder {

        public TechnicianViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
