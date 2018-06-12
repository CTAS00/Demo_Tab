package fragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import demo_fragment.MyBaseFragment;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class AFragmentAdapter extends FragmentStatePagerAdapter {
    private List<MyBaseFragment> mList;

    private List<String> tabTitles;

    public AFragmentAdapter(FragmentManager fm,List<MyBaseFragment> list,List<String> tabTitles) {
        super(fm);
        this.mList = list;
        this.tabTitles = tabTitles;
    }


    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  tabTitles.get(position);
    }
}