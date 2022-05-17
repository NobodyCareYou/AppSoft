package soft.zhuhuo.module_home.ui;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.UnionRoomInfo;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.LinkedAdapter;
import soft.zhuhuo.module_home.adapter.UnLinkedAdapter;
import soft.zhuhuo.module_home.databinding.ActivityUnionRoomBinding;
import soft.zhuhuo.module_home.mvvm.vm.UnionViewModel;


@Route(path = RouteConfig.UNION_ROOM_PAGE)
public class UnionRoomActivity extends BaseActivity<UnionViewModel, ActivityUnionRoomBinding> {

    private LinkedAdapter adapter1;
    private UnLinkedAdapter adapter2;

    @Override
    protected UnionViewModel createViewModel() {
        return new ViewModelProvider(this).get(UnionViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_union_room;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(binding.toolbarLayout.toolbar).statusBarDarkFont(true).init();
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
        binding.setTitle("联房");


        binding.rvLinked.setLayoutManager(new GridLayoutManager(this, 2));
        adapter1 = new LinkedAdapter();
        binding.rvLinked.setAdapter(adapter1);


        binding.rvUnLinked.setLayoutManager(new GridLayoutManager(this, 4));
        adapter2 = new UnLinkedAdapter();
        binding.rvUnLinked.setAdapter(adapter2);

        binding.linkedRoom.setOnClickListener(v -> {
            List<UnionRoomInfo.NoLinkedRoomDTO> selectedData = adapter2.getSelectedData();
            if (adapter2.getSelectedData() == null || selectedData.size() == 0) {
                TUtils.show("请选择要联房的房间");
                return;
            }
            BaseRequest.UnionP param = new BaseRequest.UnionP("0");
            StringBuilder sb = new StringBuilder();
            for (UnionRoomInfo.NoLinkedRoomDTO selectedDatum : selectedData) {
                sb.append(selectedDatum.getLinkRoom()).append(",");
            }
            param.RoomCode = sb.substring(0, sb.length() - 1);
            viewModel.linkedRoom(BaseRequest.getUnionP(param));
        });

        binding.unLinkedRoom.setOnClickListener(v -> {
            UnionRoomInfo.LinkedRoomDTO selectedData = adapter1.getSelectedData();
            if (selectedData == null) {
                TUtils.show("请选择要取消联房的房间");
                return;
            }
            BaseRequest.UnionP param = new BaseRequest.UnionP("1");
            param.RoomCode = selectedData.getLinkRoom();

            viewModel.linkedRoom(BaseRequest.getUnionP(param));
        });


    }

    @Override
    protected void initData() {
        viewModel.getRoomTechnicianInfo(BaseRequest.getUnionP(new BaseRequest.UnionP("3")));

        viewModel.mUnionRoomInfo.observe(this, unionRoomInfo -> {
            adapter1.setData(unionRoomInfo.getLinkedRoom());
            adapter2.setData(unionRoomInfo.getNoLinkedRoom());

            if (unionRoomInfo.getLinkedRoom() == null || unionRoomInfo.getLinkedRoom().size() == 0) {
                binding.emptyLinked.setVisibility(View.VISIBLE);
                binding.rvLinked.setVisibility(View.GONE);
            } else {
                binding.emptyLinked.setVisibility(View.GONE);
                binding.rvLinked.setVisibility(View.VISIBLE);
            }

            if (unionRoomInfo.getNoLinkedRoom() == null || unionRoomInfo.getNoLinkedRoom().size() == 0) {
                binding.emptyUnlinked.setVisibility(View.VISIBLE);
                binding.rvUnLinked.setVisibility(View.GONE);
            } else {
                binding.emptyUnlinked.setVisibility(View.GONE);
                binding.rvUnLinked.setVisibility(View.VISIBLE);
            }


        });

        viewModel.refreshResult.observe(this, aBoolean -> {
            viewModel.getRoomTechnicianInfo(BaseRequest.getUnionP(new BaseRequest.UnionP("3")));
        });
    }


}
