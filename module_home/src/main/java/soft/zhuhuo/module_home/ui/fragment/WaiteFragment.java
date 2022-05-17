package soft.zhuhuo.module_home.ui.fragment;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.WaitAdapter;
import soft.zhuhuo.module_home.databinding.FragmentWaitBinding;
import soft.zhuhuo.module_home.mvvm.vm.FirstViewModel;

/**
 *
 */
public class WaiteFragment extends BaseFragment<FirstViewModel, FragmentWaitBinding> {

    private WaitAdapter mAdapter;


    public static WaiteFragment getInstance() {
        return new WaiteFragment();
    }

    @Override
    protected FirstViewModel createViewModel() {
        return new ViewModelProvider(this).get(FirstViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait;
    }

    @Override
    protected void initView() {
        mAdapter = new WaitAdapter();
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

                        RoomTechnicianInfo.NoTecDTO mSelectedData = mAdapter.getSelectedData();
                        List<RoomTechnicianInfo.NoTecDTO> mNoTec = info.getNoTec();
                        if (mSelectedData != null) {
                            for (RoomTechnicianInfo.NoTecDTO noTecDTO : mNoTec) {
                                if (mSelectedData.getConsumerDetailID().equals(noTecDTO.getConsumerDetailID())) {
                                    noTecDTO.isSelected = true;
                                }
                            }
                        }
                        mAdapter.setData(mNoTec);
                    }
                }
        );
        binding.cancelFirst.setOnClickListener(v -> {
            RoomTechnicianInfo.NoTecDTO data = mAdapter.getSelectedData();
            if (data == null) {
                TUtils.show("请选择要取消优先安排的项目");
                return;
            }

            BaseRequest.FirstP p = new BaseRequest.FirstP("1", data.getConsumerDetailID());
            viewModel.first(BaseRequest.getFirstP(p));
        });

        binding.first.setOnClickListener(v -> {
            RoomTechnicianInfo.NoTecDTO data = mAdapter.getSelectedData();
            if (data == null) {
                TUtils.show("请选择要优先安排的项目");
                return;
            }

            BaseRequest.FirstP p = new BaseRequest.FirstP("0", data.getConsumerDetailID());
            viewModel.first(BaseRequest.getFirstP(p));
        });
    }


}
