package com.sc.android.meituan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sc.android.meituan.adapter.DataHelper;

public class LoginActivity extends Activity implements OnClickListener {
	private Button mLoginBtn;
	private EditText mUserNameEdit, mPassWordEdit;
	private ImageView mUserNameClear, mPassWordClear;
	private TextView mPhoneRegistertxt, mRegisterTxt;
	private CheckBox mRememberPassWord, mAutomaticLogin;
	private long exitTime = 0;
	private SQLiteDatabase db;
	private SharedPreferences mPreference;
	private static final String PREFERENCE = "com.sc.android.meituan_PREFERENCE_REMEMBER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_layout);

		// 实例化布局上面应用的控件
		mLoginBtn = (Button) findViewById(R.id.login_btn);

		mUserNameEdit = (EditText) findViewById(R.id.login_username_edit);
		mPassWordEdit = (EditText) findViewById(R.id.login_password_edit);

		mUserNameClear = (ImageView) findViewById(R.id.username_clear_img);
		mPassWordClear = (ImageView) findViewById(R.id.password_clear_img);

		mPhoneRegistertxt = (TextView) findViewById(R.id.login_byphone_txt);
		mRegisterTxt = (TextView) findViewById(R.id.register_txt);

		mRememberPassWord = (CheckBox) findViewById(R.id.remember_password);
		mAutomaticLogin = (CheckBox) findViewById(R.id.automatic_login);

		// 实例化SharedPreferences
		mPreference = getSharedPreferences(PREFERENCE, this.MODE_PRIVATE);
		if (mPreference != null) {
			// 记住了密码
			if (mPreference.getBoolean("isrmb", false) == true) {
				mUserNameEdit.setText(mPreference.getString("name", null));
				mPassWordEdit.setText(mPreference.getString("pass", null));
				mRememberPassWord.setChecked(true);
			}
			if (mPreference.getBoolean("islgs", false) == true) {
				mAutomaticLogin.setChecked(true);
				new Thread() {
					public void run() {

						Intent intent2 = new Intent(LoginActivity.this,
								LoginLoadingActivity.class);
						startActivity(intent2);

					}
				}.start();
			}
		}
		mRememberPassWord
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (mRememberPassWord.isChecked() == false) {
							mAutomaticLogin.setChecked(false);
						}
					}
				});
		mAutomaticLogin
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						mRememberPassWord.setChecked(true);
					}
				});
		// String username = mPreference.getString("USERNAME", "");
		// String password = mPreference.getString("PASSWORD", "");
		//
		// boolean choseMRememberPassWord = mPreference.getBoolean(
		// "mRememberPassWord", false);
		// boolean choseMAutomaticLogin = mPreference.getBoolean(
		// "mAutomaticLogin", false);
		//
		// Log.v("tag", "choseMRememberPassWord  >> :" +
		// choseMRememberPassWord);
		// // 如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
		// if (choseMRememberPassWord) {
		// mUserNameEdit.setText(username);
		// mPassWordEdit.setText(password);
		// mRememberPassWord.setChecked(true);
		// }
		// // 如果上次登录选了自动登录，那进入登录页面也自动勾选自动登录
		// if (choseMAutomaticLogin) {
		// mAutomaticLogin.setChecked(true);
		// }
		// 登录按钮监听事件设置
		mLoginBtn.setOnClickListener(this);

		// 点击清除用户名输入的内容
		mUserNameClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mUserNameEdit.setText("");
			}
		});

		// 点击清除密码输入的内容
		mPassWordClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mPassWordEdit.setText("");
			}
		});

		mUserNameEdit.addTextChangedListener(new TextWatcher() {

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
					mUserNameClear.setVisibility(View.VISIBLE);
				} else {
					mUserNameClear.setVisibility(View.INVISIBLE);
				}
			}
		});

		mPassWordEdit.addTextChangedListener(new TextWatcher() {

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
					mPassWordClear.setVisibility(View.VISIBLE);
				} else {
					mPassWordClear.setVisibility(View.INVISIBLE);
				}
			}
		});

		// 注册点击事件处理
		mRegisterTxt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, ReisterActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 手机号码快捷登录点击事件处理
		mPhoneRegistertxt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this,
						RegisterByPhoneActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	// 登录按钮点击事件处理
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn:
			String userName = mUserNameEdit.getText().toString();
			String passWord = mPassWordEdit.getText().toString();

			if (userName.equals("") || passWord.equals("")) {
				Toast.makeText(this, "用户名、密码不为空！", Toast.LENGTH_SHORT).show();
				return;
			}

			DataHelper dbHelper = DataHelper.getInstanceDatabaseHelper(this);
			db = dbHelper.getReadableDatabase();// 如果数据库存在就打开此数据库,否则就创建数据库

			boolean sucessFlag = false;
			Cursor cursor = db.query("student", null, null, null, null, null,
					null, null);
			while (cursor.moveToNext()) {

				String name = cursor.getString(cursor
						.getColumnIndex("username"));
				String word = cursor.getString(cursor
						.getColumnIndex("password"));

				if (userName.equals(name) && passWord.equals(word)) {

					sucessFlag = true;
					if (mAutomaticLogin.isChecked()) {
						mPreference
								.edit()
								.putBoolean("isrmb", true)
								.putBoolean("islgs", true)
								.putString("name",
										mUserNameEdit.getText().toString())
								.putString("pass",
										mPassWordEdit.getText().toString())
								.commit();
					} else {
						if (mRememberPassWord.isChecked()) {
							mPreference
									.edit()
									.putBoolean("isrmb", true)
									.putBoolean("islgs", false)
									.putString("name",
											mUserNameEdit.getText().toString())
									.putString("pass",
											mPassWordEdit.getText().toString())
									.commit();
						} else {
							mPreference
									.edit()
									.putBoolean("isrmb", false)
									.putBoolean("islgs", false)
									.putString("name",
											mUserNameEdit.getText().toString())
									.putString("pass",
											mPassWordEdit.getText().toString())
									.commit();
						}
					}
					Intent intent = new Intent(LoginActivity.this,
							LoginLoadingActivity.class);
					startActivity(intent);
					// saveMessge();
					// Intent intent = new Intent();
					// intent.setClass(LoginActivity.this,
					// LoginLoadingActivity.class);
					// startActivity(intent);
					// finish();

				}

			}

			if (!sucessFlag) {
				Toast.makeText(this, "用户名或密码错误，请重新登录！", Toast.LENGTH_SHORT)
						.show();
				mUserNameEdit.setText("");
				mPassWordEdit.setText("");
			}
		}
	}

	// 保存登录状态
	public void saveMessge() {
		SharedPreferences.Editor editor = mPreference.edit();
		String userName = mUserNameEdit.getText().toString();
		String passWord = mPassWordEdit.getText().toString();
		// 保存用户名和密码
		editor.putString("USERNAME", userName);
		editor.putString("PASSWORD", passWord);

		// 是否记住密码
		if (mRememberPassWord.isChecked()) {
			editor.putBoolean("mRememberPassWord", true);
		} else {
			editor.putBoolean("mRememberPassWord", false);
		}

		// 是否自动登录
		if (mAutomaticLogin.isChecked()) {
			editor.putBoolean("mAutomaticLogin", true);
		} else {
			editor.putBoolean("mAutomaticLogin", false);
		}
		editor.commit();

	}

	// 关闭数据库
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (db != null) {
			if (db.isOpen()) {
				db.close();
				db = null;
			}
		}
	}

	// 返回键点击事件处理
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
