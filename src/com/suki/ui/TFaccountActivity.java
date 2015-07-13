package com.suki.ui;

import com.suki.adapter.TFaccountAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TFaccountActivity extends Activity {
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide_tfaccount);
		listview = (ListView)findViewById(R.id.listView);
		listview.setAdapter(new TFaccountAdapter(this));
	}
}
