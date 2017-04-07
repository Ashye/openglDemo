package com.chinatsp.demoopengl.gl;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/1.
 */

public class FlatColoredSquare extends Square {

    @Override
    public void draw(GL10 gl) {
        gl.glColor4f(.5f,.5f,1f,1f);
        super.draw(gl);
    }
}
