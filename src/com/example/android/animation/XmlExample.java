package com.example.android.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class XmlExample extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		addButton(layout, "Alpha");
		addButton(layout, "Rotate");
		addButton(layout, "Scale");
		addButton(layout, "Translate");
		addButton(layout, "Set");
		setContentView(layout);
	}
	
	private void addButton(LinearLayout layout, String text) {
		Button button = new Button(this);
		button.setText(text);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation animation = null;
				if (((Button)v).getText().equals("Alpha")) {
					animation = AnimationUtils.loadAnimation(XmlExample.this, R.anim.alpha);
				} else if (((Button)v).getText().equals("Rotate")) {
					animation = AnimationUtils.loadAnimation(XmlExample.this, R.anim.rotate);
				} else if (((Button)v).getText().equals("Scale")) {
					animation = AnimationUtils.loadAnimation(XmlExample.this, R.anim.scale);
				} else if (((Button)v).getText().equals("Translate")) {
					animation = AnimationUtils.loadAnimation(XmlExample.this, R.anim.translate);
				} else if (((Button)v).getText().equals("Set")) {
					animation = AnimationUtils.loadAnimation(XmlExample.this, R.anim.set);
				}
				v.startAnimation(animation);
			}
		});
		layout.addView(button);
	}
}
