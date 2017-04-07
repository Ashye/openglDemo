package com.chinatsp.glesdemo;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/5.
 */

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private final IOpenGLDemo openGLDemo;

    public OpenGLRenderer(IOpenGLDemo demo) {
        openGLDemo = demo;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0f,0f,0f,.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearDepthf(1f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);
        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset the projection matrix
        gl.glLoadIdentity();
        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45f, (float) width / (float) height, 0.1f, 100.0f);
        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // Reset the modelview matrix
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        if (openGLDemo != null) {
            openGLDemo.DrawScene(gl);
        }
    }


    public interface IOpenGLDemo {
        void DrawScene(GL10 gl);
    }
}
