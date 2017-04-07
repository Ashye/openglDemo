package com.chinatsp.glesdemo.demos;

import android.opengl.GLU;

import com.chinatsp.glesdemo.demos.Model.Star;

import javax.microedition.khronos.opengles.GL10;

public class DrawSolarSystemActivity extends OpenGLESActivity {

    private Star sun = new Star();
    private Star earth = new Star();
    private Star moon = new Star();

    private int angle = 0;


    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        gl.glLoadIdentity();
        GLU.gluLookAt(gl, 0f,0f,10f, 0f,0f,0f, 0f,1f,0f);

        //sun
        gl.glPushMatrix();
        gl.glRotatef(angle, 0,0,1);
        gl.glColor4f(1f,0f,0f,1f);
        sun.draw(gl);
        gl.glPopMatrix();

        //earth
        gl.glPushMatrix();
        gl.glRotatef(-angle, 0f,0f,1f);
        gl.glTranslatef(3,0,0);
        gl.glScalef(0.5f,0.5f,0.5f);
        gl.glColor4f(0f,0f,1f,1f);
        earth.draw(gl);

        //moon
        gl.glPushMatrix();
        gl.glRotatef(-angle,0,0,1);
        gl.glTranslatef(2,0,0);
        gl.glScalef(.5f,.5f,.5f);

        gl.glRotatef(angle * 10, 0,0,1);
        gl.glColor4f(1f,1f,1f,1f);
        moon.draw(gl);

        gl.glPopMatrix();
        gl.glPopMatrix();
        angle++;
    }
}
