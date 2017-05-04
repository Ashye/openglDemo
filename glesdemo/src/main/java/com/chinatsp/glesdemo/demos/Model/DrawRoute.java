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

    private void drawLines(GL10 gl, float[] points, float lineSize) {

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
//        gl.glDrawArrays(GL10.GL_POINTS, 0, points.length/3);

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
