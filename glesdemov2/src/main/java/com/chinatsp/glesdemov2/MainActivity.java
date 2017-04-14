package com.chinatsp.glesdemov2;

import com.chinatsp.glesdemov2.base.GL20Renderer;
import com.chinatsp.glesdemov2.base.OpenGLES20Activity;
import com.chinatsp.glesdemov2.demo.RoutineRenderer;

public class MainActivity extends OpenGLES20Activity {


    @Override
    protected void onStart() {
        super.onStart();

        glSurfaceView.postDelayed(new Runnable() {
            @Override
            public void run() {
                glSurfaceView.requestRender();
                glSurfaceView.postDelayed(this, 200);
            }
        }, 200);
    }

    @Override
    protected GL20Renderer createRenderer() {
//        return new TrangleRenderer();
//        return new TrangleRenderer();
        return new RoutineRenderer();
    }
}
