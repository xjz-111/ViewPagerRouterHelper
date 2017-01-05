package me.leslie.vprouter;

import java.util.List;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  13:56
 */

public class ViewPgaerRouter implements IRouter{
    private State mState;
    private boolean mCanCallPause;
    private OnViewPagerRouterListener onViewPagerRouterListener;

    public ViewPgaerRouter(int defaultPosition, List<String> names, OnViewPagerRouterListener l) {
        mState = new State().init(defaultPosition, names);
        this.onViewPagerRouterListener = l;
        if (0 == defaultPosition){
            onPageSelected(0);
        }
    }

    @Override
    public void onPageSelected(int position) {
        int size = mState.getPageCount();
        if (position < size && mState.getLastPosition() < size){
            mState.setCurrentPosition(position);
            setOnPageSelected(position);
        }
    }

    @Override
    public void onPageResume() {
        int position = mState.getBeforChangedViewpagerPosition();
        if (position > -1 && position < mState.getPageCount()){
            mState.setCurrentPosition(mState.getBeforChangedViewpagerPosition());
            imitateOnResume();
        }
        mState.setIsCallOnPause(false);
    }

    @Override
    public void onPagePause(int beforChangedViewpagerPosition) {
        if (beforChangedViewpagerPosition > -1){
            mState.setBeforChangedViewpagerPosition(beforChangedViewpagerPosition).setIsCallOnPause(true).setLastPosition(mState.getLastPosition());
            imitateOnPause();
        }
    }

    @Override
    public final void setOnPageSelected(int position) {
        if (!mState.isCallOnPause()){
            imitateOnPause();
            imitateOnResume();
            mState.setLastPosition(position);
        }
    }

    @Override
    public final void imitateOnResume() {
        mCanCallPause = true;
        if (null != onViewPagerRouterListener){
            onViewPagerRouterListener.onPageResume(mState.getCurrentPageName());
        }
    }

    @Override
    public final void imitateOnPause() {
        if (mCanCallPause){
            if (null != onViewPagerRouterListener){
                onViewPagerRouterListener.onPagePause(mState.getLastPageName());
            }
        }
    }

}
