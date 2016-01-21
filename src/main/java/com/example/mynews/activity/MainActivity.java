package com.example.mynews.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mynews.Contants.DefineView;
import com.example.mynews.R;
import com.example.mynews.activity.base.BaseActivity;
import com.example.mynews.widget.DragLayout;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends BaseActivity implements DefineView {
    private DragLayout drag_layout;
    private ImageView top_bar_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initValidata();
        initListener();
        bindData();
    }

    /**
     * 初始化布局控件
     */
    public void initView() {
        drag_layout = (DragLayout) findViewById(R.id.drag_layout);
        top_bar_icon = (ImageView) findViewById(R.id.top_bar_icon);
    }
    @Override
    public void initValidata() {
    }
    @Override
    public void initListener() {
        drag_layout.setDragListener(new CustomDragListener());
        top_bar_icon.setOnClickListener(new CustomOnClickListener());
    }
    @Override
    public void bindData() {

    }
    class CustomDragListener implements DragLayout.DragListener{

        /**
         * 界面打开
         */
        @Override
        public void onOpen() {

        }

        /**
         * 界面关闭
         */
        @Override
        public void onClose() {

        }

        /**
         * 界面进行滑动
         * @param percent
         */
        @Override
        public void onDrag(float percent) {
              ViewHelper.setAlpha(top_bar_icon,1-percent);
        }
    }
    class CustomOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View arg0) {
            drag_layout.open();
        }
    }

}
