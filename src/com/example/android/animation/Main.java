package com.example.android.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {
	private Object[] activities = {
		"Alpha Example",		AlphaAnimationExample.class,
		"Rotate Example",		RotateAnimationExample.class,
		"Scale Example",		ScaleAnimationExample.class,
		"Translate Example",	TranslateAnimationExample.class,
		"Set Example",			AnimationSetExample.class,
		"Animation Options",	OptionExample.class,
		"XML Example",			XmlExample.class,
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		CharSequence[] list = new CharSequence[activities.length / 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = (String)activities[i * 2];
		}
		
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		
		LinearLayout layout = new LinearLayout(this);
		ListView listView = new ListView(this);
		layout.addView(listView);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(Main.this, (Class<?>)activities[position * 2 + 1]);
				startActivity(intent);
			}
		});
		setContentView(layout);
	}
}
