package soft.zhuhuo.module_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_order.databinding.ItemBinding;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private final Context mContext;
    private final List<ItemInfo.DataBean> data;
    private OnItemClickListener<ItemInfo.DataBean> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<ItemInfo.DataBean> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ItemAdapter(Context context, List<ItemInfo.DataBean> data) {
        mContext = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new ItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        if (position % 2 == 0) {
            layoutParams.rightMargin = DisplayUtil.dip2px(mContext, 10f);
            layoutParams.topMargin = DisplayUtil.dip2px(mContext, 10f);
        } else {
            layoutParams.rightMargin = DisplayUtil.dip2px(mContext, 0f);
            layoutParams.topMargin = DisplayUtil.dip2px(mContext, 10f);
        }
        holder.itemView.setLayoutParams(layoutParams);

        ItemBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
        assert mBinding != null;
        mBinding.setData(data.get(position));
        mBinding.executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener!=null){
                onItemClickListener.onItemClick(data.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
