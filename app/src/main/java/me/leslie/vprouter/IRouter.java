package me.leslie.vprouter;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-01-05  14:00
 */

interface IRouter {

    /**
     * 页面展示
     * @param position
     */
    void onPageSelected(int position);

    /**
     * 当前页面Resume状态
     */
    void onPageResume();

    /**
     * 页面处于Pause状态
     * @param beforChangedViewpagerPosition
     */
    void onPagePause(int beforChangedViewpagerPosition);

    /**
     * 页面展示时的处理
     * @param position
     */
    void setOnPageSelected(int position);

    /**
     * 模拟onResume
     */
    void imitateOnResume();

    /**
     * 模拟onPause
     */
    void imitateOnPause();
}
