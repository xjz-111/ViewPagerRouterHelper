package me.leslie.vprouter;

import java.util.List;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  13:56
 */

class State {
    private int pageCount;                          //总页数
    private int currentPosition;                    //当前页数position
    private int beforChangedViewpagerPosition = -1; //改变viewpager之前的position
    private int viewPagerDefaultPosition = 0;       //viewPager默认显示的position，如果非0，则应该在处理nameList的地方将该变量设置进来
    private int lastPosition;                       //上页position
    private boolean isCallOnPause = false;          //是否模拟onPause
    private List<String> names;                     //名称


    public void clearn() {
        setPageCount(0);
        setCurrentPosition(0);
        setBeforChangedViewpagerPosition(-1);
        setViewPagerDefaultPosition(0);
        setLastPosition(0);
        setIsCallOnPause(false);
        setNames(null);
    }

    public String getCurrentPageName(){
        return (null != names && names.size() > currentPosition && currentPosition > -1) ? names.get(currentPosition) : "";
    }

    public String getLastPageName(){
        return (null != names && names.size() > lastPosition && lastPosition > -1) ? names.get(lastPosition) : "";
    }

    public State init(int defaultPosition, List<String> names) {
        if (null == names || names.isEmpty()){
            throw new NullPointerException("names = null");
        }
        this.viewPagerDefaultPosition = defaultPosition;
        this.names = names;
        this.pageCount = names.size();
        return this;
    }

    public State() {
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getPageCount() {
        return pageCount;
    }

    public State setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public State setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public State setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
        return this;
    }

    public int getBeforChangedViewpagerPosition() {
        return beforChangedViewpagerPosition;
    }

    public State setBeforChangedViewpagerPosition(int beforChangedViewpagerPosition) {
        this.beforChangedViewpagerPosition = beforChangedViewpagerPosition;
        return this;
    }

    public boolean isCallOnPause() {
        return isCallOnPause;
    }

    public State setIsCallOnPause(boolean isCallOnPause) {
        this.isCallOnPause = isCallOnPause;
        return this;
    }

    public int getViewPagerDefaultPosition() {
        return viewPagerDefaultPosition;
    }

    public State setViewPagerDefaultPosition(int viewPagerDefaultPosition) {
        this.viewPagerDefaultPosition = viewPagerDefaultPosition;
        lastPosition = viewPagerDefaultPosition;
        return this;
    }

}
