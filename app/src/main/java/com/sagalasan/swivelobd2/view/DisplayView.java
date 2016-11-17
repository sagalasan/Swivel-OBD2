package com.sagalasan.swivelobd2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by christiaan on 11/16/16.
 */

public class DisplayView extends GaugeView
{
  public DisplayView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
  }

  @Override
  public void onDraw(Canvas canvas)
  {
    super.onDraw(canvas);

    if (getWidth() == 0 || getHeight() == 0) return;

    //canvas.drawText("hei", 100, 100, textPaint);
  }
}
