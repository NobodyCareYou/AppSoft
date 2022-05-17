package soft.zhuhuo.module_home.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.bean.RoomDetail;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemRoomDetailBinding;


public class RoomDetailAdapter extends RecyclerView.Adapter<RoomDetailAdapter.RDVieHolder> {

    private Context mContext;
    private List<RoomDetail.ConsumDetailDTO> data;

    public void setData(List<RoomDetail.ConsumDetailDTO> data,String money) {
        this.data = data;
        this.money = money;
        notifyDataSetChanged();
    }

    private String money;


    private OnItemClickListener<String> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public List<RoomDetail.ConsumDetailDTO> getData() {
        return data;
    }

    public RoomDetailAdapter(Context context) {
        mContext = context;
    }

    public String[] getOptArray(String category, String state) {
        String[] operates = new String[]{};
        if (TextUtils.equals("1", category) || TextUtils.equals("2", category)) {
            if (TextUtils.equals("0", state)) {
                operates = new String[]{"换技师", "换项目", "拆单", "退单"};
            } else if (TextUtils.equals("1", state)) {
                operates = new String[]{"起钟", "加钟", "换技师", "改类型", "换项目", "拆单", "退单"};
            } else if (TextUtils.equals("2", state)) {
                operates = new String[]{"落钟", "加钟", "催落钟", "换技师", "改余时", "改类型", "换项目", "拆单", "退单"};
            } else if (TextUtils.equals("3", state)) {
                operates = new String[]{"加钟", "改类型", "换技师", "拆单", "退单"};
            }

        } else if (TextUtils.equals("3", category)) {
            operates = new String[]{"换项目", "拆单", "退单"};
        }
        return operates;
    }


    @NonNull
    @Override
    public RDVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRoomDetailBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_room_detail, parent, false);
        return new RDVieHolder(binding.getRoot());
    }



    @Override
    public void onBindViewHolder(@NonNull RDVieHolder holder, int position) {
        ItemRoomDetailBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        if (position == 0 || !data.get(position).getRoomCode().equals(data.get(position - 1).getRoomCode())) {
            binding.content.setVisibility(View.VISIBLE);
        } else {
            binding.content.setVisibility(View.GONE);
        }

        binding.tvMoney.setText("总计消费: "+money);
        RoomDetail.ConsumDetailDTO info = data.get(position);
        binding.setData(info);
        binding.rvRoomDetailOperate.setLayoutManager(new GridLayoutManager(mContext, 4));
        List<String> opt = Arrays.asList(getOptArray(info.getItemKindID(), info.getStateID()));
        RoomOptAdapter adapter = new RoomOptAdapter(mContext,TextUtils.equals("1",info.getIsNotice()), opt);
        binding.rvRoomDetailOperate.setAdapter(adapter);
        adapter.setOnItemClickListener(new SimpleOnItemClickAdapter<String>() {
            @Override
            public void onItemClick(String data, int sPosition) {
                super.onItemClick(data, position);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(data, position);
                }
            }
        });
        binding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class RDVieHolder extends RecyclerView.ViewHolder {

        public RDVieHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
