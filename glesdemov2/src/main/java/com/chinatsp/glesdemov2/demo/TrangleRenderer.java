package com.chinatsp.glesdemov2.demo;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;

import com.chinatsp.glesdemov2.base.GL20Renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.R.attr.angle;

/**
 * Created by zhangwei on 2017/4/14.
 */

public class TrangleRenderer extends GL20Renderer{

    private FloatBuffer triangleVB;

    private int mProgram;
    private int maPositionHandle;

    private int muMVPMatrixHandle;
    private float[] mMVPMatrix = new float[16];
    private float[] mVMatrix = new float[16];
    private float[] mProjMatrix = new float[16];



    private float[] mMMatrix = new float[16];

//    public float mAngle;


    private void initShape() {
        float triangleCoords[] = {
                // X, Y, Z
                -0.5f, -0.25f, 0,
                0.5f, -0.25f, 0,
                0.0f,  0.559016994f, 0
        };

        // initialize vertex Buffer for triangle
        ByteBuffer vbb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 4 bytes per float)
                triangleCoords.length * 4);
        vbb.order(ByteOrder.nativeOrder());// use the device hardware's native byte order
        triangleVB = vbb.asFloatBuffer();  // create a floating point buffer from the ByteBuffer
        triangleVB.put(triangleCoords);    // add the coordinates to the FloatBuffer
        triangleVB.position(0);            // set the buffer to read the first coordinate

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
        Matrix.setLookAtM(mVMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);



        // Add program to OpenGL environment
        GLES20.glUseProgram(mProgram);

        // Prepare the triangle data
        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 12, triangleVB);
        GLES20.glEnableVertexAttribArray(maPositionHandle);


        // Create a rotation for the triangle
//        long time = SystemClock.uptimeMillis() % 4000L;
//        float angle = 0.090f * ((int) time);
        Matrix.setRotateM(mMMatrix, 0, mAngle, 0, 0, 1.0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, mMMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);


        // Apply a ModelView Projection transformation
//        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);
        GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);


        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
    }
}
