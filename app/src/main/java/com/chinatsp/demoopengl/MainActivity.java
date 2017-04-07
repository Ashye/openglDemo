package com.chinatsp.demoopengl;

import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chinatsp.demoopengl.design.Cube;
import com.chinatsp.demoopengl.design.OpenGLRender;
import com.chinatsp.demoopengl.design.SimplePlane;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    private OpenGLRender glRender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        glSurfaceView = new GLSurfaceView(this);
        glRender = new OpenGLRender();
        glSurfaceView.setRenderer(glRender);
        setContentView(glSurfaceView);


        Cube cube = new Cube(1,1,1);
        cube.y = 2;
        cube.rx = 45;
        cube.ry = 45;
        glRender.addMesh(cube);


        SimplePlane simplePlane = new SimplePlane();
//        Plane simplePlane = new Plane(1,1);

        simplePlane.z = 1.7f;
        simplePlane.rx = -65;

        simplePlane.loadBitmap(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        glRender.addMesh(simplePlane);


    }
}
