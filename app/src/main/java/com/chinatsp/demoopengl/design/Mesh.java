package com.chinatsp.demoopengl.design;

import android.graphics.Bitmap;
import android.opengl.GLUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by zhangwei on 2017/4/1.
 */

public class Mesh {
    //vertex buffer
    private FloatBuffer verticesBuffer = null;
    //index buffer
    private ShortBuffer indicesBuffer = null;

    //number of indices
    private int numOfIndices = -1;

    //flat color
    private float[] rgba = new float[] {1f, 1f, 1f, 1f};
    //smooth colors
    private FloatBuffer colorBuffer = null;

    //UV texture buffer
    private FloatBuffer textureBuffer;
    private int textureId = -1;
    private boolean shouldLoadTexture = false;
    private Bitmap bitmap;

    //translate params
    public float x = 0;
    public float y = 0;
    public float z = 0;

    //rotate params
    public float rx = 0;
    public float ry = 0;
    public float rz = 0;


    public void draw(GL10 gl) {
        //counter clockwise order
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glPushMatrix();

        //rendering
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, verticesBuffer);
        gl.glColor4f(rgba[0], rgba[1], rgba[2], rgba[3]);
        if (colorBuffer != null) {
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
//            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        }

        if (shouldLoadTexture) {
            loadGLTexture(gl);
            shouldLoadTexture = false;
        }

        if (textureId != -1 && textureBuffer != null) {
            gl.glEnable(GL10.GL_TEXTURE_2D);
            gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

            gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
//            gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        }

        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);

        gl.glDrawElements(GL10.GL_TRIANGLES, numOfIndices,
                GL10.GL_UNSIGNED_SHORT, indicesBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        if (colorBuffer != null) {
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        }

        if (textureId != -1 && textureBuffer != null) {
            gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        }
        gl.glDisable(GL10.GL_CULL_FACE);

        gl.glPopMatrix();
    }

    protected void setVertices(float[] vertices) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        verticesBuffer = vbb.asFloatBuffer();
        verticesBuffer.put(vertices);
        verticesBuffer.position(0);
    }

    protected void setIndices(short[] indices) {
        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        indicesBuffer = ibb.asShortBuffer();
        indicesBuffer.put(indices);
        indicesBuffer.position(0);

        numOfIndices = indices.length;
    }

    protected void setColor(float red, float green, float blue, float alpha) {
        rgba[0] = red;
        rgba[1] = green;
        rgba[2] = blue;
        rgba[3] = alpha;
    }

    protected void setColors(float[] colors) {
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        colorBuffer = cbb.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);
    }

    protected void setTextureCoordinates(float[] textureCoordinates) {
        ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoordinates.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        textureBuffer = tbb.asFloatBuffer();
        textureBuffer.put(textureCoordinates);
        textureBuffer.position(0);
    }

    public void loadBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        shouldLoadTexture = true;
    }

    private void loadGLTexture(GL10 gl) {
        int[] textures = new int[1];
        gl.glGenTextures(1, textures, 0);
        textureId = textures[0];

        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
                GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
                GL10.GL_LINEAR);

        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,
                GL10.GL_REPEAT);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,
                GL10.GL_REPEAT);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
    }
}
