package com.suki.adapter;

import com.suki.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TFaccountAdapter extends BaseAdapter {
	private int[] images = new int[] { R.drawable.t19, R.drawable.t17,
			R.drawable.t18, R.drawable.t16 };
	private Context context;

	public TFaccountAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return images.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TFaccountViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.tfaccount_item, null);
			holder = new TFaccountViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (TFaccountViewHolder) convertView.getTag();
		}
		holder.getImageView().setBackgroundResource(images[position]);
		return convertView;
	}

	private class TFaccountViewHolder {
		private ImageView imageview;
		private TextView title;
		private TextView date;
		private TextView time;
		private TextView pinluntext;
		private TextView text;
		private View view;

		private RelativeLayout bg;

		private TFaccountViewHolder(View view) {
			this.view = view;
		}

		ImageView getImageView() {
			if (imageview == null) {
				imageview = (ImageView) view.findViewById(R.id.imageview);
			}
			return imageview;
		}
	}
}
