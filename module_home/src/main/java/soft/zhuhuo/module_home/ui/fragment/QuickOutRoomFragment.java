package soft.zhuhuo.module_home.ui.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.QORAdapter;
import soft.zhuhuo.module_home.databinding.FragmentQorBinding;

/**
 * QD
 */
public class QuickOutRoomFragment extends BaseNoModelFragment<FragmentQorBinding> {

    public static QuickOutRoomFragment getInstance() {
        return new QuickOutRoomFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_qor;
    }

    private QORAdapter mAdapter;

    @Override
    protected void initView() {
        mAdapter = new QORAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        Global.getInstance().getRoomTechnicianInfo().observe(this, info ->
                {
                    if (info == null || info.getNoTec() == null || info.getNoTec().size() == 0) {
                        binding.empty.setVisibility(View.VISIBLE);
                        binding.recyclerView.setVisibility(View.INVISIBLE);
                    } else {
                        binding.empty.setVisibility(View.INVISIBLE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        mAdapter.setData(info.getFastRoom());
                    }
                }
        );
    }
}
