package com.chinatsp.glesdemo.demos.Model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class Routine {

    private FloatBuffer vertexes;
    private int vertexSize = 0;


    public Routine() {

    }

    public void setPath(final float[] route) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(route.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexes = vbb.asFloatBuffer();
        vertexes.put(route);
        vertexes.position(0);
        vertexSize = route.length /3;

//        printArray(route, 3);
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


    public void draw(GL10 gl) {

        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_POINTS, 0, vertexSize);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, vertexSize);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }


    private final float deltaX = 0.02f;
    public void drawArrow(GL10 gl, float height) {

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
//        gl.glPointSize(20f);
        gl.glLineWidth(5f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, points.length/3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    public void drawl(GL10 gl, float j, float w, float z) {

        float[] linePoints = calculateArcPoints(j,w, 0, 360, 0.05f);

        ByteBuffer vbb = ByteBuffer.allocateDirect(linePoints.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexes = vbb.asFloatBuffer();
        vertexes.put(linePoints);
        vertexes.position(0);


        gl.glColor4f(1f, 1f,1f,1f);
        gl.glPointSize(10f);
//        gl.glLineWidth(50f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, linePoints.length/3);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }


    private float[] calculateArcPoints(float centerX, float centerY, float startAngle, float endAngle, float radius) {

        double unit = Math.PI / 180;
        int count = (int) Math.ceil(Math.abs(endAngle - startAngle));

        float[] vertexes = new float[count * 3+3];
        float step = (endAngle - startAngle) / count;

        int j = 0;
        float i ;
        if (startAngle > endAngle) {
            for (i=startAngle; i> endAngle; i+=step) {
                vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
                vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
                vertexes[j++] = 0;
            }

            i+=step;
            vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
            vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
            vertexes[j] = 0;

        }else {
            for (i=startAngle; i< endAngle; i+=step) {
                vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
                vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
                vertexes[j++] = 0;
            }

            i+=step;
            vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
            vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
            vertexes[j] = 0;
        }

//        printArray(vertexes, 3);

        return vertexes;
    }
}
