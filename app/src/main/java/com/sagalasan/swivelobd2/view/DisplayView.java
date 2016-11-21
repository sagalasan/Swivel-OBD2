package com.sagalasan.swivelobd2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by christiaan on 11/16/16.
 */

public class DisplayView extends GaugeView
{
  private static final String TAG = DisplayView.class.getName();

  public DisplayView(Context context)
  {
    super(context);
  }

  public DisplayView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
  }

  @Override
  public void onDraw(Canvas canvas)
  {
    super.onDraw(canvas);

    if (getWidth() == 0 || getHeight() == 0) return;

    displayText(canvas, "--.-- --");
  }

  private void displayText(Canvas canvas, String text)
  {
    canvas.drawText(text, getWidth() / 2, getHeight() / 2
            - (getTextPaint().ascent() + getTextPaint().descent()) / 2, getTextPaint());
  }
}
