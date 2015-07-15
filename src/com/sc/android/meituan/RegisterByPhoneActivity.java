package com.sc.android.meituan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class RegisterByPhoneActivity extends Activity {
	private LinearLayout mLinearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_registerbyphone_layout);
		mLinearLayout = (LinearLayout) findViewById(R.id.phone_back_layout);

		mLinearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(RegisterByPhoneActivity.this,
						LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
