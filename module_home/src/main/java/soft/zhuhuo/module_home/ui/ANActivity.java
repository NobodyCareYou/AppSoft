package soft.zhuhuo.module_home.ui;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;

import soft.zhuhuo.lib.XAlertDialog;
import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelActivity;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.ANAdapter;
import soft.zhuhuo.module_home.databinding.ActivityAnBinding;
import soft.zhuhuo.module_home.mvvm.vm.NoticeViewModel;


@Route(path = RouteConfig.ADDITIONAL_NOTICE_PAGE)
public class ANActivity extends BaseActivity<NoticeViewModel, ActivityAnBinding> {


    @Override
    protected NoticeViewModel createViewModel() {
        return new ViewModelProvider(this).get(NoticeViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_an;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("附项通知");
        binding.notice.setLayoutManager(new LinearLayoutManager(this));
        ANAdapter mAdapter = new ANAdapter();
        binding.notice.setAdapter(mAdapter);
        Global.getInstance().getRoomTechnicianInfo().observe(this, info -> mAdapter.setData(info.getAddItemNotice()));
        mAdapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.AddItemNoticeDTO>() {
            @Override
            public void onItemClick(RoomTechnicianInfo.AddItemNoticeDTO data, int position) {
                new XAlertDialog.Builder()
                        .setTitle("提示")
                        .setContent(String.format("是否删除%s", data.getItemName()))
                        .setNegativeText("取消")
                        .setPositiveText("确认", () -> {
                            viewModel.cancelAdditional(BaseRequest.getCancelAdditional(data.getTecNoticeID()));
                        }).build()
                        .show(getSupportFragmentManager(), "删除附项通知");
            }
        });
    }

    @Override
    protected void initData() {

    }


}
