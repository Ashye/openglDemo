package com.chinatsp.glesdemo.demos.Model;

import android.opengl.GLU;

import com.chinatsp.glesdemo.demos.OpenGLESActivity;

import javax.microedition.khronos.opengles.GL10;

public class DrawRoutineActivity extends OpenGLESActivity {


    private Routine routine = new Routine();


    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        gl.glLoadIdentity();

        antiSmooth(gl);

        float[] eyePosition = {0,10,10};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);

        routine.draw(gl);
    }
}
