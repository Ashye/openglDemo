package com.chinatsp.glesdemov2;

import com.chinatsp.glesdemov2.base.GL20Renderer2D;
import com.chinatsp.glesdemov2.base.OpenGLES20Activity;
import com.chinatsp.glesdemov2.demo.RobotRender;

public class MainActivity extends OpenGLES20Activity {


    @Override
    protected void onStart() {
        super.onStart();

//        glSurfaceView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                glSurfaceView.requestRender();
//                glSurfaceView.postDelayed(this, 200);
//            }
//        }, 200);
    }

    @Override
    protected GL20Renderer2D createRenderer() {
//        return new TrangleRenderer();
//        return new RoutineRenderer();
//        return new GL20Renderer2D();
        return new RobotRender();
    }
}