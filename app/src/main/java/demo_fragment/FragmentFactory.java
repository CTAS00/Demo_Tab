package demo_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class FragmentFactory {

    private static List<Fragment> list;
    private  static Fragment lastFragment;
    private static Fragment selectFragment;
    private static FragmentManager manager;


    public enum FragmentStatus
    {
        None,
        Tab_1,
        Tab_2,
        Tab_3,
        Tab_4
    }

    public static Fragment getLastFragment(){
        return lastFragment;

    }

    public static Fragment getSelectedFragment(){
        return selectFragment;
    }



    public static FragmentManager getFragmentManager() {
        return manager;
    }
    public static void clear()
    {
        if(list!=null)
            list.clear();
        if(manager!=null)
        {
            int count = manager.getBackStackEntryCount();
            while(count>=0)
            {
                manager.popBackStackImmediate();
                count--;
            }
        }
        manager = null;
    }

    public static void changeFragment(FragmentManager manager, FragmentStatus status, int id)
    {
        FragmentFactory.manager = manager;
        FragmentTransaction transaction = manager.beginTransaction();
        if(list==null)
            list = new ArrayList<Fragment>();
        selectFragment = null;
        // 对于tab切换的处理
        switch (status) {
            case None:
                return;
            case Tab_1:
                selectFragment = FragmentA.getInstance();
                break;
            case Tab_2:
                selectFragment = FragmentB.getInstance();
                break;
            case Tab_3:
                selectFragment = FragmentC.getInstance();
                break;
            case Tab_4:
                selectFragment = FragmentD.getInstance();
                break;
            default:
                break;
        }
        String tag = null;
        if(list.contains(selectFragment))
        {
            transaction.hide(lastFragment).show(selectFragment).commitAllowingStateLoss();
        }
        else
        {
            if(list.size()==0)
                transaction.add(id, selectFragment,tag).commitAllowingStateLoss();
            else
            {
                Fragment fragment = null;
                if (fragment !=null) {
                    transaction.remove(fragment).hide(lastFragment).add(id, selectFragment,tag).commitAllowingStateLoss();
                } else {
                    transaction.hide(lastFragment).add(id, selectFragment,tag).commitAllowingStateLoss();
                }

            }
            list.add(selectFragment);

        }
        lastFragment = selectFragment;
    }


}
