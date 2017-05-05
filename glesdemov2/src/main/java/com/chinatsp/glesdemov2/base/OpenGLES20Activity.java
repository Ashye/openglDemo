package com.chinatsp.glesdemov2.base;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



public abstract class OpenGLES20Activity extends AppCompatActivity {

    protected GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GL20Renderer renderer = createRenderer3D();
        if (renderer != null) {
            glSurfaceView = new MySurfaceView(this, renderer);
        }else {
            glSurfaceView = new MySurfaceView(this, createRenderer());
        }
        setContentView(glSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    protected abstract GL20Renderer2D createRenderer();
    protected abstract GL20Renderer createRenderer3D();
}
