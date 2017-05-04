package com.chinatsp.glesdemo.demos.Model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class Routine {

    private FloatBuffer vertexes;
    private int vertexSize = 0;


    public Routine() {

    }

    public Routine(int width, int height) {
        this.width = width;
        this.height = height;
        imageBuffer = IntBuffer.allocate(imageWidth * imageHeight);
    }

    public void setPath(final float[] route) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(route.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexes = vbb.asFloatBuffer();
        vertexes.put(route);
        vertexes.position(0);
        vertexSize = route.length / 3;

//        printArray(route, 3);
    }

    private void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }


    public void draw(GL10 gl) {

        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glPointSize(20f);
//        gl.glLineWidth(5f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_POINTS, 0, vertexSize);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, vertexSize);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        saveBitmap(gl);
    }


    private final float deltaX = 0.02f;

    public void drawArrow(GL10 gl, float height) {

        float[] points = {
                deltaX, height - deltaX, 0,
                0, height, 0,
                -deltaX, height - deltaX, 0
        };

        gl.glPushMatrix();
        gl.glRotatef(-45, 0, 0, 1);
        drawLines(gl, points);
        gl.glPopMatrix();

    }

    private void drawLines(GL10 gl, float[] points) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);


        gl.glColor4f(1f, 1f, 1f, 1f);
//        gl.glPointSize(20f);
//        gl.glLineWidth(5f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, points.length / 3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    private int width;
    private int height;
    private int imageWidth = 250;
    private int imageHeight = 400;
    //保存图片
    private IntBuffer imageBuffer;

    private void saveBitmap(GL10 gl) {
        imageBuffer.position(0);

        gl.glReadPixels(width/2 - imageWidth/2, height /2 - imageHeight/2, imageWidth, imageHeight, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, imageBuffer);

        imageBuffer.position(0);
        int pix[] = new int[imageWidth*imageHeight];
        imageBuffer.get(pix);

//        int alpha = 0;
        int r;
        int g;
        int b;
        int p;
        for (int i = 0; i< pix.length ; i++) {
            p = pix[i];
//            alpha = (p & 0xff000000) >> 24;
            r = (p & 0xff0000) >> 18;
            g = (p & 0xff00) >> 8;
            b = (p & 0xff);

            if (r + g + b==0) {
                pix[i] = 0 ;
            }
        }



        Bitmap bmp = Bitmap.createBitmap(pix, imageWidth, imageHeight, Bitmap.Config.ARGB_8888);

        //图片上下颠倒纠正
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);
        bmp = Bitmap.createBitmap(bmp, 0,0,bmp.getWidth(), bmp.getHeight(), matrix, true);

//        matrix.reset();
//        matrix.setScale(0.3f, .3f);
//        bmp = Bitmap.createBitmap(bmp, 0,0,bmp.getWidth(), bmp.getHeight(), matrix, true);

//        bmp = Bitmap.createScaledBitmap(bmp, 100, 75, true);

        FileOutputStream fos = null;
        try {
            String name = Environment.getExternalStorageDirectory()+"/opengl_"+System.currentTimeMillis()+".jpg";

            Log.e("sss", "sssssssssssss ->" + name);
            fos = new FileOutputStream(name);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
