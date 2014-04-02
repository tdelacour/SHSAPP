package com.example.testproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class HealthView extends View {
	
	private int pregnancy;
	private int std;
	private int legal;
	private Paint paint = new Paint();
	
	public HealthView(Context context) {
		super(context);
		init();
	}

	public HealthView(Context context, AttributeSet as) {
		super(context, as);
		init();
	}
	
	private void init(){
		pregnancy = 50;
		std = 50;
		legal = 50;
	}
	
	public void onDraw(Canvas c){
		paint.setColor(Color.RED);
		c.drawRect(10, 10, 50, 20, paint);	
	}
	
	public void updatePreg(int x){
		pregnancy += x;
	}
	
	public void updateSTD(int x){
		std += x;
	}
	
	public void updateLegal(int x){
		legal += x;
	}
}
