package demo_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phone.kdlc.com.demo_tab.MainActivity;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class MyBaseFragment extends Fragment {
    protected MainActivity mActivity;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (MainActivity) activity;
    }


}
