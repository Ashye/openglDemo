package com.chinatsp.glesdemov2.demo;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.chinatsp.glesdemov2.base.GL20Renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/17.
 */

public class LandMark extends GL20Renderer {


    private Vector<double[]> path;


    {
        path = new Vector<>();
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


    private FloatBuffer landMarkFB;

    private int mProgram;
    private int maPositionHandle;


    private int muMVPMatrixHandle;
    private float[] mMVPMatrix = new float[16];
    private float[] mVMatrix = new float[16];
    private float[] mProjMatrix = new float[16];




    private float[] mMMatrix = new float[16];


    private float[] vertexes = null;

    private void initShape() {

        float[] triangleCoords = getVertexes();
        vertexes = triangleCoords;


        // initialize vertex Buffer for triangle
        ByteBuffer vbb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 4 bytes per float)
                triangleCoords.length * 4);
        vbb.order(ByteOrder.nativeOrder());// use the device hardware's native byte order
        landMarkFB = vbb.asFloatBuffer();  // create a floating point buffer from the ByteBuffer
        landMarkFB.put(triangleCoords);    // add the coordinates to the FloatBuffer
        landMarkFB.position(0);            // set the buffer to read the first coordinate
    }

    private float[] getVertexes() {
        float[] indices = new float[path.size() * 3];
        int idx = 0;
        double[] origin = path.get(0);
        for (double[] point : path) {
            indices[idx++] = (float) (point[0] - origin[0]) * 10000;
            indices[idx++] = (float) (point[1] - origin[1]) * 10000;
            indices[idx++] = 0f;
        }

        return indices;
    }

    private final String vertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "uniform mat4 uMVPMatrix;   \n" +

                    "attribute vec4 vPosition;  \n" +
                    "void main(){               \n" +

                    // the matrix must be included as a modifier of gl_Position
                    " gl_Position = uMVPMatrix * vPosition; \n" +

                    "}  \n";

    private final String fragmentShaderCode =
            "precision mediump float;  \n" +
                    "void main(){              \n" +
                    " gl_FragColor = vec4 (0.63671875, 0.76953125, 0.22265625, 1.0); \n" +
                    "}                         \n";

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        super.onSurfaceCreated(gl10, eglConfig);

        initShape();

        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        mProgram = GLES20.glCreateProgram();             // create empty OpenGL Program
        GLES20.glAttachShader(mProgram, vertexShader);   // add the vertex shader to program
        GLES20.glAttachShader(mProgram, fragmentShader); // add the fragment shader to program
        GLES20.glLinkProgram(mProgram);                  // creates OpenGL program executables

        // get handle to the vertex shader's vPosition member
        maPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        super.onSurfaceChanged(gl10, i, i1);

        float ratio = (float) i / i1;

        // this projection matrix is applied to object coodinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

        muMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");

    }


    private int currIdx = 1;
    private float[] eyePosition = new float[2];
    private float[] eyeTarget = new float[2];
    private void getPathPointAt(int idx) {

        if (idx < path.size()) {
            eyePosition[0] = vertexes[(idx - 1) * 3];
            eyePosition[1] = vertexes[(idx - 1) * 3 +1];

        }

        if (idx <path.size() -1) {
            eyeTarget[0] = vertexes[(idx-1) * 3];
            eyeTarget[1] = vertexes[(idx-1) * 3 +1];

        }
    }


    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);

        getPathPointAt(currIdx++);
        Matrix.setLookAtM(mVMatrix, 0,
//                0,0,3,
                eyePosition[0], eyePosition[1], 3,
//                0,0,0,
                eyeTarget[0], eyeTarget[1], 0,
                0f, 1.0f, 0.0f);

        // Add program to OpenGL environment
        GLES20.glUseProgram(mProgram);

        // Prepare the triangle data
        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 0, landMarkFB);
        GLES20.glEnableVertexAttribArray(maPositionHandle);


        // Create a rotation for the triangle
//        long time = SystemClock.uptimeMillis() % 4000L;
//        float angle = 0.090f * ((int) time);
//        Matrix.setRotateM(mMMatrix, 0, mAngle, 0, 0, 1.0f);
//        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, mMMatrix, 0);
//        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);


        // Apply a ModelView Projection transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);
        GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);


        // Draw the triangle
        GLES20.glLineWidth(50f);
        GLES20.glDrawArrays(GLES20.GL_LINE_STRIP, 0, path.size());


    }
}
