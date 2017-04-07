package com.chinatsp.glesdemo.demos;

import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawArrowActivity extends OpenGLESActivity {

//    private float[] vertexes = new float[] {
//        -2f, 0, -4f, 1f,
//        -2f, 0f, 4f, 1f,
//        2, 0, 4, 1f,
//        2, 0, -4, 1f
//    };
//
//    private short[] indices = new short[] {
//        0,1,2,0,2,3
//    };

    private float[] vertexes = new float[] {
        0,0,0,1,
            -8, -1, 4, 1,
            -8, -1, 5, 1,
            0,0,1,1,
            8, -1, 5, 1,
            8, -1, 4, 1
    };

    private short[] indices = new short[] {
        0,1,2,0,2,3,3,4,5,3,5,0
    };

    private FloatBuffer vertexBuffer;
    private ShortBuffer indiceBuffer;

    {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexes.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertexes);
        vertexBuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        indiceBuffer = ibb.asShortBuffer();
        indiceBuffer.put(indices);
        indiceBuffer.position(0);


    }

    private void initLight(GL10 gl) {

        gl.glClearColor(1,1,1,0);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);

        //环境光
        float[] lightAmbient = {1,1,1,1};
        //漫反射光
        float[] lightDiffuse = {1,1,1,1};
        //镜面反射光
        float[] lightSpecular = {1,1,1,1};

        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, lightAmbient, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightDiffuse, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, lightSpecular, 0);

        gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, new float[]{0,0,0,0}, 0);

        //发射光
        float[] emission = {0,0,0,1};
        //环境光
        float[] ambient = {0.2f,0.2f,0.2f,0};
        //漫反射特性
        float[] diffuse = {1,0.5f,0.5f,.5f};
        //镜面反射光色
        float[] specular = {0.5f,0.5f,0.5f,0};
        //镜面反射光亮度
        float[] shineiness = {10f};

        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, ambient, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, specular, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, shineiness, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, emission, 0);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }



    private void lightOff(GL10 gl) {
        gl.glDisable(GL10.GL_LIGHT0);
        gl.glDisable(GL10.GL_LIGHTING);
    }

    private void drawSquare(GL10 gl) {
        gl.glColor4f(1f, 1, 1, 1);
        gl.glPointSize(20f);

        gl.glPushMatrix();
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(4, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indiceBuffer);
        gl.glPopMatrix();

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        //light
//        initLight(gl);
        float[] lightPosition = {0,3,6,1};

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glPushMatrix();
        gl.glLoadIdentity();

        float[] eyePosition = {20,10,10};

        eyePosition[0] -= angle * 0.1;
//        eyePosition[2] -= angle * 0.1;

//        eyePosition[2] -= step * angle /2;
//        eyePosition[1] -= step * angle /3;
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);

        gl.glPushMatrix();
//        gl.glRotatef(angle, 1,0,0);
        //在 lookat 后，固定在空间中，与视角无关，类似普通物体
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);
        gl.glPopMatrix();

        //square
        gl.glPushMatrix();
        drawSquare(gl);
        gl.glPopMatrix();

        gl.glLoadIdentity();
//        lightOff(gl);


        if (eyePosition[0] >0.5) {
            angle++;
        }


    }

    private float step = 0.1f;
    private int count = 0;
    private float angle = 0;
}
