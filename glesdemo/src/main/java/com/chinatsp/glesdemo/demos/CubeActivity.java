package com.chinatsp.glesdemo.demos;

import android.opengl.GLU;

import com.chinatsp.glesdemo.demos.Model.Cube;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CubeActivity extends OpenGLESActivity {

    private Cube cube = new Cube(4, 1f, 6);


    float[] lightPos = new float[]{1, 10, 0, 0,
            0,0,0,1
    };
    private void drawLight(GL10 gl) {
        gl.glLoadIdentity();
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glClearDepthf(1f);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glShadeModel(GL10.GL_SMOOTH);

        gl.glEnable(GL10.GL_LIGHT0);


        float[] maamb = { 0f, 1f, .0f, 1.0f, };
        float[] madiff = { 1f, 0f, 0f, 1.0f, };
        float[] maspec = { 0.8f, 0.8f, .8f, 1.0f, };
        float[] mashin = { 32 };


        float[] shin = { 64 };
        float[] amb = { 0f, 1f, .0f, 1.0f, };
        float[] diff = { 1f, 0f, 0f, 1.0f, };
        float[] spec = { 0.8f, 0.8f, .8f, 1.0f, };
        float[] spot_dir = { 0.0f, 0f, 1f, };


        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPos, 0);
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPOT_DIRECTION, spot_dir, 0);

        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, diff, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, spec, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, amb, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SHININESS, shin, 0);
        gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, amb, 0);


        gl.glMaterialfv(GL10.GL_FLOAT, GL10.GL_SHININESS, mashin, 0);
        gl.glMaterialfv(GL10.GL_FLOAT, GL10.GL_SPECULAR, maspec, 0);
        gl.glMaterialfv(GL10.GL_FLOAT, GL10.GL_AMBIENT, maamb, 0);
        gl.glMaterialfv(GL10.GL_FLOAT, GL10.GL_DIFFUSE, madiff, 0);


    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);


        drawTest(gl, lightPos);

        gl.glLoadIdentity();
        drawLight(gl);

        gl.glLoadIdentity();
        GLU.gluLookAt(gl, 0, 5, 10,
                0, 0, 0,
                0, 1, 0);

//        count ++;
//        if (count >= 20) {
//            goAround();
//        }

//        cube.x = 1;
//        cube.y = 1;
//        cube.z = -2;
        cube.draw(gl);


    }

    private int count = 0;
    private void goAround() {
        if (cube.x <= 2) {
            cube.x += 0.1f;
        }else if (cube.y <=2) {
            cube.y += .1f;
        }else if (cube.z <=2 ){
            cube.z += .1f;
        }else {
            cube.x = 0;
            cube.y = 0;
            cube.z = 0;

        }
    }


//    float[] vertexArray = new float[]{
//            -0.8f , -0.4f * 1.732f , 0.0f ,
//            0.8f , -0.4f * 1.732f , 0.0f ,
//            0.0f , 0.4f * 1.732f , 0.0f ,
//    };
    float[] vertexArray = new float[]{
        0f,0f,0f,
        1f,1f,1f,
    };

    private void drawTest(GL10 gl, float[] position) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(position.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(position);
        vertex.position(0);

        gl.glColor4f(1f, 0f,0f,0f);
        gl.glPointSize(20f);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertex);
        gl.glDrawArrays(GL10.GL_POINTS, 0, 1);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

}
