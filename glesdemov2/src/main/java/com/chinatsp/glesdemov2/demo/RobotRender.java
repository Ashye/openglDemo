package com.chinatsp.glesdemov2.demo;

import android.opengl.GLES20;

import com.chinatsp.glesdemov2.base.GL20Renderer2D;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/20.
 */

public class RobotRender extends GL20Renderer2D {


    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);

        //head
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.125f,0.7f,0, -0.125f,0.8f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.125f,0.7f,0, 0.125f,0.8f,0}, null);
        drawStrokeRect(0, 0.55f, 0.5f, 0.3f, null);
        drawCircle(-0.125f,0.55f, 0.05f);
        drawCircle(0.125f,0.55f, 0.05f);
        drawArc(0,0.55f, 225f, 315f, 0.1f);
        drawStrokeRect(-0.32f,0.55f, 0.1f, 0.15f, null);
        drawStrokeRect(0.32f,0.55f, 0.1f, 0.15f, null);

        //neck
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.1f,0.3f,0, -0.1f,0.4f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.1f,0.3f,0, 0.1f,0.4f,0}, null);

        //body
        drawStrokeRect(0,0, 0.6f,0.6f, null);
        drawCircle(0,0, 0.2f);

        //hands
        drawStrokeRect(-0.4f, 0.1f, 0.16f, 0.2f, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.44f,0f,0, -0.44f,-0.05f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.36f,0f,0, -0.36f,-0.05f,0}, null);
        drawStrokeRect(-0.4f, -0.1f, 0.16f, 0.1f, null);
        drawCircle(-0.4f, -0.2f, 0.05f);

        drawStrokeRect(0.4f, 0.1f, 0.16f, 0.2f, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.44f,0f,0, 0.44f,-0.05f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.36f,0f,0, 0.36f,-0.05f,0}, null);
        drawStrokeRect(0.4f, -0.1f, 0.16f, 0.1f, null);
        drawCircle(0.4f, -0.2f, 0.05f);

        //legs
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.18f,-0.3f,0, -0.18f,-0.4f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.12f,-0.3f,0, -0.12f,-0.4f,0}, null);
        drawStrokeRect(-0.15f, -0.5f, 0.16f, 0.2f, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.18f,-0.6f,0, -0.18f,-0.65f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{-0.12f,-0.6f,0, -0.12f,-0.65f,0}, null);
        drawStrokeRect(-0.15f, -0.7f, 0.22f, 0.1f, null);

        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.18f,-0.3f,0, 0.18f,-0.4f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.12f,-0.3f,0, 0.12f,-0.4f,0}, null);
        drawStrokeRect(0.15f, -0.5f, 0.16f, 0.2f, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.18f,-0.6f,0, 0.18f,-0.65f,0}, null);
        drawLine(GLES20.GL_LINE_STRIP, new float[]{0.12f,-0.6f,0, 0.12f,-0.65f,0}, null);
        drawStrokeRect(0.15f, -0.7f, 0.22f, 0.1f, null);
    }
}
