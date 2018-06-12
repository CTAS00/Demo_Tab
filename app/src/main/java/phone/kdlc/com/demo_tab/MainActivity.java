package phone.kdlc.com.demo_tab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo_fragment.FragmentFactory;
import rx.Observable;
import rx.functions.Action1;
import util.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout tab_ll_container;
    private LayoutInflater mLayoutInflater;


    // 对于tab的存储
    private List<View> mChildViewList = new ArrayList<>();



    private final int main_tab_A = 0;
    private final int main_tab_B = 1;
    private final int main_tab_C = 2;
    private final int main_tab_D = 3;
    private  int tagId;

    public FragmentFactory.FragmentStatus toTabIndex = FragmentFactory.FragmentStatus.None;

    private FragmentFactory.FragmentStatus odlState = FragmentFactory.FragmentStatus.None;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        doTabView();
        initListener();
        // 默认第一项
        initDefaultFragment();
    }




    private void initView() {
        tab_ll_container = (LinearLayout) findViewById(R.id.tab_ll_container);
        mLayoutInflater = LayoutInflater.from(this);
    }

    private void doTabView() {
        // 生成4个tab
        Observable.just("A", "B", "C", "D").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("CTAS", "当前的值 =" + s);
                View childView = mLayoutInflater.inflate(R.layout.activity_tabview, tab_ll_container, false);
                TextView tab_tv = (TextView) childView.findViewById(R.id.tab_tv);
                tab_tv.setText(s);
                tab_ll_container.addView(childView);
                mChildViewList.add(childView);

            }
        });
    }

    private void initListener() {
        Observable.from(mChildViewList).subscribe(new Action1<View>() {
            @Override
            public void call(View view) {
                view.setId(tagId);
                tagId++;
                view.setOnClickListener(MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case main_tab_A:
                toTabIndex = FragmentFactory.FragmentStatus.Tab_1;
                if (toTabIndex == odlState) return;
                FragmentFactory.changeFragment(getSupportFragmentManager(), toTabIndex, R.id.container);
                odlState = toTabIndex;
                break;
            case main_tab_B:
                toTabIndex = FragmentFactory.FragmentStatus.Tab_2;
                if (toTabIndex == odlState) return;
                FragmentFactory.changeFragment(getSupportFragmentManager(), toTabIndex, R.id.container);
                odlState = toTabIndex;
                break;
            case main_tab_C:
                toTabIndex = FragmentFactory.FragmentStatus.Tab_3;
                if (toTabIndex == odlState) return;
                FragmentFactory.changeFragment(getSupportFragmentManager(), toTabIndex, R.id.container);
                odlState = toTabIndex;
                break;
            case main_tab_D:
                toTabIndex = FragmentFactory.FragmentStatus.Tab_4;
                if (toTabIndex == odlState) return;
                FragmentFactory.changeFragment(getSupportFragmentManager(), toTabIndex, R.id.container);
                odlState = toTabIndex;
                break;
            default:
                break;

        }
    }

    private void initDefaultFragment() {
        toTabIndex = FragmentFactory.FragmentStatus.Tab_1;
        FragmentFactory.changeFragment(getSupportFragmentManager(), toTabIndex, R.id.container);
        odlState = toTabIndex;
    }
}
