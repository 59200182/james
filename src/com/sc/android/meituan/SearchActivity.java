package com.sc.android.meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

public class SearchActivity extends Activity {
	private ImageView mSearchClear;
	private AutoCompleteTextView mAutoCompleteTxt;
	private PopupWindow mPopupWindow;
	private View v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_pin_layout);
		mSearchClear = (ImageView) findViewById(R.id.search_clear_img);
		View contentView = getPopupWindowView();
		mPopupWindow = new PopupWindow(contentView, LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		mAutoCompleteTxt = (AutoCompleteTextView) findViewById(R.id.search_eidt1);
		mAutoCompleteTxt.setThreshold(1);
		mAutoCompleteTxt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String key = s.toString();
				// String[] from = new String[] { "title", "count" };
				// int[] to = new int[] { R.id.search_txt11, R.id.for_mesg };
				// SimpleAdapter adapters = new SimpleAdapter(
				// TwoActivityPopup.this, getData(),
				// R.layout.activity_auto_layout, from, to);
				if (key.equals("a")) {
					mPopupWindow.showAsDropDown(v, 0, -10);
				}
			}

			// private List<HashMap<String, Object>> getData() {
			// List<HashMap<String, Object>> list = new
			// ArrayList<HashMap<String, Object>>();
			//
			// HashMap<String, Object> item = new HashMap<String, Object>();
			// item.put("title", "a肥牛");
			// item.put("count", "约10个团购");
			// list.add(item);
			//
			// item = new HashMap<String, Object>();
			// item.put("title", "a冬瓜");
			// item.put("count", "约10个团购");
			// list.add(item);
			// item = new HashMap<String, Object>();
			// item.put("title", "a舍尔");
			// item.put("count", "约10个团购");
			// list.add(item);
			// item = new HashMap<String, Object>();
			// item.put("title", "a咖啡");
			// item.put("count", "约1个团购");
			// list.add(item);
			// item = new HashMap<String, Object>();
			// item.put("title", "a按摩");
			// item.put("count", "约1个团购");
			// list.add(item);
			//
			// return list;
			// }

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		mSearchClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mAutoCompleteTxt.setText("");
			}
		});
		mAutoCompleteTxt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() > 0) {
					mSearchClear.setVisibility(View.VISIBLE);
				} else {
					mSearchClear.setVisibility(View.INVISIBLE);
				}
			}
		});
	}

	private View getPopupWindowView() {
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		v = mLayoutInflater.inflate(R.layout.view_popupwindow, null);
		ListView listView = (ListView) v
				.findViewById(R.id.popupwindow_listview);
		String[] from = new String[] { "title", "count" };
		int[] to = new int[] { R.id.search_txt11, R.id.for_mesg };
		SimpleAdapter adapters = new SimpleAdapter(SearchActivity.this,
				getData(), R.layout.activity_auto_layout, from, to);

		listView.setAdapter(adapters);
		return v;
	}

	private List<HashMap<String, Object>> getData() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> item = new HashMap<String, Object>();
		item.put("title", "a肥牛肥牛");
		item.put("count", "约10个团购");
		list.add(item);

		item = new HashMap<String, Object>();
		item.put("title", "a矮冬瓜");
		item.put("count", "约10个团购");
		list.add(item);
		item = new HashMap<String, Object>();
		item.put("title", "a舍尔儿");
		item.put("count", "约10个团购");
		list.add(item);
		item = new HashMap<String, Object>();
		item.put("title", "a爱上咖啡");
		item.put("count", "约1个团购");
		list.add(item);
		item = new HashMap<String, Object>();
		item.put("title", "a爱上按摩");
		item.put("count", "约1个团购");
		list.add(item);

		return list;
	}
}
