package demo_fragment.AInnerFragment.delegate;

import android.util.Log;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import phone.kdlc.com.demo_tab.R;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class BigImageDelegate implements ItemViewDelegate<JSONObject> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.fragment_a_one_bigimage;
    }

    @Override
    public boolean isForViewType(JSONObject item, int position) {
        Log.e("CTAS","isForViewType");
        try {
            return "bigimage".equals(item.getString("key"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, JSONObject jsonObject, int position) {
        Log.e("CTAS","我进入了convert");
    }
}
