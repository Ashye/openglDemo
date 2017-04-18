package com.chinatsp.glesdemo.demos;

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


    public static double DTOR(double Degree)	// 角度转化成弧度
    {
        return Degree * Math.PI / 180.0;
    }
    public static double RTOD(double Radian)	// 弧度转化成角度
    {
        return Radian * 180.0 / Math.PI;
    }

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

    public static int LngLatToOrient(	double dBeginLong,double dBeginLat,double dEndLong,double dEndLat/*,double& dDist*/) {
        // 计算航向(方位)
        double DMP = 7915.70447 * (Math.log10(Math.tan(DTOR(45 + dEndLat / 2.0))) - Math.log10(Math.tan(DTOR(45 + dBeginLat / 2.0))));    // 计算纬度渐长率差,单位:分
        double tmpdOrient = Math.atan((dEndLong - dBeginLong) * 60 / DMP);  //dEndLong-dBeginLong单位是度,而DMP单位是分,故*60
        tmpdOrient = RTOD(Math.abs(tmpdOrient));
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
}
