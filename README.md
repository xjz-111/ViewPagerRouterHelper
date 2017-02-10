# ViewPagerRouterHelper

Help to record ViewPager router using onResume() and onPause().

## Usage

```Java
ViewPagerRouter router = new ViewPagerRouter(defaultPosition, pageNameList, onViewPagerRouterListener);
router.onPageSelected(position);                   //in ViewPager.OnPageChangeListener -> onPageSelected()
router.onPageResume();                             //in onResume() 
router.onPagePause(viewPager.getCurrentItem());    //in onPause()


//Do something in OnViewPagerRouterListener->onPageResume()/onPagePause()
@Override
public void onPageResume(String pageName) {
    Log.i("router", "Current onResume：" + pageName);
}

@Override
public void onPagePause(String pageName) {
    Log.e("router", "Current onPause：" + pageName);
}
```

## Demo

![image](https://github.com/zhaoxj/ViewPagerRouterHelper/blob/master/screencast/1.gif)

