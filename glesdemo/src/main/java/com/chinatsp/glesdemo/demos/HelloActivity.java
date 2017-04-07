package com.chinatsp.glesdemo.demos;

import android.os.Bundle;

import javax.microedition.khronos.opengles.GL10;

public class HelloActivity extends OpenGLESActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void DrawScene(GL10 gl) {
        gl.glClearColor(1f,0f,0f,0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }
}
