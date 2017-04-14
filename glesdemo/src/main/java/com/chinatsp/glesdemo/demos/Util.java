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
}
