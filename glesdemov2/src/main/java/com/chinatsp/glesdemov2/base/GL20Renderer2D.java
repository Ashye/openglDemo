package com.chinatsp.glesdemov2.base;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/20.
 */

public class GL20Renderer2D implements GLSurfaceView.Renderer {

    protected int mProgram;
    protected int maPositionHandle;
    protected int maColorHandle;
    protected float mAngle = 0;


    protected int muMVPMatrixHandle;
    protected float[] mMVPMatrix = new float[16];
    protected float[] mVMatrix = new float[16];
    protected float[] mProjMatrix = new float[16];


    protected float[] mMMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);


        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        mProgram = GLES20.glCreateProgram();             // create empty OpenGL Program
        GLES20.glAttachShader(mProgram, vertexShader);   // add the vertex shader to program
        GLES20.glAttachShader(mProgram, fragmentShader); // add the fragment shader to program
        GLES20.glLinkProgram(mProgram);                  // creates OpenGL program executables

        // get handle to the vertex shader's vPosition member
        maPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        maColorHandle = GLES20.glGetAttribLocation(mProgram, "vColor");
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        GLES20.glViewport(0,0, i, i1);

        float ratio = (float) i / i1;

        // this projection matrix is applied to object coodinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjMatrix, 0, -ratio, ratio, -1, 1, 1, 7);

        muMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        Matrix.setLookAtM(mVMatrix, 0,
                0,0,3f,
                0,0,0,
                0f, 1f, 0.0f);


        // Add program to OpenGL environment
        GLES20.glUseProgram(mProgram);


////         Apply a ModelView Projection transformation
//        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);
//        GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);


        GLES20.glLineWidth(5f);

        //画内容




        // Add program to OpenGL environment
//        GLES20.glUseProgram(mProgram);

        // Prepare the triangle data
//        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 0, triangleVB);
//        GLES20.glEnableVertexAttribArray(maPositionHandle);


        // Create a rotation for the triangle
//        long time = SystemClock.uptimeMillis() % 4000L;
//        float angle = 0.090f * ((int) time);
//        Matrix.setRotateM(mMMatrix, 0, mAngle, 0, 0, 1.0f);
//        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, mMMatrix, 0);
//        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);


        // Apply a ModelView Projection transformation
//        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);
//        GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);


        // Draw the triangle
//        GLES20.glLineWidth(200f);
//        GLES20.
//        GLES20.glDrawArrays(GLES20.GL_LINE_STRIP, 0, path.size());

    }


    protected void drawCircle(float centerX, float centerY, float radius) {
        drawArc(centerX, centerY, 0f, 360f, radius);
    }

    protected void drawSoftStrokeRect(float centerX, float centerY, float width, float height, float radius, float[] color) {
        float[] varc0 = calculateArcPoints(centerX - width/2, centerY + (height/2 + radius), 90f, 180f, radius);
        float[] varc1 = calculateArcPoints(centerX - width/2, centerY - (height/2 + radius), 180f, 270f, radius);
        float[] varc2 = calculateArcPoints(centerX + width/2, centerY - (height/2 + radius), 270f, 360f, radius);
        float[] varc3 = calculateArcPoints(centerX + width/2, centerY + (height/2 + radius), 0f, 90f, radius);

        float[] vertexes = new float[varc0.length + varc1.length + varc2.length + varc3.length];
        int offset = 0;
        System.arraycopy(varc0, 0, vertexes, offset, varc0.length);
        offset += varc0.length;
        System.arraycopy(varc1, 0, vertexes, offset, varc0.length);
        offset += varc1.length;
        System.arraycopy(varc2, 0, vertexes, offset, varc0.length);
        offset += varc2.length;
        System.arraycopy(varc3, 0, vertexes, offset, varc0.length);

        drawLine(GLES20.GL_LINE_LOOP, vertexes, color);
    }

    protected void drawStrokeRect(float centerX, float centerY, float width, float height, float[] color) {
        float[] points = {
                centerX - width / 2, centerY - height / 2, 0,
                centerX - width / 2, centerY + height / 2, 0,
                centerX + width / 2, centerY + height / 2, 0,
                centerX + width / 2, centerY - height / 2, 0
        };
        drawLine(GLES20.GL_LINE_LOOP, points, color);
    }

    protected void drawStrokeTriangle(float centerX, float centerY, float side) {
        float height = (float) Math.sin(Math.toRadians(60))*side;
        float[] points = {
                centerX, centerY + height/2, 0,
                centerX - side/2, centerY - height/2, 0,
                centerX + side/2, centerY - height/2, 0
        };
//        printArray(points, 3);

        drawLine(GLES20.GL_LINE_LOOP, points, null);
    }

    protected void drawGraph(int mode, float[] vertexes, short[] indices, float[] color) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexes.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vb = vbb.asFloatBuffer();
        vb.put(vertexes);
        vb.position(0);


        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        ShortBuffer ib = ibb.asShortBuffer();
        ib.put(indices);
        ib.position(0);


        FloatBuffer cb = null;
        if (color != null) {
            ByteBuffer cbb = ByteBuffer.allocateDirect(color.length * 4);
            cbb.order(ByteOrder.nativeOrder());
            cb = cbb.asFloatBuffer();
            cb.put(color);
            cb.position(0);
        }


        // Prepare the triangle data
        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 0, vb);
        GLES20.glEnableVertexAttribArray(maPositionHandle);




        if (cb != null) {
            GLES20.glEnableVertexAttribArray(maColorHandle);
            GLES20.glVertexAttribPointer(maColorHandle, 4, GLES20.GL_FLOAT, false, 0, cb);
        }

        GLES20.glDrawElements(mode, indices.length, GLES20.GL_UNSIGNED_SHORT, ib);

        GLES20.glDisableVertexAttribArray(maPositionHandle);
        if (cb != null) {
            GLES20.glDisableVertexAttribArray(maColorHandle);
        }
    }

    protected void drawGraph(int mode, float[] vertexes, float[] color) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexes.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vb = vbb.asFloatBuffer();
        vb.put(vertexes);
        vb.position(0);


        FloatBuffer cb = null;
        if (color != null) {
            ByteBuffer cbb = ByteBuffer.allocateDirect(color.length * 4);
            cbb.order(ByteOrder.nativeOrder());
            cb = cbb.asFloatBuffer();
            cb.put(color);
            cb.position(0);
        }


        // Prepare the triangle data
        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 0, vb);
        GLES20.glEnableVertexAttribArray(maPositionHandle);

        if (cb != null) {
            GLES20.glEnableVertexAttribArray(maColorHandle);
            GLES20.glVertexAttribPointer(maColorHandle, 4, GLES20.GL_FLOAT, false, 0, cb);
        }

        GLES20.glDrawArrays(mode, 0, vertexes.length /3);

        GLES20.glDisableVertexAttribArray(maPositionHandle);
        if (cb != null) {
            GLES20.glDisableVertexAttribArray(maColorHandle);
        }
    }

    protected void drawArc(float centerX, float centerY, float startAngle, float endAngle, float radius) {
        float[] vertexes = calculateArcPoints(centerX, centerY, startAngle, endAngle, radius);
        drawLine(GLES20.GL_LINE_STRIP, vertexes, null);
    }

    protected void drawLine(int mode, float[] vertexes, float[] color) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexes.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vb = vbb.asFloatBuffer();
        vb.put(vertexes);
        vb.position(0);


        FloatBuffer cb = null;
        if (color != null) {
            ByteBuffer cbb = ByteBuffer.allocateDirect(color.length * 4);
            cbb.order(ByteOrder.nativeOrder());
            cb = cbb.asFloatBuffer();
            cb.put(color);
            cb.position(0);
        }


        // Prepare the triangle data
        GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false, 0, vb);
        GLES20.glEnableVertexAttribArray(maPositionHandle);


        if (cb != null) {
            GLES20.glEnableVertexAttribArray(maColorHandle);
            GLES20.glVertexAttribPointer(maColorHandle, 4, GLES20.GL_FLOAT, false, 0, cb);
        }

        GLES20.glDrawArrays(mode, 0, vertexes.length /3);

        GLES20.glDisableVertexAttribArray(maPositionHandle);
        if (cb != null) {
            GLES20.glDisableVertexAttribArray(maColorHandle);
        }
    }


    /**
     * 计算顶点
     */


    private float[] calculateArcPoints(float centerX, float centerY, float startAngle, float endAngle, float radius) {

        double unit = Math.PI / 180;
        int count = (int) Math.ceil(Math.abs(endAngle - startAngle));

        float[] vertexes = new float[count * 3+3];
        float step = (endAngle - startAngle) / count;

        int j = 0;
        float i ;
        if (startAngle > endAngle) {
            for (i=startAngle; i> endAngle; i+=step) {
                vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
                vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
                vertexes[j++] = 0;
            }

            i+=step;
            vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
            vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
            vertexes[j] = 0;

        }else {
            for (i=startAngle; i< endAngle; i+=step) {
                vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
                vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
                vertexes[j++] = 0;
            }

            i+=step;
            vertexes[j++] = (float) (centerX + radius * Math.cos(i * unit));
            vertexes[j++] = (float) (centerY + radius * Math.sin(i * unit));
            vertexes[j] = 0;
        }



//        printArray(vertexes, 3);

        return vertexes;
    }

    protected final String vertexShaderCode =
            "uniform mat4 uMVPMatrix;   \n" +

            "attribute vec4 vPosition;" +
            "attribute vec4 vColor;" +
            "varying vec4 v_fragmentColor;" +
                    "void main() {" +
                    "  gl_Position = uMVPMatrix * vPosition;" +
                    " gl_PointSize = 20.0f; \n" +
                    " v_fragmentColor = vColor; \n" +
                    "}";

//    protected final String fragmentShaderCode =
//             "varying vec4 v_fragmentColor;" +
//                    "void main() {" +
//                    "  gl_FragColor = v_fragmentColor;" +
//                    "}";

    protected final String fragmentShaderCode =
             "varying vec4 v_fragmentColor;" +
                    "void main() {" +
                    "  gl_FragColor = v_fragmentColor;" +
                    "}";

    protected static int loadShader(int type, String shaderCode){

        // 创建一个vertex shader类型(GLES20.GL_VERTEX_SHADER)
        // 或fragment shader类型(GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // 将源码添加到shader并编译之
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }


    protected void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i=0; i< data.length; i++) {
            System.out.print(" "+ data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
