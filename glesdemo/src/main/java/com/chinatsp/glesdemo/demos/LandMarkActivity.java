package com.chinatsp.glesdemo.demos;

import android.graphics.Point;
import android.opengl.GLU;
import android.util.Log;

import com.chinatsp.glesdemo.demos.Model.LandMark;
import com.chinatsp.glesdemo.demos.Model.Routine;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class LandMarkActivity extends OpenGLESActivity {

    //经纬度
    private Vector<double[]> path = new Vector<>();

    {

        /**
         * 平面路径：下下下右右上上上上上上上左左左左左左左
         */
        path.add(new double[] {113.95398, 22.53655});
        path.add(new double[] {113.95399, 22.5364});
        path.add(new double[] {113.95399, 22.5364});
        path.add(new double[] {113.95399, 22.53632});
        path.add(new double[] {113.95399, 22.53632});
        path.add(new double[] {113.95403, 22.53631});
        path.add(new double[] {113.95403, 22.53631});
        path.add(new double[] {113.95403, 22.5364});
        path.add(new double[] {113.95403, 22.5364});
        path.add(new double[] {113.95402, 22.53665});
        path.add(new double[] {113.95402, 22.53665});
        path.add(new double[] {113.95401, 22.53684});
        path.add(new double[] {113.95401, 22.53684});
        path.add(new double[] {113.954, 22.53713});
        path.add(new double[] {113.954, 22.53713});
        path.add(new double[] {113.954, 22.53721});
        path.add(new double[] {113.954, 22.53721});
        path.add(new double[] {113.95399, 22.53752});
        path.add(new double[] {113.95399, 22.53752});
        path.add(new double[] {113.95398, 22.53776});
        path.add(new double[] {113.95398, 22.53776});
        path.add(new double[] {113.95398, 22.53829});
        path.add(new double[] {113.95398, 22.53829});
        path.add(new double[] {113.95397, 22.53888});
        path.add(new double[] {113.95397, 22.53888});
        path.add(new double[] {113.95395, 22.53895});
        path.add(new double[] {113.95395, 22.53895});
        path.add(new double[] {113.95396, 22.5392});
        path.add(new double[] {113.95396, 22.5392});
        path.add(new double[] {113.95396, 22.53938});
        path.add(new double[] {113.95396, 22.53938});
        path.add(new double[] {113.95395, 22.53965});
        path.add(new double[] {113.95395, 22.53965});
        path.add(new double[] {113.95394, 22.53987});
        path.add(new double[] {113.95394, 22.53987});
        path.add(new double[] {113.95393, 22.54012});
        path.add(new double[] {113.95393, 22.54012});
        path.add(new double[] {113.95394, 22.54038});
        path.add(new double[] {113.95394, 22.54038});
        path.add(new double[] {113.95386, 22.54038});
        path.add(new double[] {113.95386, 22.54038});
        path.add(new double[] {113.95357, 22.54036});
        path.add(new double[] {113.95357, 22.54036});
        path.add(new double[] {113.95329, 22.54035});
        path.add(new double[] {113.95329, 22.54035});
        path.add(new double[] {113.95295, 22.54034});
        path.add(new double[] {113.95295, 22.54034});
        path.add(new double[] {113.95225, 22.54031});
        path.add(new double[] {113.95225, 22.54031});
        path.add(new double[] {113.95198, 22.5403});
        path.add(new double[] {113.95198, 22.5403});
        path.add(new double[] {113.95171, 22.54028});
        path.add(new double[] {113.95171, 22.54028});
        path.add(new double[] {113.95131, 22.54026});
        path.add(new double[] {113.95131, 22.54026});
        path.add(new double[] {113.94914, 22.54016});
        path.add(new double[] {113.94914, 22.54016});
        path.add(new double[] {113.94805, 22.54012});
        path.add(new double[] {113.94805, 22.54012});
        path.add(new double[] {113.94786, 22.54009});
        path.add(new double[] {113.94786, 22.54009});
        path.add(new double[] {113.94742, 22.54008});
        path.add(new double[] {113.94742, 22.54008});
        path.add(new double[] {113.94695, 22.54006});
        path.add(new double[] {113.94695, 22.54006});
        path.add(new double[] {113.9463, 22.54003});
        path.add(new double[] {113.9463, 22.54003});
        path.add(new double[] {113.94578, 22.54001});
        path.add(new double[] {113.94578, 22.54001});
        path.add(new double[] {113.94552, 22.54});
        path.add(new double[] {113.94552, 22.54});
        path.add(new double[] {113.94532, 22.53999});
        path.add(new double[] {113.94532, 22.53999});
        path.add(new double[] {113.94465, 22.53995});
        path.add(new double[] {113.94465, 22.53995});
        path.add(new double[] {113.94331, 22.53989});
        path.add(new double[] {113.94331, 22.53989});
        path.add(new double[] {113.94285, 22.53996});


        /**
         * 平面路径：右右上上左左上左（右上）左左（右上）（右顺时圈）左左左左
         */
//        path.add(new double[] {113.95585, 22.53957});
//        path.add(new double[] {113.9552, 22.53957});
//        path.add(new double[] {113.95514, 22.53954});
//        path.add(new double[] {113.95514, 22.53921});
//        path.add(new double[] {113.95522, 22.53914});
//        path.add(new double[] {113.9554, 22.53916});
//        path.add(new double[] {113.9554, 22.53916});
//        path.add(new double[] {113.95589, 22.53916});
//        path.add(new double[] {113.95589, 22.53916});
//        path.add(new double[] {113.95594, 22.53898});
//        path.add(new double[] {113.95594, 22.53898});
//        path.add(new double[] {113.95593, 22.53894});
//        path.add(new double[] {113.95593, 22.53894});
//        path.add(new double[] {113.95604, 22.53894});
//        path.add(new double[] {113.95604, 22.53894});
//        path.add(new double[] {113.95627, 22.53891});
//        path.add(new double[] {113.95627, 22.53891});
//        path.add(new double[] {113.95638, 22.53885});
//        path.add(new double[] {113.95638, 22.53885});
//        path.add(new double[] {113.95657, 22.53867});
//        path.add(new double[] {113.95657, 22.53867});
//        path.add(new double[] {113.95664, 22.53858});
//        path.add(new double[] {113.95664, 22.53858});
//        path.add(new double[] {113.9568, 22.53836});
//        path.add(new double[] {113.9568, 22.53836});
//        path.add(new double[] {113.95696, 22.53814});
//        path.add(new double[] {113.95696, 22.53814});
//        path.add(new double[] {113.95699, 22.53804});
//        path.add(new double[] {113.95698, 22.53794});
//        path.add(new double[] {113.95698, 22.53794});
//        path.add(new double[] {113.9569, 22.53776});
//        path.add(new double[] {113.9569, 22.53776});
//        path.add(new double[] {113.95686, 22.53769});
//        path.add(new double[] {113.95686, 22.53769});
//        path.add(new double[] {113.95682, 22.53764});
//        path.add(new double[] {113.95682, 22.53764});
//        path.add(new double[] {113.95673, 22.53748});
//        path.add(new double[] {113.95673, 22.53748});
//        path.add(new double[] {113.95665, 22.53734});
//        path.add(new double[] {113.95665, 22.53734});
//        path.add(new double[] {113.95642, 22.53698});
//        path.add(new double[] {113.95642, 22.53698});
//        path.add(new double[] {113.95639, 22.53692});
//        path.add(new double[] {113.95639, 22.53692});
//        path.add(new double[] {113.95618, 22.53656});
//        path.add(new double[] {113.95618, 22.53656});
//        path.add(new double[] {113.95616, 22.53653});
//        path.add(new double[] {113.95616, 22.53653});
//        path.add(new double[] {113.956, 22.53628});
//        path.add(new double[] {113.956, 22.53628});
//        path.add(new double[] {113.95563, 22.53569});
//        path.add(new double[] {113.95563, 22.53569});
//        path.add(new double[] {113.95559, 22.5356});
//        path.add(new double[] {113.95559, 22.5356});
//        path.add(new double[] {113.95559, 22.53552});
//        path.add(new double[] {113.95559, 22.53552});
//        path.add(new double[] {113.95643, 22.53511});
//        path.add(new double[] {113.95643, 22.53511});
//        path.add(new double[] {113.95656, 22.53492});
//        path.add(new double[] {113.95656, 22.53473});
//        path.add(new double[] {113.95656, 22.53473});
//        path.add(new double[] {113.95636, 22.53443});
//        path.add(new double[] {113.95636, 22.53443});
//        path.add(new double[] {113.95628, 22.5343});
//        path.add(new double[] {113.95628, 22.5343});
//        path.add(new double[] {113.95537, 22.53281});
//        path.add(new double[] {113.95509, 22.53217});
//        path.add(new double[] {113.95491, 22.53157});
//        path.add(new double[] {113.95491, 22.53157});
//        path.add(new double[] {113.95488, 22.53091});
//        path.add(new double[] {113.95488, 22.53091});
//        path.add(new double[] {113.95474, 22.52854});
//        path.add(new double[] {113.95474, 22.52854});
//        path.add(new double[] {113.95473, 22.52832});
//        path.add(new double[] {113.95473, 22.52832});
//        path.add(new double[] {113.95469, 22.52788});
//        path.add(new double[] {113.95469, 22.52788});
//        path.add(new double[] {113.95465, 22.52719});
//        path.add(new double[] {113.95465, 22.52719});
//        path.add(new double[] {113.95465, 22.52711});
//        path.add(new double[] {113.95465, 22.52711});
//        path.add(new double[] {113.95461, 22.52674});
//        path.add(new double[] {113.95461, 22.52674});
//        path.add(new double[] {113.95454, 22.52608});
//        path.add(new double[] {113.95454, 22.52608});
//        path.add(new double[] {113.95452, 22.52587});
//        path.add(new double[] {113.95452, 22.52587});
//        path.add(new double[] {113.95436, 22.5247});
//        path.add(new double[] {113.95431, 22.52408});
//        path.add(new double[] {113.95431, 22.52408});
//        path.add(new double[] {113.95429, 22.52398});
//        path.add(new double[] {113.95429, 22.52398});
//        path.add(new double[] {113.954, 22.52162});
//        path.add(new double[] {113.954, 22.52162});
//        path.add(new double[] {113.9539, 22.52095});
//        path.add(new double[] {113.9539, 22.52095});
//        path.add(new double[] {113.95383, 22.5203});
//        path.add(new double[] {113.95383, 22.5203});
//        path.add(new double[] {113.9536, 22.51968});
//        path.add(new double[] {113.95354, 22.51959});
//        path.add(new double[] {113.95336, 22.51945});
//        path.add(new double[] {113.95317, 22.51939});
//        path.add(new double[] {113.95301, 22.51938});
//        path.add(new double[] {113.95268, 22.51949});
//        path.add(new double[] {113.95256, 22.51965});
//        path.add(new double[] {113.95247, 22.51989});
//        path.add(new double[] {113.95247, 22.52012});
//        path.add(new double[] {113.95254, 22.52033});
//        path.add(new double[] {113.95268, 22.52048});
//        path.add(new double[] {113.95286, 22.52057});
//        path.add(new double[] {113.95299, 22.52061});
//        path.add(new double[] {113.9533, 22.52064});
//        path.add(new double[] {113.9533, 22.52064});
//        path.add(new double[] {113.95413, 22.52057});
//        path.add(new double[] {113.95413, 22.52057});
//        path.add(new double[] {113.95463, 22.52052});
//        path.add(new double[] {113.95463, 22.52052});
//        path.add(new double[] {113.95626, 22.52033});
//        path.add(new double[] {113.95626, 22.52033});
//        path.add(new double[] {113.95691, 22.52026});
//        path.add(new double[] {113.95691, 22.52026});
//        path.add(new double[] {113.95832, 22.5201});

    }


    private Routine routine;

    private LandMark landMark;



    @Override
    protected void onStart() {
        super.onStart();

        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

        //去掉重复的点，很重要！不然计算相对角时有问题
        filterDuplicatedPoints();

        routine = new Routine(path);
        landMark = new LandMark(point.x, point.y);



        mGlSurfaceView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mGlSurfaceView.requestRender();

                if (currPosition < path.size() - 2) {
                    mGlSurfaceView.postDelayed(this, 1000);
                }
            }
        }, 1000);

    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

//        long startTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene start ===>"+startTime);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();


        float[] eyePosition = {0,10,10};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);


        gl.glPushMatrix();

        antiSmooth(gl);


//        printAllPointAngle();
//        printPointAngle(2);

//        filterDuplicatedPoints();
//        printAllPointAngle();


        landMark.setAngle(calculateTurnAngle());
        landMark.draw(gl);
//        routine.draw(gl);

        gl.glPopMatrix();
//        long endTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene end ===>"+ endTime + " duration:"+(endTime - startTime));

        currPosition ++;
    }

    private int currPosition = 0;
//    private float getAngle() {
//        if (currPosition > path.size() - 3) {
//            return 0f;
//        }
//
//
////        double[] a = path.get(currPosition);
////        double[] b = path.get(currPosition +1);
////        double[] c = path.get(currPosition +2);
////
//        double[] a = {-8.385278, 4.8952637};
//        double[] b = {-23.98528, 12.8952637};
//        double[] c = {-24.085278, 15.395264};
//
//
//        double sideC = Util.getrelativeDistance(a[0], a[1], b[0], b[1]);
//        double sideA = Util.getrelativeDistance(b[0], b[1], c[0], c[1]);
//        double sideB = Util.getrelativeDistance(a[0], a[1], c[0], c[1]);
//
//
//        double cosB = (sideA * sideA + sideC * sideC - sideB * sideB) / (2 * sideA * sideC);
//
//        Log.e("sss", "sss cosb: "+cosB);
//
//
//        double angle = Math.toDegrees(Math.acos(cosB));
//
////        angle = 180 - angle;
//
//        if (c[0] > b[0]) {
//            angle = 180 - angle;
//        }
////
////
////        if (c[0] - b[0] <0) {
////            angle *= -1;
////        }
//
//        Log.e("ss", String.format("%f, %f, %f, %f", sideA, sideB, sideC, angle));
//
//        return (float) angle;
//    }

    private int getAngleBetweenPoints(double[] first, double[] second) {
        int angle = Util.LngLatToOrient(first[0], first[1], second[0], second[1]);
//        Log.e("sssss ", "position:"+currPosition+"origin angle:"+angle);
        return Util.ConvertAngleIn0_180(angle);
//        return angle;
    }

    private int calculateTurnAngle() {
        //到路径起点或者终点时，无转弯角度
        if (currPosition > path.size() - 2 || currPosition == 0) {
            return 0;
        }

        //根据当前点，前点，后点，计算转向角度
        int angleNow = getAngleBetweenPoints(path.get(currPosition -1), path.get(currPosition));
        int angleComming = getAngleBetweenPoints(path.get(currPosition), path.get(currPosition+1));

        Log.e("sssss ", "======"+currPosition+"======: now=======>"+angleNow + " comming======>"+ angleComming);

        int turnAngle = angleNow - angleComming;

        /**
         * [-180, 180]
         */
        if (turnAngle < -180) {
            turnAngle += 360;
        }else if (turnAngle > 180) {
            turnAngle -= 360;
        }

        Log.e("sssss ", "turn angle=====>"+(turnAngle));
        Log.e("sssss ", "-------------------------------");

        return turnAngle;
    }

    private void printAllPointAngle() {
        calculateTurnAngle();
    }

    private void printPointAngle(int currPosition) {
        int angleNow = 0;
        if (currPosition ==0) {
            angleNow = 0;
        }else {
            angleNow = getAngleBetweenPoints(path.get(currPosition - 1), path.get(currPosition));
        }
        Log.e("sssss ", "point"+currPosition+"=====>"+(angleNow));
    }

    private void filterDuplicatedPoints() {
        printAllPoints();
        double[] first;
        double[] second;

        for (int i=1; i<path.size(); i++) {
            first = path.get(i-1);
            second = path.get(i);
            if (Math.abs(first[0] - second[0]) < Double.MIN_VALUE
                    && Math.abs(first[1] - second[1]) < Double.MIN_VALUE) {
                path.remove(i);
            }
        }
        Log.e("sssss ", "--------------------------------------------------------------------------");
        printAllPoints();
    }

    private void printAllPoints() {
        for (double[] point :
                path) {
            System.out.println(String.format("%f, %f", point[0], point[1]));
        }
        System.out.println(String.format("size: %d", path.size()));
    }
}
