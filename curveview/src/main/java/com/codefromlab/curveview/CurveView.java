package com.codefromlab.curveview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * A Android View with Curved at Top.
 */
public class CurveView extends View {

    private Paint mBorderPaint;
    private Paint mCurvePaint;
    private float mBorderWidth = 4;
    private int mBorderColor = Color.BLACK;
    private int mCurveColor = Color.WHITE;
    private int mCurveGravity = CurveGravity.TOP;

    public static class CurveGravity{
        public static final int TOP = 0;
        public static final int BOTTOM = 1;
    }

    public CurveView(Context context) {
        super(context);
        init(null, 0);
    }


    public CurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CurveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.CurveView, defStyle, 0);

        mBorderColor = a.getColor(R.styleable.CurveView_border_color, mBorderColor);
        mCurveColor = a.getColor(R.styleable.CurveView_curve_color, mCurveColor);
        mBorderWidth = a.getDimension(R.styleable.CurveView_border_width, mBorderWidth);
        mCurveGravity = a.getInt(R.styleable.CurveView_curve_gravity, CurveGravity.TOP);
        a.recycle();

        mCurvePaint = new Paint();
        mCurvePaint.setColor(mCurveColor);
        mCurvePaint.setStyle(Paint.Style.FILL);
        mCurvePaint.setAntiAlias(true);

        mBorderPaint = new Paint();
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setAntiAlias(true);

    }

    private void invalidateTextPaintAndMeasurements() {
        mCurvePaint.setColor(mCurveColor);
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        invalidate();
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

        double widthSquare = Math.pow(contentWidth, 2.0f);
        double heightSquare = Math.pow(contentHeight, 2.0f);
        float r = (float) ((widthSquare / 4.0f) + heightSquare) / (2.0f * contentHeight);

        if (mCurveGravity == CurveGravity.TOP) {
            // draw curve
            canvas.drawCircle(contentWidth / 2.0f, r, r, mCurvePaint);

            // draw curve border
            canvas.drawCircle(contentWidth / 2.0f, r, r - (mBorderWidth / 2.0f), mBorderPaint);
        } else if (mCurveGravity == CurveGravity.BOTTOM) {

            // draw curve
            canvas.drawCircle(contentWidth / 2.0f, -(r - contentHeight), r, mCurvePaint);

            // draw curve border
            canvas.drawCircle(contentWidth / 2.0f, -(r - contentHeight), r - (mBorderWidth / 2.0f), mBorderPaint);
        }else{
            // draw curve
            canvas.drawCircle(contentWidth / 2.0f, r, r, mCurvePaint);

            // draw curve border
            canvas.drawCircle(contentWidth / 2.0f, r, r - (mBorderWidth / 2.0f), mBorderPaint);
        }




    }

    public int getCurveGravity() {
        return mCurveGravity;
    }

    public void setCurveGravity(int mCurveGravity) {
        this.mCurveGravity = mCurveGravity;
        invalidateTextPaintAndMeasurements();
    }

    public float getBorderWidth() {
        return mBorderWidth;
    }

    public void setBorderWidth(float mBorderWidth) {
        this.mBorderWidth = mBorderWidth;
        invalidateTextPaintAndMeasurements();
    }

    public int getCurveColor() {
        return mCurveColor;
    }

    public void setCurveColor(int mCurveColor) {
        this.mCurveColor = mCurveColor;
        invalidateTextPaintAndMeasurements();
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public void setBorderColor(int mBorderColor) {
        this.mBorderColor = mBorderColor;
        invalidateTextPaintAndMeasurements();
    }
}
