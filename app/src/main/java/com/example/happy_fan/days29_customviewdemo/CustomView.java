package com.example.happy_fan.days29_customviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Happy_Fan on 2016.3.29.
 */
public class CustomView extends View {

    private static final String TAG = CustomView.class.getSimpleName();

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            switch (widthMode) {
                case MeasureSpec.UNSPECIFIED:
                    Log.d(TAG, "onMeasure: UNSPECIFIED");
                    widthSize = 200;
                    break;
                //wrap——content
                case MeasureSpec.AT_MOST:
                    Log.d(TAG, "onMeasure: AT_MOST");
                    widthSize = Math.min(200,widthSize);
                    break;
                //*dp是这种模式
                case MeasureSpec.EXACTLY:
                    Log.d(TAG, "onMeasure: EXACTLY");
                    break;

            }
        //模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //大小
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.UNSPECIFIED:
                Log.d(TAG, "onMeasure:Height: UNSPECIFIED");
                heightSize = 200;
                break;
            //wrap——content
            case MeasureSpec.AT_MOST:
                Log.d(TAG, "onMeasure: Height:AT_MOST");
                heightSize = Math.min(200,widthSize);
                break;
            //*dp是这种模式
            case MeasureSpec.EXACTLY:
                Log.d(TAG, "onMeasure:Height: EXACTLY");
                break;

        }
        setMeasuredDimension(widthSize,heightSize);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



    }
}
