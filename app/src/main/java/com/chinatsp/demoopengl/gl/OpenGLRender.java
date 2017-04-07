package com.chinatsp.demoopengl.gl;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/1.
 */

public class OpenGLRender implements GLSurfaceView.Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0f, 0f, 0f, 0.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, 1.0f * width / height, 0.1f, 100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }



    SmoothColoredSquare square = new SmoothColoredSquare();

    private float angle = 0;


    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -10);

        //A
        gl.glPushMatrix();
        gl.glRotatef(angle, 0,0,1);
        square.draw(gl);
        gl.glPopMatrix();

        //B
        gl.glPushMatrix();
        gl.glRotatef(-angle, 0,0,1);
        gl.glTranslatef(2,0,0);
        gl.glScalef(.5f,.5f,.5f);
        square.draw(gl);

        //C
        gl.glPushMatrix();
        gl.glRotatef(-angle, 0,0,1);
        gl.glTranslatef(2,0,0);
        gl.glScalef(.5f,.5f,.5f);
        gl.glRotatef(angle * 5, 0,0,1);
        square.draw(gl);

        gl.glPopMatrix();
        gl.glPopMatrix();


        angle++;
    }
}
