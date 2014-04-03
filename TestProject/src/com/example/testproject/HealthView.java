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
	
	@Override
	public void onDraw(Canvas c){
		//retrieve padding values
		int top = getPaddingTop();
		int border = 5;
		
		//draw border
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(border);
		c.drawRect(0, top, 100 + 2*border, top + 30, paint);	
	
		//draw fill
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL);
		c.drawRect(0, top + border, border + pregnancy, top + 30 - border, paint);
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

	    int desiredWidth = 200;
	    int desiredHeight = 160;

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
