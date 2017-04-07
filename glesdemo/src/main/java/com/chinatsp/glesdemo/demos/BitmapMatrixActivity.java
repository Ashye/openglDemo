package com.chinatsp.glesdemo.demos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.chinatsp.glesdemo.R;

public class BitmapMatrixActivity extends AppCompatActivity {

    private Bitmap bitmap;
    ImageView bitmapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_matrix);

        bitmapView = (ImageView)findViewById(R.id.iv_image);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
        bitmapView.setImageBitmap(bitmap);

//        test();
//        test1();
//        test2();
        test3();


    }

    private Matrix matrix = new Matrix();

    private float angle = 20f;
    // 1 - 0.1
    private float depth = 0.8f;
    private Bitmap transform(Bitmap srcBitmap, float angle, float depth) {
        Bitmap bitmap1 = null;
        bitmap1 = transformScale(srcBitmap, depth, depth);
        bitmap1 = transformDepth(bitmap1, depth);
        bitmap1 = transformAngle(bitmap1, angle);
        return transformTurn(bitmap1, angle, depth);
//        return bitmap1;
    }

    private Bitmap transformScale(Bitmap srcBitmap, float scaleX, float scaleY) {
        float width = srcBitmap.getWidth() * scaleX;
        float height = srcBitmap.getHeight() * scaleY;

        float[] targetPoints = {
                0, 0,
                width, 0,
                width, height,
                0, height
        };

        return transform(srcBitmap, targetPoints);
    }

    private Bitmap transformDepth(Bitmap srcBitmap, float depth) {
        float width = srcBitmap.getWidth();
        float height = srcBitmap.getHeight();

        //俯视因子，暂时值
        float factor = 0.8f;

        float step = factor * (width - depth * width) /2;

        float[] targetPoints = {
                0 + step, 0,
                width - step, 0,
                width, height * factor,
                0, height * factor
        };

        return transform(srcBitmap, targetPoints);
    }

    private Bitmap transformAngle(Bitmap srcBitmap, float angle) {
        float width = srcBitmap.getWidth();
        float height = srcBitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.setRotate(angle);
        Bitmap bitmap1 = Bitmap.createBitmap(srcBitmap, 0,0, (int)width, (int) height, matrix, true);
        return bitmap1;
    }

    private Bitmap transformTurn(Bitmap srcBitmap, float angle, float depth) {
        int drection;
        if (angle <0) {
            drection = -1;
        }else {
            drection = 1;
        }

        float stepX = drection * srcBitmap.getWidth() / 10;
        float stepY = drection * srcBitmap.getHeight() / 10;

        float[] targetPoints = {
            //left top
                0 + stepX, 0 - stepY,
                //right top
                srcBitmap.getWidth() - stepX, 0,
                //right bottom
                srcBitmap.getWidth(), srcBitmap.getHeight(),
                //left bottom
                0, srcBitmap.getHeight()

        };

        return transform(srcBitmap, targetPoints);

    }

    private Bitmap transform(Bitmap srcBitmap, float[] targetPoints) {
        float[] srcPoints = {
                0, 0,
                srcBitmap.getWidth(), 0,
                srcBitmap.getWidth(), srcBitmap.getHeight(),
                0, srcBitmap.getHeight()
        };

        Matrix matrix = new Matrix();
        matrix.setPolyToPoly(srcPoints, 0, targetPoints, 0, srcPoints.length/2);

        return Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(),
                srcBitmap.getHeight(), matrix, true);
    }






    private void test() {
        matrix.reset();

        matrix.setScale(1f, -1f);//先把图片在y轴方向反向缩放
        matrix.postTranslate(0, bitmap.getHeight());//然后再把反向缩放后的图片移到canvas上显示即可
        matrix.postTranslate(bitmap.getWidth()+160, 0);
        matrix.postSkew(-1, 0);

        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmapView.setImageBitmap(bitmap1);
    }

    private void test1() {
        float[] src = new float[] { 0, 0, // 左上
                bitmap.getWidth(), 0,// 右上
                bitmap.getWidth(), bitmap.getHeight(),// 右下
                0, bitmap.getHeight() };// 左下
        float[] dst = new float[] { 0, 0,
                bitmap.getWidth(), 100,
                bitmap.getWidth(), bitmap.getHeight() - 100,
                0,bitmap.getHeight() };
        matrix.setPolyToPoly(src, 0, dst, 0, src.length/2);
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);

        bitmapView.setImageBitmap(bm);
    }

    private void test2() {
        float[] src = new float[] { 0, 0, // 左上
                bitmap.getWidth(), 0,// 右上
                bitmap.getWidth(), bitmap.getHeight(),// 右下
                0, bitmap.getHeight() };// 左下

        float[] dest = {
                -10, 100,
                150, 90,
                bitmap.getWidth() - 50, bitmap.getHeight(),
                100, bitmap.getHeight() + 20
        };

        matrix.setPolyToPoly(src, 0, dest, 0, src.length/2);

        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
        bitmap.getHeight(), matrix, true);

        bitmapView.setImageBitmap(bm);
    }


    private void test3() {
//        Bitmap bitmap1 = createReflectedImage(bitmap);
//        Bitmap bitmap1 = drawImageDropShadow(bitmap);
        Bitmap bitmap1 = transform(bitmap, angle, depth);
        bitmapView.setImageBitmap(bitmap1);
    }

    public static Bitmap drawImageDropShadow(Bitmap originalBitmap) {

        BlurMaskFilter blurFilter = new BlurMaskFilter(1,
                BlurMaskFilter.Blur.NORMAL);
        Paint shadowPaint = new Paint();
        shadowPaint.setAlpha(50);


        shadowPaint.setColor(Color.RED);
        shadowPaint.setMaskFilter(blurFilter);

        int[] offsetXY = new int[2];
        Bitmap shadowBitmap = originalBitmap
                .extractAlpha(shadowPaint, offsetXY);

        Bitmap shadowImage32 = shadowBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas c = new Canvas(shadowImage32);
        c.drawBitmap(originalBitmap, offsetXY[0], offsetXY[1], null);

        return shadowImage32;
    }

    public static Bitmap createReflectedImage(Bitmap originalBitmap) {
        // 图片与倒影间隔距离
        final int reflectionGap = 4;

        // 图片的宽度
        int width = originalBitmap.getWidth();
        // 图片的高度
        int height = originalBitmap.getHeight();

        Matrix matrix = new Matrix();
        // 图片缩放，x轴变为原来的1倍，y轴为-1倍,实现图片的反转
        matrix.preScale(1, -1);
        // 创建反转后的图片Bitmap对象，图片高是原图的一半。
        Bitmap reflectionBitmap = Bitmap.createBitmap(originalBitmap, 0,
                height / 2, width, height / 2, matrix, false);
        // 创建标准的Bitmap对象，宽和原图一致，高是原图的1.5倍。
        Bitmap withReflectionBitmap = Bitmap.createBitmap(width, (height
                + height / 2 + reflectionGap), Bitmap.Config.ARGB_8888);

        // 构造函数传入Bitmap对象，为了在图片上画图
        Canvas canvas = new Canvas(withReflectionBitmap);
        // 画原始图片
        canvas.drawBitmap(originalBitmap, 0, 0, null);

        // 画间隔矩形
        Paint defaultPaint = new Paint();
        canvas.drawRect(0, height, width, height + reflectionGap, defaultPaint);

        // 画倒影图片
        canvas.drawBitmap(reflectionBitmap, 0, height + reflectionGap, null);

        // 实现倒影效果
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0,
                originalBitmap.getHeight(), 0,
                withReflectionBitmap.getHeight(), 0x70ffffff, 0x00ffffff,
                Shader.TileMode.MIRROR);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        // 覆盖效果
        canvas.drawRect(0, height, width, withReflectionBitmap.getHeight(),
                paint);

        return withReflectionBitmap;
    }
}
