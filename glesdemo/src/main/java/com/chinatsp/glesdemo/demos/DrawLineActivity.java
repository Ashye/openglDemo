package com.chinatsp.glesdemo.demos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawLineActivity extends OpenGLESActivity {

//    float[] vertexArray = new float[]{
//            -0.8f , -0.4f * 1.732f , 0.0f ,
//            -0.4f , 0.4f * 1.732f , 0.0f ,
//            0.0f , -0.4f * 1.732f , 0.0f ,
//            0.4f , 0.4f * 1.732f , 0.0f ,
//    };

    float[] vertexArray = new float[]{
            -0.8f , -0.4f * 1.732f , 0.0f ,
            -0.4f , 0.4f * 1.732f , 0.0f ,
            0.0f , -0.4f * 1.732f , 0.0f ,
            0.4f , 0.4f * 1.732f , 0.0f ,
    };

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

//        gl.glColor4f(1f, 0f,0f,1f);
//        gl.glPointSize(8f);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-4);


        antiSmooth(gl);

        gl.glLineWidth(10);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);

//        index ++;
//        index %= 10;
        switch (index) {
            case 0:
            case 1:
            case 2:
                gl.glColor4f(1f,0f,0f,1f);
                gl.glDrawArrays(GL10.GL_LINES, 0, 4);
                break;
            case 3:
            case 4:
            case 5:
                gl.glColor4f(0f,1f,0f,1f);
                gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 4);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                gl.glColor4f(0f,0f,1f,1f);
                gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
                break;
        }

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    private int index = 0;
}
