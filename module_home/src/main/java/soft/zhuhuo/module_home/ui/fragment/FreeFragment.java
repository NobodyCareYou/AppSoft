package soft.zhuhuo.module_home.ui.fragment;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.FreeAdapter;
import soft.zhuhuo.module_home.databinding.FragmentFreeBinding;

/**
 * QD
 */
public class FreeFragment extends BaseNoModelFragment<FragmentFreeBinding> {

    private FreeAdapter mAdapter;

    public static FreeFragment getInstance() {
        return new FreeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_free;
    }

    @Override
    protected void initView() {
        mAdapter = new FreeAdapter();
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
                        mAdapter.setData(info.getFreeTec());
                    }
                }
        );
    }
}
