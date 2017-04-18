package com.chinatsp.glesdemo.demos.Model;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class Routine {

    private Vector<double[]> path;


//    {
//        path = new Vector<>();
//        path.add(new double[] {113.95643f,22.53511f});
//        path.add(new double[] {113.95656f,22.53504f});
//        path.add(new double[] {113.95683f,22.53491f});
//        path.add(new double[] {113.95687f,22.53498f});
//        path.add(new double[] {113.95675,22.53504});
//        path.add(new double[] {113.9565f,22.53516f});
//        path.add(new double[] {113.95566,22.53557});
//        path.add(new double[] {113.95559,22.5356});
//        path.add(new double[] {113.95403,22.5364});
//        path.add(new double[] {113.95402,22.53665});
//        path.add(new double[] {113.954,22.53713});
//        path.add(new double[] {113.954,22.53721});
//        path.add(new double[] {113.95399,22.53752});
//        path.add(new double[] {113.95398,22.53829});
//        path.add(new double[] {113.95397,22.53888});
//        path.add(new double[] {113.95395,22.53895});
//        path.add(new double[] {113.95396,22.53938});
//    }

    private FloatBuffer vertexes;
    private int vertexSize = 0;



    private LandMark landMark;


    public Routine(Vector<double[]> path) {
        setPath(path);

        landMark = new LandMark(1024, 768);
    }

    public Routine() {
        this(null);
    }


    private void setPath(final Vector<double[]> route) {
        // TODO: 2017/4/14 for test
        path = route;
        float[] points = routeMapToCoordinates(path);

        ByteBuffer vbb = ByteBuffer.allocateDirect(points.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexes = vbb.asFloatBuffer();
        vertexes.put(points);
        vertexes.position(0);
//        vertexSize = points.length /4;
        vertexSize = path.size();
    }


    private float[] routeMapToCoordinates(final Vector<double[]> route) {
//        float[] points = new float[route.size() * 4];

        float[] points = new float[path.size() * 3];
        int idx = 0;
        double[] origin = path.get(0);
        for (double[] point : path) {
            points[idx++] = (float) (point[0] - origin[0]) * 10000;
            points[idx++] = (float) (point[1] - origin[1]) * 10000;
            points[idx++] = 0f;
        }

//        float[] points = {
//            0,0,0,1,
//                1,1,1,1,
//                1.5f,1.5f,1.5f,1f,
//                2,2,2,1,
//                3,3,3,1,
//        };

        printArray(points, 3);
        return points;
    }

    private void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i=0; i< data.length; i++) {
            System.out.print(" "+ data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }


    public void draw(GL10 gl) {

        gl.glColor4f(1f, 0f,0f,1f);
        gl.glPointSize(10f);



        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        Log.e("sss", "sss ====>"+ vertexSize);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
        gl.glDrawArrays(GL10.GL_POINTS, 0, vertexSize);

        gl.glFlush();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }


}
