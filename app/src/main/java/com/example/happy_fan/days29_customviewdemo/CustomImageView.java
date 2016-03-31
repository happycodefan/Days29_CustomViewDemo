package com.example.happy_fan.days29_customviewdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Happy_Fan on 2016.3.29.
 */
public class CustomImageView extends ImageView {
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 前提条件：
     * 1宽度固定高度不固定
     * 2.是否有图片展示
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //条件2
        Drawable drawable = getDrawable();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if(drawable != null && (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY)){
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            int h = drawable.getIntrinsicHeight()  * widthSize/ drawable.getIntrinsicWidth();
            switch (heightMode) {
                case MeasureSpec.AT_MOST:
                    heightSize = Math.min(h,heightSize);
                    break;
                case MeasureSpec.UNSPECIFIED:
                    heightSize = h;
                    break;
            }
            setMeasuredDimension(widthSize,heightSize);
            //生成一个MeasureSpec的数
//            MeasureSpec.makeMeasureSpec()
        }else{

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
