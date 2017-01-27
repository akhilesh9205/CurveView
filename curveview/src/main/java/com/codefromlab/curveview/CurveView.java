package com.codefromlab.curveview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * A Android View with Curved at Top.
 */
public class CurveView extends View {

    private Paint mPaint;


    public CurveView(Context context) {
        super(context);
        init();
    }


    public CurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int w = getWidth();
        int h = getHeight();

        int contentWidth = w - paddingLeft - paddingRight;
        int contentHeight = h - paddingTop - paddingBottom;

        // Draw curve
        double widthSquare = Math.pow(contentWidth, 2.0f);
        double heightSquare = Math.pow(contentHeight, 2.0f);
        float r = (float) ((widthSquare / 4.0f) + heightSquare) / (2.0f * contentHeight);
        canvas.drawCircle(contentWidth / 2.0f, r, r, mPaint);

    }


}
