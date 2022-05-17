package soft.zhuhuo.module_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;
    private Context mContext;
    private List<Fragment> mFragments;

    public TabFragmentAdapter(List<Fragment> fragments, List<String> titles, FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = context;
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
        TextView textView = view.findViewById(R.id.tv_header);
        textView.setText(mTitles.get(position));
        return view;
    }


}