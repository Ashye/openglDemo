package com.chinatsp.glesdemo.demos.Model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLU;
import android.os.Environment;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class DrawRoute2D {


    private List<double[]> pathPoints = new ArrayList<>();

    private float[] points;


    public void setPathPoints(final List<double[]> path) {
        pathPoints.clear();
        pathPoints.addAll(path);
        points = routeMapToCoordinates(pathPoints);

//        printArray(points, 3);
    }


    public void drawroute(GL10 gl) {

        gl.glLoadIdentity();

        GLU.gluLookAt(gl, 0,0,0.5f,
                0,0.5f,0,
                0,0,1);

//        gl.glTranslatef(0,-0.5f,-1.5f);


        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glTranslatef(0f, 0.3f, 0);



        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glPushMatrix();

        double angle = getEyeDirectionAngle(points[3], points[4]);
        gl.glRotatef((float)angle, 0,0,1);





        //draw route
//        drawRouteLine(gl, points);


//        gl.glTranslatef(-0.1f, -0.1f, 0);
//        drawRouteLine(gl, points);
//        gl.glTranslatef(0.2f, 0.2f, 0);
//        drawRouteLine(gl, points);

        //draw arrow
        int i=0;
        acnt = 0;
        for (; i<points.length - 5; i+=3) {
            drawArrow(gl, points[i], points[i + 1], points[i + 3], points[i + 4]);
        }


        gl.glPopMatrix();
        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }




    /**
     * 传入向量与正上方向量比较：
     * 向量夹角为正是逆时针方向转动，负为顺时针方向转动
     */
    private float getArrowAngle(float startX, float startY,
                                float endX, float endY) {

        double angle = calculateVectorAngle(0-0, 0.5-0, endX - startX, endY - startY);
//        Log.e("sss", String.format("getArrowAngle: %f,%f--%f,%f--%f,%f--%f,%f=====>%f"
//                ,  0f, 0f, 0f, 0.5f, startX,startY, endX,endY, angle));
        return (float) angle;
    }

    private float[] getArrowPoints(float scale) {
        float[] points = {
            -size* scale, 0,0,
                0,size/2f*scale,0,
                size*scale,0,0
        };

        return points;
    }

    private int acnt = 0;
    private float size = 0.05f;
    private float scale = 1f;
//    private float scaleFactor = 0.1f;
    private float scaleFactor = 0;
    private void drawArrow(GL10 gl, float startX, float startY, float endX, float endY) {

        float deltaX = endX - startX;
        float deltaY = endY - startY;

        gl.glPushMatrix();
        float angle = getArrowAngle(startX, startY, endX, endY);

        do {
            gl.glPushMatrix();
            gl.glTranslatef(startX, startY, 0);
            gl.glRotatef(angle, 0, 0, 1);
            float scales = scale - acnt * scaleFactor;
            if (scales <= 0) {
                gl.glPopMatrix();
                break;
            }
            drawArrowLine(gl, getArrowPoints(scales));
            acnt++;
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(startX + deltaX / 2, startY + deltaY / 2, 0);
            gl.glRotatef(angle, 0, 0, 1);
            scales = scale - acnt * scaleFactor;
            if (scales <= 0) {
                gl.glPopMatrix();
                break;
            }
            drawArrowLine(gl, getArrowPoints(scales));
            acnt++;
            gl.glPopMatrix();

        }while (false);
        gl.glPopMatrix();
    }

    private void drawArrowLine(GL10 gl, float[] points) {
        drawLines(gl, points, 10, false);
    }

    private void drawRouteLine(GL10 gl, float[] points) {
        drawLines(gl, points, 2, true);
    }

    private void drawLines(GL10 gl, float[] points, float lineSize, boolean point) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);


        gl.glColor4f(1f, 1f,1f,1f);
        gl.glLineWidth(lineSize);
        gl.glPointSize(20);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, points.length/3);
        if (point) {
            gl.glDrawArrays(GL10.GL_POINTS, 0, points.length / 3);
        }

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);



        //save image
        if (saveImage) {
            saveBitmap(gl);
        }
    }

    private double getEyeDirectionAngle(double x, double y) {
        return calculateVectorAngle(x, y, 0f, 0.5f);
    }

    private double calculateVectorAngle(double x1, double y1, double x2, double y2) {

        double cos = (x1 * x2 + y1 * y2) /
                (Math.sqrt(x1*x1 +y1*y1) * Math.sqrt(x2*x2 + y2*y2));
        double angle = Math.round(Math.toDegrees(Math.acos(cos)));

        double axb = x1 * y2 - x2 * y1;
        if (axb <0) {
            angle = - Math.abs(angle);
        }else {
            angle = Math.abs(angle);
        }
//        Log.e("sss", "index:    angle:"+angle+ " cos:"+cos);
        return angle;
    }

    private float[] routeMapToCoordinates(final List<double[]> route) {
        float[] points = new float[route.size() * 3];

        int idx = 0;
        double[] origin = route.get(0);
        for (double[] point : route) {
            points[idx++] = (float) (point[0] - origin[0]) * 10000;
            points[idx++] = (float) (point[1] - origin[1]) * 10000;
            points[idx++] = 0f;
        }
//        printArray(points, 3);
        return points;
    }

    private void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i=0; i< data.length; i++) {
            System.out.print(" "+ data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }



    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        imageWidth = width;
        imageHeight = height;
        imageBuffer = IntBuffer.allocate(imageWidth * imageHeight);
    }


    private int width;
    private int height;
    private int imageWidth = 250;
    private int imageHeight = 400;
    //保存图片
    private IntBuffer imageBuffer;

    private boolean saveImage = false;
    public void setSaveImage(boolean saveImage) {
        this.saveImage = saveImage;
    }

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
