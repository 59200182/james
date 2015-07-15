package com.sc.android.meituan.adapter;

import java.util.ArrayList;
import java.util.List;

import com.sc.android.meituan.R;
import com.sc.android.meituan.R.id;
import com.sc.android.meituan.R.layout;
import com.sc.android.meituan.bean.ContenBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {
	private Context mContext;
	private List<ContenBean> mList = new ArrayList<ContenBean>();;
	private LayoutInflater mInflater;

	public MyBaseAdapter(Context context, List<ContenBean> list) {
		mContext = context;
		mList = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ContentMsg contentMsg;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_messge_list, null);

			contentMsg = new ContentMsg();

			contentMsg.iconImg = (ImageView) convertView
					.findViewById(R.id.pic_img);
			contentMsg.textTitle = (TextView) convertView
					.findViewById(R.id.title_txt);
			contentMsg.textMessge = (TextView) convertView
					.findViewById(R.id.msg_txt);
			contentMsg.zekou = (TextView) convertView
					.findViewById(R.id.zekou_txt);
			contentMsg.pingfen = (TextView) convertView
					.findViewById(R.id.pingfen_txt);
			contentMsg.jiage = (TextView) convertView
					.findViewById(R.id.jiaqian_txt);

			convertView.setTag(contentMsg);

		} else {
			contentMsg = (ContentMsg) convertView.getTag();
		}

		ContenBean mContent = (ContenBean) getItem(position);
		contentMsg.iconImg.setBackgroundResource(mContent.getIcon());
		contentMsg.textTitle.setText(mContent.getTitle());
		contentMsg.textMessge.setText(mContent.getMessge());
		contentMsg.pingfen.setText(mContent.getPingfen());
		contentMsg.zekou.setText(mContent.getZekou());
		contentMsg.jiage.setText(mContent.getJiage());
		return convertView;
	}

	class ContentMsg {
		ImageView iconImg;
		TextView textTitle;
		TextView textMessge;
		TextView pingfen;
		TextView jiage;
		TextView zekou;
	}

}
