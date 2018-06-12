package demo_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo_fragment.AInnerFragment.FragmentAOne;
import demo_fragment.AInnerFragment.FragmentAThree;
import demo_fragment.AInnerFragment.FragmentATwo;
import fragmentAdapter.AFragmentAdapter;
import phone.kdlc.com.demo_tab.R;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class FragmentA extends MyBaseFragment {
    // UI
    private View mView;
    private TabLayout tabLayout;
    private ViewPager viewpager;


    private final String TAB_ONE = "A1";
    private final String TAB_TWO = "A2";
    private final String TAB_THREE = "A3";


    private AFragmentAdapter mFragmentAdapter;

    private List<String> mTitleList ;
    private List<MyBaseFragment> mFragmentList;

    public static FragmentA fragment;

    public static FragmentA getInstance() {
        if (fragment == null)
            fragment = new FragmentA();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_a,null);
        initView();
        initData();
        return mView;
    }
    private void initView() {
        tabLayout = (TabLayout) mView.findViewById(R.id.tabLayout);
        viewpager = (ViewPager) mView.findViewById(R.id.viewpager);
    }
    private void initData() {
        tabLayout.addTab(tabLayout.newTab().setText(TAB_ONE));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TWO));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_THREE));
        if(mTitleList ==null){
            mTitleList = new ArrayList<>();
        }
        mTitleList.clear();
        mTitleList.add(TAB_ONE);
        mTitleList.add(TAB_TWO);
        mTitleList.add(TAB_THREE);
        // 对viewpager进行处理
        doViewPager();
        tabLayout.setupWithViewPager(viewpager);
        //默认选中第一项
        tabLayout.getTabAt(0).select();
    }

    private void doViewPager() {
        if(mFragmentList==null){
            mFragmentList = new ArrayList<>();
        }
        mFragmentList.clear();
        mFragmentList.add(new FragmentAOne());
        mFragmentList.add(new FragmentATwo());
        mFragmentList.add(new FragmentAThree());

        mFragmentAdapter = new AFragmentAdapter(fragment.getChildFragmentManager(),mFragmentList,mTitleList);
        viewpager.setAdapter(mFragmentAdapter);
    }
}
