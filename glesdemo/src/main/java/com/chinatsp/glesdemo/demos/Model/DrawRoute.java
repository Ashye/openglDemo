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
        //draw line and arrow
        int idx = 3;
//        while (idx < points.length -6) {
            float firstX = points[idx++];
            float firstY = points[idx++];
            float firstZ = points[idx++];
            float secondX = points[idx++];
            float secondY = points[idx++];
            float secondZ = points[idx++];

            gl.glTranslatef(points[0] - points[3], points[1] - points[4], 0);
            drawTwo(gl, firstX, firstY, firstZ, secondX, secondY, secondZ);
//            idx -=3;
//        }


        gl.glPopMatrix();
        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }



    private void drawTwo(GL10 gl, float firstX, float firstY, float firstZ,
                         float secondX, float secondY, float secondZ) {

        Log.e("ss", String.format("%f,%f,%f  ->%f,%f,%f",firstX, firstY,firstZ, secondX, secondY, secondZ));

        float dirtectionX = secondX - firstX;
        float dirtectionY = secondY - firstY;



        drawLines(gl, new float[]{0, 0, 0, dirtectionX, dirtectionY, 0});

    }


    private final float deltaX = 0.02f;

    private void drawArrow(GL10 gl, float height) {

        float[] points = {
            deltaX, height - deltaX, 0,
                0, height,0,
                -deltaX,height - deltaX,0
        };

        gl.glPushMatrix();
        gl.glRotatef(-45,0,0,1);
        drawLines(gl, points);
        gl.glPopMatrix();

    }

    private void drawLines(GL10 gl, float[] points) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);


        gl.glColor4f(1f, 1f,1f,1f);
        gl.glLineWidth(5f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, points.length/3);
        gl.glDrawArrays(GL10.GL_POINTS, 0, points.length/3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    private double getEyeDirectionAngle(double x, double y) {

//        Log.e("sss", "origin:"+points[0]+"  "  +points[1] + " x:"+x+ "  "+y);

        double cos = (0.5 * x + 0.5 * y)
                / Math.sqrt((x * x + y * y) * (0.5 * 0.5 + 0.5 * 0.5f));
        double angle = Math.round(Math.toDegrees(Math.acos(cos)));

//        double axb = target[0] * y - x * target[1];
        double axb = x * 0.5 - 0.5 * y;
        if (axb <0) {
            angle *= -1;
        }
//        Log.e("sss", "index:"+ currPosition+"    angle:"+angle+ " cos:"+cos);
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

    private float[] routeMpatoCoordinates(double[] first, double[] second) {
        float[] points = new float[]{
                0,0,0,
                (float) (second[0] - first[0]) * 10000, (float) (second[1] - first[1]) * 10000, 0
        };
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
