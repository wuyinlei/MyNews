package com.example.mynews.viewdrag;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mynews.R;
import com.example.mynews.widget.DragLayout;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends BaseActivity {
	private DragLayout dl;
	private ListView lv;
	private ImageView iv_icon, iv_bottom;
	public DragLayout getDl() {
		return dl;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setStatusBar();
		initDragLayout();
		initView();

	}

	/**
	 * 初始化DragLayout
	 */
	private void initDragLayout() {
		dl = (DragLayout) findViewById(R.id.dl);
		dl.setDragListener(new DragLayout.DragListener() {
			//界面打开的时候
			@Override
			public void onOpen() {
			}
			//界面关闭的时候
			@Override
			public void onClose() {
			}

			//界面滑动的时候
			@Override
			public void onDrag(float percent) {
				ViewHelper.setAlpha(iv_icon, 1 - percent);
			}
		});
	}

	/**
	 * 初始化view
	 */
	private void initView() {

		//找到控件
		iv_icon = (ImageView) findViewById(R.id.iv_icon);
		iv_bottom = (ImageView) findViewById(R.id.iv_bottom);

		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
				R.layout.item_text, new String[] { "item 01", "item 01",
						"item 01", "item 01", "item 01", "item 01",
						"item 01", "item 01", "item 01", "item 01",
						"item 01", "item 01", "item 01", "item 01",
						"item 01", "item 01", "item 01",
						"item 01", "item 01", "item 01", "item 01"}));
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
									int position, long arg3) {
				Toast.makeText(MainActivity.this,"Click Item "+position,Toast.LENGTH_SHORT).show();
			}
		});
		iv_icon.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dl.open();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
