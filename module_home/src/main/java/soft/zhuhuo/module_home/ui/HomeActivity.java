package soft.zhuhuo.module_home.ui;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import soft.zhuhuo.lib.adapter.mvvm.BaseActivity;
import soft.zhuhuo.lib.bean.Global;
import soft.zhuhuo.lib.bean.RoomTechnicianInfo;
import soft.zhuhuo.lib.constant.Key;
import soft.zhuhuo.lib.net.ApiService;
import soft.zhuhuo.lib.net.NetworkApi;
import soft.zhuhuo.lib.utils.MVUtils;
import soft.zhuhuo.lib.utils.RouteConfig;
import soft.zhuhuo.lib.utils.TUtils;
import soft.zhuhuo.module_home.R;
import soft.zhuhuo.module_home.databinding.ActivityHomeBinding;
import soft.zhuhuo.module_home.mvvm.vm.RoomTechnicianViewModel;
import soft.zhuhuo.module_home.ui.fragment.AchievementFragment;
import soft.zhuhuo.module_home.ui.fragment.HomeFragment;
import soft.zhuhuo.module_home.ui.fragment.MineFragment;


@Route(path = RouteConfig.HOME_PAGE)
public class HomeActivity extends BaseActivity<RoomTechnicianViewModel, ActivityHomeBinding> {

    private Fragment[] mFragments;
    private int mIndex;

    @Override
    protected RoomTechnicianViewModel createViewModel() {
        return new ViewModelProvider(this).get(RoomTechnicianViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        HomeFragment homeFragment = HomeFragment.getInstance();
        AchievementFragment achievementFragment = AchievementFragment.getInstance();
        MineFragment mineFragment = MineFragment.getInstance();
        init(homeFragment, achievementFragment, mineFragment);
    }

    @Override
    protected void initData() {
        viewModel.getFloorInfo();
        viewModel.getRoomTypeInfo();
        viewModel.getTechnicianTypeInfo();
        viewModel.getItems();
        viewModel.mFloorInfo.observe(this, info -> Global.getInstance().setFloorInfo(info));
        viewModel.mRoomTypeInfo.observe(this, info -> Global.getInstance().setRoomTypeInfo(info));
        viewModel.mTechnicianTypeInfo.observe(this, info -> Global.getInstance().setTechnicianTypeInfo(info));
        viewModel.mItemInfo.observe(this, info -> Global.getInstance().setItemInfo(info));
    }


    @SuppressLint("NonConstantResourceId")
    private void init(HomeFragment homeFragment, AchievementFragment achievementFragment, MineFragment mineFragment) {
        mFragments = new Fragment[]{homeFragment, achievementFragment, mineFragment};
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl, homeFragment).commit();
        setIndexSelected(0);
        binding.home.setChecked(true);

        binding.rgGuide.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.home) {
                setIndexSelected(0);
            } else if (i == R.id.achievement) {
                binding.rgGuide.check(R.id.home);
                TUtils.show("业绩功能暂未开放");
                setIndexSelected(0);
            } else if (i == R.id.mine) {
                binding.rgGuide.check(R.id.home);
                TUtils.show("个人中心暂未开放");
                setIndexSelected(0);
            }
        });
    }

    private Disposable disposable;

    @Override
    protected void onStart() {
        super.onStart();
        start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        end();
    }

    private void start() {
        Observable.interval(0, 3, TimeUnit.SECONDS)
                .flatMap((Function<Long, ObservableSource<RoomTechnicianInfo>>) aLong -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("ID", "1002");
                    jsonObject.addProperty("MecCode", "");
                    jsonObject.addProperty("OrgId", MVUtils.getString(Key.ORG_ID));
                    ApiService apiService = NetworkApi.createService(ApiService.class);
                    RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
                    return apiService.getRoomTechnicianInfo(body);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RoomTechnicianInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                        Log.d("zzz", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull RoomTechnicianInfo info) {
                        Log.d("zzz", "onNext: ");
                        Global.getInstance().setRoomTechnicianInfo(info);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("zzz", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("zzz", "onComplete: ");
                    }
                });

    }


    private void end() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }


    private void setIndexSelected(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.hide(mFragments[mIndex]);
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.fl, mFragments[index]).show(mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }
        ft.commit();
        mIndex = index;
    }
}