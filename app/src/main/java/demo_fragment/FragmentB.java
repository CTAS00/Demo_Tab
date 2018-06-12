package demo_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import phone.kdlc.com.demo_tab.R;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class FragmentB extends MyBaseFragment {

    private View mView;
    private TextView tv_show;

    public static FragmentB fragment;

    public static FragmentB getInstance() {
        if (fragment == null)
            fragment = new FragmentB();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_b_d,null);

        initView();
        initData();
        return mView;
    }


    private void initView() {
        tv_show = (TextView) mView.findViewById(R.id.tv_show);
    }
    private void initData() {
        tv_show.setText("B");
    }

}
