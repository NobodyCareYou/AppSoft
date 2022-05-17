package soft.zhuhuo.module_order.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_order.R;
import soft.zhuhuo.module_order.databinding.ItemCar2Binding;
import soft.zhuhuo.module_order.databinding.ItemCar3Binding;

public class Car3Adapter extends RecyclerView.Adapter<Car3Adapter.CarViewHolder> {

    private final List<BaseRequest.OrderGoodsParam.Data> data;

    public Car3Adapter(List<BaseRequest.OrderGoodsParam.Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCar3Binding mBiding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_car3, parent, false);
        return new CarViewHolder(mBiding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        ItemCar3Binding mBiding = DataBindingUtil.getBinding(holder.itemView);
        assert mBiding != null;
        mBiding.setData(data.get(position));
        mBiding.executePendingBindings();
        mBiding.tvReduce.setOnClickListener(v -> {
            BaseRequest.OrderGoodsParam.Data data1 = Car3Adapter.this.data.get(position);
            if (data1.ItemCount == 1) {
                data.remove(position);
                notifyItemRemoved(position);
            } else {
                data1.ItemCount = data1.ItemCount - 1;
                notifyItemChanged(position);
            }
        });
        mBiding.tvAdd.setOnClickListener(v -> {
            BaseRequest.OrderGoodsParam.Data data = Car3Adapter.this.data.get(position);
            data.ItemCount = data.ItemCount + 1;
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder {

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
