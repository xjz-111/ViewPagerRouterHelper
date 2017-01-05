package me.lesile.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.leslie.vprouter.OnViewPagerRouterListener;
import me.leslie.vprouter.ViewPgaerRouter;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  15:56
 */

public class MFragment extends Fragment implements ViewPager.OnPageChangeListener, OnViewPagerRouterListener{


    private ViewPgaerRouter router;

    private ViewPager viewPager;
    private MAdapter adapter;
    private int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN};
    private List<String> names = new ArrayList<>();


    @Override
    public void onPageResume(String pageName) {
        Log.i("router", "当前显示页面：" + pageName);
    }

    @Override
    public void onPagePause(String pageName) {
        Log.e("router", "当前离开页面：" + pageName);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mfragment, null);
        viewPager = (ViewPager) v.findViewById(R.id.id_page_vp);
        adapter = new MAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        for (int i = 0; i < colors.length; i++){
            names.add("test-" + i);
        }
        int defaultPosition = getArguments().getInt("position");
        router = new ViewPgaerRouter(defaultPosition, names, this);
        viewPager.setCurrentItem(defaultPosition);
        return v;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        router.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MAdapter extends FragmentPagerAdapter {
        private List<PagerFragment> fragments = new ArrayList<>();

        public MAdapter(FragmentManager fm) {
            super(fm);
            clean();
        }

        public void clean(){
            for (int i = 0; i < colors.length; i++){
                fragments.add(null);
            }
        }

        @Override
        public Fragment getItem(int position) {
            PagerFragment f = getFragment(position);
            if (null == f){
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putInt("color", colors[position]);
                f = (PagerFragment) Fragment.instantiate(getActivity(), PagerFragment.class.getName(), bundle);
                fragments.set(position, f);
            }
            return f;
        }

        private PagerFragment getFragment(int position){
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return colors.length;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        router.onPageResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        router.onPagePause(viewPager.getCurrentItem());
    }
}
