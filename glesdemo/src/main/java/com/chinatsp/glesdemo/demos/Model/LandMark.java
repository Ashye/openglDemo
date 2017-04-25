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
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/7.
 */

public class LandMark {

    //负值右转；正值左转

    private float depth = 1.5f;
    private float scaleFacter = 0.9f;

    private int width;
    private int height;
    private int imageWidth = 300;
    private int imageHeight = 100;


    private float xOffset = 1.5f;
    private final float zWidth = 0.8f;
    private float zOffset = 2f;


    private float[] vertexUnit = new float[] {
            0,0,0,1,
            -xOffset,0, zOffset,1,
            -xOffset,0, zWidth + zOffset,1,
            0,0, zWidth,1,
            xOffset,0, zOffset,1,
            xOffset, 0, zWidth + zOffset,1,
    };

    private short[] indices = new short[] {
            0,1,2,0,2,3,0,3,5,0,5,4
    };

    private FloatBuffer vertexBuffer;
    private ShortBuffer indiceBuffer;


    //保存图片
    private IntBuffer imageBuffer;



    public LandMark() {

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexUnit.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertexUnit);
        vertexBuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        indiceBuffer = ibb.asShortBuffer();
        indiceBuffer.put(indices);
        indiceBuffer.position(0);
    }

    public LandMark(int width, int height) {
        this();
        this.width = width;
        this.height = height;
        imageWidth = 400;
        imageHeight = 300;
        imageBuffer = IntBuffer.allocate(imageWidth * imageHeight);
    }


    public void drawMark(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(4, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indiceBuffer);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        drawMarkCount++;
    }


    private final static int markCountMax = 15;
    private int drawMarkCount = 0;

    public void drawAngleWithDistance(GL10 gl, double distance, int angle) {
        drawMarkCount = 0;
        if (angle !=0 && distance > 50) {
            int cnt = (int)(distance / 50);
            drawAngle(gl, 0, cnt);
        }

        drawAngle(gl, angle, markCountMax);
    }

    private void drawAngle(GL10 gl, int angle, float drawCount) {

        //避免角度太大
        if (angle > 90) {
            angle = 90;
        }else if (angle <-90) {
            angle = -90;
        }

        float step = angle / drawCount;
        float count = drawCount;
        float sca = scaleFacter;
        while (count >0) {

            if (drawMarkCount >= markCountMax) {
                break;
            }

            gl.glTranslatef(0, 0, -depth);
            gl.glScalef(sca, sca, sca);

            if (step != 0) {
                gl.glRotatef(step, 0, 1, 0);
            }

            drawMark(gl);

            count--;
        }
    }

    private void saveBitmap(GL10 gl) {
        imageBuffer.position(0);

        gl.glReadPixels(width/2 - imageWidth/2, height /2 - imageHeight/3, imageWidth, imageHeight, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, imageBuffer);

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
            String name = Environment.getExternalStorageDirectory()+"/opengl_.jpg";

            Log.e("sss", "sssssssssssss ->" + name);
            fos = new FileOutputStream(name);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
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
