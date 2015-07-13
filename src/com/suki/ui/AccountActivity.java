package com.suki.ui;

import com.suki.util.ImageUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class AccountActivity extends Activity {
	private ImageView imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide_account);
		init();
	}

	private void init() {
		imageview = (ImageView) findViewById(R.id.tf_pic);
		Bitmap temp = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.t20);
		Bitmap bitmap = ImageUtil.getRoundedCornerBitmap(temp);
		imageview.setBackgroundDrawable(new BitmapDrawable(bitmap));
	}
}
