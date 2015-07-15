package com.sc.android.meituan;

import java.util.ArrayList;
import java.util.List;

import com.sc.android.meituan.adapter.MyBaseAdapter;
import com.sc.android.meituan.bean.ContenBean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class PinShowActivity extends Activity {
	private ImageView mSearchImg;
	private ListView mListView;
	private long exitTime = 0;
	private Spinner mSpinner1, mSpinner2, mSpinner3, mSpinner4;
	private String[] arrays1 = { "美食", "娱乐", "KTV", "全国" };
	private String[] arrays2 = { "全城", "郫县", "青羊区", "金牛区", "高新区" };
	private String[] arrays3 = { "智能排序", "字母升序", "价格升序", "价格降序" };
	private String[] arrays4 = { "筛选", "按字母筛选", "按地区筛选", "按内容筛选" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pin_layout);

		mSearchImg = (ImageView) findViewById(R.id.search_img);
		mListView = (ListView) findViewById(R.id.messge_view);
		MyBaseAdapter adapter = new MyBaseAdapter(this, getData());
		mListView.setAdapter(adapter);

		mSpinner1 = (Spinner) findViewById(R.id.one_spinner);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				R.layout.item_textview, arrays1);

		mSpinner1.setAdapter(adapter1);

		mSpinner2 = (Spinner) findViewById(R.id.two_spinner);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				R.layout.item_textview, arrays2);
		mSpinner2.setAdapter(adapter2);

		mSpinner3 = (Spinner) findViewById(R.id.three_spinner);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				R.layout.item_textview, arrays3);
		mSpinner3.setAdapter(adapter3);

		mSpinner4 = (Spinner) findViewById(R.id.foure_spinner);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				R.layout.item_textview, arrays4);
		mSpinner4.setAdapter(adapter4);

		mSearchImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(PinShowActivity.this, SearchActivity.class);
				startActivity(intent);
			}
		});
	}

	public List<ContenBean> getData() {
		List<ContenBean> list = new ArrayList<ContenBean>();

		ContenBean mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.meituan_gt_image7);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("巴菲盛宴环球美食");
		mContent.setIcon(R.drawable.meituan_bf_image5);
		mContent.setJiage("150");
		mContent.setZekou("200元");
		mContent.setPingfen("5分（40）");
		mContent.setMessge("[孵化园] 单人自助套餐，价格公道，流连忘返的美食");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("新石器烤肉");
		mContent.setIcon(R.drawable.meituan_xsq_image2);
		mContent.setJiage("88");
		mContent.setZekou("200元");
		mContent.setPingfen("4.9分（50）");
		mContent.setMessge("[春熙路] 代金券领取，全场通用，优惠多多");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("水果集萃");
		mContent.setIcon(R.drawable.meituan_sgl_image1);
		mContent.setJiage("3");
		mContent.setZekou("30元");
		mContent.setPingfen("4.9分（1000）");
		mContent.setMessge("[天府广场] 特色水果套餐，优惠多多，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("可爱多火锅");
		mContent.setIcon(R.drawable.meituan_ka_image3);
		mContent.setJiage("45");
		mContent.setZekou("100元");
		mContent.setPingfen("4.5分（1050）");
		mContent.setMessge("[春熙路] 菜品种类齐全，酒水免费，优惠多多");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic3);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic27);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic24);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic23);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic18);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic17);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		mContent = new ContenBean();
		mContent.setTitle("港台美食荟");
		mContent.setIcon(R.drawable.team_buy_pic14);
		mContent.setJiage("9.9");
		mContent.setZekou("20元");
		mContent.setPingfen("5分（50）");
		mContent.setMessge("[天府广场] 雪花绵绵冰4选1，新店优惠，内设免费Wifi");
		list.add(mContent);

		return list;
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
