package com.chinatsp.glesdemo.demos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class AntiSmoothActivity extends OpenGLESActivity {

    float[] vertexArray = new float[]{
            -0.8f , -0.4f * 1.732f , 0.0f ,
            0.8f , -0.4f * 1.732f , 0.0f ,
            0.0f , 0.4f * 1.732f , 0.0f ,
    };


    private void antiSmooth(GL10 gl) {
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glEnable(GL10.GL_POINT_SMOOTH);
        gl.glHint(GL10.GL_POINT_SMOOTH_HINT, GL10.GL_NICEST);

        gl.glEnable(GL10.GL_LINE_SMOOTH);
        gl.glHint(GL10.GL_LINE_SMOOTH_HINT, GL10.GL_NICEST);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        antiSmooth(gl);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

        gl.glColor4f(1f, 0f,0f,1f);
        gl.glPointSize(8f);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-4);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 3);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
