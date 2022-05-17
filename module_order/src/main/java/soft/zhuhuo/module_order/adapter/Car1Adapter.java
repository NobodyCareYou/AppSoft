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
import soft.zhuhuo.module_order.databinding.ItemCarBinding;

public class Car1Adapter extends RecyclerView.Adapter<Car1Adapter.CarViewHolder> {

    private List<BaseRequest.OrderMainParam.Data> data;

    public Car1Adapter(List<BaseRequest.OrderMainParam.Data> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCarBinding mBiding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_car, parent, false);
        return new CarViewHolder(mBiding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        ItemCarBinding mBiding = DataBindingUtil.getBinding(holder.itemView);
        mBiding.setData(data.get(position));
        mBiding.executePendingBindings();
        mBiding.tvReduce.setOnClickListener(v -> TUtils.show("主项不允许修改数量"));
        mBiding.tvAdd.setOnClickListener(v -> TUtils.show("主项不允许修改数量"));
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
