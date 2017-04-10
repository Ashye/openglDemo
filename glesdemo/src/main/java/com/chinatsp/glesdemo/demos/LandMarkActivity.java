package com.chinatsp.glesdemo.demos;

import android.graphics.Point;
import android.opengl.GLU;

import com.chinatsp.glesdemo.demos.Model.LandMark;

import javax.microedition.khronos.opengles.GL10;

public class LandMarkActivity extends OpenGLESActivity {



    private LandMark landMark;

    private float[] routePoints = {
            0,0,1,1,
        0,0,2,1,
        0,0,3,1,
        0,0,4,1,
        0,0,5,1,
        0,0,6,1,
        0,0,7,1,
        0,0,8,1,

    };


    @Override
    protected void onStart() {
        super.onStart();

        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

        landMark = new LandMark(point.x, point.y);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();


        float[] eyePosition = {0,10,20};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);

        gl.glPushMatrix();

//        for (int i=routePoints.length; i >0; i-=4) {
//            可以实现清除所画内容
//            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

            //深度与角度通过路径点计算
            //深度就是往前的路径点索引
            landMark.setDepth(8);
            //
            landMark.setAngle(calculateAngle());

            landMark.draw(gl);
//        }

        gl.glPopMatrix();
    }

    private float calculateAngle() {



        return 20;
    }

}
