package com.chinatsp.glesdemo.demos.Model;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class DrawRoute {

//    private FloatBuffer vertexes;
//    private int vertexSize = 0;

    private List<double[]> pathPoints = new ArrayList<>();

    private float[] points;


    public DrawRoute() {

    }

    public void setPathPoints(final List<double[]> path) {
        pathPoints.clear();
        pathPoints.addAll(path);
        points = routeMapToCoordinates(pathPoints);

        printArray(points, 3);
    }


    /**
     * 两点两点画，然后平移
     * @param gl
     */
    public void drawParts(GL10 gl) {
        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glTranslatef(0.3f, 0.3f, 0);


        gl.glPushMatrix();


        double angle = getEyeDirectionAngle(points[3], points[4]);
        gl.glRotatef((float)angle, 0,0,1);

        gl.glPushMatrix();
        int i=0;
        for (; i< points.length -5; i+=3) {
            drawTwo(gl, points[i], points[i+1], points[i+3], points[i+4]);
        }


        gl.glPopMatrix();


        //draw route
//        drawRouteLine(gl, points);

        gl.glPopMatrix();
//        gl.glFlush();
//        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }

    //计算箭头坐标失败
    private void drawTwo(GL10 gl, float x1, float y1, float x2, float y2) {
        float[] points = {
                x1, y1, 0, x2, y2,0
        };


        float angleOfArrow = 60;
        float angle = getArrowAngle(x1, y1, x2, y2);
        float size = 0.1f;

        float centerX = (x1+x2)/2;
        float centerY = (y1+y2)/2;

         float x11 = (float) (centerX - size * Math.cos(Math.toRadians(angleOfArrow/2+angle)));
         float y11 = (float) (centerY - size * Math.sin(Math.toRadians(angleOfArrow/2+angle)));

         float x12 = (float) (centerX - size * Math.sin(Math.toRadians(angleOfArrow/2+angle)));
         float y12 = (float) (centerY + size * Math.cos(Math.toRadians(angleOfArrow/2+angle)));

        float[] pointsArrowtest = {
                x11,y11,0, centerX,centerY,0, x12, y12,0
        };

        drawLines(gl, points, 2);
        gl.glPushMatrix();
        gl.glTranslatef((x1+x2)/2,(y1+y2)/2,0);
        drawArrowLine(gl, pointsArrowtest);
        gl.glPopMatrix();
    }







    public void drawroute(GL10 gl) {
        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glTranslatef(0.3f, 0.3f, 0);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glPushMatrix();

        double angle = getEyeDirectionAngle(points[3], points[4]);
        gl.glRotatef((float)angle, 0,0,1);

        //draw route
        drawRouteLine(gl, points);

        gl.glPopMatrix();
        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }






















    public void draw(GL10 gl) {

        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glTranslatef(0.3f, 0.3f, 0);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glPushMatrix();

        double angle = getEyeDirectionAngle(points[3], points[4]);
        gl.glRotatef((float)angle, 0,0,1);


//        int i=0;
        for (int i=0; i<points.length - 5; i+=3) {
            drawArrow(gl, points[i], points[i+1], points[i+3], points[i+4]);
        }


        //draw route
        drawRouteLine(gl, points);

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



        double angle = calculateVectorAngle(points[3] - points[0], points[4] - points[1], endX - startX, endY - startY);
        Log.e("sss", String.format("getArrowAngle: %f,%f--%f,%f--%f,%f--%f,%f=====>%f"
                ,  points[0], points[1], points[3], points[4], startX,startY, endX,endY, angle));
        return (float) angle;
    }

    private final float deltaX = 0.03f;
    private final float height = 0.08f;

    private void drawArrow(GL10 gl, float startX, float startY,
                           float endX, float endY) {

        float angle = getArrowAngle(startX, startY, endX, endY);

        int sign = -1;
        if (endY < startY) {
            sign = 1;
        }

        float[] points = {
            0+deltaX, height*sign , 0,
                0, 0,0,
                0-deltaX, height*sign,0
        };


        Log.e("ss", "arrows:");
        printArray(points, 3);

        gl.glPushMatrix();
        gl.glTranslatef(endX, endY, 0);
        //opengl es :正数左转，负数右转
        gl.glRotatef(angle, 0,0,1);
        drawArrowLine(gl, points);
        gl.glTranslatef(-endX, -endY, 0);


//        drawLines(gl, pointste, 10);
        gl.glPopMatrix();

    }

    private void drawArrowLine(GL10 gl, float[] points) {
        drawLines(gl, points, 1);
    }

    private void drawRouteLine(GL10 gl, float[] points) {
        drawLines(gl, points, 2);
    }

    public void drawLines(GL10 gl, float[] points, float lineSize) {

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
        gl.glDrawArrays(GL10.GL_POINTS, 0, points.length/3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    private double getEyeDirectionAngle(double x, double y) {
        return calculateVectorAngle(x, y, 0.5f, 0.5f);
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
        Log.e("sss", "index:    angle:"+angle+ " cos:"+cos);
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


    private void mapToNewCoordinates(float[] oldPoints, float angle) {
        int i = 0;

        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));
        while (i<oldPoints.length-2) {
            oldPoints[i] = (float) (oldPoints[i]*cos + oldPoints[i+1]*sin);
            oldPoints[i] =(float)(oldPoints[i+1]*cos - oldPoints[i]*sin);
            i+=3;
        }

    }

    private float[] pathPointToBroader(float[] path, float angle) {
        float[] result = new float[path.length];
        int i=0;
        while (i < path.length -2) {

            float a = path[i];
            float b = path[i+1];

            if (angle >0) {
                result[i] = (float) (a * Math.cos(Math.toRadians(angle)) - b * Math.sin(Math.toRadians(angle)));
                result[i + 1] = (float) (a * Math.sin(Math.toRadians(angle)) + b * Math.cos(Math.toRadians(angle)));
            }else {
                result[i] = (float) (a * Math.cos(Math.toRadians(angle)) + b * Math.sin(Math.toRadians(angle)));
                result[i + 1] = (float) (b * Math.cos(Math.toRadians(angle)) + a * Math.sin(Math.toRadians(angle)));
            }
            result[i+2] = 0;

            i+=3;
        }
        return result;
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
}
