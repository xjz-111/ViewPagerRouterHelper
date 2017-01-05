package me.lesile.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import java.util.UUID;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  14:36
 */

public class MActivity extends FragmentActivity{
    private FragmentManager mFragmentManager;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mactivity);
        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            replace(fragment = getFragment(), null, false);
        }
    }

    private Fragment getFragment(){
        String fragmentName = getIntent().getStringExtra("fragment_name");
        return Fragment.instantiate(this, fragmentName, getIntent().getExtras());
    }

    public void replace(final Fragment fragment, String tag, boolean canBack) {
        if (null == fragment) {
            return;
        }
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out);
        if (TextUtils.isEmpty(tag)) {
            tag = UUID.randomUUID().toString();
        }
        ft.replace(R.id.replace, fragment, tag);
        if (canBack) {
            ft.addToBackStack(tag);
        }
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (null != fragment && fragment instanceof MFragment){
            ((MFragment) fragment).onBackPress();
        }
    }
}
