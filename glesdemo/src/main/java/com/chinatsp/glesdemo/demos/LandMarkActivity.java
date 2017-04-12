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


//        initLight(gl);


        float[] eyePosition = {0,10,10};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);

//        float[] lightPosition = {0,10,5,1};
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);

        gl.glPushMatrix();

        antiSmooth(gl);
        for (int i=routePoints.length; i >0; i-=4) {
//            可以实现清除所画内容
//            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

            //深度与角度通过路径点计算
            //深度就是往前的路径点索引
            landMark.setDepth(1);
            //
            landMark.setAngle(calculateAngle());

            landMark.draw(gl);
        }

        gl.glPopMatrix();
    }

    private float calculateAngle() {



        return 5;
    }


    private void initLight(GL10 gl) {

        gl.glClearColor(1,1,1,0);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);

//        //环境光
//        float[] lightAmbient = {0.2f,0.2f,0.2f,1};
//        //漫反射光
//        float[] lightDiffuse = {.2f,.2f,0.2f,1};
//        //镜面反射光
//        float[] lightSpecular = {0.2f,0.2f,0.2f,1};
//
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, lightAmbient, 0);
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightDiffuse, 0);
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, lightSpecular, 0);
//
//        gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, new float[]{0,0,0,0}, 0);

        //发射光
        float[] emission = {0,0,0,1};
        //环境光
        float[] ambient = {0.2f,0.6f,0.2f,0};
        //漫反射特性
//        float[] diffuse = {1,0.5f,0.5f,.5f};
        float[] diffuse = {0.2f,0.6f,0.2f,.5f};
        //镜面反射光色
        float[] specular = {0.2f,0.6f,0.2f,0};
        //镜面反射光亮度
        float[] shineiness = {40f};

        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, ambient, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, specular, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, shineiness, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, emission, 0);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
