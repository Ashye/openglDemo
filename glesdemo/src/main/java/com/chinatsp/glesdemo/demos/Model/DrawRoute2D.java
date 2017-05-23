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
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class DrawRoute2D {

//    private double[] carPosition;

    private List<double[]> pathPoints = new ArrayList<>();

    private float[] points;


//    public void setCarPosition(double[] carPosition) {
//        this.carPosition = carPosition;
//    }

    public void setPathPoints(final List<double[]> path) {
        pathPoints.clear();
        pathPoints.addAll(path);
        points = Util.routeMapToCoordinates(pathPoints);

//        printArray(points, 3);
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




        //draw bezier line
        float[] points = Util.getBezierPoints(pathPoints);
//        drawRouteLine(gl, points);
//        drawLines(gl, points, 10, false);
//        drawLines(gl, Util.getBezierPointsV2(pathPoints.get(0), pathPoints.get(1), pathPoints.get(2)), 10, false);
//        drawLines(gl, Util.getBezierPointsV2(pathPoints.get(1), pathPoints.get(2), pathPoints.get(3)), 10, false);


        int id = 0;
        lefts.clear();
        rights.clear();
        for (; id< points.length - 5; id+=3) {
//            calculatePathPoints(gl, points[id], points[id + 1], points[id + 3], points[id + 4]);
            drawPath1(gl, points[id], points[id + 1], points[id + 3], points[id + 4]);

        }

        //draw route
//        drawRouteLine(gl, points);
//        drawLines(gl, points, 10, false);

//        gl.glTranslatef(-0.05f, 0, 0);
//        drawRouteLine(gl, points);


//        gl.glTranslatef(-0.1f, -0.1f, 0);
//        drawRouteLine(gl, points);
//        gl.glTranslatef(0.2f, 0.2f, 0);
//        drawRouteLine(gl, points);

        //draw arrow
//        int i=3;
//        acnt = 0;
//        rights.clear();
//        for (; i<points.length - 5; i+=3) {
//////            drawArrows(gl, points[i], points[i + 1], points[i + 3], points[i + 4]);
//            drawPath1(gl, points[i], points[i + 1], points[i + 3], points[i + 4]);
//        }


        gl.glPopMatrix();
        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

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
    private static final float pathSize = 0.01f;
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

//        calculateCornerPoints(gl, startX, startY, endX, endY);
        calculatePathPoints(gl, startX, startY, endX, endY);
        float[] points = getPoints(rights);
        drawLines(gl, points, 10, false);

        points = getPoints(lefts);
        drawLines(gl, points, 10, false);

//        float[] points = getPoints(lefts);
//        drawLines(gl, points, 10, false);

//        points = getPoints(rights);
//        drawLines(gl, points, 10, false);
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

    /**
     * 计算等分角度点，需要考虑左转还是右转
     * @return
     */
    private void calculateCornerPoints(GL10 gl, float startX, float startY, float endX, float endY) {

        float angle = getLineAngleToAxisY(startX, startY, endX, endY);

        int sign = -1;
        if (angle <=0) {
            sign = 1;
        }

        float[] r;
        float a = 0;
        float b = pathSize;


        float angleValue = Math.abs(angle);
        if (angleValue < Float.MIN_NORMAL || Math.abs(angleValue - 180) < Float.MIN_NORMAL) {
            //x 变，y不变

            r = new float[] {
                0 + sign * b, 0
            };

        }else if (Math.abs(angleValue - 90) < Float.MIN_NORMAL) {
            //x 不变，y 变
            r = new float[] {
                  0, 0 - sign * b
            };
        }else {
            //x, y 都变
            r = Util.getRotatedPoints(a, b, angle);

        }

//        Log.e("ssss", "rotate:"+angle);


        r[0] += startX;
        r[1] += startY;


//        lefts.add(new float[]{startX, startY});
//        lefts.add(new float[]{});
        rights.add(new float[]{r[0], r[1]});
        rights.add(new float[]{r[0] + endX - startX, r[1] + endY - startY});

//        float[] points = {
//                xs, ys, 0,
//                xe, ye, 0
//        };
//
//        drawLines(gl, points, 10, true);
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
