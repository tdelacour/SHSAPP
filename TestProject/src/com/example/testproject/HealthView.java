package com.example.testproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class HealthView extends View {
	
	private int alcohol;
	private int sexual;
	private int screenHeight;
	private int screenWidth;	
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
		alcohol = 50;
		sexual = 50;
	}
	
	@Override
	public void onDraw(Canvas c){
		int red; int green; 
		int left = getPaddingLeft(); //offset from edge
		int top = getPaddingTop(); //offset from edge
		int height = screenHeight/30; //height of health fill
		int spacer = screenHeight/50; //height of space btwn bars
		int width = screenWidth/3; //width of health fill max
		int widthAlc = width*alcohol/100; //width of health fill Alcohol
		int widthSex = width*sexual/100; //width of health fill sexual
		int ovalSize = width/5; //width of oval which creates cap ends
		int borderVer = height/10; //width of border
		int borderHor = ovalSize/2; //width of the healthbar cap ends
		
		//Some calculations
		int fillLeft = left + borderHor;
		int alcFillTop = top + borderVer;
		int alcFillRight = fillLeft + widthAlc;
		int alcFillBot = top + borderVer + height;
		int alcEmptyRight = fillLeft + width;
		int oval1Right = left + ovalSize;
		int alcOval1Bot = top + height + 2*borderVer;
		int oval2Left = left + width;
		int oval2Right = oval2Left + ovalSize;
		int borderWidth = left + width + borderHor;
		int border1Bot = top + borderVer;
		int border2Top = top + height + borderVer;
		int border2Bot = top + height + 2*borderVer;
		int sexFillTop = top + 3*borderVer + height + spacer;
		int sexFillRight = fillLeft + widthSex;
		int sexFillBot = top + 2*height + 3*borderVer + spacer;
		int sexEmptyRight = left + borderHor + width;
		int oval3Bot = top + 2*height + spacer + 4*borderVer;
		int border3Top = top + height + spacer + 3*borderVer;
		int border3Bot = top + height + spacer + 4*borderVer;
		int border4Top = top + 2*height + spacer + 3*borderVer;
		int border4Bot = top + 2*height+ spacer + 4*borderVer;
		
		//Universal
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(25);
		paint.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
		
		//Color for alcohol
		red = (int)((100 - alcohol) * 1.75);
		green = (int)(alcohol * 1.75);	
		paint.setColor(Color.rgb(red, green, 0)); //***Color Tag***
		
		//Draw alcohol health fill
		c.drawRect(fillLeft, alcFillTop, alcFillRight, alcFillBot, paint);
		paint.setColor(Color.rgb(51, 181, 229)); //***Color Tag***
		c.drawRect(alcFillRight,  alcFillTop, alcEmptyRight, alcFillBot, paint);
		
		//label
		paint.setColor(Color.BLACK);
		c.drawText("Alcohol Safety", fillLeft + height, alcFillBot - 3*borderVer, paint);
		
		//Shell
		paint.setColor(Color.DKGRAY); //**Color Tag***
		RectF oval = new RectF(left, top, oval1Right, alcOval1Bot);
		c.drawArc(oval, 90, 180, true, paint);
		oval = new RectF(oval2Left, top, oval2Right, alcOval1Bot);
		c.drawArc(oval, 270, 180, true, paint);
		c.drawRect(fillLeft, top, borderWidth, border1Bot, paint);
		c.drawRect(fillLeft, border2Top, borderWidth, border2Bot, paint);
		
		//sexual
		red = (int)((100 - sexual) * 1.75);
		green = (int)(sexual * 1.75);	
		paint.setColor(Color.rgb(red, green, 0)); //***Color Tag***
		c.drawRect(fillLeft, sexFillTop, sexFillRight, sexFillBot, paint);
		paint.setColor(Color.rgb(51, 181, 229)); //***Color Tag***
		c.drawRect(sexFillRight, sexFillTop, sexEmptyRight, sexFillBot, paint);
		paint.setColor(Color.BLACK);
		c.drawText("Sexual Health", fillLeft + height, sexFillBot - 3*borderVer, paint);
		paint.setColor(Color.DKGRAY); //***Color Tag***
		oval = new RectF(left, sexFillTop, oval1Right, oval3Bot);
		c.drawArc(oval, 90, 180, true, paint);
		oval = new RectF(oval2Left, sexFillTop, oval2Right, oval3Bot);
		c.drawArc(oval, 270, 180, true, paint);
		c.drawRect(fillLeft, border3Top, borderWidth, border3Bot, paint);
		c.drawRect(fillLeft, border4Top, borderWidth, border4Bot, paint);
	}
	
	public void updateAlcohol(int x){
		alcohol += x;
		if (alcohol < 0) alcohol = 0;
		if (alcohol > 100) alcohol = 100;
	}
	
	public void updateSexual(int x){
		sexual += x;
		if (sexual < 0) sexual = 0;
		if (sexual > 100) sexual = 100;
	}
	
	public void updateAll(int[] x){
		updateAlcohol(x[0]);
		updateSexual(x[1] + x[2] + x[3]);
	}
	
	public void setDimension(Point dim){
		screenWidth = dim.x;
		screenHeight = dim.y;
	}
	
	//yay google...
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

	    int desiredWidth = getPaddingLeft() + 2*screenWidth/5;
	    int desiredHeight = screenHeight/7;

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
