package demo_fragment.AInnerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import demo_fragment.AInnerFragment.adapter.FragmentAoneAdapter;
import demo_fragment.MyBaseFragment;
import phone.kdlc.com.demo_tab.R;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class FragmentAOne extends MyBaseFragment {
    private View mView;

    private SmartRefreshLayout refreshView;
    private RecyclerView recyclerView;

    private FragmentAoneAdapter mFragmentAOneAdapter;
    private List<JSONObject> mDatas;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_a_one,null);
        initView();
        initData();
        initListener();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshView.autoRefresh();
    }

    private void initListener() {
        refreshView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshView.finishRefresh();
                doData();
            }
        });
    }


    private void initView() {
        refreshView = (SmartRefreshLayout) mView.findViewById(R.id.refreshView);
        recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new MyLinearLayoutManager(mActivity));
    }
    private void initData() {
        mDatas = new ArrayList<>();
        mFragmentAOneAdapter = new FragmentAoneAdapter(mActivity,mDatas);
        recyclerView.setAdapter(mFragmentAOneAdapter);
    }
    private void doData(){
        String result = "[\n" +
                "       {\"key\":\"bigimage\"} ,\n" +
                "       {\"key\":\"image_withtext\"},\n" +
                "       {\"key\":\"button\"},\n" +
                "       {\"key\":\"bigimage\"} ,\n" +
                "       {\"key\":\"image_withtext\"}\n" +
                "        \n" +
                "    ]";

        mDatas.clear();


        try {
            JSONArray array = new JSONArray(result);
            for(int i=0;i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
                mDatas.add(object);
            }
            mFragmentAOneAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
