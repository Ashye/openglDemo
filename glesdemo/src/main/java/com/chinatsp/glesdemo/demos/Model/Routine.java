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

}
