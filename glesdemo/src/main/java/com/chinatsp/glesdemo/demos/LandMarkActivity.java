package com.chinatsp.glesdemo.demos;

import android.graphics.Point;
import android.opengl.GLU;
import android.util.Log;

import com.chinatsp.glesdemo.demos.Model.LandMark;
import com.chinatsp.glesdemo.demos.Model.Routine;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class LandMarkActivity extends OpenGLESActivity {

    //经纬度
    private Vector<double[]> path = new Vector<>();

    {
        path.add(new double[] {113.95643f,22.53511f});
        path.add(new double[] {113.95656f,22.53504f});
        path.add(new double[] {113.95683f,22.53491f});
        path.add(new double[] {113.95687f,22.53498f});
        path.add(new double[] {113.95675,22.53504});
        path.add(new double[] {113.9565f,22.53516f});
        path.add(new double[] {113.95566,22.53557});
        path.add(new double[] {113.95559,22.5356});
        path.add(new double[] {113.95403,22.5364});
        path.add(new double[] {113.95402,22.53665});
        path.add(new double[] {113.954,22.53713});
        path.add(new double[] {113.954,22.53721});
        path.add(new double[] {113.95399,22.53752});
        path.add(new double[] {113.95398,22.53829});
        path.add(new double[] {113.95397,22.53888});
        path.add(new double[] {113.95395,22.53895});
        path.add(new double[] {113.95396,22.53938});
        path.add(new double[] {113.95394,22.53987});
        path.add(new double[] {113.95393,22.54012});
        path.add(new double[] {113.95386,22.54038});
        path.add(new double[] {113.95329,22.54035});
        path.add(new double[] {113.95268,22.54032});
        path.add(new double[] {113.95241,22.54031});
        path.add(new double[] {113.95171,22.54028});
        path.add(new double[] {113.95131,22.54026});
        path.add(new double[] {113.94914,22.54016});
    }


    private LandMark landMark;
    private Routine routine;

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
        routine = new Routine(path);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        long startTime = System.currentTimeMillis();
        Log.e("ssssssss", "drawScene start ===>"+startTime);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();


//        initLight(gl);


        float[] eyePosition = {0,0,50};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,30,0, 0,1,0);

//        float[] lightPosition = {0,10,5,1};
//        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);

        gl.glPushMatrix();

        antiSmooth(gl);

        routine.draw(gl);
//        landMark.draw(gl);
//        float[] angles = calculateAngle(path);
//        for (int i=0; i< angles.length; i++) {
////            可以实现清除所画内容
////            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
//
//            //深度与角度通过路径点计算
//            //深度就是往前的路径点索引
////            landMark.setDepth(1);
//            //
//            landMark.setDepth(5);
//            landMark.setAngle(angles[i]);
//
//            landMark.draw(gl);
//        }




        gl.glPopMatrix();
        long endTime = System.currentTimeMillis();
        Log.e("ssssssss", "drawScene end ===>"+ endTime + " duration:"+(endTime - startTime));
    }

    private float[] calculateAngle(Vector<double[]> path) {
        float[] angles = new float[path.size()];
        angles[0] = 0;
        if (path.size() >1) {
            for (int i=1; i<path.size(); i++) {
                angles[i] = getAngle3(path.get(i-1), path.get(i));
            }

        }

        return angles;
    }

    private float getAngle3(double[] first, double[] second) {

        double an = CalculationLogLatDistance.GetAzimuth(first[0], first[1], second[0], second[1]);

        float angle = (float) an;
        Log.e("sss", "angle ==>"+angle);
        return angle;
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
