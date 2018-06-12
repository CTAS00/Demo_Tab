package demo_fragment.AInnerFragment.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import org.json.JSONObject;

import java.util.List;

import demo_fragment.AInnerFragment.delegate.BigImageDelegate;
import demo_fragment.AInnerFragment.delegate.ButtonDelegate;
import demo_fragment.AInnerFragment.delegate.ImageWithTextDelegate;

/**
 * Created by koudai_nick on 2018/6/12.
 */

public class FragmentAoneAdapter extends MultiItemTypeAdapter<JSONObject> {
    public FragmentAoneAdapter(Context context, List<JSONObject> datas) {
        super(context, datas);
        addItemViewDelegate(new BigImageDelegate());
        addItemViewDelegate(new ImageWithTextDelegate());
        addItemViewDelegate(new ButtonDelegate());
    }
}
