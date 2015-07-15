package com.sc.android.meituan;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

public class MainMeiTuanActivity extends TabActivity implements
		OnTabChangeListener {
	private Context mContext;
	private TextView mTextView;
	private long exitTime = 0;
	private LayoutInflater mLayoutInflater;
	public static final int DEAL_TAB = 1;
	public static final int POI_TAB = 2;
	public static final int UAER_TAB = 3;
	public static final int MORE_TAB = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_tab_layout);

		mTextView = (TextView) findViewById(R.id.city_txt);
		mLayoutInflater = LayoutInflater.from(this);
		TabHost tabHost = getTabHost();

		TabSpec tabSpec1 = tabHost.newTabSpec("deal");
		tabSpec1.setIndicator(createTabView(DEAL_TAB));
		tabSpec1.setContent(new Intent(mContext, DealActivity.class));

		TabSpec tabSpec2 = tabHost.newTabSpec("poi");
		tabSpec2.setIndicator(createTabView(POI_TAB));
		tabSpec2.setContent(new Intent(mContext, PinShowActivity.class));

		TabSpec tabSpec3 = tabHost.newTabSpec("user");
		tabSpec3.setIndicator(createTabView(UAER_TAB));
		tabSpec3.setContent(new Intent(mContext, UserActivity.class));

		TabSpec tabSpec4 = tabHost.newTabSpec("more");
		tabSpec4.setIndicator(createTabView(MORE_TAB));
		tabSpec4.setContent(new Intent(mContext, MoreActivity.class));

		tabHost.addTab(tabSpec1);
		tabHost.addTab(tabSpec2);
		tabHost.addTab(tabSpec3);
		tabHost.addTab(tabSpec4);

		tabHost.setOnTabChangedListener(this);

	}

	public View createTabView(int tab) {
		View view = mLayoutInflater.inflate(R.layout.item_tab_view, null);

		TextView titleTxt = (TextView) view.findViewById(R.id.tab_name_txt);
		ImageView iconImg = (ImageView) view.findViewById(R.id.tab_name_img);

		switch (tab) {
		case DEAL_TAB:
			titleTxt.setText("团购");
			iconImg.setImageResource(R.drawable.selector_deal_item);
			break;
		case POI_TAB:
			titleTxt.setText("商家");
			iconImg.setImageResource(R.drawable.selector_poi_item);
			break;
		case UAER_TAB:
			titleTxt.setText("我的");
			iconImg.setImageResource(R.drawable.selector_user_item);
			break;
		case MORE_TAB:
			titleTxt.setText("更多");
			iconImg.setImageResource(R.drawable.selector_more_item);
			break;
		}

		return view;
	}

	@Override
	public void onTabChanged(String tabId) {

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exit();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void exit() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			Toast.makeText(getApplicationContext(), "再按一次退出程序",
					Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();

		} else {
			finish();
			System.exit(0);
		}
	}
}
