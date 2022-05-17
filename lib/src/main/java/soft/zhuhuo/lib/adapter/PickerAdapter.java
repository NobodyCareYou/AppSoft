package soft.zhuhuo.lib.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import soft.zhuhuo.lib.R;
import soft.zhuhuo.lib.utils.DisplayUtil;

public class PickerAdapter extends RecyclerView.Adapter<PickerAdapter.PickerViewHolder> {

    private final Context context;
    private List<String> data;
    private final String defaultText;

    private final int width;
    private final int height;

    private int background;
    private OnItemClickListener<String> onItemClickListener;

    public PickerAdapter(Context context, List<String> data, String defaultText, int floorConditionWidth, int floorConditionHeight) {
        this.context = context;
        this.data = data;
        this.defaultText = defaultText;
        width = floorConditionWidth;
        height = floorConditionHeight;
    }

    public PickerAdapter(Context context, List<String> data, String defaultText, int floorConditionWidth, int floorConditionHeight, int background) {
        this.context = context;
        this.data = data;
        this.defaultText = defaultText;
        width = floorConditionWidth;
        height = floorConditionHeight;
        this.background = background;
    }


    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PickerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_picker, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PickerViewHolder holder, int position) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        param.width = width;
        param.height = height;
        param.topMargin = DisplayUtil.dip2px(context, 5f);
        holder.itemView.setLayoutParams(param);

        if (background != 0) {
            holder.itemView.setBackgroundResource(R.drawable._add_goods_type);
        }

        if (data.get(position).equals(defaultText)) {
//            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.blue));
            holder.tv.setBackgroundResource(R.drawable.bg_picker_blue);
            holder.tv.setTextColor(Color.WHITE);
        } else {
            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.tv.setBackgroundResource(R.drawable.bg_picker);
        }

        holder.tv.setText(data.get(position));
        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class PickerViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public PickerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }
}
