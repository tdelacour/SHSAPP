package com.example.testproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
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
		legal = 20;
		std = 80;
	}
	
	@Override
	public void onDraw(Canvas c){
		int red; int green; 
		int left = getPaddingLeft();
		int top = getPaddingTop();
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(20);
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		
		//Color for pregnancy
		red = (int)((100 - pregnancy) * 1.75);
		green = (int)(pregnancy * 1.75);	
		paint.setColor(Color.rgb(red, green, 0));
		
		//Draw pregnancy rectangle
		c.drawRect(left, top, left + 2*pregnancy + 2, top + 30, paint);
		paint.setColor(Color.rgb(51, 181, 229));
		c.drawText("Pregnancy", left + 2, top + 23, paint);
		
		//legal
		red = (int)((100 - legal) * 1.75);
		green = (int)(legal * 1.75);	
		paint.setColor(Color.rgb(red, green, 0));
		c.drawRect(left, top + 50, left + 2*legal + 2, top + 80, paint);
		paint.setColor(Color.rgb(51, 181, 229));
		c.drawText("Rape", left + 2, top + 73, paint);
		
		//std
		red = (int)((100 - std) * 1.75);
		green = (int)(std * 1.75);	
		paint.setColor(Color.rgb(red, green, 0));
		c.drawRect(left, top + 100, left + 2*std + 2, top + 130, paint);
		paint.setColor(Color.rgb(51, 181, 229));
		c.drawText("STD", left + 2, top + 123, paint);
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
	
	//yay google...
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

	    int desiredWidth = 220;
	    int desiredHeight = 200;

	    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
	    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	    int width;
	    int height;

	    //Measure Width
	    if (widthMode == MeasureSpec.EXACTLY) {
	        width = widthSize;
	    } else if (widthMode == MeasureSpec.AT_MOST) {
	        width = Math.min(desiredWidth, widthSize);
	    } else {
	        width = desiredWidth;
	    }

	    //Measure Height
	    if (heightMode == MeasureSpec.EXACTLY) {
	        height = heightSize;
	    } else if (heightMode == MeasureSpec.AT_MOST) {
	        height = Math.min(desiredHeight, heightSize);
	    } else {
	        height = desiredHeight;
	    }

	    setMeasuredDimension(width, height);
	}
}
