package soft.zhuhuo.module_home.ui.fragment;

import android.content.Context;
import android.os.Vibrator;

import com.alibaba.android.arouter.launcher.ARouter;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.VoiceUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.FragmentHomeBinding;


public class HomeFragment extends BaseNoModelFragment<FragmentHomeBinding> {

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        binding.name.setText(MVUtils.getString(Key.ORG_Name));
        binding.role.setText(MVUtils.getString(Key.ROLE_NAME));
        binding.room.setText(String.format("房间数:%s", MVUtils.getString(Key.ROOM_NUM)));
        binding.technicianNum.setText(String.format("技师数:%s", MVUtils.getString(Key.TECH_NUM)));
        binding.openRoom.setOnClickListener(view -> ARouter.getInstance().build(RouteConfig.MAIN_FUNCTION_PAGE).withInt("mCurrentPosition", 0).navigation());
        binding.technicianState.setOnClickListener(v -> ARouter.getInstance().build(RouteConfig.MAIN_FUNCTION_PAGE).withInt("mCurrentPosition", 1).navigation());
        binding.pointState.setOnClickListener(view -> ARouter.getInstance().build(RouteConfig.HOME_UP_POINT_PAGE).navigation());
        binding.additionalService.setOnClickListener(view -> ARouter.getInstance().build(RouteConfig.ADDITIONAL_NOTICE_PAGE).navigation());
        binding.serviceNotice.setOnClickListener(view -> ARouter.getInstance().build(RouteConfig.GOODS_NOTICE_PAGE).navigation());
        binding.searchTechnician.setOnClickListener(v -> ARouter.getInstance().build(RouteConfig.TECHNICIAN_INFO_PAGE).withString("technicianCode", binding.etTechnicianCode.getText().toString()).navigation());
    }

    private int goodsNoticeCount = 0;
    private int additionalNoticeCount = 0;

    @Override
    protected void initData() {
        Global.getInstance().getRoomTechnicianInfo().observe(this, info ->
                {
                    try {
                        if (goodsNoticeCount < info.getGoodsNotice().size() || additionalNoticeCount < info.getAddItemNotice().size()) {
                            Vibrator mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            mVibrator.vibrate(1500);
                            VoiceUtils.playRing(context);
                        }
                        goodsNoticeCount = info.getGoodsNotice().size();
                        additionalNoticeCount = info.getAddItemNotice().size();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

        );

    }

}
