package com.chinatsp.glesdemo.demos;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chinatsp.glesdemo.OpenGLRenderer;

import javax.microedition.khronos.opengles.GL10;

public abstract class OpenGLESActivity extends AppCompatActivity implements OpenGLRenderer.IOpenGLDemo {

    private GLSurfaceView mGlSurfaceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow()
                .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mGlSurfaceView = new GLSurfaceView(this);
//        mGlSurfaceView.setEGLConfigChooser(new GLSurfaceView.EGLConfigChooser() {
//
//            @Override
//            public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
//                int[] attrList = new int[] { //
//                        EGL10.EGL_SURFACE_TYPE, EGL10.EGL_WINDOW_BIT, //
//                        EGL10.EGL_RED_SIZE, 8, //
//                        EGL10.EGL_GREEN_SIZE, 8, //
//                        EGL10.EGL_BLUE_SIZE, 8, //
//                        EGL10.EGL_DEPTH_SIZE, 16, //
//                        EGL10.EGL_SAMPLE_BUFFERS, 1,
//                        EGL10.EGL_SAMPLES, 2,
//                        EGL10.EGL_NONE //
//                };
//                EGLConfig[] configOut = new EGLConfig[1];
//                int[] configNumOut = new int[1];
//                egl.eglChooseConfig(display, attrList, configOut, 1, configNumOut);
//                return configOut[0];
//            }
//        });
        mGlSurfaceView.setRenderer(new OpenGLRenderer(this));
        mGlSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        setContentView(mGlSurfaceView);
    }

    @Override
    public void DrawScene(GL10 gl) {
        gl.glClearColor(0f,0f,0f,1f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGlSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGlSurfaceView.onPause();
    }
}
