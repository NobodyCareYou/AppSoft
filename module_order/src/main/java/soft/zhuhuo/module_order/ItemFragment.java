package soft.zhuhuo.module_order;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import soft.zhuhuo.lib.adapter.SimpleOnItemClickAdapter;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelFragment;
import soft.zhuhuo.lib.bean.EventData;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.ItemInfo;
import soft.zhuhuo.module_order.databinding.FragmentChildItemBinding;
import soft.zhuhuo.module_order.fragment.ProjectFragment;

public class ItemFragment extends BaseNoModelFragment<FragmentChildItemBinding> {


    public static ItemFragment getInstance(String category, String typeName) {
        ItemFragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Category", category);
        bundle.putString("TypeName", typeName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_child_item;
    }

    private String category;
    private String typeName;


    @Override
    protected void initView() {
        if (getArguments()!=null){
            category = getArguments().getString("Category");
            typeName = getArguments().getString("TypeName");
        }
        binding.rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initData() {
        List<ItemInfo.DataBean> itemList = new ArrayList<>();
        switch (category) {
            case "1":
                assert getParentFragment() != null;
                itemList = ((ProjectFragment) getParentFragment()).mItemList;
                break;
            case "2":
                assert getParentFragment() != null;
                itemList = ((AdditionalFragment) getParentFragment()).mItemList;
                break;
            case "3":
                assert getParentFragment() != null;
                itemList = ((GoodsFragment) getParentFragment()).mItemList;
                break;
        }
        List<ItemInfo.DataBean> data = itemList.stream().filter(t -> t.getItemKindID().equals(category) && t.getItemTypeName().equals(typeName)).collect(Collectors.toList());
        ItemAdapter adapter = new ItemAdapter(context, data);
        binding.rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new SimpleOnItemClickAdapter<ItemInfo.DataBean>() {
            @Override
            public void onItemClick(ItemInfo.DataBean data, int position) {
                sendEvent(new EventData(data));
            }
        });
    }
}
