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
import soft.zhuhuo.module_order.databinding.ItemCarBinding;

public class Car2Adapter extends RecyclerView.Adapter<Car2Adapter.CarViewHolder> {

    private List<BaseRequest.OrderAdditionalParam.Data> data;

    public Car2Adapter(List<BaseRequest.OrderAdditionalParam.Data> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCar2Binding mBiding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_car2, parent, false);
        return new CarViewHolder(mBiding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        ItemCar2Binding mBiding = DataBindingUtil.getBinding(holder.itemView);
        mBiding.setData(data.get(position));
        mBiding.executePendingBindings();
        mBiding.tvReduce.setOnClickListener(v -> TUtils.show("附项不允许修改数量"));
        mBiding.tvAdd.setOnClickListener(v -> TUtils.show("附项不允许修改数量"));
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
