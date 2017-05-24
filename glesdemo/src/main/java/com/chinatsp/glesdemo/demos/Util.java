package com.chinatsp.glesdemo.demos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/4/13.
 */

public class Util {


    private static final double DEF_R = 6370693.5; // radius of earth

    public static float getAngle(double lat1, double lon1, double lat2, double lon2) {

        return 0;
    }

    public static double[] getrelativeCoordinate(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        // 角度转换为弧度
        ew1 = lon1 * Math.PI / 180f;
        ns1 = lat1 * Math.PI / 180f;
        ew2 = lon2 * Math.PI / 180f;
        ns2 = lat2 * Math.PI / 180f;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > Math.PI)
            dew = Math.PI * 2 - dew;
        else if (dew < -Math.PI)
            dew = Math.PI * 2  + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)

        return new double[]{dx, dy};
    }

    public static double getrelativeDistance(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        // 角度转换为弧度
        ew1 = lon1 * Math.PI / 180f;
        ns1 = lat1 * Math.PI / 180f;
        ew2 = lon2 * Math.PI / 180f;
        ns2 = lat2 * Math.PI / 180f;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > Math.PI)
            dew = Math.PI * 2 - dew;
        else if (dew < -Math.PI)
            dew = Math.PI * 2  + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }


//    public static double DTOR(double Degree)	// 角度转化成弧度
//    {
//        return Degree * Math.PI / 180.0;
//    }
//    public static double RTOD(double Radian)	// 弧度转化成角度
//    {
//        return Radian * 180.0 / Math.PI;
//    }

    public static int ConvertAngleIn0_180(int InAngle)
    {
        if (InAngle<0)
        {
            InAngle+=360;
        }
        else
        {
            if (InAngle>360)
            {
                InAngle-=360;
            }
        }
        if (InAngle>180)
        {
            InAngle=360-InAngle;
            InAngle *= -1;
        }
        return InAngle;	//[0,180]
    }

    public static int LngLatToOrient(double dBeginLong,double dBeginLat,double dEndLong,double dEndLat/*,double& dDist*/) {
        // 计算航向(方位)
        double DMP = 7915.70447 * (Math.log10(Math.tan(Math.toRadians(45 + dEndLat / 2.0))) - Math.log10(Math.tan(Math.toRadians(45 + dBeginLat / 2.0))));    // 计算纬度渐长率差,单位:分
        double tmpdOrient = Math.atan((dEndLong - dBeginLong) * 60 / DMP);  //dEndLong-dBeginLong单位是度,而DMP单位是分,故*60
        tmpdOrient = Math.toDegrees(Math.abs(tmpdOrient));
        int dOrient = (int) tmpdOrient;

        //  由于tmpdOrient的角度值在[0，90]之间，应讨论
        if (dEndLong >= dBeginLong) // 向东
        {
            if (dEndLat >= dBeginLat) // 向北[0 90] NE
            {
                dOrient = dOrient;
            } else                     // 向南(90 180] SE
            {
                dOrient = 180 - dOrient;
            }
        } else   // 向西
        {
            if (dEndLat >= dBeginLat) // 向北[270 360) NW
            {
                dOrient = 360 - dOrient;
            }                        // 向南(90 180]  SW
            else {
                dOrient = 180 + dOrient;
            }
        }
        return dOrient;
    }





    /**
     * points method
     */
    public static void filterDuplicatedPoints(List<double[]> path) {

//        printAllPoints();
        List<double[]> deleted = new ArrayList<>();
        double[] first;
        double[] second;

        for (int i = 1; i < path.size(); i++) {
            first = path.get(i - 1);
            second = path.get(i);
            if (Math.abs(first[0] - second[0]) < Double.MIN_VALUE
                    && Math.abs(first[1] - second[1]) < Double.MIN_VALUE) {
//                path.remove(i);
                deleted.add(path.get(i));
            }
        }
        path.removeAll(deleted);
        Log.e("sssss ", "--------------------------------------------------------------------------");
//        printAllPoints();
    }

    public static double getEarthDistanceBetweenPoints(double[] first, double[] second) {
        double distance = Util.getrelativeDistance(first[0], first[1], second[0], second[1]);
        return distance;
    }

    /**
     * 以第一点为原点，构建所有点的相对坐标,如有必要，插入新点
     * @param route
     * @return
     */
    public static List<double[]> mapToCoordinatesInserted(final List<double[]> route) {
        List<double[]> inserted = new ArrayList<>();

        double[] first;
        double[] second;
        for (int idx = 0; idx < route.size() -1; idx ++) {
            first = route.get(idx);
            second = route.get(idx+1);
            inserted.addAll(routePointInsert(first, second));
        }
        filterDuplicatedPoints(inserted);
        return inserted;
    }

    /**
     * 两点之间大于 5米后，插点
     * @param first
     * @param second
     * @return
     */
    public static List<double[]> routePointInsert(double[] first, double[] second) {
        double distance = getEarthDistanceBetweenPoints(first, second);

        List<double[]> routePoints = new ArrayList<>();

        if (distance > 5) {
            int count = (int) Math.ceil(distance / 5);
            double stepX = (second[0] - first[0]) / count;
            double stepY = (second[1] - first[1]) / count;

            for (int i=0; i <= count; i++) {
                routePoints.add(new double[] {first[0] + stepX * i, first[1] + stepY * i});
            }

        }else {
            routePoints.add(first);
            routePoints.add(second);
        }

        return routePoints;
    }

    /**
     * 以第一点为原点，构建所有点的相对坐标
     * @param route
     * @return
     */
    public static float[] routeMapToCoordinates(final List<double[]> route) {
        float[] points = new float[route.size() * 3];

        int idx = 0;
        double[] origin = route.get(0);
        for (double[] point : route) {
            points[idx++] = (float) (point[0] - origin[0]) * 10000;
            points[idx++] = (float) (point[1] - origin[1]) * 10000;
            points[idx++] = 0f;
        }
//        printArray(points, 3);
        return points;
    }



    /**
     * vector method
     */
    /**
     * 根据向量夹角公式，计算两向量间夹角
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double calculateVectorAngle(double x1, double y1, double x2, double y2) {

        double cos = (x1 * x2 + y1 * y2) /
                (Math.sqrt(x1*x1 +y1*y1) * Math.sqrt(x2*x2 + y2*y2));
        double angle = Math.round(Math.toDegrees(Math.acos(cos)));

        double axb = x1 * y2 - x2 * y1;
        if (axb <0) {
            angle = - Math.abs(angle);
        }else {
            angle = Math.abs(angle);
        }
//        Log.e("sss", "index:    angle:"+angle+ " cos:"+cos);
        return angle;
    }

    /**
     * 根据坐标系旋转公式计算 向量A（a, b）旋转 angle 后的坐标
     * @param a
     * @param b
     * @param angle
     * @return
     */
    public static float[] getRotatedPoints(float a, float b, float angle) {
        float[] points = new float[2];
        if (angle >0) {
            points[0] = (float)(a * Math.cos(Math.toRadians(angle)) - b * Math.sin(Math.toRadians(angle)));
            points[1] = (float)(a * Math.sin(Math.toRadians(angle)) + b * Math.cos(Math.toRadians(angle)));
        }else {
            points[0] = (float)(a * Math.cos(Math.toRadians(angle)) + b * Math.sin(Math.toRadians(angle)));
            points[1] = (float)(a * Math.sin(Math.toRadians(angle)) + b * Math.cos(Math.toRadians(angle)));
        }
        return points;
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }


    /**
     * 贝塞尔曲线点
     */

    /**
     * 只显示前 100 米
     * @param paths
     * @return
     */
    public static float[] getBezierPoints(List<double[]> paths) {
        List<double[]> temp = new ArrayList<>();
        temp.add(paths.get(0));

        double len = 0;
        List<double[]> sub;
        for (int i=0; i< paths.size() -2; i++) {
            sub = getBezierPointsV2(paths.get(i), paths.get(i+1), paths.get(i+2));

            len += Util.getEarthDistanceBetweenPoints(temp.get(temp.size()-1), sub.get(0));
            temp.add(sub.get(0));
            if (len > 100) {
                break;
            }

            for (int j=0; j< sub.size()-1 ; j++) {
                len += Util.getEarthDistanceBetweenPoints(sub.get(j), sub.get(j+1));
                temp.add(sub.get(j+1));
                if (len > 100) {
                    break;
                }
            }
        }

        if (len < 100) {
            temp.add(paths.get(paths.size() - 1));
        }

        return routeMapToCoordinates(temp);
    }
    /**
     * 二次方程
     */
    public static List<double[]> getBezierPointsV2(double[] point0, double[] point1, double[] point2) {
        /**
         * 临近弯点，使用离弯点 1/10 的点为开始结束点，尽量逼近路径
         */
        double[] p0;
        double dis = Util.getEarthDistanceBetweenPoints(point0, point1);
        if (dis > 1) {
            p0 = new double[]{
                    point0[0] + (point1[0] - point0[0]) * 0.7 ,
                    point0[1] + (point1[1] - point0[1]) * 0.7,
            };
        }else {
            p0 = new double[]{
                    point0[0] + (point1[0] - point0[0]) * 0.7 * dis ,
                    point0[1] + (point1[1] - point0[1]) * 0.7 * dis,
            };
        }
        double[] p2 = new double[] {
                point1[0] + (point2[0] - point1[0]) * 0.4,
                point1[1] + (point2[1] - point1[1]) * 0.4,
        };


        List<double[]> temp = new ArrayList<>();

        double t = 0;
        for (; t<=1; t += 0.1) {
            double a1 = Math.pow(1 - t, 2);
            double a2 = 2 * t * (1 - t);
            double a3 = Math.pow(t, 2);

            double x = a1 * p0[0] + a2 * point1[0] + a3 * p2[0];
            double y = a1 * p0[1] + a2 * point1[1] + a3 * p2[1];
            temp.add(new double[]{x, y});
        }
        return temp;
    }




    public static void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

}
