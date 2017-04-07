package com.chinatsp.glesdemo.demos.Model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/7.
 */

public class LandMark {

    private float xSize = 2f;
    private float ySize = 0.5f;
    private float zSize = 1f;

    //负值右转；正值左转
    public float angle = 0f;

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


    public void draw(GL10 gl) {

        if (angle != 0) {
            gl.glRotatef(angle, 0, 1, 0);
        }

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(4, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indiceBuffer);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
