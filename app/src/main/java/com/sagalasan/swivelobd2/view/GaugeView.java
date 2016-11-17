package com.sagalasan.swivelobd2.view;

import android.content.Context;
import android.graphics.Canvas;
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

  private Paint gaugePaint;
  private Paint textPaint;

  public GaugeView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    init();
  }

  private void init()
  {
    gaugePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    gaugePaint.setStyle(Paint.Style.FILL);
    gaugePaint.setColor(0xffff00);

    textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    textPaint.setColor(Color.BLACK);
    textPaint.setTextSize(50f);
  }
}
