package me.leslie.vprouter;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  14:14
 */

public interface OnViewPagerRouterListener {
    /**
     * onResume
     * @param pageName
     */
    void onPageResume(String pageName);

    /**
     * onPause
     * @param pageName
     */
    void onPagePause(String  pageName);
}
