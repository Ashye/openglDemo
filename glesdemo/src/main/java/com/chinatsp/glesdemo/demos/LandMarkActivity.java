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


    private Routine routine;

    private LandMark landMark;
    private final int markCount = 8;

    /**
     * 车头航向
     */
    private int directionOfCar = 100;


    @Override
    protected void onStart() {
        super.onStart();

        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

        routine = new Routine(path);
        landMark = new LandMark(point.x, point.y);

//        float[] points = getVertexes();
//
//        printArray(points, 3);


//        mGlSurfaceView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mGlSurfaceView.requestRender();
//
//                if (currPosition < path.size() - 2) {
//                    mGlSurfaceView.postDelayed(this, 1000);
//                }
//            }
//        }, 1000);

    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

//        long startTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene start ===>"+startTime);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();


        float[] eyePosition = {0,10,10};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);


        gl.glPushMatrix();

        antiSmooth(gl);


//        angletwoTest();
//        getAngle();

//        printAllPointAngle();

        landMark.setAngle(angletwoTest());
        landMark.draw(gl);
//        routine.draw(gl);

        gl.glPopMatrix();
//        long endTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene end ===>"+ endTime + " duration:"+(endTime - startTime));

        currPosition ++;
    }

    private int currPosition = 3;
//    private float getAngle() {
//        if (currPosition > path.size() - 3) {
//            return 0f;
//        }
//
//
////        double[] a = path.get(currPosition);
////        double[] b = path.get(currPosition +1);
////        double[] c = path.get(currPosition +2);
////
//        double[] a = {-8.385278, 4.8952637};
//        double[] b = {-23.98528, 12.8952637};
//        double[] c = {-24.085278, 15.395264};
//
//
//        double sideC = Util.getrelativeDistance(a[0], a[1], b[0], b[1]);
//        double sideA = Util.getrelativeDistance(b[0], b[1], c[0], c[1]);
//        double sideB = Util.getrelativeDistance(a[0], a[1], c[0], c[1]);
//
//
//        double cosB = (sideA * sideA + sideC * sideC - sideB * sideB) / (2 * sideA * sideC);
//
//        Log.e("sss", "sss cosb: "+cosB);
//
//
//        double angle = Math.toDegrees(Math.acos(cosB));
//
////        angle = 180 - angle;
//
//        if (c[0] > b[0]) {
//            angle = 180 - angle;
//        }
////
////
////        if (c[0] - b[0] <0) {
////            angle *= -1;
////        }
//
//        Log.e("ss", String.format("%f, %f, %f, %f", sideA, sideB, sideC, angle));
//
//        return (float) angle;
//    }

    private int angleStandard = 0;
    private int angletwoTest() {

        if (currPosition > path.size() -2) {
            return 0;
        }

        // TODO: 2017/4/18 for test
        if (currPosition < 1) {
            angleStandard = 0;
        }else {
            angleStandard = getAngleBetweenPoints(path.get(currPosition-1), path.get(currPosition));
        }
        int andnow = getAngleBetweenPoints(path.get(currPosition), path.get(currPosition+1));

//        double[] first = path.get(currPosition);
//        double[] second = path.get(currPosition+1);
//        int angleOffset = getAngleBetweenPoints(first, second);
        int angle = andnow - angleStandard;
//
//        if (currPosition == 0) {
//            angleStandard = angleOffset;
//        }else {
//            angle = angleOffset - angleStandard;
//            angleStandard = angleOffset;
//        }
//        Log.e("sssss ", "======"+currPosition+"=======: "+angle);
//        Log.e("ss", String.format("s: %d, next: %d, angle:%d", angleStandard, andnow, angle));
        return angle;
    }

    private int getAngleBetweenPoints(double[] first, double[] second) {
        int angle = Util.LngLatToOrient(first[0], first[1], second[0], second[1]);
        return Util.ConvertAngleIn0_180(angle);
    }

    private void printAllPointAngle() {

        int angle = getAngleBetweenPoints(path.get(currPosition), path.get(currPosition +1));
        Log.e("sssss ", "======"+currPosition+"=======: "+ angleStandard +"   "+angle + "  offsetAngle: "+(angle - angleStandard));
        angleStandard = angle;

    }

//    private float[] getVertexes() {
//        float[] indices = new float[path.size() * 3];
//        int idx = 0;
//        double[] origin = path.get(0);
//        for (double[] point : path) {
//            indices[idx++] = (float) (point[0] - origin[0]) * 10000;
//            indices[idx++] = (float) (point[1] - origin[1]) * 10000;
//            indices[idx++] = 0f;
//        }
//
//        return indices;
//    }
//
//    private void printArray(float[] data, int unitSize) {
//        System.out.println("print array:");
//
//        for (int i=0; i< data.length; i++) {
//            System.out.print(" "+ data[i]);
//            if ((i + 1) % unitSize == 0) {
//                System.out.println();
//            }
//        }
//
//        System.out.println();
//    }
}
