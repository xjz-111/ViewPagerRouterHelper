package me.lesile.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  15:59
 */

public class PagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView t = new TextView(getActivity());
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1920);
        t.setLayoutParams(lp);
        int color = getArguments().getInt("color");
        t.setBackgroundColor(color);
        t.setText(String.valueOf(getArguments().getInt("position")));
        t.setGravity(Gravity.CENTER);
        t.setTextSize(50);
        t.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        return t;
    }
}
