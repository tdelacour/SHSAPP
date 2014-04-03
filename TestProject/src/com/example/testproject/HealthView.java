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
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(2);
		c.drawRect(10, 10, 110, 40, paint);	
	
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL);
		c.drawRect(12, 12, 10 + pregnancy, 38, paint);
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
