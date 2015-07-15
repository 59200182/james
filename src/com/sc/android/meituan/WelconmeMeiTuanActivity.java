package com.sc.android.meituan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class WelconmeMeiTuanActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.item_welcome_meituan);
		startActivityByPostDelayed();
	}

	public void startActivityByPostDelayed() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(WelconmeMeiTuanActivity.this,
						LoginActivity.class));
				WelconmeMeiTuanActivity.this.finish();
			}
		}, 2000);
	}
}
