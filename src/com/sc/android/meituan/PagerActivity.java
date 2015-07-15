package com.sc.android.meituan;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class PagerActivity extends Activity {
	private ViewPager mViewPager;
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private int currIndex = 0;
	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide_layout);

		mViewPager = (ViewPager) findViewById(R.id.guide_popup_layout);
		mButton = (Button) findViewById(R.id.experience_btn);
		mPage0 = (ImageView) findViewById(R.id.guide1_img);
		mPage1 = (ImageView) findViewById(R.id.guide2_img);
		mPage2 = (ImageView) findViewById(R.id.guide3_img);
		mPage3 = (ImageView) findViewById(R.id.guide4_img);

		LayoutInflater inflater = LayoutInflater.from(this);
		View view1 = inflater.inflate(R.layout.item_pager1_view, null);
		View view2 = inflater.inflate(R.layout.item_pager2_view, null);
		View view3 = inflater.inflate(R.layout.item_pager3_view, null);
		View view4 = inflater.inflate(R.layout.item_pager4_view, null);

		final ArrayList<View> dataList = new ArrayList<View>();
		dataList.add(view1);
		dataList.add(view2);
		dataList.add(view3);
		dataList.add(view4);

		MyAdapter myAdapter = new MyAdapter();
		mViewPager.setAdapter(myAdapter);
		myAdapter.setData(dataList);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					mPage0.setImageDrawable(getResources().getDrawable(
							R.drawable.page_now));
					mPage1.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					break;
				case 1:
					mPage1.setImageDrawable(getResources().getDrawable(
							R.drawable.page_now));
					mPage0.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					mPage2.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					break;
				case 2:
					mPage2.setImageDrawable(getResources().getDrawable(
							R.drawable.page_now));
					mPage1.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					mPage3.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					break;
				case 3:
					mPage3.setImageDrawable(getResources().getDrawable(
							R.drawable.page_now));
					mPage2.setImageDrawable(getResources().getDrawable(
							R.drawable.page));
					break;
				}
				currIndex = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		// PagerAdapter mPagerAdapter = new PagerAdapter() {
		//
		// @Override
		// public boolean isViewFromObject(View arg0, Object arg1) {
		// return arg0 == arg1;
		// }
		//
		// @Override
		// public int getCount() {
		// return dataList.size();
		// }
		//
		// @Override
		// public void destroyItem(View container, int position, Object object)
		// {
		// ((ViewPager) container).removeView(dataList.get(position));
		// }
		//
		// @Override
		// public Object instantiateItem(View container, int position) {
		// Vi
		// container.addView(dataList.get(position));
		// return dataList.get(position);
		// }
		// };
		//
		// mViewPager.setAdapter(mPagerAdapter);
	}

	public class MyAdapter extends PagerAdapter {
		private ArrayList<View> list = new ArrayList<View>();

		public void setData(ArrayList<View> list) {
			this.list = list;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = list.get(position);
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = list.get(position);
			container.removeView(view);
		}

	}

	// public class MyOnPageChangeListener implements OnPageChangeListener {
	// @Override
	// public void onPageScrollStateChanged(int arg0) {
	// switch (arg0) {
	// case 0:
	// mPage0.setImageDrawable(getResources().getDrawable(
	// R.drawable.page_now));
	// mPage1.setImageDrawable(getResources().getDrawable(
	// R.drawable.page));
	// break;
	// case 1:
	// mPage1.setImageDrawable(getResources().getDrawable(
	// R.drawable.page_now));
	// mPage0.setImageDrawable(getResources().getDrawable(
	// R.drawable.page));
	// mPage2.setImageDrawable(getResources().getDrawable(
	// R.drawable.page));
	// break;
	// case 2:
	// mPage2.setImageDrawable(getResources().getDrawable(
	// R.drawable.page_now));
	// mPage1.setImageDrawable(getResources().getDrawable(
	// R.drawable.page));
	// break;
	// }
	// currIndex = arg0;
	// }
	//
	// @Override
	// public void onPageScrolled(int arg0, float arg1, int arg2) {
	// }
	//
	// @Override
	// public void onPageSelected(int arg0) {
	//
	// }
	//
	// }

	public void onExperience(View v) {
		Intent intent = new Intent();
		intent.setClass(PagerActivity.this, DealLoadingActivity.class);
		startActivity(intent);
		this.finish();
	}
}