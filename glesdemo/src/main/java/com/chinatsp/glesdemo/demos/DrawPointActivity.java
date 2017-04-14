package com.chinatsp.glesdemo.demos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawPointActivity extends OpenGLESActivity {

    float[] vertexArray = new float[]{
            -0.8f , -0.4f * 1.732f , 0.0f ,
            0.8f , -0.4f * 1.732f , 0.0f ,
            0.0f , 0.4f * 1.732f , 0.0f ,
    };

//    float[] vertexArray = {
//            -1.0f, 1.0f, 1.0f,
//            -1.0f, -1.0f, 1.0f,
//            1.0f, -1.0f, 1.0f,
//            1.0f, 1.0f, 1.0f,
//
//            //后面
//            -1.0f, 1.0f, -1.0f,
//            -1.0f, -1.0f, -1.0f,
//            1.0f, -1.0f, -1.0f,
//            1.0f, 1.0f, -1.0f,
//    };

//    short[] indices = {0,1,2,3,4,5,6,7};

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

//        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
//        ibb.order(ByteOrder.nativeOrder());
//        ShortBuffer indice = ibb.asShortBuffer();
//        indice.put(indices);
//        indice.position(0);

        gl.glColor4f(1f, 0f,0f,1f);
        gl.glPointSize(8f);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-4);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
//        gl.glDrawElements(GL10.GL_POINTS, indices.length, GL10.GL_UNSIGNED_SHORT, indice);
        gl.glDrawArrays(GL10.GL_POINTS, 0, vertexArray.length/3);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
