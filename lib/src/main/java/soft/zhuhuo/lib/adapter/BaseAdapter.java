package soft.zhuhuo.lib.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<T extends ViewDataBinding, DATA> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    private @LayoutRes
    final
    int itemLayoutId;

    public BaseAdapter(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
    }

    public BaseAdapter(int itemLayoutId, List<DATA> data) {
        this(itemLayoutId);
        this.data = data;
    }

    public List<DATA> data;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), itemLayoutId, parent, false);
        return new BaseViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        T binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        bindData(binding, data.get(position));
        bindEvent(binding, position);
        binding.executePendingBindings();
    }

    public abstract void bindData(T binding, DATA data);

    public void bindEvent(T binding, int position) {
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
