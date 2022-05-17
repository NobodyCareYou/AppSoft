package soft.zhuhuo.module_home.ui.fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseFragment;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.QDCAdapter;
import soft.zhuhuo.module_home.databinding.FragmentQdcBinding;
import soft.zhuhuo.module_home.mvvm.vm.QuicklyDownClockViewModel;
import soft.zhuhuo.module_home.ui.dialog.UpdateDownTime;

/**
 * QD
 */
public class QuickDownClockFragment extends BaseFragment<QuicklyDownClockViewModel, FragmentQdcBinding> {

    private QDCAdapter mAdapter;

    public static QuickDownClockFragment getInstance() {
        return new QuickDownClockFragment();
    }

    @Override
    protected QuicklyDownClockViewModel createViewModel() {
        return new ViewModelProvider(this).get(QuicklyDownClockViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_qdc;
    }

    @Override
    protected void initView() {
        mAdapter = new QDCAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        Global.getInstance().getRoomTechnicianInfo().observe(this, info ->
                {
                    if (info == null || info.getNoTec() == null || info.getNoTec().size() == 0) {
                        binding.empty.setVisibility(View.VISIBLE);
                        binding.content.setVisibility(View.INVISIBLE);
                    } else {
                        binding.empty.setVisibility(View.INVISIBLE);
                        binding.content.setVisibility(View.VISIBLE);
                        RoomTechnicianInfo.FastDownDTO mSelectedData = mAdapter.getSelectedData();
                        List<RoomTechnicianInfo.FastDownDTO> mFastDown = info.getFastDown();
                        if (mSelectedData != null) {
                            for (RoomTechnicianInfo.FastDownDTO noTecDTO : mFastDown) {
                                Log.d("xxx", "noTecDTO: "+noTecDTO.getConsumerDetailID());
                                Log.d("xxx", "mSelectedData: "+mSelectedData.getConsumerDetailID());
                                if (TextUtils.equals(mSelectedData.getConsumerDetailID(),noTecDTO.getConsumerDetailID())) {
                                    noTecDTO.isSelected = true;
                                }
                            }
                        }
                        mAdapter.setData(mFastDown);
                    }
                }
        );

        //改余时
        binding.tvUpdateDownTime.setOnClickListener(v -> {
            RoomTechnicianInfo.FastDownDTO data = mAdapter.getSelectedData();
            if (data == null) {
                TUtils.show("请选择要修改余时项目");
                return;
            }
             UpdateDownTime.getInstance(data.getConsumerDetailID()).setOnUpdateDownTimeSuccessListener(new UpdateDownTime.OnUpdateDownTimeSuccessListener() {
                 @Override
                 public void updateDownTimeSuccess() {
                     TUtils.show("操作成功");
                 }
             }).show(getChildFragmentManager(),"");
        });

        //提前下钟
        binding.tvAdvanceDownClock.setOnClickListener(v -> {
            RoomTechnicianInfo.FastDownDTO data = mAdapter.getSelectedData();
            if (data == null) {
                TUtils.show("请选择要提前下钟的项目");
                return;
            }

            BaseRequest.TechnicianDownClockP p1 = new BaseRequest.TechnicianDownClockP();
            p1.TecCode = data.getTecCode();
            p1.IsForceEnd = "1";
//                p1.RoomCode = data.getr();
            viewModel.downClock(BaseRequest.getTechnicianDownClockP(p1));
        });
    }


}
