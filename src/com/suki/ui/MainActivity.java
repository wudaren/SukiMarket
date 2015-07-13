package com.suki.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends TabActivity {

	private long mExitTime;

	private TabHost tabHost;
	/**
	 * 动画图片
	 */
	private ImageView mTabImg;
	/**
	 * 动画图片偏移量
	 */
	private int zero = 0;
	/**
	 * 第一个水平动画平移大小
	 */
	private int one = 0;
	/**
	 * 当前页卡编号
	 */
	private int currIndex = 0;
	private Animation animation;
	private RadioButton guide_home, guide_tfaccount, guide_account, guide_cart,
			guide_logistics, guide_ww;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initTab();
		init();
	}

	private void initTab() {
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec("guide_home")
				.setIndicator("guide_home")
				.setContent(new Intent(this, HomeActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("guide_tfaccount")
				.setIndicator("guide_tfaccount")
				.setContent(new Intent(this, TFaccountActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("guide_account")
				.setIndicator("guide_account")
				.setContent(new Intent(this, AccountActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("guide_cart")
				.setIndicator("guide_cart")
				.setContent(new Intent(this, CartActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("guide_logistics")
				.setIndicator("guide_logistics")
				.setContent(new Intent(this, LogisticsActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("guide_ww").setIndicator("guide_ww")
				.setContent(new Intent(this, WWActivity.class)));
	}

	private void init() {
		mTabImg = (ImageView) findViewById(R.id.img_tab_now);
		Display currDisplay = getWindowManager().getDefaultDisplay();// 获取屏幕当前分辨率
		int displayWidth = currDisplay.getWidth();
		one = displayWidth / 6;

		guide_home = (RadioButton) findViewById(R.id.guide_home);
		guide_tfaccount = (RadioButton) findViewById(R.id.guide_tfaccount);
		guide_account = (RadioButton) findViewById(R.id.guide_account);
		guide_cart = (RadioButton) findViewById(R.id.guide_cart);
		guide_logistics = (RadioButton) findViewById(R.id.guide_logistics);
		guide_ww = (RadioButton) findViewById(R.id.guide_ww);
		guide_home.setOnClickListener(new MyOnPageChangeListener());
		guide_tfaccount.setOnClickListener(new MyOnPageChangeListener());
		guide_account.setOnClickListener(new MyOnPageChangeListener());
		guide_cart.setOnClickListener(new MyOnPageChangeListener());
		guide_logistics.setOnClickListener(new MyOnPageChangeListener());
		guide_ww.setOnClickListener(new MyOnPageChangeListener());
	}

	private class MyOnPageChangeListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			animation = null;
			switch (v.getId()) {
			case R.id.guide_home:
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(one * 2, 0, 0, 0);
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(one * 3, 0, 0, 0);
				} else if (currIndex == 4) {
					animation = new TranslateAnimation(one * 4, 0, 0, 0);
				} else if (currIndex == 5) {
					animation = new TranslateAnimation(one * 5, 0, 0, 0);
				}
				currIndex = 0;
				tabHost.setCurrentTabByTag("guide_home");
				break;
			case R.id.guide_tfaccount:
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(one * 2, one, 0, 0);
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(one * 3, one, 0, 0);
				} else if (currIndex == 4) {
					animation = new TranslateAnimation(one * 4, one, 0, 0);
				} else if (currIndex == 5) {
					animation = new TranslateAnimation(one * 5, one, 0, 0);
				}
				currIndex = 1;
				tabHost.setCurrentTabByTag("guide_tfaccount");
				break;
			case R.id.guide_account:
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one * 2, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, one * 2, 0, 0);
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(one * 3, one * 2, 0, 0);
				} else if (currIndex == 4) {
					animation = new TranslateAnimation(one * 4, one * 2, 0, 0);
				} else if (currIndex == 5) {
					animation = new TranslateAnimation(one * 5, one * 2, 0, 0);
				}
				currIndex = 2;
				tabHost.setCurrentTabByTag("guide_account");
				break;
			case R.id.guide_cart:
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one * 3, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, one * 3, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(one * 2, one * 3, 0, 0);
				} else if (currIndex == 4) {
					animation = new TranslateAnimation(one * 4, one * 3, 0, 0);
				} else if (currIndex == 5) {
					animation = new TranslateAnimation(one * 5, one * 3, 0, 0);
				}
				currIndex = 3;
				tabHost.setCurrentTabByTag("guide_cart");
				break;
			case R.id.guide_logistics:
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one * 4, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, one * 4, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(one * 2, one * 4, 0, 0);
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(one * 3, one * 4, 0, 0);
				} else if (currIndex == 5) {
					animation = new TranslateAnimation(one * 5, one * 4, 0, 0);
				}
				currIndex = 4;
				tabHost.setCurrentTabByTag("guide_logistics");
				break;
			case R.id.guide_ww:
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one * 5, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, one * 5, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(one * 2, one * 5, 0, 0);
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(one * 3, one * 5, 0, 0);
				} else if (currIndex == 4) {
					animation = new TranslateAnimation(one * 5, one * 5, 0, 0);
				}
				currIndex = 5;
				tabHost.setCurrentTabByTag("guide_ww");
				break;
			}
			if (animation != null) {
				animation.setFillAfter(true);// True:图片停在动画结束位置
				animation.setDuration(150);
				mTabImg.startAnimation(animation);
			}
		}

	}

	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				if (currIndex != 0) {
					new MyOnPageChangeListener().onClick(guide_home);
					guide_home.setChecked(true);
				} else {
					if ((System.currentTimeMillis() - mExitTime) > 2000) {// 如果两次按键时间间隔大于2000毫秒，则不退出
						Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT)
								.show();
						mExitTime = System.currentTimeMillis();// 更新mExitTime
					} else {

						int id = android.os.Process.myPid();
						if (id != 0) {
							android.os.Process.killProcess(id);
						}
					}
				}
				return true;
			}
		}

		return super.dispatchKeyEvent(event);

	}
}