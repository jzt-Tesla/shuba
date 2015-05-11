package com.qiwenge.android.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.liuguangqiang.android.mvp.BaseUi;
import com.liuguangqiang.android.mvp.Presenter;

/**
 * BaseFragment
 * <p/>
 * Created by Eric on 2014-4-26
 */
public class BaseFragment extends Fragment {

    private Presenter presenter;
    private BaseUi baseUi;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = setPresenter();
        baseUi = setUi();
    }

    public Presenter setPresenter() {
        return null;
    }

    public BaseUi setUi() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null && baseUi != null)
            presenter.attach(baseUi);
    }

    @Override
    public void onPause() {
        if (presenter != null && baseUi != null)
            presenter.detach(baseUi);
        super.onPause();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    public void startActivity(Class<?> cls, Bundle extra) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(extra);
        startActivity(intent);
    }

}
