package com.sc.android.meituan;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sc.android.meituan.adapter.DataHelper;

public class ReisterActivity extends Activity {
	private EditText mUserName, mPassword1, mPassword2;
	private Button mConfirmbtn, mTestNameBtn;
	private LinearLayout mLinearLayout;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register_layout);

		mUserName = (EditText) findViewById(R.id.register_name_edit);
		mPassword1 = (EditText) findViewById(R.id.register_password1_edit);
		mPassword2 = (EditText) findViewById(R.id.register_password2_edit);

		mConfirmbtn = (Button) findViewById(R.id.confirm_btn);
		mTestNameBtn = (Button) findViewById(R.id.test_user_name_btn);

		mLinearLayout = (LinearLayout) findViewById(R.id.register_back_layout);

		DataHelper dbHelper = DataHelper.getInstanceDatabaseHelper(this);
		db = dbHelper.getReadableDatabase();

		// 注册确定按钮事件处理
		mConfirmbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!mUserName.getText().toString().equals("")
						&& !mPassword1.getText().toString().equals("")) {
					addAccount();

				} else {
					Toast.makeText(ReisterActivity.this, "注册信息不能为空！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 检测用户名是否存在
		mTestNameBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Cursor cursor = db.rawQuery(
						"select * from student where username = ?",
						new String[] { mUserName.getText().toString()});
				boolean flag = false;
				if (cursor.moveToFirst()) {
					flag = true;
					Toast.makeText(ReisterActivity.this, "您输入的用户名已存在，请重新输入！",
							Toast.LENGTH_SHORT).show();
					mUserName.setText("");
					return;
				}
				if (!flag) {
					Toast.makeText(ReisterActivity.this, "此用户名可以使用！",
							Toast.LENGTH_SHORT).show();

				}

				// while (cursor.moveToNext()) {
				// if (mUserName
				// .getText()
				// .toString()
				// .equals(cursor.getString(cursor
				// .getColumnIndex("username")))) {
				// flag = true;
				// Toast.makeText(ReisterActivity.this,
				// "您输入的用户名已存在，请重新输入！", Toast.LENGTH_SHORT).show();
				// mUserName.setText("");
				// }
				// }
				// if (!flag) {
				// Toast.makeText(ReisterActivity.this, "此用户名可以使用！",
				// Toast.LENGTH_SHORT).show();
				//
				// }
			}
		});

		// 返回登录窗口
		mLinearLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ReisterActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	// 将账号信息添加到数据库
	public void addAccount() {

		DataHelper dbHelper = DataHelper.getInstanceDatabaseHelper(this);
		db = dbHelper.getReadableDatabase();
		ContentValues contentValues = new ContentValues();

		if (mPassword1.getText().toString()
				.equals(mPassword2.getText().toString())) {
			contentValues.put("username", mUserName.getText().toString());
			contentValues.put("password", mPassword1.getText().toString());
			db.insert("student", null, contentValues);
			Toast.makeText(ReisterActivity.this, "注册成功！", Toast.LENGTH_SHORT)
					.show();

			Intent intent = new Intent();
			intent.setClass(ReisterActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();

		} else {
			Toast.makeText(ReisterActivity.this, "两次密码不一致，请重新输入！",
					Toast.LENGTH_SHORT).show();
			mPassword1.setText("");
			mPassword2.setText("");
		}

	}
}
