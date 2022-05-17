package soft.zhuhuo.module_home.ui.dialog;

import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.List;

import soft.zhuhuo.lib.adapter.mvvm.BaseDialogFragment;
import soft.zhuhuo.lib.adapter.mvvm.BaseNoModelDialogFragment;
import soft.zhuhuo.lib.base.BaseRequest;
import soft.zhuhuo.lib.bean.TD;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.adapter.TUCAdapter;
import soft.zhuhuo.module_home.databinding.DialogTechUcBinding;
import soft.zhuhuo.module_home.mvvm.vm.UpClockViewModel;


public class TechnicianUpClock extends BaseDialogFragment<UpClockViewModel,DialogTechUcBinding> {

    private final List<TD.TecClockInfoDTO> data;

    public TechnicianUpClock(List<TD.TecClockInfoDTO> data) {
        this.data = data;
    }

    public interface  OnUpClockSuccessListener{
        void upClockSuccess();
    }

    private OnUpClockSuccessListener mOnUpClockSuccessListener;

    public TechnicianUpClock setOnUpClockSuccessListener(OnUpClockSuccessListener onUpClockSuccessListener) {
        mOnUpClockSuccessListener = onUpClockSuccessListener;
        return this;
    }

    public static TechnicianUpClock getInstance(List<TD.TecClockInfoDTO> data) {
        return new TechnicianUpClock(data);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_tech_uc;
    }

    @Override
    protected void initView() {
        binding.rvTechnicianConsume.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        TUCAdapter adapter = new TUCAdapter(data);
        binding.rvTechnicianConsume.setAdapter(adapter);
        binding.ivClose.setOnClickListener(view -> dismiss());
        binding.cancel.setOnClickListener(view -> dismiss());
        binding.confirm.setOnClickListener(view -> {
            TD.TecClockInfoDTO selectedData = adapter.getSelectedData();
            if (selectedData == null) {
                return;
            }
            upClock(selectedData);
        });
    }

    @Override
    protected void initData() {

    }




    private void upClock(TD.TecClockInfoDTO data) {
        BaseRequest.TechnicianUpClockP p = new BaseRequest.TechnicianUpClockP();
        p.RoomCode  = data.getRoomCode();
        p.ItemID = data.getItemID();
        p.TecCode = data.getTecCode();
        viewModel.upClock(BaseRequest.getTechnicianUpClockParam(p));
        viewModel.upClockResult.observe(this, aBoolean -> {
            if (aBoolean){
                if (mOnUpClockSuccessListener!=null){
                    mOnUpClockSuccessListener.upClockSuccess();
                }
                dismiss();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            getDialog().getWindow().setLayout((int) (dm.widthPixels * 0.8f), ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }

    @Override
    protected UpClockViewModel createViewModel() {
        return new ViewModelProvider(this).get(UpClockViewModel.class);
    }
}
