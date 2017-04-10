package com.chinatsp.glesdemo.demos.Model;

import android.graphics.Bitmap;
import android.graphics.Matrix;

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
    private float angle = 0f;
    private int depth = 1;

    private int width;
    private int height;
    private int imageWidth = 300;
    private int imageHeight = 100;


    private float xSize = 2f;
    private float ySize = 0.5f;
    private float zSize = 1f;

    private float[] vertexUnit = new float[] {
            0,0,0,1,
            -xSize,-ySize,0,1,
            -xSize,-ySize,zSize,1,
            0,0,zSize,1,
            xSize,-ySize,0,1,
            xSize, -ySize,zSize,1,
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
        imageWidth = width;
        imageHeight = height;
        imageBuffer = IntBuffer.allocate(imageWidth * imageHeight);
    }


    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setDepth(int depth) {
        this.depth = depth;
        if (this.depth <1) {
            this.depth = 1;
        }
    }

    public void draw(GL10 gl) {

        if (angle != 0) {
            gl.glRotatef(angle, 0, 1, 0);
        }

        //根据深度设置大小
        for (int i=0; i< depth; i++) {
            gl.glTranslatef(0, 0, -2.5f);
            gl.glScalef(0.9f, 0.9f, 0.9f);
        }

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(4, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indiceBuffer);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        saveBitmap(gl);
    }

    private void saveBitmap(GL10 gl) {
        imageBuffer.position(0);

        gl.glReadPixels(width/2 - imageWidth/2, height /2 - imageHeight/2, imageWidth, imageHeight, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, imageBuffer);

        imageBuffer.position(0);
        int pix[] = new int[imageWidth*imageHeight];
        imageBuffer.get(pix);



        Bitmap bmp = Bitmap.createBitmap(pix, imageWidth, imageHeight, Bitmap.Config.ARGB_8888);

        //图片上下颠倒纠正
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);
        bmp = Bitmap.createBitmap(bmp, 0,0,bmp.getWidth(), bmp.getHeight(), matrix, true);


        FileOutputStream fos = null;
        try {
            String name = "opengl_.png";
            fos = new FileOutputStream("/sdcard/"+name);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
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
