package soft.zhuhuo.module_home.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import soft.zhuhuo.lib.adapter.OnItemClickListener;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.bean.RoomInfo;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.constant.RoomState;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemRoomBinding;
import soft.zhuhuo.module_home.databinding.ItemRoomTypeBinding;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.HomeViewHolder> {


    private final Context context;

    public RoomAdapter(Context context) {
        this.context = context;
    }

    private OnItemClickListener<RoomTechnicianInfo.RoomInfoDTO> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.RoomInfoDTO> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private List<RoomInfo> data;


    public void setData(List<RoomInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRoomTypeBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_room_type, parent, false);
        return new HomeViewHolder(mBinding.getRoot());
    }

    private boolean isAnimate = false;

    private void animateToggle(View v, ImageView arrow, int position, boolean isExpand, float viewHeight, long animationDuration) {
        ObjectAnimator animator1;
        ObjectAnimator animator2;
        ObjectAnimator animator3;
        Log.d("xxx", "run: isExpand = " + isExpand);
        if (isExpand) {
            Log.d("xxx", "run: 展开状态 执行收缩动画----  -viewHeight" + -viewHeight);
            animator1 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 0, -viewHeight);
            animator2 = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f);
            animator3 = ObjectAnimator.ofFloat(arrow, View.ROTATION, 0f, 180f);
        } else {
            v.setVisibility(View.VISIBLE);
            Log.d("xxx", "run: 收缩状态 执行展开动画----- -viewHeight = " + -viewHeight);
            animator1 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, -viewHeight, 0);
            animator2 = ObjectAnimator.ofFloat(v, "alpha", 0, 1);
            animator3 = ObjectAnimator.ofFloat(arrow, View.ROTATION, 180f, 0);
        }
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator1).with(animator2).with(animator3);
        animSet.setDuration(animationDuration);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isAnimate = true;
                Log.d("xxx", "run: 开始执行动画----");
            }


            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.d("xxx", "run: 动画执行完毕----");
                if (isExpand) {
                    v.setVisibility(View.GONE);
                } else {
                    v.setVisibility(View.VISIBLE);
                }
                isAnimate = false;
                data.get(position).isExpand = !data.get(position).isExpand;
//                notifyItemChanged(position);
            }
        });

        animSet.start();
    }


    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ItemRoomTypeBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
        mBinding.setData(data.get(position));
        mBinding.rvRoomState.setFocusable(false);
        mBinding.rvRoomState.setLayoutManager(new GridLayoutManager(context, 3));
        HomeDetailAdapter adapter = new HomeDetailAdapter(context, data.get(position).data);
        adapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.RoomInfoDTO>() {
            @Override
            public void onItemClick(RoomTechnicianInfo.RoomInfoDTO data, int position) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(data, position);
                }
            }
        });
        mBinding.rvRoomState.setAdapter(adapter);

        holder.itemView.setOnClickListener(view -> {
            if (isAnimate) {
                Log.d("xxx", "run: 正在执行动画----");
                return;
            }

            mBinding.rvRoomState.post(() -> {
                int height = mBinding.rvRoomState.getHeight();
                Log.d("xxx", "高度" + height);
                animateToggle(mBinding.rvRoomState, mBinding.icMore, position, data.get(position).isExpand, 200, 500);
            });

        });

        mBinding.executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface On {
        void cc(RoomTechnicianInfo.RoomInfoDTO data, int position);
    }


    static class HomeDetailAdapter extends RecyclerView.Adapter<HomeDetailAdapter.HomeDetailViewHolder> {

        private final List<RoomTechnicianInfo.RoomInfoDTO> data;
        private final Context context;
        private OnItemClickListener<RoomTechnicianInfo.RoomInfoDTO> onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.RoomInfoDTO> onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public HomeDetailAdapter(Context context, List<RoomTechnicianInfo.RoomInfoDTO> data) {
            this.context = context;
            this.data = data;
        }

        @NonNull
        @Override
        public HomeDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemRoomBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_room, parent, false);
            return new HomeDetailViewHolder(mBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull HomeDetailViewHolder holder, int position) {
            int dp2 = DisplayUtil.dip2px(context, 2.5f);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            params.setMargins(dp2, dp2, dp2, dp2);
            holder.itemView.setLayoutParams(params);
            ItemRoomBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
            assert mBinding != null;
            mBinding.setData(data.get(position));
            RoomTechnicianInfo.RoomInfoDTO roomInfoDTO = data.get(position);
            if (TextUtils.isEmpty(roomInfoDTO.getTecCode())) {
                mBinding.setFirstCode("空");
                mBinding.setSecondCode("空");
                mBinding.setThirdCode("空");
                mBinding.setFirstState("0'");
                mBinding.setSecondState("0'");
                mBinding.setThirdState("0'");
            } else {
                String[] split = roomInfoDTO.getTecCode().split(",");
                String[] techState = roomInfoDTO.getTecStateID().split(",");
                String[] timeLong = roomInfoDTO.getTecTimeLong().split(",");
                if (split.length == 3) {
                    mBinding.setFirstCode(split[0]);
                    mBinding.setSecondCode(split[1]);
                    mBinding.setThirdCode(split[2]);
                    mBinding.setFirstState(getDuration(techState[0], Integer.parseInt(timeLong[0])));
                    mBinding.setSecondState(getDuration(techState[1], Integer.parseInt(timeLong[1])));
                    mBinding.setThirdState(getDuration(techState[2], Integer.parseInt(timeLong[2])));
                } else if (split.length == 2) {
                    mBinding.setFirstCode(split[0]);
                    mBinding.setSecondCode(split[1]);
                    mBinding.setFirstState(getDuration(techState[0], Integer.parseInt(timeLong[0])));
                    mBinding.setSecondState(getDuration(techState[1], Integer.parseInt(timeLong[1])));
                    mBinding.setThirdCode("空");
                    mBinding.setThirdState("0'");
                } else {
                    mBinding.setFirstCode(split[0]);
                    mBinding.setFirstState(getDuration(techState[0], Integer.parseInt(timeLong[0])));
                    mBinding.setSecondCode("空");
                    mBinding.setSecondState("0'");
                    mBinding.setThirdCode("空");
                    mBinding.setThirdState("0'");
                }
            }


            holder.itemView.setBackgroundResource(RoomState.getRoomStateBg(data.get(position).getStateID()));
            mBinding.executePendingBindings();

            holder.itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    Log.d("xxx", "onBindViewHolder: " + position);
                    onItemClickListener.onItemClick(data.get(position), position);
                }
            });

        }

        private String getDuration(String stateID, int timeLong) {
            String duration = "";
            switch (stateID) {
                case "0":
                case "1":
                    duration = String.format("等%s'", timeLong);
                    break;
                case "2":
                    if (timeLong > 0) {
                        duration = String.format("余%s'", timeLong);
                    } else {
                        duration = String.format("超%s'", -timeLong);
                    }
                    break;
                case "3":
                    duration = "落钟";
                    break;
            }
            return duration;
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        static class HomeDetailViewHolder extends RecyclerView.ViewHolder {

            public HomeDetailViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
