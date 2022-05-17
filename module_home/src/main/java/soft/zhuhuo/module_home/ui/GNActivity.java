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
import soft.zhuhuo.module_home.adapter.GNAdapter;
import soft.zhuhuo.module_home.databinding.ActivityGnBinding;
import soft.zhuhuo.module_home.mvvm.vm.NoticeViewModel;


@Route(path = RouteConfig.GOODS_NOTICE_PAGE)
public class GNActivity extends BaseActivity<NoticeViewModel, ActivityGnBinding> {

    @Override
    protected NoticeViewModel createViewModel() {
        return new ViewModelProvider(this).get(NoticeViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gn;
    }


    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("服务通知");
        binding.notice.setLayoutManager(new LinearLayoutManager(this));
        GNAdapter mAdapter = new GNAdapter();
        binding.notice.setAdapter(mAdapter);
        Global.getInstance().getRoomTechnicianInfo().observe(this, info ->
                mAdapter.setData(info.getGoodsNotice()));
        mAdapter.setOnItemClickListener(new SimpleOnItemClickAdapter<RoomTechnicianInfo.GoodsNoticeDTO>() {
            @Override
            public void onItemClick(RoomTechnicianInfo.GoodsNoticeDTO data, int position) {
                new XAlertDialog.Builder()
                        .setTitle("提示")
                        .setContent(String.format("您要对%s的操作", data.getItemName()))
                        .setNegativeText("取消服务", () -> {
                            BaseRequest.CancelItemParam p = new BaseRequest.CancelItemParam(data.getConsumerDetailID());
                            viewModel.cancelItem(BaseRequest.getCancelItemParam(p));
                        })
                        .setPositiveText("完成服务", () -> {
                            viewModel.completeGoods(BaseRequest.getCompleteServiceP(data.getRoomCode(), data.getGoodsNoticeID()));
                        }).build()
                        .show(getSupportFragmentManager(), "服务通知操作");
            }
        });
    }

    @Override
    protected void initData() {

    }
}
