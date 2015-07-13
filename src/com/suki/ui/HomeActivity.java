package com.suki.ui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.suki.adapter.BannerAdapter;
import com.suki.adapter.GridViewAdapter;
import com.suki.widget.MyGridView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class HomeActivity extends Activity {

	/**
	 * ��ͼ
	 */
	private ViewPager viewPager;
	/**
	 * ������
	 */
	private ViewGroup group;
	/**
	 * ����ͼ������
	 */
	private ImageView[] images;

	private int[] im = new int[] { R.drawable.t0, R.drawable.t1, R.drawable.t2,
			R.drawable.t3 };
	private MyGridView hotgridview;

	private MyGridView catgridview;
	/**
	 * ��ǰ��ʾ��ͼƬid
	 */
	private int currentItem = 0;

	private ScheduledExecutorService scheduledExecutorService;
	// �л���ǰ��ʾ��ͼƬ
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			viewPager.setCurrentItem(currentItem);// �л���ǰ��ʾ��ͼƬ
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		init();
		// ��ʼ����б���
		initListNavigation();
		viewPager.setAdapter(new BannerAdapter(this));
		viewPager.setOnPageChangeListener(new pagerListener());
	}

	private void initListNavigation() {
		int num = im.length;
		images = new ImageView[num];
		for (int i = 0; i < num; i++) {
			images[i] = new ImageView(this);
			images[i].setLayoutParams(new LayoutParams(20, 20));
			images[i].setPadding(40, 0, 40, 0);
			if (i == 0) {
				images[i].setBackgroundResource(R.drawable.dotchecked);
			} else {
				images[i].setBackgroundResource(R.drawable.dotdefault);
			}
			group.addView(images[i]);
		}
	}

	private void init() {
		// ������
		group = (ViewGroup) findViewById(R.id.viewGroup);
		// ���
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		hotgridview = (MyGridView) findViewById(R.id.hotgridview);
		int[] images = new int[] { R.drawable.t5, R.drawable.t6, R.drawable.t7,
				R.drawable.t8, R.drawable.t9, R.drawable.t10 };
		hotgridview.setAdapter(new GridViewAdapter(this, images));

		catgridview = (MyGridView) findViewById(R.id.catgridview);
		int[] images2 = new int[] { R.drawable.t11, R.drawable.t12,
				R.drawable.t15, R.drawable.t14 };
		catgridview.setAdapter(new GridViewAdapter(this, images2));
	}

	private class pagerListener implements OnPageChangeListener {
		private int oldPosition = 0;

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int position) {
			currentItem = position;
			images[position].setBackgroundResource(R.drawable.dotchecked);
			images[oldPosition].setBackgroundResource(R.drawable.dotdefault);
			oldPosition = position;
		}
	}

	/**
	 * �����л�����
	 * 
	 * @author Administrator
	 * 
	 */
	private class ScrollTask implements Runnable {

		public void run() {
			synchronized (viewPager) {
				currentItem = (currentItem + 1) % images.length;
				handler.obtainMessage().sendToTarget(); // ͨ��Handler�л�ͼƬ
			}
		}

	}

	@Override
	protected void onStart() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// ��Activity��ʾ������ÿ�������л�һ��ͼƬ��ʾ
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
				TimeUnit.SECONDS);
		super.onStart();
	}

	@Override
	protected void onStop() {
		// ��Activity���ɼ���ʱ��ֹͣ�л�
		scheduledExecutorService.shutdown();
		super.onStop();
	}
}
