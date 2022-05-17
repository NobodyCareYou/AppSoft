package soft.zhuhuo.module_home.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
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
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.bean.TechnicianInfo;
import soft.zhuhuo.lib.bean.TechnicianState;
import soft.zhuhuo.lib.utils.DisplayUtil;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ItemTechnicianBinding;
import soft.zhuhuo.module_home.databinding.ItemTechnicianTypeBinding;


public class TechnicianAdapter extends RecyclerView.Adapter<TechnicianAdapter.HomeViewHolder> {


    private final Context context;

    public TechnicianAdapter(Context context) {
        this.context = context;
    }

    private List<TechnicianInfo> data;


    private OnItemClickListener<RoomTechnicianInfo.TecInfoDTO> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.TecInfoDTO> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public void setData(List<TechnicianInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTechnicianTypeBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_technician_type, parent, false);
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
        ItemTechnicianTypeBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
        mBinding.setData(data.get(position));
        mBinding.rvRoomState.setFocusable(false);
        mBinding.rvRoomState.setLayoutManager(new GridLayoutManager(context, 3));
        TechnicianDetailAdapter adapter = new TechnicianDetailAdapter(context, data.get(position).data);
        mBinding.rvRoomState.setAdapter(adapter);

        adapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.TecInfoDTO>() {
            @Override
            public void onItemClick(RoomTechnicianInfo.TecInfoDTO data, int position) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(data, position);
                }
            }
        });
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

    static class TechnicianDetailAdapter extends RecyclerView.Adapter<TechnicianDetailAdapter.TechnicianDetailViewHolder> {

        private final List<RoomTechnicianInfo.TecInfoDTO> data;
        private final Context context;
        private OnItemClickListener<RoomTechnicianInfo.TecInfoDTO> onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener<RoomTechnicianInfo.TecInfoDTO> onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public TechnicianDetailAdapter(Context context, List<RoomTechnicianInfo.TecInfoDTO> data) {
            this.context = context;
            this.data = data;
        }

        @NonNull
        @Override
        public TechnicianDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemTechnicianBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_technician, parent, false);
            return new TechnicianDetailViewHolder(mBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull TechnicianDetailViewHolder holder, int position) {
            int dp2 = DisplayUtil.dip2px(context, 2.5f);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            params.setMargins(dp2, dp2, dp2, dp2);
            holder.itemView.setLayoutParams(params);
            ItemTechnicianBinding mBinding = DataBindingUtil.getBinding(holder.itemView);
            Log.d("xxx", "onBindViewHolder: " + data.get(position).toString());

            mBinding.setData(data.get(position));
            holder.itemView.setBackgroundResource(TechnicianState.getTechnicianStateBg(data.get(position).getStateID()));
            mBinding.executePendingBindings();

            holder.itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    Log.d("xxx", "onBindViewHolder: "+position);
                    onItemClickListener.onItemClick(data.get(position), position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        static class TechnicianDetailViewHolder extends RecyclerView.ViewHolder {

            public TechnicianDetailViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
