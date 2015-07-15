package com.sc.android.meituan;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginLoadingActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_loading);
		LoadingDialog loadingDialog = new LoadingDialog(this, "正在登陆中......",
				R.anim.frame);
		loadingDialog.show();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(LoginLoadingActivity.this,
						PagerActivity.class));
				LoginLoadingActivity.this.finish();
			}
		}, 2000);
	}

	class LoadingDialog extends ProgressDialog {

		private AnimationDrawable mAnimation;
		private Context mContext;
		private ImageView mImageView;
		private String mLoadingTip;
		private TextView mLoadingTv;
		private int count = 0;
		private String oldLoadingTip;
		private int mResid;

		public LoadingDialog(Context context, String content, int id) {
			super(context);
			this.mContext = context;
			this.mLoadingTip = content;
			this.mResid = id;
			setCanceledOnTouchOutside(true);
		}

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			initView();
			initData();
		}

		private void initData() {
			mImageView.setBackgroundResource(mResid);
			// 通过ImageView对象拿到背景显示的AnimationDrawable
			mAnimation = (AnimationDrawable) mImageView.getBackground();
			// 为了防止在onCreate方法中只显示第一帧的解决方案之一
			mImageView.post(new Runnable() {
				@Override
				public void run() {
					mAnimation.start();

				}
			});
			mLoadingTv.setText(mLoadingTip);

		}

		public void setContent(String str) {
			mLoadingTv.setText(str);
		}

		private void initView() {
			setContentView(R.layout.login_loading);
			mLoadingTv = (TextView) findViewById(R.id.loadingTv);
			mImageView = (ImageView) findViewById(R.id.loadingIv);
		}
	}

}
