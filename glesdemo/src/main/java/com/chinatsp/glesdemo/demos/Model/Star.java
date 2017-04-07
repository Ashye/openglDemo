package com.chinatsp.glesdemo.demos.Model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/5.
 */

public class Star {
    protected float[] vertices;

    protected FloatBuffer vertexBuffer;

    public Star() {
        float a = (float) (1f / (2f - 2f * Math.cos(72f * Math.PI / 180f)));
        float bx = (float) (a * Math.cos(18 * Math.PI / 180f));
        float by = (float) (a * Math.sin(18 * Math.PI / 180f));
        float cy = (float) (-a * Math.cos(18 * Math.PI / 180f));

        vertices = new float[] {
                0, a,.5f,cy,-bx,by,bx,by,-.5f,cy
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 5);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}
