package com.chinatsp.glesdemo.demos.Model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLU;
import android.os.Environment;
import android.util.Log;

import com.chinatsp.glesdemo.demos.Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */


// TODO: 2017/5/23  1. fillup ; 2. at the ending points 3. turning messed up
public class DrawRoute2D {

//    private double[] carPosition;

    private List<double[]> pathPoints = new ArrayList<>();

    private float[] points;

    public void setPathPoints(final List<double[]> path) {
        pathPoints.clear();
        pathPoints.addAll(path);
        points = Util.routeMapToCoordinates(pathPoints);

        Util.printArray(points, 3);
    }


    public void drawroute(GL10 gl) {

        gl.glLoadIdentity();

        GLU.gluLookAt(gl, 0,0,0.3f,
                0,0.5f,0,
                0,0,1);

//        gl.glTranslatef(0,-0.5f,-1.5f);


        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(50f);

        gl.glTranslatef(0f, 0.3f, 0);



        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glPushMatrix();

        double angle = getEyeDirectionAngle(points[3], points[4]);
        gl.glRotatef((float)angle, 0,0,1);




        if (pathPoints.size() >= 3) {
            //draw bezier line
            float[] points = Util.getBezierPoints(pathPoints);

            int id = 0;
            lefts.clear();
            rights.clear();
            for (; id < points.length - 5; id += 3) {
                calculatePathPoints(gl, points[id], points[id + 1], points[id + 3], points[id + 4]);
//                drawPath1(gl, points[id], points[id + 1], points[id + 3], points[id + 4]);
            }

            id = 0;
            drawPath1(gl, points[id], points[id + 1], points[id + 3], points[id + 4]);
        }else {

            float[] points = Util.routeMapToCoordinates(pathPoints);

            lefts.clear();
            rights.clear();
            lefts.add(new float[]{points[0] - pathSize, points[1], 0});
            lefts.add(new float[]{points[3] - pathSize, points[4], 0});


            rights.add(new float[]{points[0] + pathSize, points[1], 0});
            rights.add(new float[]{points[3] + pathSize, points[4], 0});

            drawPath1(gl, this.points[0], this.points[0 + 1], this.points[0 + 3], this.points[0 + 4]);
//            gl.glTranslatef(-pathSize, 0, 0);
//            drawRouteLine(gl, points);
//            gl.glTranslatef(pathSize * 2, 0, 0);
//            drawRouteLine(gl, points);
        }


        gl.glPopMatrix();
        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//        gl.glDisable(GL10.GL_BLEND);
//        gl.glDisable();

        //save image
        if (saveImage) {
            saveBitmap(gl);
        }
    }






    /**
     * 传入向量与正上方向量比较：
     * 向量夹角为正是逆时针方向转动，负为顺时针方向转动
     */
    private float getLineAngleToAxisY(float startX, float startY,
                                      float endX, float endY) {

        double angle = Util.calculateVectorAngle(0-0, 0.5-0, endX - startX, endY - startY);
//        Log.e("sss", String.format("getLineAngleToAxisY: %f,%f--%f,%f--%f,%f--%f,%f=====>%f"
//                ,  0f, 0f, 0f, 0.5f, startX,startY, endX,endY, angle));
        return (float) angle;
    }

    private float getLineAngleToFirstLine(float startX, float startY,
                                          float endX, float endY) {

        double angle = Util.calculateVectorAngle(points[3]-0, points[4]-0, endX - startX, endY - startY);
//        Log.e("sss", String.format("getLineAngleToAxisY: %f,%f--%f,%f--%f,%f--%f,%f=====>%f"
//                ,  0f, 0f, 0f, 0.5f, startX,startY, endX,endY, angle));
        return (float) angle;
    }


    /**
     * draw path
     * @param scale
     * @return
     */
    private static final float pathSize = 0.05f;
    private void drawPath(GL10 gl, float startX, float startY, float endX, float endY) {

        double leftSX = 0;
        double leftSY = 0;

        double rightSX = 0;
        double rightSY = 0;


        float angle = getLineAngleToAxisY(startX, startY, endX, endY);

        float a = endX - startX;
        float b = endY - startY;

//        if (angle <0) {
            leftSX = startX + a - Math.cos(Math.toRadians(angle)) * pathSize /2;
            leftSY = startY + b + Math.sin(Math.toRadians(angle)) * pathSize /2;

            rightSX = startX + a + Math.cos(Math.toRadians(angle)) * pathSize /2;
            rightSY = startY + b - Math.sin(Math.toRadians(angle)) * pathSize /2;
//        }



        float[] points = {
                (float) leftSX, (float)leftSY, 0,
                (float) leftSX + a, (float)leftSY + b, 0,
                (float)rightSX + a , (float)rightSY + b, 0,
                (float)rightSX, (float)rightSY, 0
        };


        gl.glPushMatrix();
//        gl.glTranslatef(startX , startY, 0);
//        gl.glRotatef(angle, 0, 0, 1);
        drawLines(gl, points, 10, true);
        gl.glPopMatrix();
//
//        gl.glPushMatrix();
//        gl.glTranslatef(endX , endY, 0);
//        gl.glRotatef(angle, 0, 0, 1);
//        drawLines(gl, points, 10, false);
//        gl.glPopMatrix();


    }

    private List<float[]> lefts = new ArrayList<>();
    private List<float[]> rights = new ArrayList<>();

    private void drawPath1(GL10 gl, float startX, float startY, float endX, float endY) {

//        calculatePathPoints(gl, startX, startY, endX, endY);

//        float[] pointsLeft = getPoints(rights);
//        drawLines(gl, points, 10, true);
//
//        float[] pointsRight = getPoints(lefts);
//        drawLines(gl, points, 10, true);

        getPaths(gl, lefts, rights);
//        drawRect(gl, ps, 10, false);
    }

    /**
     * 计算垂直路径线点
     * @param gl
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    private void calculatePathPoints(GL10 gl, float startX, float startY, float endX, float endY) {
        float angle = getLineAngleToAxisY(startX, startY, endX, endY);

//        Log.e("ss", "anlge: "+angle);


        float a = endX - startX;
        float b = endY - startY;

        float[] pointsLeft = Util.getRotatedPoints(-pathSize, 0, angle);
        float[] pointsRight = Util.getRotatedPoints(pathSize, 0, angle);

        int count = 10;

        int i = 0;

        float lx = pointsLeft[0] + startX + i * a/count;
        float ly = pointsLeft[1] + startY + i * b/ count;

        float rx = pointsRight[0] + startX + i * a/count;
        float ry = pointsRight[1] + startY + i * b/ count;

        lefts.add(new float[]{lx,ly});
        rights.add(new float[]{rx,ry});

//        float[] points = {
//                lx, ly, 0,
//                rx, ry, 0
//        };

//        Log.e("ss", String.format("%f,%f; %f,%f", lx, ly, rx, ry));

//        drawLines(gl, points, 10, false);
    }

    private float[] getPoints(List<float[]> list) {
        float[] points = new float[list.size() * 3];
        int idx = 0;
        for (float[] p : list) {
            points[idx++] = p[0];
            points[idx++] = p[1];
            points[idx++] = 0;
        }
        return points;
    }

    private void getPaths(GL10 gl, List<float[]> left, List<float[]> right) {

        List<float[]> temp = new ArrayList<>();
        temp.addAll(left);
        temp.addAll(right);
        float[] points = getPoints(temp);

        short[] vs = new short[left.size() * 6];
        short rightOffset = (short) left.size();
        int idx = 0;
        for (short i=0; i< left.size()-1; i++) {
            vs[idx++] = i;
            vs[idx++] = (short) (rightOffset +i);
            vs[idx++] = (short)(i+1);

            vs[idx++] = (short)(i+1);
            vs[idx++] = (short)(rightOffset + i);
            vs[idx++] = (short)(rightOffset + i +1);

        }



        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);

        ByteBuffer obb = ByteBuffer.allocateDirect(points.length * 4);
        obb.order(ByteOrder.nativeOrder());
        ShortBuffer order = obb.asShortBuffer();
        order.put(vs);
        order.position(0);


        gl.glColor4f(1f, 1f,1f,0.5f);
        gl.glLineWidth(10);
        gl.glPointSize(20);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);


        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
//        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, points.length/3);
//        gl.glVertexPointer();
        gl.glDrawElements(GL10.GL_TRIANGLES, vs.length, GL10.GL_UNSIGNED_SHORT, obb);

        gl.glColor4f(1,0,0,0.2f);
        if (false) {
            gl.glDrawArrays(GL10.GL_POINTS, 0, points.length / 3);
        }

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }


    /**
     * draw arrow
     * @param scale
     * @return
     */
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
    private float scale = 1.3f;
    private float scaleFactor = 0.05f;
//    private float scaleFactor = 0;


    private void drawArrow(GL10 gl, float startX, float startY, float endX, float endY) {

        float deltaX = endX - startX;
        float deltaY = endY - startY;

        gl.glPushMatrix();
        float angle = getLineAngleToAxisY(startX, startY, endX, endY);

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
    private void drawArrows(GL10 gl, float startX, float startY, float endX, float endY) {
        
        gl.glPushMatrix();
        float angle = getLineAngleToAxisY(startX, startY, endX, endY);

        float angle2 = getLineAngleToFirstLine(startX, startY, endX, endY);

        Log.e("ss", "angle1:"+angle+ " angle2:"+angle2);

        double distance = Util.getDistance(startX,startY, endX, endY);
        int arrowUnits = (int) Math.ceil(distance/0.07f);


        float deltaX = (endX - startX) /arrowUnits;
        float deltaY = (endY - startY) / arrowUnits;

        int arrLeft = 0;

        if(Math.abs(Math.abs(angle2)) > 30) {
            arrLeft = 1;
        }

//        if (acnt >0) {
//            arrLeft = 1;
//        }
        do {
            gl.glPushMatrix();
            gl.glTranslatef(startX + deltaX * arrLeft, startY + deltaY * arrLeft, 0);
            gl.glRotatef(angle, 0, 0, 1);
            float scales = scale - acnt * scaleFactor;
            if (scales <= 0 || acnt >= 15) {
                gl.glPopMatrix();
                break;
            }
            drawArrowLine(gl, getArrowPoints(scales));
            acnt++;
            gl.glPopMatrix();

            arrLeft ++;
        }while (arrLeft < arrowUnits);
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

    }

    private void drawRect(GL10 gl, float[] points, float lineSize, boolean point) {

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
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, points.length/3);
        if (point) {
            gl.glDrawArrays(GL10.GL_POINTS, 0, points.length / 3);
        }

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }

    private void drawPoints(GL10 gl, float[] points, float lineSize) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);


        gl.glColor4f(1f, 1f,1f,1f);
//        gl.glLineWidth(lineSize);
        gl.glPointSize(lineSize);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
//        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, points.length/3);
            gl.glDrawArrays(GL10.GL_POINTS, 0, points.length / 3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }

    private double getEyeDirectionAngle(double x, double y) {
        return Util.calculateVectorAngle(x, y, 0f, 0.5f);
    }




    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
//        imageWidth = width * 2 /3;
        imageHeight = height * 2 /3;
        imageBuffer = IntBuffer.allocate(imageWidth * imageHeight);
    }


    private int width;
    private int height;
    private int imageWidth = 300;
    private int imageHeight = 400;
    //保存图片
    private IntBuffer imageBuffer;

    private boolean saveImage = false;
    public void setSaveImage(boolean saveImage) {
        this.saveImage = saveImage;
    }

    private void saveBitmap(GL10 gl) {
        imageBuffer.position(0);

        gl.glReadPixels(width/2 - imageWidth/2, height /2 - imageHeight/2 , imageWidth, imageHeight, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, imageBuffer);

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

        matrix.reset();
        matrix.setScale(0.5f, .5f);
        bmp = Bitmap.createBitmap(bmp, 0,0,bmp.getWidth(), bmp.getHeight(), matrix, true);

//        bmp = Bitmap.createScaledBitmap(bmp, 100, 75, true);

        FileOutputStream fos = null;
        try {
//            String name = Environment.getExternalStorageDirectory()+"/opengl_"+System.currentTimeMillis()+".jpg";
            String name = Environment.getExternalStorageDirectory()+"/opengl_"+".jpg";

            Log.e("sss", "sssssssssssss ->" + name);
            fos = new FileOutputStream(name);
            bmp.compress(Bitmap.CompressFormat.JPEG, 30, fos);
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
