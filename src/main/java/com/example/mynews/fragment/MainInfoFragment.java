package com.example.mynews.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynews.R;
import com.example.mynews.adapter.FixedPagerAdapter;
import com.example.mynews.viewdrag.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:主Fragment承载类,上面会放置若干个Fragment类
 */
public class MainInfoFragment extends Fragment implements ViewPager.OnPageChangeListener {
    ViewPager info_viewpager;
    private View mView;

    private List<Fragment> fragments;

    //适配器
    private FixedPagerAdapter mPagerAdater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.main_info_layout, container, false);
            info_viewpager = (ViewPager) mView.findViewById(R.id.info_viewpager);
            initDatas();
        }
        return mView;
    }

    /**
     * 初始化数据
     */
    public void initDatas() {
        fragments = new ArrayList<>();

        //添加数据
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());

        mPagerAdater = new FixedPagerAdapter(getChildFragmentManager());
        mPagerAdater.setFragments(fragments);
        //设置适配器
        info_viewpager.setAdapter(mPagerAdater);
        //对viewpager设置点击监听事件
        info_viewpager.setOnPageChangeListener(this);
    }


    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     * 当页面滚动时该方法将被调用。
     *
     * @param position             Position index of the first page currently being d
     *                             isplayed. Page position+1 will be visible
     *                             if positionOffset is nonzero.
     *                             当前正在显示的第一页的位置的索引。页面位置+1将是可见的，如果positionOffset非零。
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     *                             表示从[0，1）的值从在位置上的页的偏移量。
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     *                             以像素为单位，表示从位置偏移值。
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    /**
     * This method will be invoked when a new page becomes selected. Animation is not necessarily complete.
     * 当一个新的页面选择，这种方法将被调用。
     *
     * @param position Position index of the new selected page.
     *                 新选定的页面位置索引。
     */
    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            ((MainActivity) getActivity()).getDl().setDrag(true);
        } else if (position == fragments.size() - 1) {
            ((MainActivity) getActivity()).getDl().setDrag(false);
        } else {
            ((MainActivity) getActivity()).getDl().setDrag(false);
        }
    }


    /**
     * Called when the scroll state changes. Useful for discovering when the user begins dragging,
     * when the pager is automatically settling to the current page, or when it is fully stopped/idle.
     * 滚动状态，当夜面滚动的时候调用，当是当前页可见或者完全消失
     *
     * @param state The new scroll state.    新的滚动状态
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
