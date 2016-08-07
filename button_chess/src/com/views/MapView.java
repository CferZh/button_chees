package com.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示地图的View <br>
 * 根据一个（m,n）的矩形来显示地图
 * Created by zxy94400 on 2016/8/7.
 */
public class MapView extends View{
    public final static String TAG = "MapView";

    private Paint paint;

    List<BoradRect> borad = new ArrayList<BoradRect>();
    private int[][] map = {
            {1,2,3,1,2,3,3},
            {0,0,0,0,0,0,1},
            {0,0,0,1,2,3,1},
            {4,1,3,1,0,0,0},
            {0,1,0,1,2,3,0},
            {0,1,2,1,0,3,0},
            {0,1,4,1,2,3,0},
    };

    public MapView(Context context) {
        super(context);
        init();
        //计算宽度和高度
        //从而确定每一格需要多大
        Log.i(TAG, "View width: " +  getWidth());
        //在这里获取的宽度为空，可以在在draw里面重新获取，暂时默认为100
        final int WIDTH = 100;
        final int HEIGHT = 100;

        synchronized (borad) {
            for(int i = 0;i <map.length;i++) {
                for(int j = 0;j < map[i].length; j++) {
                    int colorType = map[i][j];
                    float left = i * WIDTH;
                    float top = j * HEIGHT;
                    float right = left + WIDTH;
                    float bottom = top + HEIGHT;

                    int color = getColor(colorType);
                    borad.add(new BoradRect(new RectF(left, top, right, bottom), color));
                }
            }
        }
    }

    private int getColor(int colorType) {
        switch (colorType) {
            case 0: return Color.WHITE;
            case 1: return Color.YELLOW;
            case 2: return Color.DKGRAY;
            case 3: return Color.GRAY;
            default:return Color.BLACK;
        }
    }

    private void init() {

        paint = new Paint();

        paint.setColor(Color.YELLOW);

        paint.setStrokeJoin(Paint.Join.ROUND);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setStrokeWidth(3);
    }

    private void initPaint() {
        if (paint == null) {
            paint = new Paint();
        } else {
            paint.reset();
        }
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制弧线区域

        synchronized (borad) {
            for(BoradRect boradRect : borad) {
                initPaint();
                paint.setColor(boradRect.color);
                canvas.drawRect(boradRect.rect,paint);
            }
        }


    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}

class BoradRect {
    android.graphics.RectF rect;
    int color;

    public BoradRect(RectF rect, int color) {
        this.rect = rect;
        this.color = color;
    }
}

