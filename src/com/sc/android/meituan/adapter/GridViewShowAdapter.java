package com.sc.android.meituan.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sc.android.meituan.R;
import com.sc.android.meituan.bean.MessgeBean;

public class GridViewShowAdapter extends BaseAdapter {
	private List<MessgeBean> mList = new ArrayList<MessgeBean>();;
	private LayoutInflater mInflater;

	public GridViewShowAdapter(Context context, List<MessgeBean> list) {
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
		ContentMessge content;
		if (convertView == null) {

			convertView = mInflater.inflate(R.layout.item_gridview_show, null);

			content = new ContentMessge();

			content.iconImg = (ImageView) convertView
					.findViewById(R.id.gridview_img);
			content.textTitle = (TextView) convertView
					.findViewById(R.id.girdview_txt);

			convertView.setTag(content);
		} else {
			content = (ContentMessge) convertView.getTag();
		}

		MessgeBean msgBean = (MessgeBean) getItem(position);
		content.iconImg.setBackgroundResource(msgBean.getIcon());
		content.textTitle.setText(msgBean.getTitle());
		return convertView;
	}

	class ContentMessge {
		ImageView iconImg;
		TextView textTitle;
	}

}
