package com.sagalasan.swivelobd2.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by christiaan on 11/9/16.
 */

public abstract class GaugeView extends CardView
{
  private static final String TAG = GaugeView.class.getName();

  public static final float DEFAULT_MIN = 0;
  public static final float DEFAULT_MAX = 100;
  public static final float DEFAULT_VALUE = 0;

  private boolean isInitMode = false;

  private Paint backGroundPaint;
  private Paint gaugePaint;
  private Paint textPaint;

  public GaugeView(Context context)
  {
    super(context);
    init();
  }

  public GaugeView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    init();
  }

  public Paint getTextPaint()
  {
    return textPaint;
  }

  public Paint getBackGroundPaint()
  {
    return backGroundPaint;
  }

  public Paint getGaugePaint()
  {
    return gaugePaint;
  }

  @Override
  public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
  {
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    int width;
    int height;

    if(widthMode == MeasureSpec.EXACTLY)
    {
      Log.d(TAG, "Width exactly " + widthSize);
      width = widthSize;
    }
    else if(widthMode == MeasureSpec.AT_MOST)
    {
      Log.d(TAG, "Width at most " + widthSize);
      width = widthSize;
    }
    else width = -1;

    if(heightMode == MeasureSpec.EXACTLY)
    {
      Log.d(TAG, "Height exactly " + heightSize);
      height = heightSize;
    }
    else if(heightMode == MeasureSpec.AT_MOST)
    {
      Log.d(TAG, "Height at most " + heightSize);
      height = heightSize;
    }
    else height = -1;

    if(width >= 0 && height >= 0) { }
    else if(width >= 0)
    {
      height = width;
    }
    else if(height >= 0)
    {
      width = height;
    }
    else
    {
      width = 0;
      height = 0;
    }

    int dimension = Math.min(width, height) - 8;

    setMeasuredDimension(dimension, dimension);
  }

  private void init()
  {
    gaugePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    gaugePaint.setStyle(Paint.Style.FILL);
    gaugePaint.setColor(0x000000);

    textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    textPaint.setColor(Color.BLACK);
    textPaint.setTextAlign(Paint.Align.CENTER);
    textPaint.setTextSize(200f);

    backGroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    backGroundPaint.setStyle(Paint.Style.FILL);
    //backGroundPaint.setColor(Color.GRAY);
  }
}
