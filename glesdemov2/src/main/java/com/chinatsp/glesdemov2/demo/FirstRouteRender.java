package com.chinatsp.glesdemov2.demo;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;

import com.chinatsp.glesdemov2.base.GL20Renderer2D;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/5/5.
 */

public class FirstRouteRender extends GL20Renderer2D {

    private List<double[]> path;


    {
        path = new ArrayList<>();
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


        filterDuplicatedPoints(path);
    }

    private void filterDuplicatedPoints(List<double[]> path) {
//        printAllPoints();
        List<double[]> deleted = new ArrayList<>();
        double[] first;
        double[] second;

        for (int i = 1; i < path.size(); i++) {
            first = path.get(i - 1);
            second = path.get(i);
            if (Math.abs(first[0] - second[0]) < Double.MIN_VALUE
                    && Math.abs(first[1] - second[1]) < Double.MIN_VALUE) {
//                path.remove(i);
                deleted.add(path.get(i));
            }
        }
        path.removeAll(deleted);
        Log.e("sssss ", "--------------------------------------------------------------------------");
//        printAllPoints();
    }

    private float[] routeMapToCoordinates(final List<double[]> route) {
        float[] points = new float[route.size() * 3];

        int idx = 0;
        double[] origin = route.get(0);
        for (double[] point : route) {
            points[idx++] = (float) (point[0] - origin[0]) * 10000;
            points[idx++] = (float) (point[1] - origin[1]) * 10000;
            points[idx++] = 0f;
        }
//        printArray(points, 3);
        return points;
    }

    private double getEyeDirectionAngle(double x, double y) {
        return calculateVectorAngle(x, y, 0f, 0.5f);
    }

    private double calculateVectorAngle(double x1, double y1, double x2, double y2) {

        double cos = (x1 * x2 + y1 * y2) /
                (Math.sqrt(x1*x1 +y1*y1) * Math.sqrt(x2*x2 + y2*y2));
        double angle = Math.round(Math.toDegrees(Math.acos(cos)));

        double axb = x1 * y2 - x2 * y1;
        if (axb <0) {
            angle = - Math.abs(angle);
        }else {
            angle = Math.abs(angle);
        }
        Log.e("sss", "index:    angle:"+angle+ " cos:"+cos);
        return angle;
    }


    private float[] points;
    private int currPosition = 0;

    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);

        if (currPosition < path.size() -6) {
            points = routeMapToCoordinates(path.subList(currPosition, currPosition + 6));
        }


        //        float angle = 0.090f * ((int) time);
        double angle = getEyeDirectionAngle(points[3], points[4]);
        Matrix.setRotateM(mMMatrix, 0, (float) angle, 0, 0, 1f);

        //平移视线
        Matrix.translateM(mVMatrix, 0, 0, -1f, 0);

        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, mMMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);

        //         Apply a ModelView Projection transformation
        GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);



        drawLine(GLES20.GL_LINE_STRIP, points, null);

        currPosition ++;
    }
}
