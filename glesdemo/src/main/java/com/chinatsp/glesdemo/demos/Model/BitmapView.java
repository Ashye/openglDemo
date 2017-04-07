package com.chinatsp.glesdemo.demos.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangwei on 2017/4/6.
 */

public class BitmapView extends View{
    private int width;
    private int height;
    private Bitmap bitmap;
    private Canvas canvasBit;
    private Paint paintCircle;
    private Paint paintRect;
    private Paint paint;
    private int bimapWidth;
    private int bitmapHeight;

    public BitmapView(Context context) {
        super(context);
    }

    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintCircle = new Paint();
        paintCircle.setColor(Color.YELLOW);
        paintRect = new Paint();
        paintRect.setColor(Color.GREEN);
        paint = new Paint();

        //使重叠部分不显示
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);//必须设置在上面的控件
        paintCircle.setXfermode(mode);

//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
//        canvasBit = new Canvas(bitmap);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
//        bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);//创建一个bitmap
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg);//创建一个bitmap
//        canvasBit=new Canvas(bitmap);//创建一个包含上面bitmap的canvas
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        bitmapHeight = 300;
        bimapWidth = 300;

        this.bitmap = Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight());

    }

    private Matrix matrix = new Matrix();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);//将画布背景布成红色
//        canvasBit.drawCircle(width / 2, height / 2, width / 2, paintCircle);//通过bitmap的canvas画
//        canvasBit.drawRect(0, 0, width / 2, width / 2, paintRect);
//        matrix.setScale(0.2f, 0.2f);
//        canvas.drawBitmap(bitmap, matrix  ,paint);//最后将bitmap添加到最后的画布中
//
//
//        matrix.postTranslate(300, 0);
//        canvas.drawBitmap(bitmap, matrix ,paint);//最后将bitmap添加到最后的画布中
//
        matrix.reset();
        matrix.setScale(0.2f, 0.2f);
        matrix.postTranslate(0, 200);
        matrix.setSkew(1, 0);
        canvas.drawBitmap(bitmap, matrix ,paint);//最后将bitmap添加到最后的画布中

    }
}
