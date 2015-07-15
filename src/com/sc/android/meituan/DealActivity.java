package com.sc.android.meituan;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sc.android.meituan.adapter.GridViewShowAdapter;
import com.sc.android.meituan.adapter.MyBaseAdapter;
import com.sc.android.meituan.bean.ContenBean;
import com.sc.android.meituan.bean.MessgeBean;

public class DealActivity extends Activity {
	private GridView mGridView;
	private ListView mListView;
	private TextView mTextView;
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deal_layout);

		mGridView = (GridView) findViewById(R.id.gridview_type);
		mListView = (ListView) findViewById(R.id.love_lis_msg);
		mTextView = (TextView) findViewById(R.id.city_txt);
		GridViewShowAdapter adapter = new GridViewShowAdapter(this,
				getGridDate());
		mGridView.setAdapter(adapter);
		MyBaseAdapter adapters = new MyBaseAdapter(this, getListData());
		mListView.setAdapter(adapters);
	}

	public List<MessgeBean> getGridDate() {
		List<MessgeBean> list = new ArrayList<MessgeBean>();
		MessgeBean msgBean = new MessgeBean();
		msgBean.setTitle("美食");
		msgBean.setIcon(R.drawable.ic_category_0);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("电影");
		msgBean.setIcon(R.drawable.ic_category_1);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("商场");
		msgBean.setIcon(R.drawable.ic_category_2);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("KTV");
		msgBean.setIcon(R.drawable.ic_category_3);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("今日最新");
		msgBean.setIcon(R.drawable.ic_category_4);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("代金券");
		msgBean.setIcon(R.drawable.ic_category_5);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("周边游");
		msgBean.setIcon(R.drawable.ic_category_6);
		list.add(msgBean);

		msgBean = new MessgeBean();
		msgBean.setTitle("小吃快餐");
		msgBean.setIcon(R.drawable.ic_category_7);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("蛋糕甜点");
		msgBean.setIcon(R.drawable.ic_category_8);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("生活服务");
		msgBean.setIcon(R.drawable.ic_category_9);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("休闲娱乐");
		msgBean.setIcon(R.drawable.ic_category_10);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("丽人");
		msgBean.setIcon(R.drawable.ic_category_11);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("足疗按摩");
		msgBean.setIcon(R.drawable.ic_category_12);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("旅游");
		msgBean.setIcon(R.drawable.ic_category_13);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("购物");
		msgBean.setIcon(R.drawable.ic_category_14);
		list.add(msgBean);
		msgBean = new MessgeBean();
		msgBean.setTitle("全部");
		msgBean.setIcon(R.drawable.ic_category_15);
		list.add(msgBean);

		return list;

	}

	public List<ContenBean> getListData() {
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
