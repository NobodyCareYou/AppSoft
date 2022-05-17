package soft.zhuhuo.module_order;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class SimpleAdapter extends FragmentPagerAdapter {

    private final List<Fragment> data;

    public SimpleAdapter(@NonNull FragmentManager fm, List<Fragment> data) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
