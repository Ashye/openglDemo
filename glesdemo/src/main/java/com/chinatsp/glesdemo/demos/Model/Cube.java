package com.chinatsp.glesdemo.demos.Model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/1.
 */

public class Cube {

    public float x = 0;
    public float y = 0;
    public float z = 0;
    public float rx = 0;
    public float ry = 0;
    public float rz = 0;


    public Cube(float width, float height, float depth) {
        width /= 2;
        height /= 2;
        depth /= 2;

        float vertices[] = {
                -width, -height, -depth,
                width, -height, -depth,
                width, height, -depth,
                -width, height, -depth,
                -width, -height, depth,
                width, -height, depth,
                width, height, depth,
                -width, height, depth,
        };

        short[] indices = {
                0,4,5,
                0,5,1,
                1,5,6,
                1,6,2,
                2,6,7,
                2,7,3,
                3,7,4,
                3,4,0,
                4,7,6,
                4,6,5,
                3,0,1,
                3,1,2
        };

        setIndices(indices);
        setVertices(vertices);
    }

    private FloatBuffer vertexBuffer;
    private ShortBuffer indicesBuffer;

    private void setVertices(float[] vertices) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length *4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    private void setIndices(short[] indices) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(indices.length *2);
        vbb.order(ByteOrder.nativeOrder());
        indicesBuffer = vbb.asShortBuffer();
        indicesBuffer.put(indices);
        indicesBuffer.position(0);
    }

    public void draw(GL10 gl) {
//counter clockwise order
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glPushMatrix();

        gl.glTranslatef(x, 0,0);
        gl.glTranslatef(0, y,0);
        gl.glTranslatef(0, 0,z);

        //rendering
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);


        gl.glDrawElements(GL10.GL_TRIANGLES, 12 * 3,
                GL10.GL_UNSIGNED_SHORT, indicesBuffer);




        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glDisable(GL10.GL_CULL_FACE);

        gl.glPopMatrix();
    }
}
